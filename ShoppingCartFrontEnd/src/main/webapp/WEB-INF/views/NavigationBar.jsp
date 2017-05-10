<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/Home.css">
</head>
<body>
	<nav id="nav" class="navbar navbar-inverse">

	<div class="container-fluid">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!-- <a class="navbar-brand" href="#">ShoppingCart</a> -->
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="Home">Welcome to Shopping Cart</a></li>

				<c:forEach var="category" items="${categoryList}">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">${category.name}<span
							class="caret"></span></a>
						<ul class="dropdown-menu">

							<c:forEach var="product" items="${productList}">

								<c:if test="${product.category_id == category.id}">
									<li><a>${product.name}</a></li>
								</c:if>

							</c:forEach>
							<!-- <li><a href="#">model 1</a></li>
							<li><a href="#">model 2</a></li>
							<li><a href="#">model 3</a></li> -->
						</ul></li>
				</c:forEach>


				<!-- <li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Dell<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">model 1</a></li>
						<li><a href="#">model 2</a></li>
						<li><a href="#">model 3</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">hp<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">model 1</a></li>
						<li><a href="#">model 2</a></li>
						<li><a href="#">model 3</a></li>
					</ul></li>
 -->
			</ul>

			<!-- <form class="navbar-form navbar-left">
				<li><div class="input-group">
						<input type="text" class="form-control" placeholder="Search">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div></li>
			</form>
 -->
			<ul class="nav navbar-nav navbar-right">
				<li><a href="CartPage"><span
						class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
				<li><a href="SignUpPage"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				<li><a href="LoginPage"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
				<li><a href="AboutUsPage">About Us</a></li>
				<li><a href="ContactUsPage">ContactUs</a></li>

			</ul>
		</div>
	</div>
	</nav>

</body>
</html>