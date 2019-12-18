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
            <c:when test="${qn == 3}">
                The value you entered: ${pv}  
            </c:when>
            <c:when test="${qn == 13}">
                <ul>
                    <li>Case 1: mymap containing an item with a digit key - ${mymap["4"]}</li>
                    <li>Case 2: mymap containing an item with a wrong digit key - ${mymap["3"]}</li>
                    <li>Case 3: access mylst within the range - ${mylst["2"]}</li>
                    <li>Case 4: access mylst out of the range - ${mylst["4"]}</li>
                    <li>Case 5: access myarr out of the range - ${myarr["4"]}</li>
                    <li>Case 6: access myprob with double quotes - ${myprob["pid"]}</li>
                    <li>Case 7: access myprob without double quotes - ${myprob["content"]}</li>
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