
package DomainDecider;

import StringFormating.StringTokenFormating;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DatabaseOperations.*;
import javax.swing.JOptionPane;

public class DomainDecider
{
static int No_Of_Domain=0;

public static void main(String args[])
{

String Query=JOptionPane.showInputDialog("Enter query");//"online shoping";
DomainDecider domainDecider=new DomainDecider();
String Results[][]=domainDecider.getResultsOfQuery(Query);
//JOptionPane.showMessageDialog(null,Results.length);
}
public String[][] getResultsOfQuery(String Query)
{
    String Results[][]=null;
    try{
    DomainDecider domainDecider=new DomainDecider();
    String Domains[]=domainDecider.RelatedDomains(Query);
    int NoOfResults=new DomainDecider().getNoOfRelatedDomains(Domains);
//JOptionPane.showMessageDialog(null,"Size is"+NoOfResults);
   Results=new String[NoOfResults][6];
int total=0;
for(int i=0;i<Domains.length;i++)
{
    
    String Subresults[][]=new DomainOperations().URLReturning("Domain",Domains[i]);
for(int j=0;j<Subresults.length;j++)
{
    Results[total][0]=Subresults[j][0];
    Results[total][1]=Subresults[j][1];
    Results[total][2]=Subresults[j][2];
    Results[total][3]=Subresults[j][3];
    Results[total][4]=Subresults[j][4];
    Results[total][5]=Domains[i];
    total=total+1;
}
}
   // JOptionPane.showMessageDialog(null,"total is"+total);
System.out.println(""+total);
for(int i=0;i<Results.length;i++)
{
    System.out.println(Results[i][0]);
    System.out.println(Results[i][1]);
    System.out.println(Results[i][2]);
    System.out.println(Results[i][3]);
    System.out.println(Results[i][4]);
    System.out.println(Results[i][5]);
    
}

    }
    catch(Exception e){}
return Results;
}
public void RelatedDomainsDisplay(String Domain[])
{
    for(int i=0;i<Domain.length;i++)
    {
        System.out.println(""+Domain[i]);
    }
}
public void DomainDecider(String Word,String Domain[])
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/SearchEngine","root","");
String sql=" select domain from domainterminology where terminology like '%"+Word+"%';";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(sql);
while(rs.next())
{
Domain[No_Of_Domain]=rs.getString(1);
//System.out.println(Word+"-"+Domain[No_Of_Domain]);
No_Of_Domain=No_Of_Domain+1;
}

}
catch(  ClassNotFoundException | SQLException | HeadlessException e)
{
}
}
public int getNoOfRelatedDomains(String x[])
{
   int Total_Related_Domains=0;
   for(int i=0;i<x.length;i++)
   {
       Total_Related_Domains+=new TableOperations().NoOfRecords(x[i]);
   }
   return Total_Related_Domains;
}


public int getNoOfDomains()
{
    return No_Of_Domain;
}
public String[] RelatedDomains(String Query)
{
    
No_Of_Domain=0;
String Result[]=null;
String Target[]=null;
try
{
StringTokenFormating stf=new StringTokenFormating();
Query=stf.CommonTermsStemmer(Query);
System.out.println("After Stemming:"+Query);
String List[]=stf.Tokens(Query);
String Domain[]=new String[100];
int j=0;
for(int i=0;i<List.length;i++)
{
new DomainDecider().DomainDecider(List[i],Domain);
}
//JOptionPane.showMessageDialog(null, No_Of_Domain);
Result=new String[No_Of_Domain];

for(int i=0;i<No_Of_Domain;i++)
{
    Result[i]=Domain[i];
}
    System.out.println("Results are:");
for(int i=0;i<Result.length;i++)
{
    System.out.println(""+Result[i]);
}
Target=new HighRelatedShowing().HighlyRelated(Result);

    System.out.println("High Related are:");
for(int i=0;i<Target.length;i++)
{
    System.out.println(""+Target[i]);
}
}
catch(Exception e)
{}
return Target;
}
}
