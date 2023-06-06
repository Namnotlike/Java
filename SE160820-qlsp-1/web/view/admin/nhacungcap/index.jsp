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
        <title>Index Admin Nhà Cung Cấp Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.taikhoan != null}">
            <h1>Xin chào admin ${sessionScope.taikhoan.tentk}</h1>
        </c:if>
        <h1>Danh sach nhà cung cấp</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Tên nhà cung cấp</th>
                    <th>Chi tiết </th>
                    <th>Chỉnh sửa </th>
                    <th>Xóa </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ncc" items="${requestScope.listNCC}" varStatus="counter" >
                    <tr>
                        <th>${counter.count}</th>
                        <th>${ncc.tenncc}</th>
                            <c:url var="detailsNCC" value="detailsNCC" >
                                <c:param name="mancc" value="${ncc.mancc}"></c:param>
                            </c:url>
                        <th><a href="${detailsNCC}">Xem chi tiết</a></th>
                            <c:url var="editNCC" value="editNCC" >
                                <c:param name="mancc" value="${ncc.mancc}"></c:param>
                            </c:url>
                        <th><a href="${editNCC}">Chỉnh sửa</a></th>
                            <c:url var="deleteNCC" value="deleteNCC" >
                                <c:param name="mancc" value="${ncc.mancc}"></c:param>
                            </c:url>
                        <th><a href="${deleteNCC}">Xóa</a></th>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <a href="createNCC"><button type="button">Thêm mới nhà cung cấp</button></a>
        <a href="homeAdmin">Quay lại trang chủ Admin</a>
    </body>
</html>
