
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="students" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <select name = "student" class="form-control">
        <c:forEach var = "student" items="${allStudents }">
            <option value="${student.id}">${student.name} ${student.lastName}</option>
        </c:forEach>

