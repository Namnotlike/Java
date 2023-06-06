<%-- 
    Document   : login
    Created on : Feb 17, 2023, 3:26:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1> Đăng nhập </h1>
        <form action="login" method="POST">
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
                    </tr>
                    <tr>
                        <td>Mật khẩu</td>
                        <td><input type="text" value="" name="matkhau"></td>
                    </tr>
                </tbody>
            </table>     
            <input type="submit" value="Xác nhận">
        </form>
    </body>
</html>
