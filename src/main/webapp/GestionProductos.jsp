<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://i.icomoon.io/public/temp/698f0840d1/UntitledProject/style.css">
<link rel="stylesheet" href="CSS/stylesGestion.css" type="text/css" />
<title>PRODUCTOS</title>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script>
</head>
<body>
	<div class="cont_subtitulo">
		<h2>TIENDA DEPORTIVA</h2>
	</div>
	<main>
		<section class="section" id=s1>
			<div class="vertical-menu">
				<nav>
					<ul>
						<li><a href="GestionUsuarios.jsp"><span class="icon-users"></span>Módulo
								Gestión de Usuarios</a></li>
						<li><a href="GestionClientes.jsp"><span class="icon-address-book"></span>Módulo
								Gestión de Clientes</a></li>
						<li><a href="GestionProveedores.jsp"><span class="icon-truck"></span>Módulo
								Gestión de Proveedores</a></li>
						<li><a href="GestionProductos.jsp"><span class="icon-database"></span>Módulo
								Gestión de Productos</a></li>
						<li><a href="GestionVentas.jsp"><span class="icon-cart"></span>Módulo
								Gestión de Ventas</a></li>
						<li><a href="Reportes.jsp"><span class="icon-stats-dots"></span>Módulo
								Gestión de Consultas y Reportes</a></li>
						<li><a href="index.jsp"><span class="icon-exit"></span>Salir</a></li>
					</ul>
				</nav>
			</div>
		</section>
		<section class="section4" id="s4">
			<fieldset>
				<legend>Productos</legend>
				<div class="gestion-productos">
					<form action="servletProductos" method="post" enctype="multipart/form-data">
						<br><input type="file" name="urlArchivo" value=""><br>
						<br><input type="text" name="nomArchivo" value="" placeholder="Nombre del archivo"><br><br>
						<input type="submit" name="btnCargar" value="Agregar Archivo"><br> 
					</form>
				</div>
			</fieldset>
			<table id="resultado" border="1"></table>
		</section>
	</main>
</body>
</html>