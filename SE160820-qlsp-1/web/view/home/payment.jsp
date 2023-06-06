<%-- 
    Document   : payment
    Created on : Feb 17, 2023, 3:17:27 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Page</title>
    </head>
    <body>
        <h1>Thanh toán</h1>
        <h2>Đơn hàng của bạn bao gồm: </h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Tên sản phẩm</th>
                    <th>Hinh anh</th>
                    <th>Đơn giá</th>
                    <th>Số lượng</th>
                    <th>Tổng tiền</th>
                </tr>
            </thead>
            <c:if test="${sessionScope.giohang == null}" var="a">
                <c:redirect url="index"></c:redirect>

            </c:if>
            <c:forEach var="sp" items="${sessionScope.giohang.list}">
                <tbody>
                    <tr>
                        <td>${sp.sp.tensp}</td>
                        <td><img style="width: 100px" src="${sp.sp.hinhanh}"></td>
                        <td>${sp.sp.dongia}</td>
                        <td>${sp.amount} </td>
                        <td>${sp.amount * sp.sp.dongia}</td>
                        <c:set var="sum" value="${sum + (sp.amount * sp.sp.dongia)}" ></c:set>
                        <%--<c:set var="s" value="${}"></c:set>--%>
                    </tr>
                </tbody>
            </c:forEach>
        </table>
        <h2>Tổng giá trị đơn hàng của bạn là: ${sum}</h2>
        <form action="payment" method="POST">
            <input type="submit" value="Xác nhận thanh toán">
        </form>
    </body>
</html>
