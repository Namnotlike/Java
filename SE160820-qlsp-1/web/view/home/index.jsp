<%-- 
    Document   : index
    Created on : Feb 17, 2023, 3:15:34 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>

    </head>
    <body> 
        <c:if test="${sessionScope.taikhoan != null}">
            <h1>Xin chao 
                <c:if test="${sessionScope.role != null}">
                    Admin
                </c:if>
                ${sessionScope.taikhoan.tentk}
            </h1>
        </c:if>
        <h1>Danh sach san pham</h1>

        <a href="search">Tìm kiếm sản phẩm</a>
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
        <form action="${order}" method="POST">
            <input type="submit" value="Xem gio hang">
        </form>
        <c:if test="${sessionScope.taikhoan == null}">
            <a href="login"><button>Đăng nhập</button></a>
            <a href="register"><button>Đăng kí</button></a>
        </c:if>
        <c:if test="${sessionScope.role != null}">
            <a href="admin/homeAdmin"><button>Vao trang quan ly</button></a>
        </c:if>
            <br>
            
        <c:if test="${sessionScope.taikhoan != null}">
            <a href="changeInformation">Thay đổi thông tin cá nhân</a><br>
            <a href="logout"><button>Đăng xuất</button></a>
        </c:if>

    </body>
</html>
