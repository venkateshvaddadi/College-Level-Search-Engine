<%--
Document   : Result
Created on : Aug 31, 2014, 5:08:45 AM
Author     : venkatesh
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="DisplayData.ConnectDatabase"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.AALOAD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet" type="text/css" href="SearchStyle.css">
</head>
<body bgcolor=#9999ff>
<div class="top1">
<div class="top2">
<form action="Check.jsp" method="post">
<table >
<tr>
<td><font style="font-size:2.8em" color="red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sodha</font></td>
<td><input type="text"  class="Subbox" value=" " name="text_name"  /></td>
<td><input type="submit"  class="Subbox1"  value="Search" height="100" width="100"  /></td>
</tr>
</table>
</form>
</div>
</div>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<div class="main">
<%
String Check[][]=new ConnectDatabase().URLReturning("domain","Search_Engine");
//out.print(Check.length);
String url[]=new String[100];
String Subject[]=new String[100];
String Title[]=new String[100];
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/domain","root","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select *from Search_Engine");
int i=0;
while(rs.next())
{
Title[i]=rs.getString(1);
Subject[i]=rs.getString(2);
url[i++]=rs.getString(3);
%>
<div class="url">
<div>
<a href="https:/<%= Title[i-1] %>">
<font size="4" ><%= Title[i-1] %></font>
</a>
</div>

<div class="inside">
<font color="green" size="4">https://<%= url[i-1] %></font>
<p><%= Subject[i-1]%></p>
</div>
</div>
<hr height="2" width="480">
<%
}
}
catch(Exception e)
{
System.out.println("Page Not Found");
}
%>


</div>

</body>
</html>
