<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관</title>

<link rel="stylesheet" href="resources/css/book/UpdateBookPage.css">
</head>
<body>
	<div id="container">
		<div id="header">
			<h1><c:out value="${dto.bookTitle}"></c:out>의 정보입니다</h1>
		</div>
		<form action="updateBook.do" method="post">
			<div id="contants">
				<div class="name">
					<b>도서ID</b> <br> <input class="text" type="text" name="bookID" value= "${dto.bookID}"  readonly required> <br>

					<div class="name">
						<b>도서명</b><br> <input class="text" type="text" name="bookTitle" placeholder=<c:out value="${dto.bookTitle}"></c:out> required>
					</div>

					<div class="name">
						<b>도서저자</b><br> <input class="text" type="text" name="bookAuthor" 	placeholder=<c:out value="${dto.bookAuthor}"></c:out> required>
					</div>

					<div class="name">
						<b>도서가격</b><br> <input class="text" type="text" name="bookPrice"   placeholder=<c:out value="${dto.bookPrice}"></c:out> required>
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