<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		var status = false;
		
		$('#modify').on("click", function(){
			alert("수정");
			if(!status){
				$('input#deptName').attr("readonly", false);
				$('input#deptFloor').attr("readonly", false);
				status = true;
			} else {
				var dept = {
						deptNo:$('#deptNo').val(),
						deptName:$('#deptName').val(),
						deptFloor:$('#deptFloor').val()
				};
				$.ajax({
					type: "post",
					url: "DeptModifyHandler",
					data: JSON.stringify(dept),
					success: function(data){
						alert(data);
						if(data == 1){
							window.location.href = "DeptListHandler";
						}
					}
				});
			}
		});
		
		$('#delete').on("click", function(){
			alert("삭제");
			var delDept = {deptNo:$('#deptNo').val()};
			$.ajax({
				type: "get",
				url: "DeptDeleteHandler",
				data: delDept,
				success: function(data){
					alert(data);			// 1이면 삭제, 0이면 실패
					if(data == 1){
						alert("삭제되었습니다.");
						window.location.href = "DeptListHandler";
					}
				}
			});
		});
		
		$('#list').on("click", function(){
			window.location.href = "DeptListHandler";
		});
	});
</script>
</head>
<body>
	<fieldset>
		<legend>부서 정보</legend>
		<ul>
			<li>
				<label for="deptNo">부서 번호</label>
				<input id="deptNo" type="number" name="deptNo" value="${dept.deptNo}" readonly>
			</li>
			<li>
				<label for="deptName">부서</label>
				<input id="deptName" type="text" name="deptName" value="${dept.deptName}" readonly>
			</li>
			<li>
				<label for="deptFloor">부서 위치</label>
				<input id="deptFloor" type="number" name="deptFloor" value="${dept.deptFloor}" readonly>
			</li>
			<li>
				<button id = "modify">수정</button>
				<button id = "delete">삭제</button>
				<button id = "list">목록</button>
			</li>
		</ul>
	</fieldset>
</body>
</html>