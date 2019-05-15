/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Checking;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author venkatesh-PC
 */
public class Checking 
{
    public static void main(String args[])
    {
//     new Checking().PageRankUpdating("accounting","4", "54");
     String Check[]=null;
     System.out.println(Check.length);
    }
    public void PageRankUpdating(String Table,String NoOfRecord,String value)
{
    try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/domain","root","");
            Statement st=con.createStatement();
            String sql="update "+Table+" set PageRank="+value+" where NoOfRecord="+NoOfRecord+"";
            st.executeUpdate(sql);
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
            ResultSet rs=st.executeQuery("select *from "+Table);
            int i=0;
            while(rs.next())
            {
                Display[i][0]=rs.getString(1); 
                Display[i][1]=rs.getString(2); 
                Display[i][2]=rs.getString(3); 
                Display[i][3]=rs.getString(4); 
                Display[i][4]=rs.getString(5); 
                System.out.println(""+Display[i][4]);
                i++;
                
            }
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
    
}

