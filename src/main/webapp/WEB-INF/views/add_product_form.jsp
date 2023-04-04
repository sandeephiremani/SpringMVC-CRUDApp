<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
</head>
<body>

	<div class="container mt-3">

		<div class="row">

			<div class="col-md-6 offset-md-3">


				<h1 class="text-center mb-3">Fill the Product Deatils</h1>
				<form action="handle-product" method="post">

					<div class="form-group">
						<label class="name">Product Name</label><input
							class="form-control" type="text" id="name"
							aria-describedby="prohelp" name="name"
							palceholder="Enter the product name here">
					</div>
					<div class="form-group">
						<label class="descrption">Product Description</label>
						<textarea class="form-control" id="descrption"
							aria-describedby="prohelp" name="descrption" row="5"
							palceholder="Enter the product description here"></textarea>
					</div>
					<div class="form-group">
						<label class="price">Product Price</label> <input
							class="form-control" type="text" id="price"
							aria-describedby="prohelp" name="price"
							palceholder="Enter the product Price here">
					</div>
					<div class="conatiner text-center">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-outline-danger">Back</a>
						<button class="btn btn-primary" type="submit">Add</button>

					</div>
				</form>

			</div>

		</div>


	</div>

</body>
</html>