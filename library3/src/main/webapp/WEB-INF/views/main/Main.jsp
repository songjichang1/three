<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관</title>
<link rel="stylesheet" href="resources/css/main/Main.css">
</head>
<body>
	<div id="container">
		<header>
			<h1>
				<a href="main.do">도서관</a>
			</h1>
		</header>
		<nav>
			<ul>
				<li><a href="selectUser.do">회원</a></li>
				<li><a href="selectBook.do">도서</a></li>
				<li><a href="borrowSelectBook.do">대여</a></li>
			</ul>
		</nav>
		<h1>공지사항</h1>
		<hr>
		<section class="box1">
			<p>
				<b>도서관이용</b>
			</p>
			<p>회원가입 후 대여 가능</p>
		</section>

		<section class="box2">
			<p>
				<b>회원</b>
			</p>
			<p>같은 책을 1개이상 대여 x</p>
			<p>이외 다른 책은 n번 대여 가능</p>
		</section>

		<section class="box3">
			<p>
				<b>프로그램 실행자</b>
			</p>
			<p>도서매니저이다</p>
			<p>도서매니저는 모든 권한</p>
		</section>
	</div>
</body>
</html>