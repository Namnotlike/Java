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
        <title>Details Admin Tài Khoản Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>Tên Tài Khoản</th>
                    <th>Mật Khẩu</th>
                    <th>Trạng thái</th>
                    <th>Email</th>
                    <th>Nhóm Tài Khoản</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th>${requestScope.tk.tentk}</th>
                    <th>***</th>
                    <th>
                        <c:if test="${requestScope.tk.trangthai}">
                            <c:out value="còn hoạt động"/>
                        </c:if>
                        <c:if test="${!requestScope.tk.trangthai}">
                            <c:out value="ngưng hoạt động"/>
                        </c:if>
                    </th>
                    <th>${requestScope.tk.email}</th>
                    <th>${requestScope.tk.nhomtk.nhomtk}</th>
                </tr>
            </tbody>
        </table>

    </body>
</html>
