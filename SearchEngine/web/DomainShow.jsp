<%--
Document   : DomainShow
Created on : Dec 13, 2014, 4:47:39 AM
Author     : venkatesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DatabaseOperations.TableOperations" %>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="EditingPageCss.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<center>
<h1>Domain-Edit</h1>
<%
TableOperations tableOperations=new TableOperations();
String Domain[]=tableOperations.gettingTablesList("Domain");
%>
<form method="post" action="Editing.jsp">
<table>
<tr>
    <td><label>Domain:</label></td>
<td>
<select name="Domain">
<%
for(int i=0;i<Domain.length;i++)
{
%>
<option><%=Domain[i]%></option>
<%}%>
</select>
</td>
</tr>
<tr>
    <td><label>Field:</label></td>
<td>
<select name="Field">
<option>0</option>
<option>1</option>
<option>2</option>
<option>3</option>
</select>
</td>
</tr>
<tr>
    <td></td>
<td >
   
<input type="submit" value="Edit">
    
</td>
</tr>
</form>
</center>
</body>
</html>
