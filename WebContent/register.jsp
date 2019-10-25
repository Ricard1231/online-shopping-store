<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<s:form action="register" method="post">
		<s:textfield name="username" label="global.name" size="20" />
		<s:password name="password" label="global.password" size="20" />
		<s:password name="cpw" label="Confirm Password" size="20" />
		<s:textfield name="email" label="Email" size="20" />
		<s:radio name="gender" label="Gender" list="{'Male', 'Female'}"
			value="'Male'" />
		<s:select name="city" label="City"
			list="#{'Foshan' : 'Foshan', 'Guangzhou' : 'Guangzhou', 'Shenzhen' : 'Shenzhen', 'Beijing' : 'Beijing', 'Shanghai' : 'Shanghai'}"
			headerKey="-1" headerValue="Please select a city" />
		<s:textarea name="address" label="Address" />
		<s:textfield name="cardnum" label="Card Number" size="20" />
		<s:password name="cardpw" label="Card Password" size="20" />
		<s:textfield name="pin" label="PIN" size="6" />
		<s:checkboxlist name="interest" label="Interest" list="{'A', 'B', 'C', 'D'}" />
		<s:submit value="Register" />
	</s:form>
	<s:url var="localeEn" namespace="/" action="locale">
		<s:param name="request_locale">en</s:param>
	</s:url>
	<s:url var="localeES" namespace="/" action="locale">
		<s:param name="request_locale">es</s:param>
	</s:url>
	<s:url var="localeDE" namespace="/" action="locale">
		<s:param name="request_locale">de</s:param>
	</s:url>
	<s:url var="localeFR" namespace="/" action="locale">
		<s:param name="request_locale">fr</s:param>
	</s:url>
	
	<s:a href="%{localeES}">Spanish</s:a>
	<s:a href="%{localeDE}">German</s:a>
	<s:a href="%{localeFR}">France</s:a>
	<s:a href="%{localeEN}">English</s:a>
</body>
</html>