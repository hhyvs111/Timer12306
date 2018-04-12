<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<title></title>
<style type="text/css">
html, body {
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
	font-size: x-large;
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
	margin-left: 5%;
}

.navi {
	background-color: #E5E5E5;
	/*border: solid #080808 1px;*/
	height: 35px;
}

.navi li {
	float: left;
	display: inline;
	height: 30px;
	color: white;
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

.navi li:hover, .navi li.on {
	cursor: pointer;
	background: #8C8C8C;

	/*border-top: 1px #000 solid;*/
	/*border-left: 1px #000 solid;*/
}
/*进入网页主体！！！！！！！！！！！！！！*/
.container {
	margin: 0 auto;
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
	position: absolute;
	bottom: 0px;
}
</style>
</head>

<body>
	<div class="container">
		<div class="head">
			<!--	<p id="ht">Timer12306<strong id="hs">|客服热线:12306</strong></p>-->
			<p id="ht">
				Timer12306<strong id="hs">|客服热线:12306</strong>
			</p>
			<div style="float: right; height: 70px; margin-right: 50px;">
				<span>您好，<a href="admin.jsp" style="color: white">admin</a>！
				</span> <span><a href="Main.html" style="color: #245580">注销</a></span>
			</div>
		</div>
		
		<div class="navi-w">
			<div class="navi">
			        <ul class="navi">
				        <li >
					        <a href="admin.jsp">首页</a>
				        </li>
				        <li >
					        <a href="adTicket.jsp">车票管理</a>
				        </li>
				        <li >
					        <a href="adRoute.jsp">车次管理</a>
				        </li>
				        <li >
					        <a href="adSite.jsp">站点管理</a>
				        </li>		
				        <li class="on">
					        <a href="adUser.jsp">用户管理</a>
				        </li>	
			        </ul>
			        
			</div>
			<div>
				<img src="img/13.jpg" class="img-responsive" alt="Cinque Terre"
					style="width: 100%; height: 84%">
				<!-- 左部菜单栏 -->
				<br />


			</div>

			<!--中部内容区-->

			<div style="position: absolute; top: 18%; width: 98.3%;">
				<form action="<%=request.getContextPath()%>/QueryAllUserInfoServlet"
					method="post">
					<table align="center"
						style="width: 60%;left :1000px; padding: 100px; margin-bottom: 20px; font-size: 14px;">
						<tr>
							 <!-- <td style="width:30px;">用户名</td><td><input type="text" name="departureTime" onFocus="WdatePicker({minDate:'%y-%M-{%d}'})"></td> 
							<td><input type="hidden" style="align-content: center;width: 100px;" name="submit" value="查询"></td> -->
							<td style="width:100px"></td>
							<td style="width:100px"></td>
							<td style="width:100px"></td>
							<td style="width:100px"></td>
							<td style="width:100px"></td>
							<td style="width:100px"></td>
							<td style="width:100px"></td>
							<td style="width:100px"></td>
							<td style="width:100px"></td>
							<td style="width:100px"></td>
							<td style="width:100px"></td>
							<td style="width:10000px"></td>
							
							<td style="width: 1000px" >
								<button type="submit" class="btn btn-default"><strong>查询</strong></button> <!--  <button type="submit" class="btn btn-default">添加</button>
                                <button type="submit" class="btn btn-default">修改</button> -->

								<button type="button" class="btn btn-default"
									data-toggle="modal" data-target="#myaddModal"><strong>添加</strong></button> <!-- 模态框（Modal） -->
							</td>
					</table>
				</form>
				

				    
				    
				<table class="table table-bordered" align="center">
					<tr>

									<td width="100px" align="center">用户id</td>
						            <td width="100px" align="center">用户名</td>
						            <td width="100px" align="center">密码</td>
						            <td width="200px" align="center">邮箱</td>
						            <td width="80px" align="center">姓名</td>
						            <td width="130px" align="center">生日</td>
						            <td width="120px" align="center">电话号码</td>
						            <td width="80px" align="center">身份证类型</td>
						            <td width="200px" align="center">身份证号</td>
						            <td width="100px" align="center">余额</td>
						            <td width="80px" align="center">删除</td>
						            <td width="80px" align="center">修改</td>
					</tr>
				</table>
			
				<c:forEach items="${requestScope.list}" var="order">
				
					<form action="DeleteUserServlet" method="post">
					<input type="hidden" name="userId" value="${order.id}">
						<table class="table table-bordered" align="center">
						
						
							<tr>
								
								<!--<td width="80px" align="center">id</td>-->
									<td width="100px" align="center">${order.id}</td>
						            <td width="100px" align="center">${order.username}</td>
						            <td width="100px" align="center">${order.password}</td>
						            <td width="200px" align="center">${order.mail}</td>
						            <td width="80px" align="center">${order.name}</td>
						            <td width="130px" align="center">${order.birthday}</td>
						            <td width="120px" align="center">${order.phoneNumber}</td>
						            <td width="80px" align="center">${order.idType}</td>
						            <td width="200px" align="center">${order.idCard}</td>
						            <td width="100px" align="center">${order.balance}元</td>
								<!--  <td width="80px" align="center"><button type="submit" class="btn btn-default">删除</button></td> -->
								 <td width="80px" align="center"><button type="submit" class="btn btn-default"
										data-toggle="modal" data-target="#myModal">删除</button></td> 
										<td width="80px" align="center"><button type="button" class="btn btn-default"
									data-toggle="modal" data-target="#mymModal">修改</button>
								<!--<td width="80px" align="center">订单 id</td>-->
								<!-- <td width="80px" align="center">用户 id</td>-->
							</tr>
							
						</table>
					</form>
					
					<form action="<%=request.getContextPath()%>/ADUpdateUserServlet" method="post">
			<div class="modal fade" id="mymModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">修改用户</h4>
						</div>
						<div class="modal-body">
							<div class="modal-body">
							
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">用户名
									</span> <input type="text" class="form-control" value = "${order.username}" placeholder="请输入用户名"
										name="username">
								</div>
								<br />
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">密码</span>
									<input type="password" class="form-control" value = "${order.password}" placeholder="请输入密码"
										name="password">
								</div>
								<br />
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">邮箱
									</span> <input type="text" class="form-control" value = "${order.mail}"placeholder="请输入邮箱"
										name="mail">
								</div>
								<br />
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">姓名
									</span> <input type="text" class="form-control" value = "${order.name}"placeholder="请输入真实姓名"
										name="name">
								</div>
								<br />	
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">手机号
									</span> <input type="text" class="form-control" value = "${order.phoneNumber}"placeholder="请输入手机号"
										name="phoneNumber">
								</div>
								<br />	
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">身份证类型
									</span> <input type="text" class="form-control" value = "${order.idType}"placeholder="请输入身份证类型"
										name="idType">
								</div>
								<br />	
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">身份证号
									</span> <input type="text" class="form-control" value = "${order.idCard}"placeholder="请输入身份证号"
										name="idCard">
								</div>
								<br />	
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">生日
									</span> <input type="text" class="form-control" value = "${order.birthday}"placeholder="请输入生日"
										name="birthday">
								</div>
								<br />	
									<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">余额
									</span> <input type="text" class="form-control" value = "${order.balance}" placeholder="请输入余额"
										name="balance">
								</div>
								<br />	
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="submit" class="btn btn-primary">修改</button>
							</div>
								</div>
	</div>
	</div>
	</div>
		</form>
					
				</c:forEach>
				

			</div>
		</div>



		<!-- 模态框（Modal） -->

		<!-- /.modal-content -->
		<!-- /.modal -->
 			<form action="<%=request.getContextPath()%>/ADRegisterServlet" method="post">
									<div class="modal fade" id="myaddModal" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">&times;</button>
													<h4 class="modal-title" id="myModalLabel">添加用户</h4>
												</div>
												<div class="modal-body">
													<div class="modal-body">
														
														<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">用户名
									</span> <input type="text" class="form-control" placeholder="请输入用户名"
										name="username">
								</div>
								<br />
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">密码</span>
									<input type="password" class="form-control" placeholder="请输入密码"
										name="password">
								</div>
								<br />
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">邮箱
									</span> <input type="text" class="form-control" placeholder="请输入邮箱"
										name="mail">
								</div>
								<br />
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">姓名
									</span> <input type="text" class="form-control" placeholder="请输入真实姓名"
										name="name">
								</div>
								<br />	
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">手机号
									</span> <input type="text" class="form-control" placeholder="请输入手机号"
										name="phoneNumber">
								</div>
								<br />	
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">身份证类型
									</span> <input type="text" class="form-control" placeholder="请输入身份证类型"
										name="idType">
								</div>
								<br />	
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">身份证号
									</span> <input type="text" class="form-control" placeholder="请输入身份证号"
										name="idCard">
								</div>
								<br />	
								<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">生日
									</span> <input type="text" class="form-control" placeholder="请输入生日"
										name="Date">
								</div>
								<br />	
									<div class="input-group" style="height: 10px; width: 450px;">
									<span class="input-group-addon" style="width: 100px;">余额
									</span> <input type="text" class="form-control" placeholder="请输入余额"
										name="balance">
								</div>
								<br />	
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
														<button type="submit" class="btn btn-primary">添加
														</button>
													</div>
													</div>
								</div>
								</div>
								</div>
								</form> <!-- /.modal-content --> <!-- /.modal -->




	<div class="foot">
		<p>
			<a href="http://abputus.com" style="color: white">关于我们 &nbsp;</a>| <a
				href="http://comment.com" style="color: white">&nbsp;网站声明 </a>
		</p>
		<p>版权所有©2016 &nbsp; 湘潭大学 &nbsp;Timer小组</p>
	</div>
	</div>
</body>

</html>