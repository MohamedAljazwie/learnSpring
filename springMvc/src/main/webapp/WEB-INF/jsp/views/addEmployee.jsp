<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
		<h2>Add Employee Data</h2>
		<form method="POST" action="save.html">
	   		<table>
			    <tr>
			        <td>Employee ID</td>
			        <td><input name="empID"  type="text" value="${employee['empID']}"  /></td>
			    </tr>
			    <tr>
			        <td>Employee Name: </td>
			        <td><input name="empName" type="text" value="${employee['empName']}"/></td>
			    </tr>
			    <tr>
			        <td>Employee Age: </td>
			        <td><input name="empAge"  type="text" value="${employee['empAge']}"/></td>
			    </tr>
			    <tr>
			        <td>Employee Salary: </td>
			        <td><input name="empSalary"  type="text" value="${employee['empSalary']}"/></td>
			    </tr>
			    
			    <tr>
			        <td>Employee Address: </td>
                    <td><input type="text" value="${employee['address']}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		
<c:if test="${!empty employees}">
	<table align="left" border="1">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Age</th>
			<th>Employee Salary</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${employees}" var="empMap">
		<c:set var="employee" value="${empMap.value}"/>
			<tr>
				<td><c:out value="${employee['empID']}"/></td>
				<td><c:out value="${employee['empName']}"/></td>
				<td><c:out value="${employee['empAge']}"/></td>
				<td><c:out value="${employee['empSalary']}"/></td>
				<td align="center"><a href="edit.html?empID=${employee['empID']}">Edit</a> | <a href="delete.html?empID=${employee['empID']}">Delete</a></td>
			
			</tr>
		</c:forEach>
	</table>
</c:if>
		
	</body>
</html>