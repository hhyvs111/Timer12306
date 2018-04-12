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

	<body>
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
				        <li class="on">
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

　　　　                                                     <div style="text-align:left;color:#000000;float: left;"><strong>您现在的位置：</strong><a href="主界面">车次车站管理</a></div>

　　                                                   </div>-->
           
		     
		        </div>
		
		         <!--中部内容区-->
		        <div style="position:absolute;top:40%;left:45%;width: 60%;color: #C7254E;">
			       <div style="font-size: 37px;position:absolute;top:30%;"><strong>亲， 欢迎管理12306</strong></div>
		        </div>
	        </div>                                                                                                        v>
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