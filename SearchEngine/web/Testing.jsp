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
<%@page import="DomainDecider.DomainDecider" %>
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
<div class="top1">
<div class="top2">
    <form action="Testing.jsp" method="post">
<table >
<tr>
<td><font style="font-size:2.8em" color="red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sodha</font></td>
<td><input type="text"  class="Subbox" value=" " name="InputText"  /></td>
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
String Database="domain";
String DecidedDomain=request.getParameter("InputText");  
String Query=DecidedDomain;
DomainDecider domainDecider=new DomainDecider();
String Domains[]=domainDecider.RelatedDomains(Query);
out.println(""+Domains.length);
if(Domains.length>0)
       {
for(int No=0;No<Domains.length;No++)
       {
%>
<%
try
{
String Check[][]=null;
Check=new ConnectDatabase().URLReturning("domain",Domains[No]);
int x=Check.length    ;
if(x==0)
{
%>
<%
}
if(x>0)
{
for(int i=0;i<Check.length;i++)
{
%>
<div class="url">
<div class="urlbox">
<a href="http://<%= Check[i][2] %>">
<font size="4" ><%= Check[i][0] %></font>
</a>
</div>
<div class="inside">
<font color="green" size="4">https://<%= Check[i][2] %></font>
<p>
    <%= Check[i][1]%>
</p>
</div>
</div>
<hr height="2" width="480">
<%
}
}
}
catch(Exception e)
               {
       
    %>
<div class="url">
<div class="urlbox">
<a href="#">
<font size="4" >Page Not Found</font>
</a>
</div>
<div class="inside">
<font color="green" size="4"></font>
<p>Youe specified Page is not available here.......</p>
</div>
</div>
</div>
<%

}
}
}
else
       {
    %>
    
    <div class="url">
<div class="urlbox">
<a href="#">
<font size="4" >Page Not Found</font>
</a>
</div>
<div class="inside">
<font color="green" size="4"></font>
<p>Youe specified Page is not available here.......</p>
</div>
</div>
</div>
    
    
    
    
    <%
    
    
    
    
    
       }
%>

</body>
</html>
