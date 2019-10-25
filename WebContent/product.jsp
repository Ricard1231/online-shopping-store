<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:property value="search" /></title>
</head>
<body>
<s:iterator value="itemlist">
<s:property name="iname" value="iname"/>
<s:property name="iprice" value="iprice"/>
<s:property value="idesc"/>
</s:iterator>
<a href="purchase.jsp">Purchase</a>
</body>
</html>