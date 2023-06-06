<%-- 
    Document   : details
    Created on : Feb 17, 2023, 3:15:48 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details Admin Sản Phẩm Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Mã sản phẩm</th>
                    <th>Tên sản phẩm</th>
                    <th>Mô tả</th>
                    <th>Số lượng</th>
                    <th>Đơn giá</th>
                    <th>Hình ảnh</th>
                    <th>Trạng thái</th>
                    <th>Danh mục</th>
                    <th>Nhà cung cấp</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>${requestScope.sp.masp}</th>
                    <th>${requestScope.sp.tensp}</th>
                    <th>${requestScope.sp.mota}</th>
                    <th>${requestScope.sp.soluong}</th>
                    <th>${requestScope.sp.dongia}</th>
                    <th><img style="width: 100px" src="${requestScope.sp.hinhanh}" alt="${requestScope.sp.tensp}"></th>
                    <th>
                        <c:if test="${requestScope.sp.trangthai}">
                            <c:out value="còn bán"/>
                        </c:if>
                        <c:if test="${!requestScope.sp.trangthai}">
                            <c:out value="ngưng bán"/>
                        </c:if>
                    </th>
                    <th>${requestScope.sp.danhmuc.tendm}</th>
                    <th>${requestScope.sp.nhacungcap.tenncc}</th>
                </tr>
            </tbody>
        </table>
                <a href="indexSP">Quay lại trang chủ</a>
    </body>
</html>
