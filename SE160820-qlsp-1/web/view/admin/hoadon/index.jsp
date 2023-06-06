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
        <title>Index Admin Hóa Đơn Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.taikhoan != null}">
            <h1>Xin chào admin ${sessionScope.taikhoan.tentk}</h1>
        </c:if>
        <h1>Danh sach Hóa Đơn</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Mã Hóa Đơn</th>
                    <th>Ngày Đơn Hàng</th>
                    <th>Trạng Thái Xử Lý</th>
                    <th>Mã Khách Hàng</th>
                    <th>Chi tiết Hóa Đơn</th>
                    <th>Chỉnh sửa </th>
                    <th>Xóa </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="hd" items="${requestScope.listHD}" varStatus="counter" >
                    <tr>
                        <th>${counter.count}</th>
                        <th>${hd.mahd}</th>
                        <th>${hd.ngaydh}</th>
                        <th>${hd.trangthaixuli}</th>
                        <th>${hd.makh.tentk}</th>
                            <c:url var="detailsHD" value="detailsHD" >
                                <c:param name="mahd" value="${hd.mahd}"></c:param>
                            </c:url>
                        <th><a href="${detailsHD}">Xem chi tiết</a></th>
                            <c:url var="editHD" value="editHD" >
                                <c:param name="mahd" value="${hd.mahd}"></c:param>
                            </c:url>
                        <th><a href="${editHD}">Chỉnh sửa</a></th>
                            <c:url var="deleteHD" value="deleteHD" >
                                <c:param name="mahd" value="${hd.mahd}"></c:param>
                            </c:url>
                        <th><a href="${deleteHD}">Xóa</a></th>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <a href="homeAdmin">Quay lại trang chủ Admin</a>
<!--        <a href="createNCC"><button type="button">Thêm mới nhà cung cấp</button></a>-->
    </body>
</html>
