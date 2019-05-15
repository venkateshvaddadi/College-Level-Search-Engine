/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseOperations;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author venkatesh
 */
public class TableOperations 
{
    public void tableCreation(String DataBase,String TableName)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/"+DataBase,"root","");
Statement st=con.createStatement();
String sql;
sql="CREATE TABLE "+TableName+" (Title varchar(200) not null,Subject varchar(2048) not null,Url varchar(512),PageRank int(10),NoOfRecord int(11) not null auto_increment,PRIMARY KEY (NoOfRecord))" ;
st.execute(sql);
System.out.println(TableName+":Domain waa Created");
}
catch(  ClassNotFoundException | SQLException | HeadlessException e)
{
System.out.println(TableName+":tableCreation():error:"+e.getMessage());
}

}
public String[] gettingTablesList(String DataBase)
{
String tables[]=new String[300];
String Domain[]=null;
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/"+DataBase,"root","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("show tables");
String res="";
int i=0;
while(rs.next())
{
tables[i]=rs.getString(1);
i++;
res=res+"\n"+rs.getString(1);
}
Domain=new String[i];
for(int j=0;j<i;j++)
{
Domain[j]=tables[j];
}
System.out.println(""+res);
}
catch(  ClassNotFoundException | SQLException | HeadlessException e)
{
System.out.println("gettingTablesList():error:"+e.getMessage());

    //JOptionPane.showMessageDialog(null,"gettingTablesList():error:"+e.getMessage());

}
return Domain;

}
public static void main(String args[])
{
   String Table="accounting";
       try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Domain","root","");
Statement st=con.createStatement();
String sql="alter table "+Table+" add Age int(10)  auto_increment ";
 System.out.println("successfully added to the:"+Table);
st.execute(sql);
}
    catch(ClassNotFoundException | SQLException e)
    {
        System.out.println(""+e);
    }
    
}
public void tableDataGetting(String Database,String Table,int Member)
{    
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/"+Database,"root","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select *from "+Table );
int i=0;
while(rs.next())
{
System.out.println(rs.getString(i));
}
}
catch(ClassNotFoundException | SQLException e)
{
System.out.println("tableDataGetting():error"+e);
}
  
}
public int NoOfRecords(String Table)
{
    int no=0;
    try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Domain","root","");
Statement st=con.createStatement();
String Sql="select count(*) from "+Table;
ResultSet rs=st.executeQuery(Sql);
while(rs.next())
{
    no=rs.getInt(1);
}
}
    catch(Exception e)
    {
        
    }
    return no;
}
public void TotalUpdate()
{
    TableOperations tableOperations=new TableOperations();
    String Domain[]=tableOperations.gettingTablesList("Domain");
    for(int i=0;i<Domain.length;i++)
    {
        UpdateNoOfRecords(Domain[i]);
    }
}
public void UpdateNoOfRecords(String TableName)
{
    try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/SearchEngine","root","");
String sql="Update domaindetails set NoOfRecords="+new TableOperations().NoOfRecords(TableName)+" where Domain='"+TableName+"'";
Statement st=con.createStatement();
st.executeUpdate(sql);
System.out.println(TableName+"Updated ");
}
catch(ClassNotFoundException | SQLException e)
{
System.out.println("tableDataGetting():error"+e);
}
}
    
 public String[] tableColoumDataGetting(String Database,String Table,int Member)
{    
    String Temp[]=new String[10000];
    String Result[]=null;

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/"+Database,"root","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("SELECT * FROM "+Table+" LIMIT 100" );
int i=0;
int j=0;
while(rs.next())
{
System.out.println(rs.getString(Member));
Temp[j++]=rs.getString(Member);
}
Result=new String[j];
for(i=0;i<j;i++)
{
 Result[i]=Temp[i];   
}
}
catch(ClassNotFoundException | SQLException e)
{
System.out.println("tableDataGetting():error"+e);
}
System.out.println(""+Result.length);
return Result;

}
    
}
