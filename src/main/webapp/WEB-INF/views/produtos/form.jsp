<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Produtos</title>
</head>
<body>

		<form:form action="${spring:mvcUrl('PC#save').build()}" method="post" commandName="product">
			<div>
				<label for="title">Título</label>
				<form:input path="title"/>
				<form:errors path="title"/>
			</div>
			<div>
				<label for="description">Descricao</label>
				<form:textarea rows="10" cols="20" path="description"/>
				<form:errors path="description"/>
			</div>
			<div>
				<label for="title">Páginas</label>
				<form:input type="text" path="pages"/>
				<form:errors path="pages"/>
			</div>
			<div>
				<c:forEach items="${types }" var="bookType" varStatus="status">
					<div>
						<label for="price_${bookType }">${bookType }</label>
						<input type="text" name="prices[${status.index }].value" id="price_${bookType }" />
						<input type="hidden" name="prices[${status.index }].bookType" value="${bookType }" />
					</div>
				</c:forEach>
			</div>
			<div>
				<label>Data de Lançamento</label>
				<form:input type="date" path="releaseDate"/>
				<form:errors path="releaseDate"/>
			</div>
			<div>
				<input type="submit" value="Enviar">
			</div>

		</form:form>

</body>
</html>