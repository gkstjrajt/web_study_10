<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.post("TitleListHandler", function(json){
			var dataLength = json.length;
			if(dataLength >= 1){
				var sCont = "";
				for(i=0; i<dataLength; i++){
					sCont += "<option value=" + json[i].titleNo + ">" + json[i].titleName + "</option>";
				}
				$("#title").append(sCont);
			}
		});
	
	
		$.post("DeptListHandler", function(json){
			var dataLength = json.length;
			if(dataLength >= 1){
				var sCont = "";
				for(i=0; i<dataLength; i++){
					sCont += "<option value=" + json[i].deptNo + ">" + json[i].deptName + "</option>";
				}
				$("#dept").append(sCont);
			}
		});
	
		 $.post("EmpListHandler", function(json){
	         var dataLength = json.length;
	         if ( dataLength >=1 ){
	             var sCont = "";
	             for ( i=0 ; i < dataLength ; i++){
	                sCont += "<tr>";
	                sCont += "<td>" + json[i].empNo + "</td>";
	                sCont += "<td>" + json[i].empName + "</td>";
	                sCont += "<td>" + json[i].title.titleName + "("+ json[i].title.titleNo + ")</td>";
	                if (json[i].manager.empNo != 0){
	                    sCont += "<td>" + json[i].manager.empName + "("+ json[i].manager.empNo + ")</td>";
	                }else{
	                    sCont += "<td></td>"; 
	                }
	                sCont += "<td>" + json[i].salary.toLocaleString("ko") + "</td>";
	                sCont += "<td>" + json[i].dept.deptName + "("+ json[i].dept.deptNo + ")</td>";
	                sCont += "<td>" + moment(json[i].regDate).format('LL') + "</td>";
	                sCont += "<td>" + json[i].email + "</td>";
	                sCont += "<td>" + json[i].tel + "</td>";
	                sCont += "</tr>";
	            }
	            /* $("table > tbody:last-child").append(sCont);    */
	            $("#load").empty();
	            $("#load").append(sCont);   
	        } 
	     });
	
	
		$('#toLobby').on("click", function(){
			window.location.href = "index.jsp";
		});
	
		$('#addEmp').on("click", function(){
			$.ajax({
				type: "get",
				url: "EmpAddHandler",
				success: function(data){
					alert("data > " + data);
					window.location.href = "empAdd.jsp" + data;
				}
			});
		});
	});
		
</script>
</head>
<body>
	<h2>사원 목록</h2>
	<table border="1">
		<thead>
			<td>사원번호</td><td>사원명</td><td>직책</td><td>직속상사</td>
			<td>급여</td><td>부서</td><td>입사일</td><td>이메일</td><td>연락처</td>
		</thead>
		<tbody id="load">
		</tbody>
	</table>
	<div id = "boxes">
		<button id = "addEmp">사원 추가</button>
		<button id = "toLobby">로비</button>
		<label>직책</label>
		<select id = "title"></select>
		<label>부서</label>
		<select id = "dept"></select>
	</div>
</body>
</html>