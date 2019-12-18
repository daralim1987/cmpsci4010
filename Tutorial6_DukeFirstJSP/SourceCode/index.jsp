<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head><title>Hello</title></head>
<body bgcolor="white">
<img src="duke.waving.gif"> 
<h2>Hello, my name is Duke. What's yours?</h2>
<form method="get">
<input type="text" name="username" size="25">
<p></p>
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</form>

<%
   String name = request.getParameter("username");
   if (name != null) {
%>
       <%@include file="response.jsp" %>
<%
   }
%> 

</body>
</html>
