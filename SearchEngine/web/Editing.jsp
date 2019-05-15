<%--
Document   : Editing
Created on : Dec 13, 2014, 2:58:14 AM
Author     : venkatesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DatabaseOperations.DomainOperations" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="EditingPageCss.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body bgcolor="black">
<center>  <h1>EditDatabase</h1> </center>
<%
String FieldList[]={"Title","Subject","Url","PageRank"};
int RealField=1;
String Domain="News_Paper";
Domain=request.getParameter("Domain");
String Field=request.getParameter("Field");
RealField=Integer.parseInt(Field);
out.println(""+(5+RealField));
String Urls[][]=new DomainOperations().URLReturning("Domain",Domain);
%>
<form method="post" action="Edit.jsp">
<center>
<table >
<%
String TextField=FieldList[RealField];
for(int i=0;i<Urls.length;i++)
{
%>

<tr>
<td> 
    <label><%=Urls[i][0]%></label>  
    <br/>
<textarea rows="6" cols="50" name="Recording:<%=i%>" name="textarea<%=i%>">
<%=Urls[i][RealField]%>
</textarea>
</td>
</tr>
<%}%>
<td >
<center>
<input type="hidden" Name="Domain" value="<%=Domain%>">
</center>
</td>
<tr>
<td >
<center>
<input type="hidden" name="Field" value="<%=TextField%>">
</center>
</td>
</tr>
<tr>
<td >
<center>
<input type="submit" value="Submit">
</center>
</td>
</tr>
</table>
</center>
</form>
</body>
</html>
