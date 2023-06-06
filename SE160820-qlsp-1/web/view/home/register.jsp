<%-- 
    Document   : register
    Created on : Feb 17, 2023, 3:26:54 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <h1>Đăng kí</h1>
        <form action="register" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Tên Tk:</td>
                        <td><input type="text" value="" name="tentk"></td>
                        <td>${requestScope.errorTk}</td>
                    </tr>
                    <tr>
                        <td>Mật khẩu:</td>
                        <td><input type="password" value="" name="matkhau"></td>
                    </tr>
                    <tr>
                        <td>Nhập lại mật khẩu:</td>
                        <td><input type="password" value="" name="matkhauxn"></td>
                        <td>${requestScope.errorMk}</td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td><input type="text" value="" name="email"></td>
                    </tr>
                </tbody>
            </table>     
            <input type="submit" value="Xác nhận">
        </form>
    </body>
</html>
