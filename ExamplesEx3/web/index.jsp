<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>List of Questions</title>
    </head>
    <body>
        <h2>Explain 3 Questions in EX3</h2>
        <p></p>
        <ul>
            <li>Q3: Check if a space character is allowed in a parameter name.
                <p></p>
                <form action="prepdata" method="get">
                    <input type="hidden" name="qn" value="3" />
                    <input type="text" name="my data" value="" />
                    <p></p>
                    <input type="submit" value="Submit" />
                </form>
                <p></p>
            </li>
            <li><a href="prepdata?qn=13">Q13:</a> Is it possible for a Map object containing an item with a number key <p></p></li>
            <li><a href="prepdata?qn=?">Q?:</a> </li>
        </ul>
    </body>
</html>