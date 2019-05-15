<%--
Document   : RecordsDelete
Created on : Dec 14, 2014, 7:02:17 AM
Author     : venkatesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DatabaseOperations.DomainOperations"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="EditingPageCss.css">
<title>JSP Page</title>
</head>
<body>

<form method="post" action="Delete.jsp">
<center>
<table border="1">
    <tr>
        <td><center>TITLE</center></td>
        <td><center>SUBJECT</center></td>
        <td><center>URL</center></td>
    </tr>
<%
String Domain="News_Paper";
DomainOperations domainOperations=new DomainOperations();
String DeletedList[][]=domainOperations.URLReturning("Domain",Domain);

for(int i=0;i<DeletedList.length;i++)
{
%>
<tr>
<td>
<input type="checkbox" Name="List<%=i%>" value="<%=DeletedList[i][0]%>">:<label><%=DeletedList[i][0]%></label>
</td>
<td>
<textArea rows="6" cols="30" >
<%=DeletedList[i][1]%>
</textarea>
</td>
<td>
<%=DeletedList[i][2]%>
</td>
</tr>
<%}%>

<input type="hidden" value="<%=Domain%>" name="Domain">

<br/>
<tr>
<td colspan="3">
<center>
<input type="submit" value="Delete">
</center></td>
</table>
</center>
<form>
</body>
</html>
