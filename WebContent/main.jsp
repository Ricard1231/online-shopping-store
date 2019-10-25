<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Page</title>
</head>
<body>
<s:form action="searchbar">
		<sx:autocompleter label="Search" size="1" name="search"
			list="listOfProducts" showDownArrow="false" />
		<s:submit value="Search"/>
</s:form>
<s:label name="picture" value="1"/>
<a href="pictureAction.action?pid=1"><img src="img/cash.png"/></a>
</body>
</html>