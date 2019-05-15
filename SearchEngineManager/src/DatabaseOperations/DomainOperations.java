/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseOperations;
import StringFormating.StringTokenFormating;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;


public class DomainOperations 
{
     public  void addDomainDescription(String Domain,String Title,String Subject,String Url,int PageRank )
{
    
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Domain","root","");
String sql="insert into "+Domain+" values( '"+Title+"','"+Subject+"','"+Url+"',"+PageRank+",null)";
Statement st=con.createStatement();
st.executeUpdate(sql);
System.out.println(Domain+":inserted Successfully");
//JOptionPane.showMessageDialog(null,"inserted Successfully"+x);
}
catch(  ClassNotFoundException | SQLException | HeadlessException e)
{
System.out.println(Domain+":domainDescription():error:"+e.getMessage());
}

}
    
    public void domain_Terminology_Inserting(String Domain,String Jargon)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/SearchEngine","root","");
String sql="insert into DomainTerminology(Domain,Terminology) values (?,?)";
PreparedStatement ps=con.prepareStatement(sql);
ps.setString(1,Domain);
ps.setString(2,Jargon);
ps.execute();
System.out.println(Domain+":inserted Successfully");
//JOptionPane.showMessageDialog(null,Domain+" inserted Successfully");
}
catch(  ClassNotFoundException | SQLException | HeadlessException e)
{
System.out.println(Domain+":domain_Terminology_Inserting();error:"+e.getMessage());
//JOptionPane.showMessageDialog(null,"domain_Terminology_Inserting();error:"+e.getMessage());
}
}
public String DomainTerminologyDetails(String Domain)
{
    String Result=domain_Jargon_Returning(Domain);
    return Result;
}
                  
    
public void domain_Terminology_Updating(String Domain,String Jargon)
{
String PreviousJargon=domain_Jargon_Returning(Domain);
//PreviousJargon=new StringFormating.StringTokenFormating().Tokenizing_Formating(PreviousJargon);
String AfterJargon=PreviousJargon+"-"+Jargon;
AfterJargon=new StringFormating.StringTokenFormating().Tokenizing_Formating(AfterJargon);
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/SearchEngine","root","");
String sql="Update DomainTerminology set Terminology=? where Domain='"+Domain+"'";
PreparedStatement ps=con.prepareStatement(sql);
ps.setString(1,AfterJargon);
ps.executeUpdate();
System.out.println(Domain+":Domain Updated Successfully");
//JOptionPane.showMessageDialog(null,"Domain Updated Successfully"+Domain+Jargon);
}
catch(  ClassNotFoundException | SQLException | HeadlessException e)
{
System.out.println(Domain+":domain_Terminology_Updating():error:"+e.getMessage());
//   JOptionPane.showMessageDialog(null,"domain_Terminology_Updating():error:"+e.getMessage());

}

}

