<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Blog</title>
</head>
<body>
  <div align="center" style="margin-top: 50px;">
 
        <form method="POST" action="BlogServlet">
            Blog ID : <input type="text" name="blog_id" size="20px" required> <br>
           	Blog Content:  <textarea  name="blog_content" rows="4" required></textarea> <br><br>
        <input type="submit" value="submit">
        </form>
 
    </div>
    <a href="MyServlet">Logout</a>
</body>
</html>