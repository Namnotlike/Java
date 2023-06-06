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
        <title>Index Admin Danh Mục Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.taikhoan != null}">
            <h1>Xin chào admin ${sessionScope.taikhoan.tentk}</h1>
        </c:if>
        <h1>Danh sách danh mục</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Tên danh mục</th>
                    <th>Chi tiết </th>
                    <th>Chỉnh sửa </th>
                    <th>Xóa </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dm" items="${requestScope.listDM}" varStatus="counter" >
                    <tr>
                        <th>${counter.count}</th>
                        <th>${dm.tendm}</th>
                            <c:url var="detailsDM" value="detailsDM" >
                                <c:param name="madm" value="${dm.madm}"></c:param>
                            </c:url>
                        <th><a href="${detailsDM}">Xem chi tiết</a></th>
                            <c:url var="editDM" value="editDM" >
                                <c:param name="madm" value="${dm.madm}"></c:param>
                            </c:url>
                        <th><a href="${editDM}">Chỉnh sửa</a></th>
                            <c:url var="deleteDM" value="deleteDM" >
                                <c:param name="madm" value="${dm.madm}"></c:param>
                            </c:url>
                        <th><a href="${deleteDM}">Xóa</a></th>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <a href="createDM"><button type="button">Thêm mới danh mục</button></a>
        <a href="homeAdmin">Quay lại trang chủ Admin</a>
    </body>
</html>
