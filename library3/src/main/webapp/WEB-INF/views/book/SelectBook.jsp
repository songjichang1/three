<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관</title>
<link rel="stylesheet" href="resources/css/book/SelectBook.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1><a href="main.do">도서관</a></h1>
		</div>
		<form action="deleteBook.do" method="post">
			<section id="contants">
				<h2 style="text-align: center;">도서목록</h2>
				<ul>
					<li><input type="button" value="도서추가"
						onclick="window.open('insertBookPage.do')"></li>
					<li><input type="submit" value="도서삭제"></li>
					<li><input type="button" value="도서조회"
						onclick="window.open('selectBook.do')"></li>
				</ul>
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
					<c:forEach var="dto" items="${List}">
						<div class="row">
							<div class="cell">
								<p>
									<input type="checkbox" name="bookID" value="${dto.bookID }">
								</p>
							</div>
							<div class="cell">
								<p>
									<a href='updateBookPage.do?bookID=<c:out value="${dto.bookID }"></c:out>'> <c:out value="${dto.bookID }"></c:out> </a>
								</p>
							</div>
							<div class="cell"> 
							<p> <c:out value="${dto.bookTitle }"></c:out> </p>

							</div>
							<div class="cell">
								<p> <c:out value="${dto.bookAuthor }"></c:out> </p>
		
							</div>
							<div class="cell">
								<p> <c:out value="${dto.bookPrice }"></c:out> </p>
							</div>
						</div>
					</c:forEach>
				</div>
			</section>
		</form>
	</div>
</body>
</html>