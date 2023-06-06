<%-- 
    Document   : create
    Created on : Feb 17, 2023, 3:16:45 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Admin Danh Mục Page</title>
    </head>
    <body>
        <h1>Tạo Danh Mục Mới</h1>
        <form action="createDM" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Mã Danh Mục: </td>
                        <td><input type="text" name="madm" value=""></td>
                        <td><c:out value="${requestScope.errorMadm}"/></td>
                    </tr>
                    
                    <tr>
                        <td>Tên Danh Mục: </td>
                        <td><input type="text" name="tendm" value=""></td>
                        <td><c:out value="${requestScope.errorTendm}"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Tạo mới">
        </form>
    </body>
</html>
