package DatabaseOperations;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class DataBaseMethods
{
public void dataBaseCreaton(String DatabaseName)
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost","root","");
Statement st=con.createStatement();
st.execute("create database "+DatabaseName);
System.out.println(DatabaseName+" Database created Successfully");
//JOptionPane.showMessageDialog(null,"DatabaseCreated Successfully");
}
catch(  ClassNotFoundException | SQLException | HeadlessException e)
{
System.out.println(DatabaseName+"DatabaseCreation():"+e.getMessage());
//JOptionPane.showMessageDialog(null,"DatabaseCreation():"+e.getMessage());
}
}
public void showDataBases()
{
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Checking","root","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("show databases");
String res="";
while(rs.next())
{
res=res+rs.getString(1);
}
System.out.println(""+res);
}
catch(  ClassNotFoundException | SQLException | HeadlessException e)
{
System.out.println("showDatabase():"+e.getMessage());
}

}
}
