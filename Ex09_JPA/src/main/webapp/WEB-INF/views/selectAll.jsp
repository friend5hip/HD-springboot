<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<body>
	<c:forEach var="member" items="${members}">
		${member.id}<br>${member.name}<br>${member.email}
		<hr>
	</c:forEach>
</body>
</html>