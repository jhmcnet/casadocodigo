<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Livros</title>
</head>
<body>
	<table>
		<tr>
			<td>Título</td>
			<td>Valores</td>
		</tr>
		<c:forEach items="${products }" var="product">
		<tr>			
			<td>${product.title }
				<c:forEach items="${product.prices }" var="price">
				[${price.value } - ${price.booktype }]
				</c:forEach>
			</td>			
		</tr>
		</c:forEach>
	</table>
	${sucesso}



</body>
</html>