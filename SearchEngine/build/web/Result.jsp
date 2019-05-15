<%-- 
    Document   : Result
    Created on : Aug 31, 2014, 5:08:45 AM
    Author     : venkatesh
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.AALOAD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="SearchStyle.css">
    </head>
    <body >
        <div id="main">
            
        </div>
   
  <div class="main">     
  <%
        String url[]=new String[100];
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/trailproject","root","");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select *from Urls");
            
            int i=0;
            while(rs.next())
            {
             url[i++]=rs.getString(1);  
       
            %>
            
            
            
            <div class="url">
          

          <div>
            <a href="https:/<%= url[i-1] %>">
            <font size="5">  &nbsp;&nbsp;<%= url[i-1] %></font>
            </a>
          </div>           
       
            <div class="inside">
                    <p> 
                        The align attribute specifies the alignment of the text within a paragraph.In our CSS tutorial you can find more details about the text-align property. Syntax. 
                    </p>                
            </div>
             
            
            </div>
            <hr height="2" width="480">
                        
            <%
            }
        }
        catch(Exception e)
        {
            System.out.println(""+e);
        }
       %>
        
        
    </div>    
       
    </body>
</html>
