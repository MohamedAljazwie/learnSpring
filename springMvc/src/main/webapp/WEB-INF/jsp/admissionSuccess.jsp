<%-- 
    Document   : admissionSuccess.jsp
    Created on : Jun 13, 2018, 2:12:28 PM
    Author     : msayed
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <table>
                <tr>
                    <td>User Name </td> 
                    <td>
                       <c:out value="${student.username}"/>    
                    </td>
                </tr>
                <tr>
                    <td>
                        password
                    </td>
                    <td>
                       <c:out value=" ${student.password}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Mobile 
                    </td>
                    <td>
                      <c:out value=" ${student.mobile}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Date
                    </td>
                    <td>
                        <c:out value=" ${student.date}"/>
                    </td>
                </tr>
                
                     <tr>
                    <td>
                        SKills
                    </td>
                    <td>
                        <c:forEach  items="${student.skills}" var="skill">
                            
                            <c:out value="${skill}"/>
                        </c:forEach>
                    </td>
                </tr>
                
                  <tr>
                    <td>
                        City 
                    </td>
                    <td>
                      <c:out value=" ${student.address.city}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Street
                    </td>
                    <td>
                         <c:out value=" ${student.address.street}"/>
                    </td>
                </tr>
                
                 <tr>
                    <td>
                        PineCode
                    </td>
                    <td>
                         <c:out value=" ${student.address.pincode}"/>
                    </td>
                </tr>
     </table>
    </body>
</html>
