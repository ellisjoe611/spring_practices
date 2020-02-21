<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 삭제</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/delete/" method="post">
		<input type='hidden' name="no" value="${no }">
		<table width=510 border=1>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
				<td><input type="submit" value="삭제하기"></td>
			</tr>
		</table>
		<br>
		<br>
		<a href="${pageContext.request.contextPath }">메인으로 돌아가기</a>
	</form>

</body>
</html>