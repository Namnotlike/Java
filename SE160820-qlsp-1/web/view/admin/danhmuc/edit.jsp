<%-- 
    Document   : create
    Created on : Feb 17, 2023, 3:16:45 PM
    Author     : Admin
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Admin Danh Mục Page</title>
    </head>
    <body>
        <h1>Chỉnh sửa Danh Mục</h1>
        <form action="editDM" method="POST">
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
                        <td>Mã Danh Mục: </td>
                        <td><input type="text" name="madm" value="${requestScope.dm.madm}" readonly=""></td>
                        <td><c:out value="${requestScope.errorMadm}"/></td>
                    </tr>

                    <tr>
                        <td>Tên Danh Mục: </td>
                        <td><input type="text" name="tendm" value="${requestScope.dm.tendm}"></td>
                        <td><c:out value="${requestScope.errorTendm}"/></td>
                    </tr>
                    <tr>
                        <td>Trạng Thái: </td>
                        <td>
                            <c:if test="${requestScope.dm.trangthai}">
                                <input type="radio" name="trangthai" value="true" checked=""> Còn sử dụng
                                <input type="radio" name="trangthai" value="false"> Ngưng sử dụng
                            </c:if>
                            <c:if test="${!requestScope.dm.trangthai}">
                                <input type="radio" name="trangthai" value="true" > Còn sử dụng
                                <input type="radio" name="trangthai" value="false" checked=""> Ngưng sử dụng
                            </c:if>
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Thay đổi">
        </form>
    </body>
</html>
