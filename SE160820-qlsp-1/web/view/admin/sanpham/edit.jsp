<%-- 
    Document   : edit
    Created on : Feb 17, 2023, 3:16:31 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Admin Sản Phẩm Page</title>
    </head>
    <body>
        <h1>Chỉnh sửa Sản Phẩm </h1>
        <form action="editSP" method="POST">
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
                        <td><input type="text" name="masp" value="${requestScope.sp.masp}" readonly=""></td>
                        <td><c:out value="${requestScope.errorMasp}"/></td>
                    </tr>

                    <tr>
                        <td>Tên Sản Phẩm: </td>
                        <td><input type="text" name="tensp" value="${requestScope.sp.tensp}"></td>
                        <td><c:out value="${requestScope.errorTensp}"/></td>
                    </tr>
                    <tr>
                        <td>Mô Tả: </td>
                        <td><input type="text" name="mota" value="${requestScope.sp.mota}"></td>
                    </tr>
                    <tr>
                        <td>Số lượng: </td>
                        <td><input type="number" name="soluong" value="${requestScope.sp.soluong}"></td>
                    </tr>
                    <tr>
                        <td>Đơn giá: </td>
                        <td><input type="text" name="dongia" value="${requestScope.sp.dongia}"></td>
                    </tr>
                    <tr>
                        <td>Hình Ảnh: </td>
                        <td><input type="text" name="hinhanh" value="${requestScope.sp.hinhanh}"></td>
                    </tr>
                    <tr>
                        <td>Trang Thai: </td>
                        <td>
                            <c:if test="${requestScope.sp.trangthai == true}">
                                <input type="radio" name="trangthai" value="true" checked=""> Con ban
                                <input type="radio" name="trangthai" value="false"> Ngung ban
                            </c:if>
                            <c:if test="${requestScope.sp.trangthai != true}">
                                <input type="radio" name="trangthai" value="true" > Con ban
                                <input type="radio" name="trangthai" value="false" checked=""> Ngung ban
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>Mã Danh Mục: </td>
                        <td><input type="text" name="madm" value="${requestScope.sp.danhmuc.madm}"></td>
                        <td><c:out value="${requestScope.errorMadm}"/></td>
                    </tr>
                    <tr>
                        <td>Mã Nhà Cung Cấp: </td>
                        <td><input type="text" name="mancc" value="${requestScope.sp.nhacungcap.mancc}"></td>
                        <td><c:out value="${requestScope.errorMancc}"/></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Xac nhan">
        </form>
    </body>
</html>
