<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<div align="center" style="margin-top: 50px;">

		<form method="POST" action="MyServlet">
			Please enter your Username: <input type="text" name="username"
				size="20px" required> <br> Please enter your Password:
			<input type="password" name="password" size="20px" required>
			<br>
			<br> <input type="submit" value="submit">
		</form>

	</div>

</body>
</html>