<%-- 
    Document   : Delete
    Created on : Dec 14, 2014, 7:11:03 AM
    Author     : venkatesh
--%>

<%@page import="DatabaseOperations.TableOperations"%>
<%@page import="DatabaseOperations.DomainOperations"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="EditingPageCss.css">

        <title>JSP Page</title>
    </head>
    <body>
        <%
        String Domain=request.getParameter("Domain");
       // out.println(""+Domain);
        int No=new TableOperations().NoOfRecords(Domain);
        //out.print(No);
        String Decision[]=new String[No];
        for(int i=0;i<No;i++)
                       {
            Decision[i]=request.getParameter("List"+i);
            if(Decision[i]!=null)
                {
                 out.println("<br/>"+Decision[i]); 
                 new DomainOperations().DomainRecordDelete(Domain,Decision[i]);
                     
                }
                             }
        %>
    </body>
</html>
