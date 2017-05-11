<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
<title>SBK Laptopdeal</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="resources/css/bootstrap.css">
<script src="resources/js/jquery.js"></script>
<script src="resources/js/bootstrap.js"></script>

</head>
<body>



	<jsp:include page="NavigationBar.jsp"></jsp:include>
	${message}


	<c:if test="${isUserClickedHome=='true'}">
		<jsp:include page="Carousel.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedHome=='true'}">
		<jsp:include page="Product Display.jsp"></jsp:include>
	</c:if>
	

	<!---------------------------------------- Start Admin --------------------------->
	<c:if test="${isAdmin == 'true'}">
		<jsp:include page="admin/AdminHome.jsp"></jsp:include>
	</c:if>
<br>
	<c:if test="${isAdminClickedCategories == 'true'}">
		<jsp:include page="admin/Category.jsp"></jsp:include>
	</c:if>

	<c:if test="${isAdminClickedSuppliers == 'true'}">
		<jsp:include page="admin/Supplier.jsp"></jsp:include>
	</c:if>

	<c:if test="${isAdminClickedProducts == 'true'}">
		<jsp:include page="admin/Product.jsp"></jsp:include>
	</c:if>

	<!--------------------------Start of Login,SignUp,AboutUs,ContactUs ----------------------------->

	<jsp:include page="Footer.jsp"></jsp:include>
	<c:if test="${isUserClickedLogin=='true'}">
		<jsp:include page="Login.jsp"></jsp:include>
	</c:if>

	<c:if test="${isUserClickedSignUp=='true'}">
		<jsp:include page="SignUp.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedAboutUs=='true'}">
		<jsp:include page="AboutUs.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedContactUs=='true'}">
		<jsp:include page="ContactUs.jsp"></jsp:include>
	</c:if>

	<!--------------------------Start Cart And Checkout ----------------------------->

	<c:if test="${isUserClickedCart=='true'}">
		<jsp:include page="Cart.jsp"></jsp:include>
	</c:if>
	<c:if test="${isUserClickedCheckout=='true'}">
		<jsp:include page="Checkout.jsp"></jsp:include>
	</c:if>
</body>
</html>