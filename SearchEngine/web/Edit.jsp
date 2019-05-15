<%--
Document   : Edit
Created on : Dec 13, 2014, 4:22:34 AM
Author     : venkatesh
--%>

<%@page import="DatabaseOperations.DomainOperations"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="EditingPageCss.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
    <center>
<%
String Field=request.getParameter("Field");
out.println("Field: "+Field);
String Domain=request.getParameter("Domain");
String Member=request.getParameter("Membetr");
DomainOperations domainOperations=new DomainOperations();
String OldSubject[][]=domainOperations.URLReturning("Domain",Domain);
String NewSubject[]=new String[OldSubject.length];
for(int i=0;i<OldSubject.length;i++)
{
NewSubject[i]=request.getParameter("Recording:"+i);
%>
<div class="OutSide">
<div class="Edited">
<label><%=OldSubject[i][0] %></label>
<br/> 
<p>
    <%=NewSubject[i] %>
</p>
</div>
</div>
<br/>
<%
}
for(int i=0;i<OldSubject.length;i++)
{
String Title,Subject;
Title=OldSubject[i][0];
domainOperations.DomainDescriptionUpdating(Domain,Title,Field,NewSubject[i]);
}
%>
</center>


</body>
</html>
