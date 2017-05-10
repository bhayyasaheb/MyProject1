<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="container">
		<div class="row">
			<div class="col-sm-12 col-md-10 col-md-offset-1">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Product</th>
							<th>Quantity</th>
							<th class="text-center">Price</th>
							<th class="text-center">Total</th>
							<th> </th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="col-sm-8 col-md-6">
								<div class="media">
									<a class="thumbnail pull-left" href="#"> <img
										class="media-object" src="resources/images/dell1500.jpg"
										style="width: 72px; height: 72px;">
									</a>
									<div class="media-body">
										<h4 class="media-heading">
											<a href="#">Dell Inspiron 15 5000 15.6 FHD Touchscreen
												Laptop ( Intel Core i5-6200U, 8 GB RAM, 1 TB HDD, Windows
												10-MaxxAudio Pro), Silver</a>
										</h4>
										<h5 class="media-heading">
											by <a href="#">Dell</a>
										</h5>
										<span>Status: </span><span class="text-success"><strong>In
												Stock</strong></span>
									</div>
								</div>
							</td>
							<td class="col-sm-1 col-md-1" style="text-align: center"><input
								type="email" class="form-control" id="exampleInputEmail1"
								value="3"></td>
							<td class="col-sm-1 col-md-1 text-center"><strong>$460</strong></td>
							<td class="col-sm-1 col-md-1 text-center"><strong>$1380</strong></td>
							<td class="col-sm-1 col-md-1">
								<button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span> Remove
								</button>
							</td>
						</tr>
						<tr>
							<td class="col-md-6">
								<div class="media">
									<a class="thumbnail pull-left" href="#"> <img
										class="media-object" src="resources/images/hpnotebook.jpg"
										style="width: 72px; height: 72px;">
									</a>
									<div class="media-body">
										<h4 class="media-heading">
											<a href="#">HP Notebook 15-ay011nr 15.6-Inch Laptop (6th
												Gen Intel Core i5-6200U Processor, 8GB DDR3L SDRAM, 1TB HDD,
												Windows 10), Silver</a>
										</h4>
										<h5 class="media-heading">
											by <a href="#">HP</a>
										</h5>
										<span>Status: </span><span class="text-warning"><strong>Leaves
												warehouse in 2 - 3 weeks</strong></span>
									</div>
								</div>
							</td>
							<td class="col-md-1" style="text-align: center"><input
								type="email" class="form-control" id="exampleInputEmail1"
								value="2"></td>
							<td class="col-md-1 text-center"><strong>$525</strong></td>
							<td class="col-md-1 text-center"><strong>$1050</strong></td>
							<td class="col-md-1">
								<button type="button" class="btn btn-danger">
									<span class="glyphicon glyphicon-remove"></span> Remove
								</button>
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td> </td>
							<td> </td>
							<td> </td>
							<td><h5>
									Subtotal<br>Estimated shipping
								</h5>
								<h3>Total</h3></td>
							<td class="text-right"><h5>
									<strong>$2430<br>$70
									</strong>
								</h5>
								<h3>$2500</h3></td>
						</tr>
						<tr>
							<td> </td>
							<td> </td>
							<td> </td>
							<td><a href="Home">
									<button type="button" class="btn btn-default">
										<span class="glyphicon glyphicon-shopping-cart"></span>
										Continue Shopping
									</button>
							</a></td>
							<td><a href="CheckoutPage"><button type="button"
										class="btn btn-success">
										Checkout <span class="glyphicon glyphicon-play"></span>
									</button></a></td>
						</tr>
					</tfoot>
				</table>

			</div>
		</div>
	</div>

</body>
</html>