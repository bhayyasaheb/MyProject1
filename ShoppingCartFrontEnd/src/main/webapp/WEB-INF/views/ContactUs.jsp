<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- <style>
.container {
	right: 0;
}
</style>
 -->
<link rel="stylesheet" type="text/css"
	href="resources/css/ContactUs.css">
</head>
<body>

	<!-- 	<h3 align="center">Contact Form</h3>


	<div class="container">
		<form>
			<div class="form-group">
				<label for="usr">Name:</label> <input type="text"
					class="form-control" id="usr">
			</div>
			<div class="form-group">
				<label for="emailid">Email Id:</label> <input type="text"
					class="form-control" id="emailid">
			</div>

			<div class="form-group">
				<label for="comment">Comment:</label>
				<textarea class="form-control" rows="5" id="comment"></textarea>
			</div>

			<div class="buttons">
				<div class="right">
					<input type="submit" value="Submit"
						class="button btn btn-theme-default" />
				</div>
			</div>
		</form>
	</div>
 -->


	<section id="contact" style="">
	<div class="container">
		<div class="row">
			<div class="about_our_company" style="margin-bottom: 20px;">
				<h1 style="color: #fff;">Write Your Message</h1>
				<div class="titleline-icon"></div>
				<p style="color: #fff;">Thank You for visiting Shopping Cart</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-8">
				<form name="sentMessage" id="contactForm" novalidate="">
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Your Name *" id="name" required=""
									data-validation-required-message="Please enter your name.">
								<p class="help-block text-danger"></p>
							</div>
							<div class="form-group">
								<input type="email" class="form-control"
									placeholder="Your Email *" id="email" required=""
									data-validation-required-message="Please enter your email address.">
								<p class="help-block text-danger"></p>
							</div>
							<div class="form-group">
								<input type="tel" class="form-control"
									placeholder="Your Phone *" id="phone" required=""
									data-validation-required-message="Please enter your phone number.">
								<p class="help-block text-danger"></p>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<textarea class="form-control" placeholder="Your Message *"
									id="message" required=""
									data-validation-required-message="Please enter a message." style="color:black"></textarea>
								<p class="help-block text-danger"></p>
							</div>
						</div>

					</div>
				</form>
			</div>
			<div class="col-md-4">
				<p style="color: #fff;">
					<strong><i class="fa fa-map-marker"></i> Address</strong><br>
					Andheri West,Mumbai, Maharashtra 400058
				</p>
				<p style="color: #fff;">
					<strong><i class="fa fa-phone"></i> Phone Number</strong><br>
					+91-9730586363
				</p>
				<p style="color: #fff;">
					<strong><i class="fa fa-envelope"></i> Email Address</strong><br>
					bhayyasahebkoke@gmail.com
				</p>
				<p></p>
				<div class="clearfix"></div>
				<div class="col-lg-12 text-center">
					<div id="success"></div>
					<button type="submit" class="btn btn-xl get">Send Message</button>
				</div>

			</div>
		</div>
	</div>
	</section>


</body>
</html>