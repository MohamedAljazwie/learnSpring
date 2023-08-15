<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!--<a href="/LearningSpring/admissionForm.html">Click Here</a>-->
    <c:url  var="requestURL" value="/admissionForm.html">
    <c:set var="current" value="1" scope="session"/>
    <% request.setAttribute("data", "DATA Session");  %>
    </c:url>
    <a href="${requestURL}">Click Here</a>
</body>
</html>