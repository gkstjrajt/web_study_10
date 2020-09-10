<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 추가</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#add').on("click", function(){
			var newEmp = {
					empNo: $('#empNo').val(),
					empName: $('#empName').val(),
					
			}
		});
	});
</script>
</head>
<body>
	<fieldset>
		<legend>사원 추가</legend>
		<ul>
			<li>
				<label for = "empNo">사원 번호</label>
				<input in = "empNo" type="number" name="empNo">
			</li>
			<li>
				<label for = "empName">사원명</label>
				<input in = "empName" type="text" name="empName">
			</li>
			<li>
				<label for = "title">직책</label>
				<input in = "title" type="text" name="title">
			</li>
			<li>
				<label for = "manager">직속상사</label>
				<input in = "manager" type="text" name="manager">
			</li>
			<li>
				<label for = "salary">급여</label>
				<input in = "salary" type="number" name="salary">
			</li>
			<li>
				<label for = "dept">부서</label>
				<input in = "dept" type="text" name="dept">
			</li>
			<li>
				<label for = "regDate">입사일</label>
				<input in = "regDate" type="Date" name="regDate">
			</li>
			<li>
				<label for = "email">이메일</label>
				<input in = "email" type="text" name="email">
			</li>
			<li>
				<label for = "tel">연락처</label>
				<input in = "tel" type="text" name="tel">
			</li>
			<li>
				<button id = "add">추가</button>
				<button id = "cancel">취소</button>
			</li>
		</ul>
	</fieldset>
</body>
</html>