<%@ page language="java" isELIgnored="false"  contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

	<body><!--style="background-image:url(img/background.jpg) ;height:50px;width:80%;float:right"-->
		<div class="container">
		<div class="head">
			<p id="ht">Timer12306<strong id="hs">|客服热线:12306</strong></p>
		</div>
		<div class="navi-w">
		<div class="navi">
			<span id="hsp" class="navi"><strong style="color:#2B542C">您好,&nbsp;&nbsp;<a href="My12306.jsp">${sessionScope.User.name}</a></strong> <a href="ExitServlet" style="color:#245580">退出&nbsp;&nbsp; </a>

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
		
		
					<div id="jsContainer" class="jsContainer" style="height:0">
    		<div id="tuna_alert" style="display:none;position:absolute;z-index:999;overflow:hidden;"></div>
    		<div id="tuna_jmpinfo" style="visibility:hidden;position:absolute;z-index:120;"></div>
		</div>
		
		
		<!--中部内容区-->
		<div>
			<img src="img/17.jpg" class="img-responsive" alt="Cinque Terre" style="width: 100%;height:84%">
			<br/>
			<div style="position:absolute; z-index:2; left:40px; top:18%">
　　　　                     	<div style="text-align:left;color:#000000;float: left;"><strong>您现在的位置：</strong><a href="主界面">车票预订</a></div>
			</div>
		</div>
		<div style="position:absolute;top: 240px;width: 98.3%;">
		<form action="QueryRouteAtoBServlet" method="post">
			<table align="center" style="width: 60%;padding: 10px;margin-bottom: 20px;font-size: 14px;">
				<tr style="font-family:'微软雅黑'" ><td><strong>出发地</strong></td><td><input type="text" class="form-control" style="width:150px; height:30px;" value="" size="15" id="fromPlace" name="fromStation" mod="address|notice" mod_address_source="hotel" mod_address_suggest="@Beijing|北京|53@Shanghai|上海|321@Shenzhen|深圳|91@Guangzhou|广州|80@Qingdao|青岛|292@Chengdu|成都|324@Hangzhou|杭州|383@Wuhan|武汉|192@Tianjin|天津|343@Dalian|大连|248@Xiamen|厦门|61@Chongqing|重庆|394@" mod_address_reference="cityid" mod_notice_tip="中文/拼音" />
									 <input id="cityid" name="cityid" type="hidden" value="{$cityid}" /></td>
									 
					<td><strong>目的地</strong></td><td><input type="text" class="form-control" style="width:150px; height:30px;" value="" size="15" id="toPlace" name="toStation" mod="address|notice" mod_address_source="hotel" mod_address_suggest="@Beijing|北京|53@Shanghai|上海|321@Shenzhen|深圳|91@Guangzhou|广州|80@Qingdao|青岛|292@Chengdu|成都|324@Hangzhou|杭州|383@Wuhan|武汉|192@Tianjin|天津|343@Dalian|大连|248@Xiamen|厦门|61@Chongqing|重庆|394@" mod_address_reference="getcityid" mod_notice_tip="中文/拼音" />
									 <input id="getcityid" name="getcityid" type="hidden" value="{$getcityid}" /></td>
									 
					<td><strong>出发日</strong></td><td><input type="text" name="departureTime" class="form-control" style="width:150px; height:30px;" onFocus="WdatePicker()"></td>
					<td><input type="submit" class="form-control" style="width:100px; height:30px;"  value="查询"></td>
					<!-- <td><input type="button" style="align-content: center;width: 100px;" name="submit" data-toggle="modal" data-target="#myModal" value="预定"></td> -->
					<div id="yuding">
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				   <div class="modal-dialog">
				      <div class="modal-content">
				         <div class="modal-header">
				            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				            <h4 class="modal-title" id="myModalLabel">票价信息</h4>
				         </div>
				         <div class="modal-body" style="font: '微软雅黑';font-size: 16px;">
				         	车次：<br />
				         	起点站：<br />
				         	终点站：<br />
				         	购票人：<br />
				         	证件号码：<br />
				         	席别：<br />
				         	票种：<br />
				         	票价：<br />
				         </div>
				         <div class="modal-footer">
				            <button type="button" class="btn btn-default" data-dismiss="modal" onclick="alert('购票成功！')">提交订单</button>
				            <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
				         </div>
				      </div><!-- /.modal-content -->
				</div><!-- /.modal -->
				</div>
				</tr>
				</table>
				</form>
				<!--<tr><table align="center" class="table table-striped"><tr>
					<td>车次类型</td>
					<td><input type="checkbox" name="checkbox1" value="checkbox">高速动车(G)</td>
					<td><input type="checkbox" name="checkbox2" value="checkbox">动车(D)</td>
					<td><input type="checkbox" name="checkbox3" value="checkbox">直达特快列车 (Z)</td>
					<td><input type="checkbox" name="checkbox4" value="checkbox">特别快车(T)</td>
					<td><input type="checkbox" name="checkbox5" value="checkbox">快速列车 (K)</td>
					<td><input type="checkbox" name="checkbox6" value="checkbox">临客(L)</td>
					<td><input type="checkbox" name="checkbox7" value="checkbox">普通列车(纯数字开头)</td></tr>
				</table></tr>-->
				
				<!--<tr><table align="center" class="table table-striped"><tr>
					<td>出发车站</td><td><input type="text" name="fromStation"></td>
					<td>到达车站</td><td><input type="text" name="toStation"></td>
					<td><input type="button" style="align-content: center;width: 100px;" name="submit" value="查询"></td></tr>
				</table></tr>-->
				
