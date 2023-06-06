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
        <title>Create Admin Sản Phẩm Page</title>
    </head>
    <body>
        <h1>Tạo Sản Phẩm Mới</h1>
        <form action="createSP" method="POST">
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
                        <td>Mã Sản Phẩm: </td>
                        <td><input type="text" name="masp" value=""></td>
                        <td><c:out value="${requestScope.errorMasp}"/></td>
                    </tr>
                    
                    <tr>
                        <td>Tên Sản Phẩm: </td>
                        <td><input type="text" name="tensp" value=""></td>
                        <td><c:out value="${requestScope.errorTensp}"/></td>
                    </tr>
                    <tr>
                        <td>Mô Tả: </td>
                        <td><input type="text" name="mota" value=""></td>
                    </tr>
                    <tr>
                        <td>Số lượng: </td>
                        <td><input type="number" name="soluong" value=""></td>
                    </tr>
                    <tr>
                        <td>Đơn giá: </td>
                        <td><input type="text" name="dongia" value=""></td>
                    </tr>
                    <tr>
                        <td>Hình Ảnh: </td>
                        <td><input type="text" name="hinhanh" value=""></td>
                    </tr>
                    <tr>
                        <td>Mã Danh Mục: </td>
                        <td><input type="text" name="madm" value=""></td>
                        <td><c:out value="${requestScope.errorMadm}"/></td>
                    </tr>
                    <tr>
                        <td>Mã Nhà Cung Cấp: </td>
                        <td><input type="text" name="mancc" value=""></td>
                        <td><c:out value="${requestScope.errorMancc}"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Tạo mới">
        </form>
    </body>
</html>
