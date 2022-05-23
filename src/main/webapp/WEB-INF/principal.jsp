<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
body {
	background color: white;
}
</style>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<title>Home</title>
</head>
<body>
	<jsp:include page="template/navbar.jsp">
		<jsp:param value="Librería Booklet" name="title" />
	</jsp:include>

	

	<c:if test="${Correcto!=null}">
		<div class="alert alert-success" role="alert">
			<c:out value="${Correcto}"></c:out>
		</div>
	</c:if>
	
	<c:if test="${Error!=null}">
		<div class="alert alert-danger" role="alert">
			<c:out value="${Error}"></c:out>
		</div>
	</c:if>

	<form:form method="post" action="/registro" class="container my-5 w-50 bg-warning border border-warning rounded" modelAttribute="libro">
		<div>
			<h1 class="text-light text-center">Ingreso de Libros</h1>
		</div>
		
		
		<div class="mb-3">
			<form:label for="titulo" path="titulo" class="form-label mt-3 text-light fw-bold">Nombre de libro</form:label> 
			<form:input type="text" class="form-control" id="titulo" path="titulo"/>
		</div>
		
		<div class="mb-3">
			<form:label for="anio" path="anio" class="form-label text-light fw-bold">Fecha Publicacion</form:label> 
			<form:input type="number" class="form-control" id="anio" path="anio"/>
		</div>

		<div class="mb-3">
			<form:label for="autor" path="autor" class="form-label text-light fw-bold">Autor</form:label> 
			<form:input type="text" value="" class="form-control" id="autor" path="autor"/>
		</div>

		<div class="mb-3">
			<form:label for="imprenta" path="imprenta" class="form-label text-light fw-bold">Editorial</form:label> 
			<form:input type="text" value="" class="form-control" id="imprenta" path="imprenta"/>
		</div>
	
		<div class="mt-4">
		<form:select id="disponible" name="disponible" path="disponible" class="form-select text-success fw-bold">
			<form:option value="">Registre Disponibilidad</form:option>
				<form:option  value="1">Disponible</form:option>
				<form:option value="0">No Disponible</form:option>
		</form:select>
		</div>
		<button type="submit" class="btn btn-success fw-bold my-3">Agregar Libro</button>
	</form:form>
	
	
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>