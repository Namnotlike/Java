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
        <title>Create Admin Nhà Cung Cấp Page</title>
    </head>
    <body>
        <h1>Tạo Nhà cung Cấp Mới</h1>
        <form action="createNCC" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Mã Nhà Cung Cấp: </td>
                        <td><input type="text" name="mancc" value=""></td>
                        <td><c:out value="${requestScope.errorMancc}"/></td>
                    </tr>
                    
                    <tr>
                        <td>Tên Nhà Cung Cấp: </td>
                        <td><input type="text" name="tenncc" value=""></td>
                        <td><c:out value="${requestScope.errorTenncc}"/></td>
                    </tr>
                    <tr>
                        <td>Địa Chỉ: </td>
                        <td><input type="text" name="diachi" value=""></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Tạo mới">
        </form>
    </body>
</html>
