<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/My97DatePicker/WdatePicker.js" ></script>
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
				position:fixed;
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
			<span id="hsp" class="navi"><strong style="color:#2B542C">您好,&nbsp;&nbsp;<a href="My12306.html">${sessionScope.User.name}</a></strong> <a href="ExitServlet" style="color:#245580">退出&nbsp;&nbsp; </a>

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
		
		<div style="margin:center;position:relative;top:-450px;left:26%;font-size:32px;width:60%;border: 1px solid #4682B4;height: 100%;">
			<div style="position:relative;font-size:38px;color:black;width:100%;border:1px solid gray;text-align: center;">我的订单</div>
			<!--<div style="margin:center;position:relative;top:10px;left:5%;width:90%;border: 1px solid gray;">
				
			        <table align="center" style="position:relative;top:10px;left:12%;margin:center;width:100%;padding: 100px;margin-bottom: 20px;font-size: 14px;">
				        <tr>
				        	<td>查询日期</td><td><input type="text" name="riddingDate" placeholder="出发日期" onFocus="WdatePicker()"></td>
					        <td></td><td><input type="text" name="riddingDate" placeholder="到达日期" onFocus="WdatePicker()"></td>
					        <td><input type="text" name="riddingDate" placeholder="订单号"></td>
					        <td class="btn-group" data-toggle="buttons" style="width: 300px">
					        	<label class="btn btn-primary">
                                    <input type="radio" name="options" id="option1"> 查询
                                </label> 
                            </td> 
				        </tr>
				    </table>
	          </div>
	         <hr style="width:90%;" color="#4682B4"/>
	         <div style="position:relative;top:-20px;left:5%;">	
	         	  <button type="button" class="btn btn-link">全部</button>
	         </div>-->
	         <hr style="width:90%;border: 1px solid #4682B4;" />
	          <div style="margin:center;position:relative;top:0px;left:5%;width:90%;height:670px;border: 1px solid gray;">
	          	<div>
				    <table align="center" class="table table-bordered" style="position:relative;margin:center;width:100%;height:50px;padding:100px;margin-bottom: 20px;font-size: 14px;border: 1px solid gray">
			            <tr>

					            	<td width="80px" align="center">id</td>
						            <td width="80px" align="center">订单状态</td>
						            <td width="200px" align="center">订单创建日期</td>
						            <td width="200px" align="center">支付日期</td>
						            <td width="200px" align="center">最后一次更改日期</td>
						            <td width="80px" align="center">订单价格</td>
						            <td width="80px" align="center">用户ID</td>
						            <td width="80px" align="center">车次ID</td>
					            </tr>

				    </table>
					
				    <table align="center"class="table table-bordered" style="position:relative;top:10px;margin:center;width:100%;padding: 100px;margin-bottom: 20px;font-size: 14px;">
			            <c:forEach items="${requestScope.list}" var="order">
			            <tr>

					            	<td width="80px" align="center">${order.id}</td>
						            <td width="80px" align="center">${order.status}</td>
						            <td width="200px" align="center">${order.createDate}</td>
						            <td width="200px" align="center">${order.payTime}</td>
						            <td width="200px" align="center">${order.lastUpdateDate}</td>
						            <td width="80px" align="center">${order.price}元</td>
						            <td width="80px" align="center">${order.userId}</td>
						            <td width="80px" align="center">${order.routeId}</td>
					            </tr>
 </c:forEach>	
				    </table>
				   
				</div>
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