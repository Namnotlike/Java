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
        <title>Details Admin Hoa Don Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Mã Hóa Đơn</th>
                    <th>Mã Sản Phẩm</th>
                    <th>số lượng</th>
                    <th>Đơn giá</th>
                    <th>Khuyến mại</th>
                    <th>Giá trị</th>
                    <th>Thay đổi</th>
                    <th>Xóa</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cthd" items="${requestScope.listCTHD}" varStatus="counter">
                    <tr>
                        <th>${counter.count}</th>
                        <th>${cthd.mahd.mahd}</th>
                        <th>${cthd.masp.masp}</th>
                        <th>${cthd.soluong}</th>
                        <th>${cthd.dongia}</th>
                        <th>${cthd.khuyenmai}</th>
                        <th>${cthd.giaitri}</th>
                            <c:url var="editCTHD" value="editCTHD" >
                                <c:param name="mahd" value="${cthd.mahd.mahd}"></c:param>
                                <c:param name="masp" value="${cthd.masp.masp}"></c:param>
                            </c:url>
                        <th><a href="${editCTHD}">Chỉnh sửa</a></th>
                            <c:url var="deleteCTHD" value="deleteCTHD" >
                                <c:param name="mahd" value="${cthd.mahd.mahd}"></c:param>
                                <c:param name="masp" value="${cthd.masp.masp}"></c:param>
                            </c:url>
                        <th><a href="${deleteCTHD}">Xóa</a></th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
