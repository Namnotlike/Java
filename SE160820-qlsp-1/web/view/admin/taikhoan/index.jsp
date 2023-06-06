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
        <title>Index Admin Tài Khoản Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.taikhoan != null}">
            <h1>Xin chào admin ${sessionScope.taikhoan.tentk}</h1>
        </c:if>
        <h1>Danh sách tài khoản</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Tên tài khoản</th>
                    <th>Chi tiết </th>
                    <th>Chỉnh sửa </th>
                    <th>Xóa </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="tk" items="${requestScope.listTK}" varStatus="counter" >
                    <tr>
                        <th>${counter.count}</th>
                        <th>${tk.tentk}</th>
                            <c:url var="detailsTK" value="detailsTK" >
                                <c:param name="tentk" value="${tk.tentk}"></c:param>
                            </c:url>
                        <th><a href="${detailsTK}">Xem chi tiết</a></th>
                            <c:url var="editTK" value="editTK" >
                                <c:param name="tentk" value="${tk.tentk}"></c:param>
                            </c:url>
                        <th><a href="${editTK}">Chỉnh sửa</a></th>
                            <c:url var="deleteTK" value="deleteTK" >
                                <c:param name="tentk" value="${tk.tentk}"></c:param>
                            </c:url>
                        <th><a href="${deleteTK}">Xóa</a></th>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <a href="homeAdmin">Quay lại trang chủ Admin</a>
<!--        <a href="createTK"><button type="button">Thêm mới nhà cung cấp</button></a>-->
    </body>
</html>
