<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:import url="common.jsp"></c:import>
<script type="text/javascript">
	$(function() {

		var page1 = 1;
		var pageNum1 = 5;
		topage(page1, pageNum1);
	})
	function topage(page1, pageNum1) {
		$.ajax({
			type : "POST",
			url : "fingPageList.action",
			data : {
				"page" : page1,
				"pageNum" : pageNum1
			},
			success : function(result) {
				var html="<table class='table table-hover' ><tr><th><input type='checkbox' /></th><th>id</th><th>title</th><th>author</th><th>createdate</th><th>option</th></tr>";
				$.each(result.list, function(i, date) {
					html+="<tr>"+
					"<td><input name='ids' type='checkbox' value=" + date.id + " /></td>"+
					"<td>"+date.id+"</td>"+
					"<td><a href="+
					"findById.action?id="+
					date.id+
					">"+
					date.title+
					"</a></td>"+
					"<td>"+date.author+"</td>"+
					"<td>"+date.createdate+"</td>"+
					"<td><input  value='修改' type='button' /></td>"+
					"</tr>";
				}); 
				html+="<tr align='center'><td colspan='6'>"+
				"<input onclick="+
				"javascript:location.href='add.action' value='添加' type='button' /> "+
				"<input value='删除' type='submit' /></td></tr>"
				html+="</table>";
				$("#table").html(html);
				$("#count").html(result.count);
				$("#num21").html(result.num);
			}
		})
	}
	function to1page(){
		
		var page1=$("#topage").val();
		var pageNum1=5;
		topage(page1, pageNum1);
	}
	function addpage(){
		var page=$("#num21").html();
		var count=$("#count").html();
		if(page==count){
			alert("已到达最后页")
			return;
		}
		var page1=parseInt(page)+1;
		var pageNum1=5;
		topage(page1, pageNum1);
	}
	function reducepage(){
		var page=$("#num21").html();
		if(page==1){
			alert("已到达首页");
			return;
		}
		var page1=page-1;
		var pageNum1=5;
		topage(page1, pageNum1);
	}
	
</script>

</head>
<body>

	<c:import url="nav.jsp"></c:import>
	<div style="margin: 0 5%">
		<form action="delete.action" method="post">
		<div id="table">
			
			
			</div>
		</form>
		<div align="center">
			<form action="" method="get">
				<a href="">首页</a> <span onclick="reducepage()">上一页</span>
				<span onclick="addpage()">下一页 </span>第<span
					style="color: red; font-weight: 600" id="num21"></span>页 共<span
					style="color: red; font-weight: 600" id="count"></span>页 <input
					type="text" class="page-input" id="topage"> <input
					type="button" class="page-btn" value="跳转" onclick="to1page()">
			</form>
		</div>
	</div>
</body>
</html>