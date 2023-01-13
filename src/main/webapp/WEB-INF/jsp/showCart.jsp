<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Your Cart Item:</h1>
	
	<table border="1">
		<tr>
			<th>Prod_ID</th>
			<th>Prod_Name</th>
			<th>Prod_Desc</th>
			<th>Price</th>
			<th>Action</th>
			
			<c:forEach items="${carts}" var="cart">
				<tr>
					<td>${user.getUser_id()}</td>
					<td>${productgetProd_id()}</td>
					<td>${product.getProd_name()}</td>
					<td>${product.getProd_desc()}</td>
					<td>${product.getPrice()}</td>
					<td><a href = "login/${product.getProdId()}">Home Page</a>&nbsp
						
						</td>
					
				</tr>

			</c:forEach>

	</table>
	<h3 style="color:red">${cartMsg}</h3>
	

</body>
</html>