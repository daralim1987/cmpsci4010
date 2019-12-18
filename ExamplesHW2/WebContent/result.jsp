<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result for Q${qn}</title>
</head>
<body>
	<h2>Result for Q${qn}</h2>
	<p></p>
	<c:choose>
		<c:when test="${qn == 14}">
		    <% int m = 12; %>
			<ul>
				<li>Case 1: Access local variable through EL - ${m}</li>
				<li>Case 2: Access local variable through JSP expression: <%= m %></li>
			</ul>    
        </c:when>
		<c:when test="${qn == 20}">
			<ul>
				<li>Case 1: myprob with valid properties - ${myprob.pid}, ${myprob.content}, ${myprob.order_num}</li>
				<li>Case 2: myprob with an invalid property - ${myprob.pid}</li>
				<li>Case 3: access prob - ${prob}</li>
				<li>Case 4: access prob with a wrong name - ${prob0}</li>
				<li>Case 5: access a property of prob - ${prob.pid}</li>
				<li>Case 6: access a property of prob - ${prob0.pid}</li>
			</ul>
		</c:when>
		<c:when test="${qn == 22}">
			<ul>
				<li>Case 1: access parameter chap - ${param.chap}</li>
				<li>Case 2: access parameter chp - ${param.chp}</li>
			</ul>
		</c:when>
		<c:otherwise>
			Nothing to display 
		</c:otherwise>
	</c:choose>
</body>
</html>