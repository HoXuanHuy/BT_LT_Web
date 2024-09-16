<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<style>
@import
	url('https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500&display=swap')
	;

* {
	box-sizing: border-box;
}

body {
	text-align: center;
	font-family: 'Montserrat', sans-serif;
	font-size: 17px;
}

#wrapper {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 80vh;
}

form {
	border: 1px solid #dadce0;
	border-radius: 5px;
	padding: 30px;
}

h2 {
	text-align: center;
	font-size: 18px;
	font-weight: 300;
	color: #FF0000;
}

h3 {
	text-align: center;
	font-size: 24px;
	font-weight: 500;
}

p{
	text-align: center;
	font-size: 18px;
	font-weight: 500;
}

.form-group {
	margin-bottom: 15px;
	position: relative;
}

input {
	height: 50px;
	width: 300px;
	outline: none;
	border: 1px solid #dadce0;
	padding: 10px;
	border-radius: 5px;
	font-size: inherit;
	color: #202124;
	transition: all 0.3s ease-in-out;
}

button {
	height: 50px;
	width: 300px;
	outline: none;
	border: 1px solid #dadce0;
	padding: 10px;
	border-radius: 5px;
	font-size: inherit;
	color: #202124;
	transition: all 0.3s ease-in-out;
}

label {
	position: absolute;
	padding: 0px 5px;
	left: 50px;
	top: 50%;
	/* Quan trọng  */
	pointer-events: none;
	transform: translateY(-50%);
	background: #fff;
	transition: all 0.3s ease-in-out;
}

/* Định dạng cho select (dropdown) */
.form-group select {
    padding: 8px 12px;
    font-size: 14px;
    margin-left: 50px;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: #fff;
    color: #333;
    width: 60%; /* Chiều rộng đầy đủ của form group */
    box-sizing: border-box; /* Đảm bảo padding không làm rộng thêm */
    appearance: none; /* Tùy chọn để loại bỏ mũi tên mặc định trên các trình duyệt */
}

.form-group input:focus {
	border: 2px solid #1a73e8;
}

.form-group input:focus+label, .form-group input:valid+label {
	top: 0px;
	font-size: 13px;
	font-weight: 500;
	color: #1a73e8;
}

input#btn-signup {
	background: #1a73e8;
	color: #fff;
	cursor: pointer;
}

input#btn-signup:hover {
	opacity: 0.85;
}

button#btn-login {
	background: #1a73e8;
	color: #fff;
	cursor: pointer;
}

button#btn-login:hover {
	opacity: 0.85;
}
</style>
	<div id="wrapper">
		<form action="/ltwebhxh/signup" method="post">
			<h3>Sign up</h3>
			<p>Please fill in this form to create an account.</p>

			<div class="form-group">
				<input type="text" name="fullname" required> <label for="">Fullname</label>
			</div>
			
			<div class="form-group">
				<input type="text" name="phone" required> <label for="">Phone</label>
			</div>
			
			<div class="form-group">
				<input type="text" name="username" required> <label for="">Username</label>
			</div>

			<div class="form-group">
				<input type="text" name="email" required> <label for="">Email</label>
			</div>

			<div class="form-group">
				<input type="password" name="password" required> <label for="">Password</label>
			</div>
			<div class="form-group">
			    <label for="role">Role</label>
			    <select name="roleid" id="role" required>
			        <option value=1>Admin</option>
			        <option value=2>Manager</option>
			        <option value=3>User</option>
			    </select>
			</div>
			<c:if test="${alert !=null}">
			<h2>${alert}</h2>
			</c:if>

			<input type="submit" value="Sign up" id="btn-signup"> <br>

			<p>Do you have an account?</p>

			<button type="button" id="btn-login"
				onclick="window.location.href='/ltwebhxh/views/login.jsp'">Log in</button>
		</form>
	</div>


</body>
</html>