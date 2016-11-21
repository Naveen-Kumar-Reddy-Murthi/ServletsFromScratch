<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="ServletInterfaceImpl_1?req=ServletInterfaceImpl_1...">ServletInterfaceImpl_1</a><br>
<a href="GenericServletImpl_2_7?req=GenericServletImpl_2_7...">GenericServletImpl_2</a><br>
<a href="HttpServletImpl_3?req=HttpServletImpl_3...">HttpServletImpl_3</a><br>
 <form action="HttpServletImpl_3_7" method="post">
<input type="text" name="req">
<input type="submit" name="submit" value="hitHttpServlet">
</form>
Request Dispatcher example<br>
<a href="input.html">login URL</a><br>

SendRedirectServlet example<br>
<form action="sendRedirectServlet">
<select name="se">
<option value="Google">Google</option>
<option value="Yahoo">Yahoo</option>
<option value="Bing">Bing</option>
</select>
<input type="text" name="query">
<input type="submit" value="search">
</form>
<br>
<a href="cookiesServlet">GenerateCookies</a><br>
<a href="showCookies">Show Cookies</a><br>
session tracking using hidden variables, cookies and HttpSession and url re-writing<br>
<form action="sessionTracker1" >
<table title="Employee Details">

<tr>
	<td>Name:</td>
	<td><input type="text" name="name"></td>
</tr>
<tr>
	<td>Id:</td>
	<td><input type="text" name="id"></td>
</tr>
<tr>
	<td>Dept:</td>
	<td><input type="text" name="dept"></td>
<tr>
<tr>
	<td>Domain:</td>
	<td><input type="text" name="domain"></td>
<tr>
<tr>
	<td>Email:</td>
	<td><input type="text" name="email"></td>
<tr>
<tr>
	<td>Location:</td>
	<td><input type="text" name="loc"></td>
<tr>
<tr>
	<td><input type="submit" name="continue"></td>
<tr>
</table>
</form>
<br>
Filters demo <br>

<form action="login">
Username:<input type="text" name="uname"><br>
Password:<input type="password" name="password"><br>
<input type="submit" name="submit" value="login">
</form>

Programatic Application security<br>
<br>
<form action="adminServlet">
 username:<input type="text" name="name"><br>
 password:<input type="text" name="password"><br>
 <input type="submit" value="login"><br>
 </form>

<br> Application declarative web security<br>
<a href="secureServlet?name=naven">secureServlet</a>


</body>
</html>