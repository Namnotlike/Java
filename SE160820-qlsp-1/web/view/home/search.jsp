<%-- 
    Document   : search
    Created on : Feb 17, 2023, 3:17:56 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <h1>
            <form action="search" method="POST">
                Search: <input type="text" name="search" value="${requestScope.search}">
            </form>
        </h1>
        <c:if test="${requestScope.search!=null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Tên sản phẩm</th>
                        <th>Đơn giá</th>
                        <th>Hình ảnh</th>
                        <th>Chi tiết</th>
                        <th>Đặt hàng</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="sp" items="${requestScope.listSP}" varStatus="counter" >
                        <tr>
                            <th>${counter.count}</th>
                            <th>${sp.tensp}</th>
                            <th>${sp.dongia}</th>
                            <th><img style="width: 100px" src="${sp.hinhanh}" alt="${sp.tensp}"></th>
                                <c:url var="details" value="details" >
                                    <c:param name="masp" value="${sp.masp}"></c:param>
                                </c:url>
                            <th><a href="${details}">Xem chi tiết</a></th>
                            <th>
                                <c:url var="order" value="order">
                                    <c:param name="masp" value="${sp.masp}"></c:param>
                                </c:url>
                                <a href="${order}"> Đặt hàng</a>
                            </th>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </c:if>
            <a href="index">Quay lại trang chủ</a>
    </body>
</html>
