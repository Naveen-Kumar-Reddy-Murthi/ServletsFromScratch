<%@ page language="java" isErrorPage="true" import="java.io.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<html>
<head>
 <!-- for error page isErrorPage="true" tag is must. Otherwise it will not
 	  work as error page   -->
<title>Error Page</title>
</head>
<body>
	<b style="color:red">Internal Error occurred. Please try again later</b>
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