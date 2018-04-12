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
				<li >
					<a href="QueryRoute.jsp">车票预定</a>
				</li>
				<li class="on" >
					<a href="QueryStation.jsp">站点查询</a>
				</li>
				<li>
					<a href="http://www.baidu.com/">出行向导</a>
				</li>
			</ul>
		</div>
			
		<!--中部内容区-->
		<div>
			<img src="img/17.jpg"class="img-responsive" alt="Cinque Terre" style="width: 100%;height:84%">
			<br/>
			<div style="position:absolute; z-index:2; left:40px; top:18%">
　　　　                     	<div style="text-align:left;color:#000000;float: left;"><strong>您现在的位置：</strong><a href="主界面">车票预订</a></div>
			</div>
		</div>
		<div style="position:absolute;top: 240px;width: 98.3%;">
		<form action="QueryStationServlet" method="post">
			<table align="center" style="width: 60%;padding: 10px;margin-bottom: 20px;font-size: 14px;">
				<tr style="font-family:'微软雅黑'">
				<td><strong>站点名</strong></td><td><input type="text" name="stationName"  class="form-control" style="width:150px; height:30px;" style="left = 50%"></td>
					<!-- <td>站点级别</td><td><input type="text" name="level"></td> -->
					<td><input class="form-control" style="width:150px; height:30px;" type="submit" style="align-content: center;width: 100px;"  value="查询"></td>
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
		<table  class="table table-bordered" align="center" >
					<tr><td width="100px" align="center"><strong>站点ID</strong></td>
						<td width="80px" align="center"><strong>车站名</strong></td>
						<td width="80px" align="center"><strong>级别</strong></td>
						<td width="80px" align="center"><strong>描述</strong></td>
					
					</tr>
						
				</table> 
				
				<form action="QueryStationServlet" method="post">
				<table   class="table table-bordered" align="center" ">
				<c:forEach items="${requestScope.list}" var="station">
					<tr style="height:10px">
						
						<td width="100px" align="center"><input type="hidden" name="routename" value="${station.id}">${station.id}</td>
						<td width="80px" align="center"><input type="hidden" name="trainType" value="${station.name}">${station.name}</td>
						<td width="80px" align="center"><input type="hidden" name="fromStation" value="${station.level}">${station.level}</td>
						<td width="80px" align="center"><input type="hidden" name="toStation" value="${station.describe}">${station.describe}</td>
					
					</tr>
						</c:forEach>
				</table>
				</form>
					
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
	</body>

</html>