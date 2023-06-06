<%-- 
    Document   : index
    Created on : Feb 17, 2023, 3:16:06 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Admin Sản Phẩm Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.taikhoan != null}">
            <h1>Xin chào admin ${sessionScope.taikhoan.tentk}</h1>
        </c:if>
        <h1>Danh sach san pham</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Mã sản phẩm</th>
                    <th>Tên sản phẩm</th>
                    <th>Đơn giá</th>
                    <th>Hình ảnh</th>
                    <th>Chi tiết </th>
                    <th>Chỉnh sửa </th>
                    <th>Xóa </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sp" items="${requestScope.listSP}" varStatus="counter" >
                    <tr>
                        <th>${counter.count}</th>
                        <th>${sp.masp}</th>
                        <th>${sp.tensp}</th>
                        <th>${sp.dongia}</th>
                        <th><img style="width: 100px" src="${sp.hinhanh}" alt="${sp.tensp}"></th>
                            <c:url var="detailsSP" value="detailsSP" >
                                <c:param name="masp" value="${sp.masp}"></c:param>
                            </c:url>
                        <th><a href="${detailsSP}">Xem chi tiết</a></th>
                            <c:url var="editSP" value="editSP" >
                                <c:param name="masp" value="${sp.masp}"></c:param>
                            </c:url>
                        <th><a href="${editSP}">Chỉnh sửa</a></th>
                            <c:url var="deleteSP" value="deleteSP" >
                                <c:param name="masp" value="${sp.masp}"></c:param>
                            </c:url>
                        <th><a href="${deleteSP}">Xóa</a></th>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <a href="createSP"><button type="button">Thêm mới Sản Phẩm</button></a>
        <a href="homeAdmin">Quay lại trang chủ Admin</a>
    </body>
</html>
