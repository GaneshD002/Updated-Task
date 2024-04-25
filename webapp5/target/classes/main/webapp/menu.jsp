<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<style>
/* Style for the horizontal menu */
nav ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #ADD8E6;
	position: relative;
}

nav ul li input[type="submit"] {
	display: block;
	color: white;
	background-color: #ADD8E6;
	border: none;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	cursor: pointer;
	border-radius: 8px;
	margin: 0 5px;
}

nav ul li {
	float: left;
}

nav ul li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

nav ul li a:hover {
	background-color: #ADD8E6;
}
</style>
</head>
<body>
	<script>
		function confirmLogout() {
			return confirm("Are you sure you want to logout?");
		}
	</script>
	<nav>
		<ul>
			<li>
				<form action="index.jsp">
					<input type="submit" value="Register">
				</form>
			</li>
			<li>
				<form action="login.jsp">
					<input type="submit" value="Login">
				</form>
			</li>
			<li>
				<form action="first.jsp">
					<input type="submit" value="Add">
				</form>
			</li>
			<li>
				<form action="display.jsp">
					<input type="submit" value="Display">
				</form>
			</li>
			<li>
				<form action="display.jsp">
					<input type="submit" value="Update">
				</form>
			</li>
			<li>
				<form action="delete.jsp">
					<input type="submit" value="Delete">
				</form>
			</li>
			<li>
				<form id="logoutForm" action="logout" method="get">
					<input type="submit" value="Logout"
						onclick="return confirmLogout()">
				</form>
			</li>
			<li style="float: right">
				<%
				String myUName = (String) session.getAttribute("Username");
				%> <%
 if (myUName == null) {
 %><a href="login.jsp">Please Login</a> <%
 } else {
 %>
				<h3>
					Welcome
					<%=myUName%></h3> <%
 }
 %>
			</li>
		</ul>
	</nav>
</body>

</html>