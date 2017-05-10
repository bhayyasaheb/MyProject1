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
 
  <form class="form-horizontal" action="">
  
    <div class="form-group">
      <label class="control-label col-sm-2" for="id">Product Id:</label>
      <div class="col-sm-4">
        <input type="text" class="form-control" id="id" placeholder="Enter Product Id" name="id">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="name">Name:</label>
      <div class="col-sm-4">          
        <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="desc">Description:</label>
      <div class="col-sm-4">          
        <input type="text" class="form-control" id="desc" placeholder="Enter Description" name="desc">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="price">price:</label>
      <div class="col-sm-4">          
        <input type="number" class="form-control" id="price" placeholder="Enter Price" name="price">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="cId">Category Id:</label>
      <div class="col-sm-4">          
        <input type="text" class="form-control" id="cId" placeholder="Enter Category Id" name="cId">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="sId">Supplier Id:</label>
      <div class="col-sm-4">          
        <input type="text" class="form-control" id="sId" placeholder="Enter Supplier Id" name="sId">
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-4">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div>



</div>

</body>
</html>





























<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>

<div class="container">

<!-- View all products -->

		<div id="changepwd" class="form-group">
			<div id="viewallproducts" class="text-right">
				<a href="${contextRoot}/admin/allproducts">View All Products</a>
			</div>
		</div>


<!---------------------------------------------Create Product ------------------------------------->

 <h2>Add Product</h2>

<c:url var="addAction" value="/manage_product_add?${csrf.parameterName}=${_csrf.token}"/>



<div id="CreateProduct">
 
  <form class="form-horizontal" action="${addAction}" commandName="product"
          enctype="multipart/form-data" method=post>
  
    <!-- <div class="form-group">
      <label class="control-label col-sm-2" for="id">Product Id:</label>
      <div class="col-sm-6">
        <input type="text" class="form-control" id="id" placeholder="Enter Product Id" name="id">
      </div>
    </div> -->
    <div class="row">
				<div class="col-sm-3">
						<form:label path="">
								<spring:message text="Product Id" />
						</form:label>
				</div>
				<div class="col-sm-9">
							<form:input path="id"  class="form-control" />
				</div>
					</div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="name">Name:</label>
      <div class="col-sm-6">          
        <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="description">Description:</label>
      <div class="col-sm-6">          
        <input type="text" class="form-control" id="description" placeholder="Enter Description" name="description">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="price">price:</label>
      <div class="col-sm-6">          
        <input type="number" class="form-control" id="price" placeholder="Enter Price" name="price">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="category_id">Category Id:</label>
      <div class="col-sm-6">          
        <input type="text" class="form-control" id="category_id" placeholder="Enter Category Id" name="category_id">
      </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-2" for="supplier_id">Supplier Id:</label>
      <div class="col-sm-6">  
                 <input type="text" class="form-control" id="supplier_id" placeholder="Enter Supplier Id" name="supplier_id">
      </div>
    </div>
    
    <div class="row">
					<div class="col-sm-3">
						<form:label path="file">
							<spring:message text="Choose Image" />
						</form:label>
					</div>
					<div class="col-sm-9">
						<form:input path="file" type="file" cssClass="form-control"
							required="required" />
					</div>
				</div>
    
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-4">
        <button type="submit" class="btn btn-success">Create Product</button>
      </div>
    </div>
  </form>
</div>

<h2>Products List</h2>
<c:if test="${!empty productList}">
	<div id="ShowCategories">
		<table border="2" class="table table-striped custab">
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Product Price</th>
					<th>Product Category ID</th>
					<th>Product Supplier ID</th>
					<th>Delete</th>
					<th>Edit</th>
					
				</tr>
			</thead>

			<c:forEach var="product" items="${productList}">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td>${product.category_id}</td>
					<td>${product.supplier_id}</td>
					<%-- <td><a href="<c:url value = "manage_category_delete/${category.id}"/> class="btn btn-danger">Delete</a></td>
					<td><a href="<c:url value="manage_category_edit/${category.id}"/> class="btn btn-info">Edit</a></td> --%>
					
					<td class="text-center">
						<a class="btn btn-info btn-xs" href="<c:url value = '/manage_product_edit/${product.id}'/>">
							 <span class="glyphicon glyphicon-edit"></span> Edit</a> </td>
							 
					<td class="text-center">		 
						<a href="<c:url value ='/manage_product_delete/${product.id}'/>" class="btn btn-danger btn-xs"> 
							 <span class="glyphicon glyphicon-remove"></span> Delete</a></td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>
	
</c:if>



</div>

</body>
</html>