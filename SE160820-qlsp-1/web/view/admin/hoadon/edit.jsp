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
        <title>Edit Admin Nhà Cung Cấp Page</title>
    </head>
    <body>
        <h1>Chỉnh sửa Hóa Đơn</h1>
        <form action="editHD" method="POST">
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
                        <td>Mã Hóa Đơn: </td>
                        <td><input type="text" name="mahd" value="${requestScope.hd.mahd}" readonly=""></td>
                        <td><c:out value="${requestScope.errorMahd}"/></td>
                    </tr>

                    <tr>
                        <td>Ngày Đặt Hàng: </td>
                        <td><input type="date" name="ngaydh" value="${requestScope.hd.ngaydh}"></td>
                    </tr>
                    <tr>
                        <td>Trạng thái xử lý: </td>
                        <td><input type="number" name="trangthaixuli" value="${requestScope.hd.trangthaixuli}"></td>
                    </tr>
                    <tr>
                        <td>Mã Khách Hàng: </td>
                        <td><input type="text" name="makh" value="${requestScope.hd.makh.tentk}"></td>
                        <td><c:out value="${requestScope.errorMakh}"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Thay đổi">
        </form>
    </body>
</html>
