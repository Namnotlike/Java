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
        <title>Edit Admin Chi Tiết Hóa Đơn Page</title>
    </head>
    <body>
        <h1>Chỉnh sửa Chi Tiết Hóa Đơn</h1>
        <form action="editCTHD" method="POST">
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
                        <td><input type="text" name="mahd" value="${requestScope.cthd.mahd.mahd}" readonly=""></td>
                        <td><c:out value="${requestScope.errorMahd}"/></td>
                    </tr>

                    <tr>
                        <td>Mã Sản Phẩm: </td>
                        <td><input type="text" name="masp" value="${requestScope.cthd.masp.masp}"></td>
                        <td><c:out value="${requestScope.errorMasp}"/></td>
                    </tr>
                    <tr>
                        <td>Số lượng: </td>
                        <td><input type="number" name="soluong" value="${requestScope.cthd.soluong}"></td>
                        <td><c:out value="${requestScope.errorSoluong}"/></td>
                    </tr>
                    <tr>
                        <td>Khuyến mãi: </td>
                        <td><input type="text" name="khuyenmai" value="${requestScope.cthd.khuyenmai}"></td>
                        <td><c:out value="${requestScope.errorKhuyenmai}"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="dongia" value="${requestScope.cthd.dongia}">
            <input type="hidden" name="masp1" value="${requestScope.cthd.masp.masp}">
            <input type="submit" value="Thay đổi">
        </form>
    </body>
</html>
