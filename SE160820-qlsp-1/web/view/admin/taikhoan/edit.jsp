<%-- 
    Document   : create
    Created on : Feb 17, 2023, 3:16:45 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Admin Tài Khoản Page</title>
    </head>
    <body>
        <h1>Chỉnh sửa Tài Khoản</h1>
        <form action="editTK" method="POST">
            <table border="0">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Tên Tài Khoản: </td>
                        <td><input type="text" name="tentk" value="${requestScope.tk.tentk}" readonly=""></td>
                        <td><c:out value="${requestScope.errorTentk}"/></td>
                    </tr>
                    <tr>
                        <td>Trạng Thái: </td>
                        <td>
                            <c:if test="${requestScope.tk.trangthai}">
                                <input type="radio" name="trangthai" value="true" checked=""> Còn hoạt động
                                <input type="radio" name="trangthai" value="false"> Ngưng hoạt động
                            </c:if>
                            <c:if test="${!requestScope.tk.trangthai}">
                                <input type="radio" name="trangthai" value="true" > Còn hoạt động
                                <input type="radio" name="trangthai" value="false" checked=""> Ngưng hoạt động
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>Email: </td>
                        <td><input type="text" name="email" value="${requestScope.tk.email}"></td>
                    </tr>
                    <tr>
                        <td>Nhóm Tài Khoản: </td>

                        <td><input type="text" name="nhomtk" value="${requestScope.tk.nhomtk.nhomtk}"></td>

                        <td><c:out value="${requestScope.errorNhomtk}"/></td>
                    </tr>

                </tbody>
            </table>
            <input type="submit" value="Thay đổi">
        </form>
    </body>
</html>
