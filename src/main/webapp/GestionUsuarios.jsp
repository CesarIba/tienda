<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://i.icomoon.io/public/temp/08a8bd0ce2/UntitledProject/style.css">
<link rel="stylesheet" href="CSS/stylesmenu.css" type="text/css" />
<title>USUARIOS</title>
</head>
<body>
	<%
	// conexion con = new conexion();
	// con.conexiondb();
	%>
	<div class="cont_subtitulo">
		<h2>Tienda genérica</h2>
	</div>
	<section class="section" id=s1>
	<main>
	<div class="vertical-menu">
		<nav>
			<ul>
				<li><a href="#"><span class="icon-users"></span>Módulo
						Gestión de Usuarios</a></li>
				<li><a href="#"><span class="icon-address-book"></span>Módulo
						Gestión de Clientes</a></li>
				<li><a href="#"><span class="icon-truck"></span>Módulo
						Gestión de Proveedores</a></li>
				<li><a href="#"><span class="icon-database"></span>Módulo
						Gestión de Productos</a></li>
				<li><a href="#"><span class="icon-cart"></span>Módulo
						Gestión de Ventas</a></li>
				<li><a href="#"><span class="icon-stats-dots"></span>Módulo
						Gestión de Consultas y Reportes</a></li>
			</ul>
		</nav>
	</div>
	</section>
	<section class="section" id=s1>
	<fieldset>
		<legend>Usuarios</legend>
		<div>
			<form action="servletGestionUsu" method="POST">
				<input type="text" name="nombre" placeholder="Nombres"> 
				<input type="text" name="cedula" placeholder="Cedula"> 
				<input type="text" name="email" placeholder="Correo"> 
				<input type="text" name="usuario" placeholder="usuario"> 
				<input type="text" name="clave" placeholder="Clave"> 
				<input type="submit" name="btnInsertar" value="Insertar"> 
				<input type="submit" name="btnEliminar" value="Eliminar"> 
				<input type="submit" name="btnEditar" value="Editar"> 
				<input type="submit" name="btnConsultar" value="Consultar">
			</form>
		</div>
	</fieldset>
	</section>
	</main>
	<%
	String dato = request.getParameter("dat");
	%>

</body>
</html>