<!--border="1" bordercolor="blue" cellpadding="10px" style="border-collapse:separate;border-spacing:1px;font-size: 16px;"-->				
				
			
			 	<table  class="table table-bordered" align="center" ">
					<tr><td width="100px" align="center"><strong>车次</strong></td>
						<td width="80px" align="center"><strong>车号</strong></td>
						<td width="80px" align="center"><strong>出发站</strong></td>
						<td width="80px" align="center"><strong>到达站</strong></td>
						<td width="200px" align="center"><strong>出发时间</strong></td>
						<td width="200px" align="center"><strong>到达时间</strong></td>
						<td width="80px" align="center"><strong>商务座</strong></td>
						<td width="80px" align="center"><strong>价格</strong></td>
						<td width="80px" align="center"><strong>特等座</strong></td>
						<td width="80px" align="center"><strong>价格</strong></td>
						<td width="80px" align="center"><strong>软座</strong></td>
						<td width="80px" align="center"><strong>价格</strong></td>
						<td width="80px" align="center"><strong>硬座</strong></td>
						<td width="80px" align="center"><strong>价格</strong></td>
						<td width="80px" align="center"><strong>无座</strong></td>
						<td width="80px" align="center"><strong>价格</strong></td>
						<td width="80px" align="center"><strong>预订</strong></td>
					</tr>
						
				</table> 
			
				
				
				<!-- <table  class="table table-striped" align="center"> -->
				<table   class="table table-bordered" align="center">
				<c:forEach items="${requestScope.list}" var="route">
				<form action="PostSessionServlet" method="post">
				<input type="hidden" name="routeId" value="${route.id}">
					<tr style="height:10px">
						<td width="100px" align="center"><input type="hidden" name="routename" value="${route.name}">${route.name}</td>
						<td width="80px" align="center"><input type="hidden" name="trainType" value="${route.type}">${route.type}</td>
						<td width="80px" align="center"><input type="hidden" name="fromStation" value="${route.fromStation}">${route.fromStation}</td>
						<td width="80px" align="center"><input type="hidden" name="toStation" value="${route.toStation}">${route.toStation}</td>
						<td width="200px" align="center"><input type="hidden" name="departureTime" value="${route.departureTime}">${route.departureTime}</td>
						<td width="200px" align="center"><input type="hidden" name="arrivalTime" value="${route.arrivalTime}">${route.arrivalTime}</td>
						<td width="80px" align="center"><input type="hidden" name="businessSeatCount" value="${route.businessSeatCount}">${route.businessSeatCount}</td>
						<td width="80px" align="center"><input type="hidden" name="bPrice" value="${route.bPrice}">${route.bPrice}元</td>
						<td width="80px" align="center"><input type="hidden" name="specialSeatCount" value="${route.specialSeatCount}">${route.specialSeatCount}</td>
						<td width="80px" align="center"><input type="hidden" name="spPrice" value="${route.bPrice}">${route.spPrice}元</td>
						<td width="80px" align="center"><input type="hidden" name="softSeatCount" value="${route.softSeatCount}">${route.softSeatCount}</td>
						<td width="80px" align="center"><input type="hidden" name="sfPrice" value="${route.bPrice}">${route.sfPrice}元</td>
						<td width="80px" align="center"><input type="hidden" name="hardSeatCount" value="${route.hardSeatCount}">${route.hardSeatCount}</td>
						<td width="80px" align="center"><input type="hidden" name="hPrice" value="${route.bPrice}">${route.hPrice}元</td>
						<td width="80px" align="center"><input type="hidden" name="noSeatCount" value="${route.noSeatCount}">${route.noSeatCount}</td>
						<td width="80px" align="center"><input type="hidden" name="nPrice" value="${route.bPrice}">${route.nPrice}元</td>
						<td width="80px" align="center"><input type = "submit" value= "预定"></td>
					</tr>
						</form>
				</c:forEach>	
				</table>
				
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
			<p>版权所有©2016   &nbsp;  湘潭大学     &nbsp;Timer小组  </p>
		</div>
		</div>
		
		<script type="text/javascript" src="js/fixdiv.js"></script>
		<script type="text/javascript" src="js/address.js"></script>
		
	</body>

</html>