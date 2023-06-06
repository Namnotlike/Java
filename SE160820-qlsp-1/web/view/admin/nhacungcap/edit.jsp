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
        <title>Edit Admin Nhà Cung Cấp Page</title>
    </head>
    <body>
        <h1>Chỉnh sửa Nhà cung Cấp</h1>
        <form action="editNCC" method="POST">
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
                        <td>Mã Nhà Cung Cấp: </td>
                        <td><input type="text" name="mancc" value="${requestScope.ncc.mancc}" readonly=""></td>
                        <td><c:out value="${requestScope.errorMancc}"/></td>
                    </tr>

                    <tr>
                        <td>Tên Nhà Cung Cấp: </td>
                        <td><input type="text" name="tenncc" value="${requestScope.ncc.tenncc}"></td>
                        <td><c:out value="${requestScope.errorTenncc}"/></td>
                    </tr>
                    <tr>
                        <td>Địa Chỉ: </td>
                        <td><input type="text" name="diachi" value="${requestScope.ncc.diachi}"></td>
                    </tr>
                    <tr>
                        <td>Trạng Thái: </td>
                        <td>
                            <c:if test="${requestScope.ncc.trangthai}">
                                <input type="radio" name="trangthai" value="true" checked=""> Còn hợp tác
                                <input type="radio" name="trangthai" value="false"> Ngưng hợp tác
                            </c:if>
                            <c:if test="${!requestScope.ncc.trangthai}">
                                <input type="radio" name="trangthai" value="true" > Còn hợp tác
                                <input type="radio" name="trangthai" value="false" checked=""> Ngưng hợp tác
                            </c:if>
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Thay đổi">
        </form>
    </body>
</html>
