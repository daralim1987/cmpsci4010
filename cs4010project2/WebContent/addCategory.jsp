<?xml version = "1.0"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%-- beans used in this JSP --%>
<jsp:useBean id="catObj" scope="page"
	class="edu.umsl.math.beans.Category" />
<jsp:useBean id="proData" scope="request"
	class="edu.umsl.math.dao.ProblemDao" />

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Add New Category</title>

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
	<jsp:setProperty name="catObj" property="*" />

	<%
		// start scriptlet

		if (catObj.getTitle() == null) {
	%>
	<%-- end scriptlet to insert fixed template data --%>

	<form method="post" action="addCategory.jsp">
		<p>Enter New category title inot category list.</p>

		<table>
			<tr>
				<td>Category Title</td>

				<td><input type="text" name="title" /></td>
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
			proData.addCategory(catObj);
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
