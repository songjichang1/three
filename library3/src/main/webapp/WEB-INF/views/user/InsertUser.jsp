<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관</title>
<link rel="stylesheet" href="resources/css/user/InsertUser.css">
</head>
<body>

	<div id="container">
		<div id="header">
			<h1>
				<a href="main.do">도서관</a>
			</h1>
		</div>
		<div id="contants">
			<h3 style="text-align: center;">회원 추가</h3>

			<form action="insertUser.do" method="post">
				
				<label for="user_id"><b>회원ID</b><br></label> 
				<input type="text" name="userID" id="user_id" placeholder="id입력하세요" required><br>

				<label for="user_name"><b>회원명</b></label><br>
				 <input type="text" name="userName" id="book_title"placeholder="회원을 입력하세요"><br>
				  
				 <label for="user_sex"><b>회원성별</b></label><br>
				<input type="text" name="userSex" id="user_sex"placeholder="회원성별을 입력하세요"><br>
				
				 <label for="book_age"><b>회원나이</b></label><br>
				<input type="text" name="userAge" id="book_age" placeholder="회원나이를 입력하세요"><br>
				
                <label for="user_phone"><b>회원전화번호</b></label><br>
				<input type="text" name="userPhone" id="user_phone" placeholder="전화번호를 입력하세요"><br>
				
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