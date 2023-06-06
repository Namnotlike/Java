<%-- 
    Document   : order
    Created on : Feb 17, 2023, 3:17:12 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
    </head>
    <body>
        <c:if test="${sessionScope.giohang == null}" var="a">
            <c:if test="${requestScope.thanhcong != null}">
                <h1><c:out value="Thanh toan thanh cong"/></h1>
            </c:if>
            <c:if test="${requestScope.thanhcong == null}">
                <c:redirect url="index"></c:redirect>
            </c:if>
        </c:if>
        <c:if test="${sessionScope.giohang != null}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Tên sản phẩm</th>
                        <th>Hinh anh</th>
                        <th>Đơn giá</th>
                        <th>Số lượng</th>
                        <th>Tổng tiền</th>
                        <th>Cập nhật</th>
                        <th>Xóa</th>
                    </tr>
                </thead>

                <c:forEach var="sp" items="${sessionScope.giohang.list}">
                    <tbody>
                        <tr>
                            <td>${sp.sp.tensp}</td>
                            <td><img style="width: 100px" src="${sp.sp.hinhanh}"></td>
                            <td>${sp.sp.dongia}</td>
                    <form action="updateCard" method="POST">
                        <td><input type="number" name="newAmount" value="${sp.amount}"> </td>
                        <td>${sp.amount * sp.sp.dongia}</td>
                        <input type="hidden" name="masp" value="${sp.sp.masp}">
                        <td>
                            <input type="submit" value="Xac nhan thay doi">
                        </td>

                    </form>
                    <c:url var="removeCard" value="removeCard">
                        <c:param name="masp" value="${sp.sp.masp}"></c:param>
                    </c:url>
                    <form action="removeCard" method="POST">
                        <input type="hidden" name="masp" value="${sp.sp.masp}">
                        <td><input type="submit" value="Xoa san pham"></td>
                    </form>

                </tr>
            </tbody>
        </c:forEach>
    </table>
    <div style="color: red">${requestScope.errorUpdateCard}</div><br>
</c:if>
<a href="index">Tiếp tục chọn sản phẩm</a><br>
<c:if test="${sessionScope.giohang != null}">
    <a href="payment">Thanh toán</a>
</c:if>
</body>
</html>
