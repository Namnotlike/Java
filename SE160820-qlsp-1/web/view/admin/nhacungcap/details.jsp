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
        <title>Details Admin Nhà Cung Cấp Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Mã nhà cung cấp</th>
                    <th>Tên nhà cung cấp</th>
                    <th>Trạng thái</th>
                    <th>Địa chỉ</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>${requestScope.ncc.mancc}</th>
                    <th>${requestScope.ncc.tenncc}</th>
                    <th>
                        <c:if test="${requestScope.ncc.trangthai}">
                            <c:out value="còn hợp tác"/>
                        </c:if>
                        <c:if test="${!requestScope.ncc.trangthai}">
                            <c:out value="ngưng hợp tác"/>
                        </c:if>
                    </th>
                    <th>${requestScope.ncc.diachi}</th>
                </tr>
            </tbody>
        </table>

    </body>
</html>
