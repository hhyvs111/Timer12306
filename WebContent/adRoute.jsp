<%@ page language="java" isELIgnored="false"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	</head>

		<body>
		<div class="container">
		    <div class="head">
	<!--	<p id="ht">Timer12306<strong id="hs">|客服热线:12306</strong></p>-->
			    <p id="ht">Timer12306<strong id="hs">|客服热线:12306</strong></p>
			        <div style="float:right;height:70px; margin-right:50px;">
                        <span>您好，<a href="admin.jsp" style="color: white">admin</a>！</span>
                        <span ><a href="Main.html" style="color:#245580">注销</a></span>
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
				        <li class="on" >
					        <a href="adRoute.jsp">车次管理</a>
				        </li>
				        <li >
					        <a href="adSite.jsp">站点管理</a>
				        </li>		
				        <li >
					        <a href="adUser.jsp">用户管理</a>
				        </li>	
			        </ul>
		        </div>

		        <div>
			        <img src="img/13.jpg" class="img-responsive" alt="Cinque Terre" style="width: 100%;height:84%">
				    <!-- 左部菜单栏 -->
				    <!--<br/>
				    <div style="position:absolute; z-index:2; left:40px; top:18%">

　　　　                                                     <div style="text-align:left;color:#000000;float: left;"><strong>您现在的位置：</strong><a href="主界面">车票管理</a></div>

