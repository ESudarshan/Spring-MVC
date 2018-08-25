<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<html>
<body>
	<h2>${title}</h2>

	<form:errors path="emp.*" />	
	<form action="signup-submit" method="post" >
	<br>Name : <input name="name" type="text" /> <br> <br>Email
		: <input name="email" type="text" /> <br> <br>DoB : <input
			name="dob" type="text" /> <br> <br>Skills : <select
			multiple name="skills">
			<option>Java</option>
			<option>Spring</option>
			<option>HIbernate</option>
		</select> <br>City : <input name="addr.city" type="text" /><br> <br>Pincode
		: <input name="addr.pincode" type="text" /> <br> <br> : <input
			type="submit">
	</form>
</body>
</html>
