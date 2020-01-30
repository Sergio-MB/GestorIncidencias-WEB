<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="date" class="java.util.Date" />
<!DOCTYPE html>
<div id="pie">
	<hr>
    <h1>Copyright &copy; <fmt:formatDate value="${date}" pattern="yyyy"/> UrbanFix<h1>
</div>