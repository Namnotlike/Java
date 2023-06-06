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
        <title>Details Admin Danh Mục Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Mã danh mục</th>
                    <th>Tên danh mục</th>
                    <th>Trạng thái</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>${requestScope.dm.madm}</th>
                    <th>${requestScope.dm.tendm}</th>
                    <th>
                        <c:if test="${requestScope.dm.trangthai}">
                            <c:out value="còn sử dụng"/>
                        </c:if>
                        <c:if test="${!requestScope.dm.trangthai}">
                            <c:out value="ngưng sử dụng"/>
                        </c:if>
                    </th>
                </tr>
            </tbody>
        </table>

    </body>
</html>
