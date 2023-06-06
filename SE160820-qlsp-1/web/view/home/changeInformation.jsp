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
        <title>Edit Admin Tài Khoản Page</title>
    </head>
    <body>
        <h1>Chỉnh sửa Tài Khoản</h1>
        <form action="changeInformation" method="POST">
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
                        <td>Tên Tài Khoản: </td>
                        <td><input type="text" name="tentk" value="${requestScope.taikhoan.tentk}" readonly=""></td>
                        <td><c:out value="${requestScope.errorTentk}"/></td>
                    </tr>
                    <tr>
                        <td>Mật Khẩu: </td>
                        <td><input type="password" name="matkhau" value="${requestScope.taikhoan.matkhau}"></td>
                    </tr>
                    <tr>
                        <td>Nhập lại mật khẩu:</td>
                        <td><input type="password" value="" name="matkhauxn"></td>
                        <td>${requestScope.errorMk}</td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td><input type="text" name="email" value="${requestScope.taikhoan.email}"></td>
                    </tr>

                </tbody>
            </table>
            <input type="submit" value="Xác nhận hay đổi">
        </form>
    </body>
</html>
