<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관</title>

<link rel="stylesheet" href="resources/css/user/UpdateUserPage.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1><c:out value="${dto.userName }"></c:out> 의 정보입니다</h1>
		</div>
		<form action="updateUser.do" method="post">
			<div id="contants">
				<div class="name">
					<b>회원ID</b> <br> <input class="text" type="text" name="userid" value="${dto.userID }"  readonly required> <br>

					<div class="name">
						<b>회원명</b><br> <input class="text" type="text" name="username" placeholder="<c:out value="${dto.userName }"></c:out>" required>
					</div>

					<div class="name">
						<b>회원성별</b><br> <input class="text" type="text" name="usersex" placeholder="<c:out value="${dto.userSex }"></c:out>" required>
					</div>

                    <div class="name">
						<b>회원나이</b><br> <input class="text" type="text" name="userage" placeholder="<c:out value="${dto.userAge }"></c:out>" required>
					</div>

					<div class="name">
						<b>회원전화번호</b><br> <input class="text" type="text" name="userphone"  placeholder="<c:out value="${dto.userPhone }"></c:out>" required>
					</div>
					<div>
						<input class="submit" type="submit" value="수정">
					</div>
					<div>
						<input class="reset" type="reset" value="취소">
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>