<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관</title>
<link rel="stylesheet" href="resources/css/book/InsertBook.css">
</head>
<body>

	<div id="container">
		<div id="header">
			<h1>
				<a href="main.do">도서관</a>
			</h1>
		</div>
		<div id="contants">
			<h3 style="text-align: center;">도서 추가</h3>

			<form action="insertBook.do" method="post">

				<label for="book_id"><b>도서ID</b><br></label> <input type="text"
					name="bookID" id="book_id" placeholder="id입력하세요" required><br>

				<label for="book_title"><b>도서명</b></label><br> <input
					type="text" name="bookTitle" id="book_title"
					placeholder="도서명을 입력하세요"><br> <label for="book_author"><b>도서저자</b></label><br>
				<input type="text" name="bookAuthor" id="book_author"
					placeholder="도서저자를 입력하세요"><br> <label for="book_price"><b>도서가격</b></label><br>
				<input type="text" name="bookPrice" id="book_price"
					placeholder="도서가격을 입력하세요"><br>

				<div>
					<input class="submit" type="submit" value="추가">
				</div>
				<div>
					<input class="reset" type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>