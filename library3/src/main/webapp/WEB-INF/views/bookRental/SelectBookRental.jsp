<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관</title>
<link rel="stylesheet" href="resources/css/bookRental/SelectBookRental.css">
</head>
<body>
	<form action="borrowBookRental.do" method="get">
		<div id="container">
			<div id="header">
				<h1><a href="main.do">도서관</a></h1>
			</div>
			<section id="contants">
				<h2 style="text-align: center;">회원목록</h2>
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
					<c:forEach var="dto" items="${userList}">
					<div class="row">
						<div class="cell">
							<p>
								<input type="checkbox" name="userID"
									value="${dto.userID }">
							</p>
						</div>
						<div class="cell">
							<p> <c:out value="${dto.userID }"></c:out> </p>
						</div>
						<div class="cell">
							<p><c:out value="${dto.userName}"></c:out> </p>
						</div>
						<div class="cell">
							<p><c:out value="${dto.userSex }"></c:out> </p>
						</div>
						<div class="cell">
							<p><c:out value="${dto.userAge }"></c:out> </p>
						</div>
						<div class="cell">
							<p><c:out value="${dto.userPhone }"></c:out> </p>
						</div>
					</div>
					</c:forEach>
				</div>
			</section>

			<section id="contants">
				<h2 style="text-align: center;">도서목록</h2>
				<div class="table">
					<div class="heading">
						<div class="cell" style="background-color: gray;">
							<p>
								<input type="checkbox" name="bookID">
							</p>
						</div>
						<div class="cell" style="background-color: gray;">
							<p>도서ID</p>
						</div>
						<div class="cell" style="background-color: gray;">
							<p>도서명</p>
						</div>
						<div class="cell" style="background-color: gray;">
							<p>도서저자</p>
						</div>
						<div class="cell" style="background-color: gray;">
							<p>도서가격</p>
						</div>
					</div>
					<c:forEach var="dto" items="${bookList }">
					<div class="row">
						<div class="cell">
							<p>
								<input type="checkbox" name="bookID"
									value="${dto.bookID }">
							</p>
						</div>
						<div class="cell">
							<p><c:out value="${dto.bookID }"></c:out> </p>
						</div>
						<div class="cell">
							<p><c:out value="${dto.bookTitle }"></c:out></p>
						</div>
						<div class="cell">
							<p><c:out value="${dto.bookAuthor }"></c:out></p>
						</div>
						<div class="cell">
							<p><c:out value="${dto.bookPrice }"></c:out></p>
						</div>
					</div>
					</c:forEach>
				</div>
			</section>
			  <div>
            <input class="submit" type="submit" value="대여하기">
        </div>
		</div>
	</form>
</body>
</html>