　　                                                   </div>-->
		     
		        </div>
						<div id="jsContainer" class="jsContainer" style="height:0">
    		<div id="tuna_alert" style="display:none;position:absolute;z-index:999;overflow:hidden;"></div>
    		<div id="tuna_jmpinfo" style="visibility:hidden;position:absolute;z-index:120;"></div>
		</div>
		         <!--中部内容区-->
		        
		        <div style="position:absolute;top:18%;width: 98.3%;">
		            <form action="<%=request.getContextPath()%>/ADQueryRouteServlet" method="post">
			        <table align="center" style="width:60%;padding: 100px;margin-bottom: 20px;font-size: 14px;">
				        <tr style="font-family:'微软雅黑'">
				        	<td><strong>出发地</strong></td><td><input class="form-control" style="width:150px; height:30px;" type="text" value="" size="15" id="fromPlace" name="fromStation" mod="address|notice" mod_address_source="hotel" mod_address_suggest="@Beijing|北京|53@Shanghai|上海|321@Shenzhen|深圳|91@Guangzhou|广州|80@Qingdao|青岛|292@Chengdu|成都|324@Hangzhou|杭州|383@Wuhan|武汉|192@Tianjin|天津|343@Dalian|大连|248@Xiamen|厦门|61@Chongqing|重庆|394@" mod_address_reference="cityid" mod_notice_tip="中文/拼音" />
									 <input id="cityid"  name="cityid" type="hidden" value="{$cityid}" /></td>
					<td><strong>目的地</strong></td><td><input type="text" class="form-control" style="width:150px; height:30px;" value="" size="15" id="toPlace" name="toStation" mod="address|notice" mod_address_source="hotel" mod_address_suggest="@Beijing|北京|53@Shanghai|上海|321@Shenzhen|深圳|91@Guangzhou|广州|80@Qingdao|青岛|292@Chengdu|成都|324@Hangzhou|杭州|383@Wuhan|武汉|192@Tianjin|天津|343@Dalian|大连|248@Xiamen|厦门|61@Chongqing|重庆|394@" mod_address_reference="getcityid" mod_notice_tip="中文/拼音" />
									 <input id="getcityid" name="getcityid" type="hidden" value="{$getcityid}" /></td>
					        <td><strong>出发日</strong></td><td><input type="text" class="form-control" style="width:150px; height:30px;" name="departureTime" onFocus="WdatePicker()"></td>
					        <!--<td><input type="button" style="align-content: center;width: 100px;" name="submit" value="查询"></td>-->
					        <td  style="width: 300px">
                                <button type="submit"  class="btn btn-default"><strong>查询</strong></button>
                              <!--   <button type="submit" class="btn btn-default">添加</button>
                                <button type="submit" class="btn btn-default">修改</button> -->
                                
                                <button type="button" class="btn btn-default"
									data-toggle="modal" data-target="#myaddModal"><strong>添加</strong></button> <!-- 模态框（Modal） -->
								
                                
                            </td> 
				        </table>
				        </form>		
				       	   <table class="table table-bordered" align="center" >
					            <tr >
					            	
					            	<!--<td width="80px" align="center">id</td>-->
						            <td width="80px" align="center"><strong>车次ID</strong></td>
						            <td width="80px" align="center"><strong>车次名</strong></td>
						            <td width="80px" align="center"><strong>车次号</strong></td>
						            <td width="80px" align="center"><strong>商务座数量</strong></td>
									<td width="80px" align="center"><strong>特等座数量</strong></td>
									<td width="80px" align="center"><strong>软卧数量</strong></td>
									<td width="80px" align="center"><strong>硬座数量</strong></td>
									<td width="80px" align="center"><strong>无座数量</strong></td>
						            <td width="150px" align="center"><strong>出发时间</strong></td>
						            <td width="150px" align="center"><strong>到达时间</strong></td>
						            <td width="80px" align="center"><strong>出发站</strong></td>
						            <td width="80px" align="center"><strong>目的站</strong></td>
						            <td width="80px" align="center"><strong>备注</strong></td>
						            <td width="80px" align="center"><strong>删除</strong></td>
						            <td width="80px" align="center"><strong>修改</strong></td>

						            <!--<td width="80px" align="center">订单 id</td>-->
					               <!-- <td width="80px" align="center">用户 id</td>-->
					            </tr>
				            </table>
				
				<c:forEach items="${requestScope.list}" var="route">
				<form action="DeleteRouteServlet" method="get">
				<input type="hidden" name="routeId" value="${route.id}">
				<table class="table table-bordered" align="center" >
					            <tr>
					            	
					            	<!--<td width="80px" align="center">id</td>-->
						            <td width="80px" align="center">${route.id}</td>
						            <td width="80px" align="center">${route.name}</td>
						            <td width="80px" align="center">${route.type}</td>
						            <td width="80px" align="center">${route.businessSeatCount}</td>
									<td width="80px" align="center">${route.specialSeatCount}</td>
									<td width="80px" align="center">${route.softSeatCount}</td>
									<td width="80px" align="center">${route.hardSeatCount}</td>
									<td width="80px" align="center">${route.noSeatCount}</td>
 					            	<td width="150px" align="center">${route.departureTime}</td>
						            <td width="150px" align="center">${route.arrivalTime}</td>
						            <td width="80px" align="center">${route.fromStation}</td>
						            <td width="80px" align="center">${route.toStation}</td>
						            <td width="80px" align="center">${route.remark}</td>
						           
						            <td width="80px" align="center"><button type="submit" class="btn btn-default">删除</button></td>
						            
						<td width="80px" align="center"><button type="button" class="btn btn-default"
									data-toggle="modal" data-target="#mymModal">修改</button></td>
						            <!--<td width="80px" align="center">订单 id</td>-->
					               <!-- <td width="80px" align="center">用户 id</td>-->
					            </tr>
				</table>
				</form>
				
				
				<form action="<%=request.getContextPath()%>/UpdateRouteServlet" method="post">
									<div class="modal fade" id="mymModal" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">&times;</button>
													<h4 class="modal-title" id="myModalLabel">修改车次</h4>
												</div>
																<input type="hidden" name="routeId" value="${route.id}">
												<div class="modal-body">
													<div class="modal-body">
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">车次
															</span> <input type="text" class="form-control"
																value="${route.name}" name="routeName">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">车次类型</span>
															<input type="text" class="form-control"
																value="${route.type}" name="routeType">
														</div>
														<br />
						
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">出发车站
															</span> <input type="text" class="form-control"
																value="${route.fromStation}" name="fromStation">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">终点车站
															</span> <input type="text" class="form-control"
																value="${route.toStation}" name="toStation">
														</div>

														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">发车时间
															</span> <input type="text" class="form-control"
																value="${route.departureTime}" name="departureTime">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">到达时间
															</span> <input type="text" class="form-control"
																value="${route.arrivalTime}" name="arrivalTime">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">商务座数
															</span> <input type="text" class="form-control"
																value="${route.businessSeatCount}" name="businessSeatCount">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">商务座价格
															</span> <input type="text" class="form-control"
																value="${route.bPrice }" name="bPrice">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">特等座数
															</span> <input type="text" class="form-control"
																value="${route.specialSeatCount}" name="specialSeatCount">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">特等座价格
															</span> <input type="text" class="form-control"
																value="${route.spPrice }" name="spPrice">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">软卧数量
															</span> <input type="text" class="form-control"
																value="${route.softSeatCount}" name="softSeatCount">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">软卧价格
															</span> <input type="text" class="form-control"
																value="${route.sfPrice }" name="sfPrice">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">硬座数量
															</span> <input type="text" class="form-control"
																value="${route.hardSeatCount}" name="hardSeatCount">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">硬座价格
															</span> <input type="text" class="form-control"
																value="${route.hPrice }" name="hPrice">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">无座数
															</span> <input type="text" class="form-control"
																value="${route.noSeatCount}" name="noSeatCount">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">无座价格
															</span> <input type="text" class="form-control"
																value="${route.nPrice}" name="nPrice">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">备注
															</span> <input type="text" class="form-control"
																value="${route.remark}" name="remark">
														</div>
														<br />
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
														<button type="submit" class="btn btn-primary">修改
														</button>
													</div>
													</div>
								</div>
								</div>
								</div>
								</form>
				
				
				
				</c:forEach>
			        
		        </div>
	        </div>



								
								<form action="<%=request.getContextPath()%>/CreateRouteServlet" method="post">
									<div class="modal fade" id="myaddModal" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">&times;</button>
													<h4 class="modal-title" id="myModalLabel">添加车次</h4>
												</div>
												<div class="modal-body">
													<div class="modal-body">
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">车次名
															</span> <input type="text" class="form-control"
																placeholder="请输入车次" name="routeName">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">车次号</span>
															<input type="text" class="form-control"
																placeholder="请输入车次类型" name="routeType">
														</div>
														<br />
						
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">出发车站
															</span> <input type="text" class="form-control"
																placeholder="请输入出发车站" name="fromStation">
														</div>
														<br />
														<!-- <div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">出发站id
															</span> <input type="text" class="form-control"
																placeholder="请输入出发站id" name="fsid">
														</div> -->
														<!-- <br /> -->
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">终点车站
															</span> <input type="text" class="form-control"
																placeholder="请输入终点车站" name="toStation">
														</div>
														<br />
														<!-- <div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">终点站id
															</span> <input type="text" class="form-control"
																placeholder="请输入终点站id" name="tsid">
														</div>
														<br /> -->
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">发车时间
															</span> <input type="text" class="form-control"
																placeholder="请输入发车时间" name="departureTime">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">到达时间
															</span> <input type="text" class="form-control"
																placeholder="请输入到达时间" name="arrivalTime">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">商务座数
															</span> <input type="text" class="form-control"
																placeholder="请输入商务座数" name="businessSeatCount">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">商务座价格
															</span> <input type="text" class="form-control"
																placeholder="请输入商务座价格" name="bPrice">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">特等座数
															</span> <input type="text" class="form-control"
																placeholder="请输入特等座数" name="specialSeatCount">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">特等座价格
															</span> <input type="text" class="form-control"
																placeholder="请输入特等座价格" name="spPrice">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">软卧数量
															</span> <input type="text" class="form-control"
																placeholder="请输入软卧数量" name="softSeatCount">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">软卧价格
															</span> <input type="text" class="form-control"
																placeholder="请输入软卧价格" name="sfPrice">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">硬座数量
															</span> <input type="text" class="form-control"
																placeholder="请输入硬座数量" name="hardSeatCount">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">硬座价格
															</span> <input type="text" class="form-control"
																placeholder="请输入硬座价格" name="hPrice">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">无座数
															</span> <input type="text" class="form-control"
																placeholder="请输入无座数" name="noSeatCount">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">无座价格
															</span> <input type="text" class="form-control"
																placeholder="请输入无座价格" name="nPrice">
														</div>
														<br />
														<div class="input-group"
															style="height: 10px; width: 450px;">
															<span class="input-group-addon" style="width: 100px;">备注
															</span> <input type="text" class="form-control"
																placeholder="备注" name="remark">
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
				    <a href="http://abputus.com" style="color: white">关于我们 &nbsp;</a>|
				    <a href="http://comment.com" style="color: white">&nbsp;网站声明 </a>
			    </p>
			    <p>版权所有©2016   &nbsp;  湘潭大学     &nbsp;Timer小组</p>
		    </div>
		</div>
				<script type="text/javascript" src="js/fixdiv.js"></script>
		<script type="text/javascript" src="js/address.js"></script>
	</body>

</html>