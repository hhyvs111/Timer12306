<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<title></title>
		<style type="text/css">
			html,body{
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
				font-style: italic;
			}
			
			#ht {
				font-family: "楷体";
				
				color: white;
				font-size: 150%;
				margin-left:5%;
			}
			.navi{
				background-color:#E5E5E5;
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
				position: relative;
			}
			
			.navi li:hover,
			.navi li.on {
				cursor: pointer;
				background:#8C8C8C;
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
	</head>

	<body>
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
		<br/>
		
		<div>
		<img src="img/27.jpg" class="img-responsive" alt="Cinque Terre" style="width: 100%;height:84%">
		<!-- 左部菜单栏 -->
		<div style="position:absolute; z-index:2; left:40px; top:18%">
		<p style="text-align:left;color:#000000"><strong>您现在的位置：</strong><a href="主界面">客运首页</a>>我的12306</p></div>
		</div> 
		
		
<div style="position:absolute;top: 240px;width: 98.3%;height:73%">
		<ul class="nav nav-pills nav-stacked" style="max-width: 260px;text-align:center">
			<li class="active"><a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">我的订单</a>
				<div id="collapseOne" class="panel-collapse collapse in">
				 	<a  class="list-group-item" href="QueryOrderByUserServlet">订单查询</a>
      				<a  class="list-group-item" href="QueryTicketServlet">我的车票</a>
				</div>
			</li>
			<li class="active"><a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">我的个人信息</a>
				<div id="collapseTwo" class="panel-collapse collapse in">
				 	<a class="list-group-item" href="Info.jsp">查看个人信息</a>
				 	<a class="list-group-item" href="ChangeInfo.jsp">修改个人信息</a>
				 	<a class="list-group-item" href="ChangePassword.jsp">修改密码</a>
      			</div>
			</li>
			<li class="active"><a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">常用信息管理</a>
				<div id="collapseThree" class="panel-collapse collapse in">
				 	<a class="list-group-item" href="http//">车票快递地址</a>
      			</div>
			</li>
			<li class="active"><a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">贴心服务</a>
				<div id="collapseFour" class="panel-collapse collapse in">
				 	<a class="list-group-item" href="http//">遗失物品查找</a>
      			</div>
			</li>
		</ul>
		
		<div style="width:650px;height:600px;background: #FFFFFF; border:1px solid #4682B4;position: absolute; margin-left:650px;    
	margin-top: -460px;
	border-radius: 5px 5px 5px 5px; ">		
		<div style="width:650px;height:50px;background: #4682B4; border:1px solid #4682B4;border-radius: 5px 5px 0px 0px;font-size: x-large; text-align:center;line-height:50px;color:#FFFFFF">		
	<span >个人信息</span>
		</div>
	
	<div style="margin:center;position:absolute; margin-left: 150px;margin-top: 50px;;font-size:32px;width:50%;">
			<span style="text-align:center;position:absolute;right:50%;font-size:22px;">*用户名：</span>
			<span style="text-align:center;position:absolute;left:50%;font-size:22px;">${sessionScope.User.username}</span><br/>
			<span style="text-align:center;position:absolute;right:50%;font-size:22px;">*姓名：</span>
			<span style="text-align:center;position:absolute;left:50%;font-size:22px;">${sessionScope.User.name}</span><br/>
			<!--<span style="text-align:center;position:absolute;right:50%;font-size:22px;">*性别：</span>
			<span style="text-align:center;position:absolute;left:50%;font-size:22px;">女</span><br/>
			<span style="text-align:center;position:absolute;right:50%;font-size:22px;">国家/地区：</span>
			<span style="text-align:center;position:absolute;left:50%;font-size:22px;">中国CHINA</span><br/>-->
			<span style="text-align:center;position:absolute;right:50%;font-size:22px;">*证件类型：</span>
			<span style="text-align:center;position:absolute;left:50%;font-size:22px;">${sessionScope.User.idType}</span><br/>
			<span style="text-align:center;position:absolute;right:50%;font-size:22px; ">*证件号码：</span>
			<span style="text-align:center;position:absolute;left:50%;font-size:22px;">${sessionScope.User.idCard}</span><br/>
			<span style="text-align:center;position:absolute;right:50%;font-size:22px;">出生日期：</span>
			<span style="text-align:center;position:absolute;left:50%;font-size:22px;">${sessionScope.User.birthday}</span><br/>
			<span style="text-align:center;position:absolute;right:50%;font-size:22px;">校验状态：</span>
			<span style="text-align:center;position:absolute;left:50%;font-size:22px;color:#4682B4">已通过</span><br/>
			<span style="text-align:center;position:absolute;right:50%;font-size:22px;">*手机号码：</span>
			<span style="text-align:center;position:absolute;left:50%;font-size:22px;">${sessionScope.User.phoneNumber}</span><br/>
			<span style="text-align:center;position:absolute;right:50%;font-size:22px;">电子邮箱：</span>
			<span style="text-align:center;position:absolute;left:50%;font-size:22px;">${sessionScope.User.mail}</span><br/>
			<span style="text-align:center;position:absolute;right:50%;font-size:22px;">当前余额：</span>
			<span style="text-align:center;position:absolute;left:50%;font-size:22px;">${sessionScope.User.balance}元   <a href="Infor.html"><input type="submit"  class="button" name="ensure" value="充值"></a></span><br/>
		</div>
		 
		</div>
		
<!--		<script type="text/javascript">
   $(function () { $('#collapseFour').collapse({
      toggle: false
   })});
   $(function () { $('#collapseTwo').collapse('show')});
   $(function () { $('#collapseThree').collapse('toggle')});
   $(function () { $('#collapseOne').collapse('hide')});
</script>-->

		
		<div class="foot">
			<p>
				<a href="http://abputus.com" style="color: white">关于我们 &nbsp;</a>|
				<a href="http://comment.com" style="color: white">&nbsp;网站声明 </a>
			</p>
			<p>版权所有©2016   &nbsp;  湘潭大学     &nbsp;Timer小组</p>
		</div>
		</div>
		</div>
	</body>

</html>