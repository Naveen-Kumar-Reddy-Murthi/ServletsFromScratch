<%@ page language="java" isErrorPage="true" import="java.io.*" 
        contentType="text/html"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
 <!-- for error page isErrorPage="true" tag is must. Otherwise it will not
 	  work as error page   -->
<title>Error1 Page</title>
</head>
<body>
	<b style="color:red">11 Internal Error occurred. Please try again later</b>
</body>
</html>

<br>
Internal error occurred! Please try again later!


<br>
StackTrace:
<%
	StringWriter stringWriter = new StringWriter();
	PrintWriter printWriter = new PrintWriter(stringWriter);
	exception.printStackTrace(printWriter);
	out.println(stringWriter);
	printWriter.close();
	stringWriter.close();
%>