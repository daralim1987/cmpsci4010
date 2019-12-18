<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.math.BigInteger" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Result</title>
</head>
<body>
<% 
    BigInteger onebigint = (BigInteger) request.getAttribute("onebigint");
    BigInteger crtbigsqrt = (BigInteger) request.getAttribute("crtbigsqrt");
    BigInteger diff1 = (BigInteger) request.getAttribute("diff1");
    BigInteger diff2 = (BigInteger) request.getAttribute("diff2");
%>
Result: <%= onebigint %> <br /><br />
Square root: <%= crtbigsqrt %> <br /><br />
Difference 1: <%= diff1 %> <br /><br />
Difference 2: <%= diff2 %> <br /><br />
</body>
</html>