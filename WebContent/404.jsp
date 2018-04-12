<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- <meta charset="UTF-8"> -->
	<!-- <meta http-equiv="refresh" content="2;url=admin.jsp">  -->
	<title>404</title>
	<style type="text/css">
	*{
		margin:0 auto;
		padding:0;
	}
	a{
		text-decoration: none;/*清除a标签下划线*/
		display:inline-block;/*a标签为行级标签，此处是让a标签同时具有行、块，以便下方的给a标签设置宽高*/
		width:100%;
		height:50px;
		line-height: 50px;
		color:#65C2D9;
		font-size:24px;
		font-weight:bold;
		position:relative;/*定位，自己可以去查*/
		top:490px;
		text-align: center;
	}
	a:hover{color: #2376BC;}/*伪类，效果为鼠标移入时改为另一种状态*/
	p{
		color:#ccc;
		font-size: 30px;
		text-align: center;
		margin-top: 10px;
	}
	div{
		width:100%;
		height:100%;
		position:absolute;
		background:url(img/404.jpg) no-repeat;
		background-size: cover;
		background-position: 0 -200px;
	}
	
	</style>
</head>
<body>
	<div>
		<p>:-(  您访问的网页可能去外太空了呢-----</p>
		<p>自动跳转中</p>
		<p id="totalSecond" style="font-size:60px; fon-family:'微软雅黑'; color:gray; text-align:center;">3</p>
		<p>.....</p>
		<a href="login.html">返回</a>
	</div>
	
	
<script type="text/javascript"> 
var second = totalSecond.innerText; 
setInterval("redirect()", 1000); 
function redirect(){ 
totalSecond.innerText=--second; 
if(second<0) location.href='404.jsp'; 
} 
</script>
</body>
</html>