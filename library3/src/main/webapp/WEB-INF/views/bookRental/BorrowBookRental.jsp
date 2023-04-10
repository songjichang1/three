<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관</title>
<link rel="stylesheet" href="resources/css/bookRental/BorrowBookRental.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1><a href="main.do">도서관</a></h1>
		</div>
		<form action="ReturnBookRental.do">
		<section id="contants">
			<ul>
				<li><input type="button" value="대여"
					onclick="window.open('borrowSelectBookPage.do')"></li>
				<li><input type="submit" value="반납"></li>
				<li><input type="button" value="대여조회"
					onclick="window.open('borrowSelectBook.do')"></li>
			</ul>
			<div class="table">
				<div class="heading">
					<div class="cell">
						<input type="checkbox">
					</div>
					<div class="cell">
						<p>회원ID</p>
					</div>
					<div class="cell">
						<p>도서ID</p>
					</div>
					<div class="cell">
						<p>도서명</p>
					</div>
					<div class="cell">
						<p>도서저자</p>
					</div>
					<div class="cell">
						<p>도서가격</p>
					</div>
				</div>
				<c:forEach var="dto" items="${rentalList}">
				<div class="row">
					<div class="cell">
						<input type="checkbox" name="userID" value="${dto.userID }">
					</div>
					<div class="cell">
						<p><c:out value="${dto.userID }"></c:out> </p>
					</div>
					<div class="cell">
						<p><c:out value="${dto.bookID }"></c:out> </p>
					</div>
					<div class="cell">
						<p><c:out value="${dto.bookTitle }"></c:out> </p>
					</div>
					<div class="cell">
						<p><c:out value="${dto.bookAuthor }"></c:out> </p>
					</div>
					<div class="cell">
						<p><c:out value="${dto.bookPrice }"></c:out> </p>
					</div>
				</div>
				</c:forEach>
			</div>
		</section>
		</form>
	</div>
</body>
</html>