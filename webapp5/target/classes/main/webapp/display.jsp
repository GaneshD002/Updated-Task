<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<center>
    <h2>Display Employee Details</h2>
    <hr>
    <form action="req3" method="post">
        <table>
            <tr>
                <td>Id:</td>
                <td><input type="text" name="eid"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="ename"></td>
            </tr>
            <tr>
                <td>Designation:</td>
                <td><input type="text" name="edesignation"></td>
            </tr>
            <tr>
                <td>Salary:</td>
                <td><input type="text" name="esalary"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" name="b1"
                    value="Display"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
