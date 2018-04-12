<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
		<title>车票预订</title>
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
				position:fixed;
				bottom:0px;
			}
		</style>
	</head>

	<body><!--style="background-image:url(img/background.jpg) ;height:50px;width:80%;float:right"-->
		<div class="container">
		<div class="head">
			<p id="ht">Timer12306<strong id="hs">|客服热线:12306</strong></p>
		</div>
		<div class="navi-w">
		<div class="navi">
			<span id="hsp" class="navi"><strong style="color:#2B542C">您好,&nbsp;&nbsp;<a href="My12306.jsp" style="color:#2B542C">${sessionScope.User.name}</a></strong> <a href="ExitServlet" style="color:#245580">退出&nbsp;&nbsp; </a>

			</span>
			<ul class="navi">
				<li >
					<a href="Main.html">客运首页</a>
				</li>
				<li >
					<a href="My12306.jsp">个人中心</a>
				</li>
				<li class="on">
					<a href="QueryRoute.jsp">车票预定</a>
				</li>
				<li  >
					<a href="QueryStation.jsp">站点查询</a>
				</li>
				<li>
					<a href="http://www.baidu.com/">出行向导</a>
				</li>
			</ul>
		</div>
			
		<!--中部内容区-->
		<div>
			<img src="img/17.jpg" class="img-responsive" alt="Cinque Terre" style="width: 100%;height:84%">
			<br/>
			<div style="position:absolute; z-index:2; left:40px; top:18%">
　　　　                     	<div style="text-align:left;color:#000000;float: left;"><strong>您现在的位置：</strong><a href="主界面">确认车票</a></div>
			</div>
		</div>
		
		<div style="position:absolute;top: 280px;width: 50%;left: 25%;">
				<tr>
					<div id="yuding">
				      <div class="modal-content">
				         <div class="modal-header">
				            <h4 class="modal-title" id="myModalLabel" style="font-size: 32px;">车票信息</h4>
				         </div>
				         <div class="modal-body" style="font: '微软雅黑';font-size: 18px;left:30%;line-height: 200%;">
				         	车名：${sessionScope.route.name}<br />
				         	车次：${sessionScope.route.type}<br />
				         	起点站：${sessionScope.route.fromStation}<br />
				         	终点站：${sessionScope.route.toStation}<br />
				         	开车时间：${sessionScope.route.departureTime}<br />
				         	<form action="CreateOrderServlet" method = "post"> 
				         	<input type="hidden" name="departureTime" value="${sessionScope.route.departureTime}">
				         	席别以及价格：<select name="seatType"><option value="商务座">商务座${sessionScope.route.bPrice}元</option><option value="特等座">特等座${sessionScope.route.spPrice}元</option>
				         		<option value="软座">软座${sessionScope.route.sfPrice}元</option><option value="硬座">硬座${sessionScope.route.hPrice}元</option><option value="无座">无座${sessionScope.route.nPrice}元</option>
				         	</select><br />
				         	购票人：${sessionScope.User.name}<br />
				         	证件号码：${sessionScope.User.idCard}<br />
				         	密码：<input type="password" placeholder="您的登录密码" name="password"><br />
				         	 <div style = "position:relative;left:50%">
				            <input type="submit">
				            <!-- < type="button" class="btn btn-primary" data-dismiss="modal">取消</button> -->
				         </div>
				         	</form>
				         </div>
				        
				      </div><!-- /.modal-content -->
				</div><!-- /.modal -->
				</tr>
				
				
				
			</table>
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