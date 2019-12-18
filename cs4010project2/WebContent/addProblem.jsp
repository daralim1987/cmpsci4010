<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%-- beans used in this JSP --%>
<jsp:useBean id="proObj" scope="page"
	class="edu.umsl.math.beans.Problem" />
<jsp:useBean id="proData" scope="request"
	class="edu.umsl.math.dao.ProblemDao" />

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Add New Math Problem</title>

<style type="text/css">
body {
	font-family: tahoma, helvetica, arial, sans-serif;
}

table, tr, td {
	font-size: .9em;
	border: 3px groove;
	padding: 5px;
	background-color: #dddddd;
}
</style>
</head>

<body>
	<jsp:setProperty name="proObj" property="*" />

	<%
		// start scriptlet

		if (proObj.getContent() == null) {
	%>
	<%-- end scriptlet to insert fixed template data --%>

	<form method="post" action="addProblem.jsp">
		<p>Enter content order number and category id to
			problem list.</p>

		<table>
	
			<tr>
				<td>Problem Content</td>

				<td><input type="text" name="content" /></td>
			</tr>

			<tr>
				<td>Order number</td>

				<td><input type="text" name="order_num" /></td>
			</tr>

			<tr>
				<td>Category ID</td>

				<td><input type="text" name="cid" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>

	<%
		// continue scriptlet

		} // end if
		else {
			proData.addProblem(proObj);
	%>
	<%-- end scriptlet to insert jsp:forward action --%>

	<%-- forward to display guest book contents --%>
	<jsp:forward page="index.jsp" />

	<%
		// continue scriptlet

		} // end else
	%>
	<%-- end scriptlet --%>
</body>

</html>
