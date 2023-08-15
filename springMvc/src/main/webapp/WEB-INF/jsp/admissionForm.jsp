<%-- 
    Document   : admissionForm
    Created on : Jun 13, 2018, 1:57:33 PM
    Author     : msayed
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form:errors path="student.*"/>
         Data <h1>${requestScope.data}</h1>
        <h1>${message}</h1>
        <form action="/LearningSpring/admissionSuccess.html" method="post">
           <table>
                <tr>
                    <td>User Name </td> 
                    <td>
                        <input type="text" name="username" value="${student.username}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        password
                    </td>
                    <td>
                        <input type="password" name="password" value="${student.password}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Mobile 
                    </td>
                    <td>
                        <input type="text" name="mobile" value="${student.mobile}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Date
                    </td>
                    <td>
                        <input type="text" name="date"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Skills 
                    </td>
                    <td>
                        <select multiple="true" name="skills">
                            <option value="Java"> Java</option>
                            <option value="Linux"> Linux</option>
                            <option value="Angular"> Angular</option>
                            <option value="Spring"> Spring</option>

                        </select>
                    </td>
                </tr>
                <tr><td>Register</td>
               
                </tr>
            </table>
                    <div>
                        <div>  Student Address  Information </div>
                    <table>
                        <tr><td>city </td> <td>  <input type="text" name="city"/></td></tr>
                        <tr><td>street </td> <td>  <input type="text" name="street"/></td></tr>
                        <tr><td>pincode </td> <td>  <input type="text" name="pincode"/></td></tr>
                    </table>
                    </div>
            <input type="submit" value="login"/>
        </form>
              
    </body>
</html>
