<%@ include file="menu.jsp" %>
<html>
<body>
<center>
    <h2>Registration</h2>
    <form action="req1" method="post">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="uname" required><br><br>
        
        <label for="email">Email:</label><br>
        <input type="text" id="email" name="uemail" required><br><br>
        
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="upassword" required><br><br>
        
        <input type="submit" name="a1" value="Register">
    </form>
</center>
</body>
</html>
