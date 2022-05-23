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
	background-image: url('/img/libreria_booklet.jpg');
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
<div class="container text-center mt-4">
	<form method="get" action="/libro/busqueda">
		<input type="text" name="autor" name="titulo" id="autor" size="50" required />  
		<input type="submit" value="Buscar" /> 
	</form>
</div>

	<div class="row mt-3">
		<div class="col">
			<table class="table container bg-warning">
				<thead>
					<tr>

						<th scope="col">Título</th>
						<th scope="col">Año</th>
						<th scope="col">Autor</th>
						<th scope="col">Editorial</th>
						<th scope="col">Disponibilidad</th>
						<th scope="col">Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="libro" items="${listaLibros}">

						<tr>

							<td><c:out value="${libro.titulo}"></c:out></td>
							<td><c:out value="${libro.anio}"></c:out></td>
							<td><c:out value="${libro.autor}"></c:out></td>
							<td><c:out value="${libro.imprenta}"></c:out></td>

							<td><c:choose>
									<c:when test="${libro.disponible==true}">
										<c:out value="Disponible"></c:out>
									</c:when>
									<c:otherwise>No Disponible</c:otherwise>
								</c:choose></td>

							<td><a class="btn btn-primary"
								href="/libro/editar/${libro.id}" role="button">Editar</a> <a
								class="btn btn-danger" href="/libro/eliminar/${libro.id}"
								role="button">Eliminar</a></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>