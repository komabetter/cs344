<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Truck a Transport</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/table.css" type="text/css" />
<meta name="keywords"
	content="Truck Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- bootstarp-css -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!--// bootstarp-css -->
<!-- css -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!--// css -->
<script src="js/jquery-1.11.1.min.js"></script>
<!--fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,800,700,600'
	rel='stylesheet' type='text/css'>
<!--/fonts-->
<link href="css/animate.css" rel="stylesheet" type="text/css"
	media="all">
<script src="js/wow.min.js"></script>
<script>
	new WOW().init();
</script>
<!-- pop-up -->
<link rel="stylesheet" href="css/touchTouch.css" type="text/css"
	media="all" />
<script type="text/javascript" src="js/jquery.fancybox.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/*
		 *  Simple image gallery. Uses default settings
		 */

		$('.fancybox').fancybox();

	});
</script>
<!-- pop-up -->
<!--start-smoth-scrolling-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 900);
		});
	});
</script>
<!--start-smoth-scrolling-->

</head>
<body>
	
	<!-- banner -->
	<div id="home" class="banner a-banner">
		<!-- container -->
		<div class="container">
			<div class="header">
				<div class="head-logo">
					<a href="index.html"><img src="images/logo.png" alt="" /></a>
				</div>
				<div class="top-nav">
					<span class="menu"><img src="images/menu.png" alt=""></span>
					<ul class="nav1">
						
						
						<li class="hvr-sweep-to-bottom active"><a
							href="services_customer.jsp">Services<i><img
									src="images/nav-but3.png" alt="" /></i></a></li>
					<li class="hvr-sweep-to-bottom"><a href="login.jsp">Logout<i><img
									src="images/nav-but2.png" alt="" /></i></a></li>
					</ul>
					<!-- script-for-menu -->
					<script>
						$("span.menu").click(function() {
							$("ul.nav1").slideToggle(300, function() {
								// Animation complete.
							});
						});
					</script>
					<!-- /script-for-menu -->
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<!-- //container -->
	</div>
	<!-- //banner -->
	<!-- products-top -->
	<div class="products-top">
		<!-- container -->
		<div class="container">
			<h3 class="wow fadeInRight animated" data-wow-delay="0.4s"
				style="visibility: visible; -webkit-animation-delay: 0.4s;">ตรวจสอบสถานะการจัดส่ง</h3>

			<div class="products-top-grids wow fadeInLeft animated"
				data-wow-delay="0.4s"
				style="visibility: visible; -webkit-animation-delay: 0.4s;">
				<div class="col-md-4 products-grid">

					<div class="products-text">
<%
		ArrayList<orderemployeedetail> list = (ArrayList<orderemployeedetail>)request.getAttribute("listProduct");
%>
						<!-- container -->
						<div class="container">
							<div class="col-md-12 footer-left" data-wow-delay="0.4s"
								style="visibility: visible; -webkit-animation-delay: 0.4s;">

								

								<div class="CSSTableGenerator"
									style="width: 600px; height: 150px;">

									<table>
										<tr>
											<td>ลำดับ</td>
											<td>Order id</td>
											<td>สถานะการส่ง</td>
											<td>ปลายทาง</td>
											<td>ผู้ส่ง</td>
											<td>ผู้รับ</td>
											<td>รายละเอียด</td>

										</tr>
										<%
										int i = 1;
										double total = 0;
											for (orderemployeedetail order : list) {
										%>
										<tr>
											<td><%=(i) %></td>
											<td><%=order.getOrder().getOrderId() %></td>
											<td><%=order.getOrder().getStatus() %></td>
											<td><%=order.getOrder().getDestination() %></td>
											<td><%=order.getEmployee_send().getEmployeename()%></td>
											<td><%=order.getEmployee_resive().getEmployeename() %></td>
											<td><a href="companyOrderDetail?idorder=<%=order.getOrder().getOrderId()%>"><input type="button" value="Detail"></a></td>
					
										</tr>
										<%
										i++;

											}
										%>
									</table>
								</div>
							</div>
						</div>
						<br><br><br><br><br><br><br>
						<h3 class="wow fadeInRight animated" data-wow-delay="0.4s"
							style="visibility: visible; -webkit-animation-delay: 0.4s;"></h3>



					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>