public String[][] domain_Terminology_List(String Domain)
{
String DomainDetails=domain_Jargon_Returning(Domain);
String Domain_Jargon[][]=null;
Domain_Jargon=new StringTokenFormating().ListOfTokens(DomainDetails);
return Domain_Jargon;
}
public String domain_Jargon_Returning(String Domain)
{
String Result="";
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/SearchEngine","root","");
String sql="select *from DomainTerminology where Domain='"+Domain+"'";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(sql);
int i=0;
while(rs.next())
{
    Result=""+rs.getString(2);
}
}
catch(  ClassNotFoundException | SQLException | HeadlessException e)
{
}
return Result;
}
public void domain_Details_Inserting(String DomainName)
{
try  
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/SearchEngine","root","");
String sql="insert into domaindetails values(null,'"+DomainName+"',0)";
Statement st=con.createStatement();
st.executeUpdate(sql);
System.out.println(DomainName+":Domain Description Entered Successfully");
new TableOperations().UpdateNoOfRecords(DomainName);
//JOptionPane.showMessageDialog(null,"Domain Description Entered Successfully");
}
catch(  ClassNotFoundException | SQLException | HeadlessException e)
{
System.out.println(DomainName+":domain_Details_Inserting():error:"+e.getMessage());
    
//JOptionPane.showMessageDialog(null,"domain_Details_Inserting():error:"+e.getMessage());

}
}
public String[][] DomainNames(String Letter)
{
String DomainNames[][]=new String[100][2];
String Result[][]=null;
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/SearchEngine","root","");
String sql="select *from domaindetails where domain like '"+Letter+"%'";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(sql);
int i=0;
while(rs.next())
{
    DomainNames[i][0]=rs.getString(2);
    DomainNames[i++][1]=rs.getString(1);
    System.out.println(""+rs.getString(2));
}
Result=new String[i][2];
for(int j=0;j<i;j++)
{
    Result[j][0]=DomainNames[j][0];
    Result[j][1]=DomainNames[j][1];

}
}
catch(  ClassNotFoundException | SQLException | HeadlessException e)
{
}
return Result;
}
public void domainDescription(String Domain,String Title,String Subject,String Url,int PageRank )
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Domain","root","");
String sql="insert into "+Domain+"(Title,Subject,Url,PageRank) values(?,?,?,?)";
PreparedStatement ps=con.prepareStatement(sql);
ps.setString(1,Title);
ps.setString(2,Subject);
ps.setString(3,Url);
ps.setInt(4,PageRank);
int x=ps.executeUpdate();
System.out.println(Domain+":inserted Successfully");
//JOptionPane.showMessageDialog(null,"inserted Successfully"+x);
}
catch(  ClassNotFoundException | SQLException | HeadlessException e)
{
System.out.println(Domain+":domainDescription():error:"+e.getMessage());
}

}
public void addDomainsNotAvailable(String Query )
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/SearchEngine","root","");
String sql="insert into domainnotavailable values(null,'"+Query+"')";
Statement st=con.createStatement();
st.execute(sql);
JOptionPane.showMessageDialog(null,"added to Suggestions");
}
catch(  ClassNotFoundException | SQLException | HeadlessException e)
{
System.out.println("Failed to add it"+e);
}

}
public void AlterDomainDetails(String Table)
{
    try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/SearchEngine","root","");
Statement st=con.createStatement();
String sql="alter table "+Table+" add NoOfRecords int(4) DEFAULT 0 ";
 System.out.println("successfully added to the:"+Table);
st.execute(sql);
}
    catch(ClassNotFoundException | SQLException e)
    {
        System.out.println(""+e);
    }
}

public String[][] URLReturning(String Database,String Table)
    {
        String Display[][]=new String[100][5];
        String Result[][]=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Domain","root","");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select *from "+Table+" order by pagerank desc");
            int i=0;
                System.out.print(""+Table+":");
            while(rs.next())
            {
                Display[i][0]=rs.getString(1); 
                Display[i][1]=rs.getString(2); 
                Display[i][2]=rs.getString(3); 
                Display[i][3]=rs.getString(4); 
                Display[i][4]=rs.getString(5); 
                //System.out.println(""+Display[i][4]);
                i++;
                
            }
            System.out.println(""+i);
            Result=new String[i][5];
                
            for(int j=0;j<i;j++)
            {
                Result[j][0]=Display[j][0];
                Result[j][1]=Display[j][1];
                Result[j][2]=Display[j][2];
                Result[j][3]=Display[j][3];
                Result[j][4]=Display[j][4];
            }
        }
        catch(Exception e)
        {
            System.out.println(""+e);
        }
        return Result;
    }
public void DomainDescriptionUpdating(String Table,String Title,String value)
{
    try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/domain","root","");
            Statement st=con.createStatement();
            String sql="update "+Table+" set Subject='"+value+"' where Title='"+Title+"'";
            st.executeUpdate(sql);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(""+e);
        }
    
}
public void DomainDescriptionUpdating(String Table,String Title,String Field,String value)
{
    try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/domain","root","");
            Statement st=con.createStatement();
            System.out.println(""+Field.equalsIgnoreCase("PageRank"));
            String sql=null;
            if(Field.equalsIgnoreCase("PageRank"))
            {
            sql="update "+Table+" set "+Field+"="+value+" where Title='"+Title+"'";
            }
            else
            {
            sql="update "+Table+" set "+Field+"='"+value+"' where Title='"+Title+"'";
            }
            st.executeUpdate(sql);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(""+e);
        }
    
}
public void PageRankUpdating(String Table,String Title,int value)
{
    try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/domain","root","");
            Statement st=con.createStatement();
            
            String sql=null;
            
            sql="update "+Table+" set PageRank="+value+" where Title='"+Title+"'";
           
          
            st.executeUpdate(sql);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(""+e);
        }
    
}
public void DomainRecordDelete(String Domain,String Title)
{
    try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/domain","root","");
            Statement st=con.createStatement();
            String sql="delete from "+Domain+" where Title='"+Title+"'";
            int t=st.executeUpdate(sql);
            if(t>0)
            {
                System.out.println(Domain+" successfully Deleted");
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(""+e);
        }
}
public static void main(String args[])
{
    DomainOperations domainOperations=new DomainOperations();
    domainOperations.addDomainsNotAvailable("Hello");

}

}
