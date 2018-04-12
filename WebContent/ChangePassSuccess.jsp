<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<script src="js/jquery-3.0.0.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<title></title>
		<style type="text/css">
			html,body{
				/*background:url(movie_bg.png) repeat;*/
				/*background-color: gray;*/
				height: 100%;
				width: 100%;
			}
			.head {
				background-color: #4682B4;
				color: white;
				font-family: '微软雅黑';
				font-weight: bold;
				font-size:x-large;
				border-bottom: 1px solid #4682B4;
				height: 100px;
				margin-bottom: 1px;
				width: 100%;
			}
			
			#hsp {
				clear: both;
				float: right;
				padding-top: 4px;
			}
			
			#hs {
				font-size: 50%;
				/*font-style: normal;*/
				font-style: italic;
			}
			
			#ht {
				font-family: "楷体";
				/*font-style: normal;*/
				
				color: white;
				/* float:left; */
				font-size: 150%;
				/*font-style: italic;*/
				margin-left:5%;
			}
			.navi{
				background-color:#E5E5E5;
				/*border: solid #080808 1px;*/
				height: 35px;
			}
			.navi li {
				float: left;
				display: inline;
				height: 30px;
				color:white;
				font-size: 14px;
				font-weight: 700;
				padding: 0 20px;
				margin: 4px 30px;
				line-height: 25px;
				text-align: center;
				border: 1px transparent solid;
				border-radius: 5px;
				/* behavior: url(css/PIE.htc); */
				position: relative;
			}
			
			.navi li:hover,
			.navi li.on {
				cursor: pointer;
				background:#8C8C8C;
				
				/*border-top: 1px #000 solid;*/
				/*border-left: 1px #000 solid;*/
			}
			/*进入网页主体！！！！！！！！！！！！！！*/
			.container{
				
				margin:0 auto;
				padding-bottom: 60px;
				width: 994px;
				position: relative;
				height: 100%;
				width: 100%;
			}
			/*进入网页底部！！！！！！！！！！！！！！！！！！*/
			
			.foot {
				border-top: 1px solid #4682B4;
				color: white;
				background-color: #4682B4;
				text-align: center;
				height: 60px;
				width: 98.3%;
				position:absolute;
				bottom:0px;
			}
		</style>
		<link rel="stylesheet" type="text/css" href="css/promptPanel.css"/>
		
	</head>

	<body><!--style="background-image:url(img/background.jpg) ;height:50px;width:80%;float:right"-->
		<div class="container">
		<div class="head">
			<p id="ht">Timer12306<strong id="hs">|客服热线:12306</strong></p>
		</div>
		<div class="navi-w">
		<div class="navi">
			
			<ul class="navi">
				<li >
					<a href="Main.html">客运首页</a>
				</li>
				<li class="on">
					<a href="My12306.jsp">个人中心</a>
				</li>
				<li >
					<a href="QueryRoute.jsp">车票预定</a>
				</li>
				<li >
					<a href="QueryStation.jsp">站点查询</a>
				</li>
				<li>
					<a href="http://www.baidu.com/">出行向导</a>
				</li>
			</ul>
		</div>
		<div>
			<img src="img/27.jpg" class="img-responsive" alt="Cinque Terre" style="width: 100%;height:84% ;">
				<!-- 左部菜单栏 -->
				<br/>
				　　<div style="position:absolute; z-index:2; left:40px; top:18%">
　　　　                                                     <div style="text-align:left;color:#000000;float: left;"><strong>您现在的位置：</strong><a href="主界面">修改密码</a></div>
　　                                               </div>
		        <!--修改密码失败面板-->
		     <div class="lge-block">
			<div class="lge-panel">
				<div class="lge-panel2">
					<p>修改密码成功</p>
				</div>
				<div class="lge-panel1">
					<p>Timer12306</p>
				</div>
				<div class="lge-panel3">
					<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改密码成功</p>
				<input type="button" value="返回" onclick="javascript:window.location.href='ChangePassword.jsp';"
					style="margin-left: 100px;margin-top: 10px;"
					>
			</div>
		</div>
		     
		     
		</div>
		</div>
		<div class="foot">
			<p>
				<a href="http://abputus.com" style="color: white">关于我们 &nbsp;</a>|
				<a href="http://comment.com" style="color: white">&nbsp;网站声明 </a>
			</p>
			<p>版权所有©2016   &nbsp;  湘潭大学     &nbsp;Timer小组</p>
		</div>
		</div>
	</body>

</html>