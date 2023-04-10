<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관</title>
<link rel="stylesheet" href="resources/css/user/SelectUser.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1><a href="main.do">도서관</a></h1>
		</div>
		<form action="deleteUser.do" method="post">
			<section id="contants">
				<h2 style="text-align: center;">회원목록</h2>
				<ul>
					<li><input type="button" value="회원추가"
						onclick="window.open('insertUserPage.do')"></li>
					<li><input type="submit" value="회원삭제"></li>
					<li><input type="button" value="회원조회"
						onclick="window.open('selectUser.do')"></li>
				</ul>
				<div class="table">
					<div class="heading">
						<div class="cell" style="background-color: gray;">
							<p>
								<input type="checkbox" name="userID">
							</p>
						</div>
						<div class="cell" style="background-color: gray;">
							<p>회원ID</p>
						</div>
						<div class="cell" style="background-color: gray;">
							<p>회원명</p>
						</div>
						<div class="cell" style="background-color: gray;">
							<p>회원성별</p>
						</div>
						<div class="cell" style="background-color: gray;">
							<p>회원나이</p>
						</div>
						<div class="cell" style="background-color: gray;">
							<p>회원전화번호</p>
						</div>

					</div>
					<c:forEach var="dto" items="${List}">
						<div class="row">
							<div class="cell">
								<p>
									<input type="checkbox" name="userID"
										value="${dto.userID }">
								</p>
							</div>
							<div class="cell">
								<p>
									<a href='updateUserPage.do?userID=<c:out value="${dto.userID }"></c:out>'> <c:out value="${dto.userID }"></c:out> </a>
									                               
								</p>
							</div>
							<div class="cell">
								<p> <c:out value="${dto.userName }"></c:out> </p>
							</div>
							<div class="cell">
								<p> <c:out value="${dto.userSex }"></c:out> </p>
							</div>
							<div class="cell">
								<p> <c:out value="${dto.userAge }"></c:out> </p>
							</div>
							<div class="cell">
								<p> <c:out value="${dto.userPhone }"></c:out> </p>
							</div>
						</div>
					</c:forEach>
				</div>
			</section>
		</form>
	</div>
</body>
</html>