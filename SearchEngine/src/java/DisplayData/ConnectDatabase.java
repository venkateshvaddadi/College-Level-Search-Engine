package DisplayData;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDatabase 
{
    public String[][] URLReturning(String Database,String Table)
    {
        String Display[][]=new String[100][4];
        String Result[][]=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/"+Database,"root","");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select *from "+Table);
            int i=0;
            while(rs.next())
            {
                Display[i][0]=rs.getString(1); 
                Display[i][1]=rs.getString(2); 
                Display[i++][2]=rs.getString(3); 
            }
            Result=new String[i][4];
                
            for(int j=0;j<i;j++)
            {
                Result[j][0]=Display[j][0];
                Result[j][1]=Display[j][1];
                Result[j][2]=Display[j][2];
            }
        }
        catch(Exception e)
        {
            System.out.println(""+e);
        }
        return Result;
    }
    
}
