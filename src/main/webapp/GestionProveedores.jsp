<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://i.icomoon.io/public/temp/2b5b85b3e1/UntitledProject/style.css">
<link rel="stylesheet" href="CSS/stylesGestion.css" type="text/css" />
<title>PROVEEDORES</title>
</head>
<body>
	<%
	String nit = "", nom = "", ciu = "", dir = "", tel = "";
	if (request.getParameter("nit") != null) {
		nit = request.getParameter("nit");
		nom = request.getParameter("nom");
		ciu = request.getParameter("ciu");
		dir = request.getParameter("dir");
		tel = request.getParameter("tel");
	}
	%>
	<div class="cont_subtitulo">
		<h2>TIENDA DEPORTIVA</h2>
	</div>
	<main>
		<section class="section" id=s1>
			<div class="vertical-menu">
				<nav>
					<ul>
						<li><a href="GestionUsuarios.jsp"><span class="icon-users"></span>M�dulo
								Gesti�n de Usuarios</a></li>
						<li><a href="GestionClientes.jsp"><span class="icon-address-book"></span>M�dulo
								Gesti�n de Clientes</a></li>
						<li><a href="GestionProveedores.jsp"><span class="icon-truck"></span>M�dulo
								Gesti�n de Proveedores</a></li>
						<li><a href="GestionProductos.jsp"><span class="icon-database"></span>M�dulo
								Gesti�n de Productos</a></li>
						<li><a href="GestionVentas.jsp"><span class="icon-cart"></span>M�dulo
								Gesti�n de Ventas</a></li>
						<li><a href="Reportes.jsp"><span class="icon-stats-dots"></span>M�dulo
								Gesti�n de Consultas y Reportes</a></li>
						<li><a href="index.jsp"><span class="icon-exit"></span>Salir</a></li>
					</ul>
				</nav>
			</div>
		</section>
		<section class="section2" id="s2">
			<fieldset>
				<legend>Proveedores</legend>
				<div class="gestion-usuarios">
					<form action="servletProveedores" method="POST">
						<input type="text" name="nit" value="<%=nit%>" placeholder="NIT"><br> 
						<input type="text" name="nombre" value="<%=nom%>" placeholder="Nombre"><br>
						<input type="text" name="ciudad" value="<%=ciu%>" placeholder="Ciudad"><br> 
						<input type="text" name="dir_prov" value="<%=dir%>" placeholder="Direccion"><br>
						<input type="text" name="tel_prov" value="<%=tel%>" placeholder="Telefono"><br> <br> <br> 
						<input class="consultar" type="submit" name="btnConsultar" value="Consultar"> 
						<input class="insertar" type="submit" name="btnInsertar" value="Insertar">
						<input class="editar" type="submit" name="btnEditar" value="Editar"> 
						<input class="eliminar" type="submit" name="btnEliminar" value="Eliminar">
						<input class="limpiar" type="reset" name="btnLimpiar" value="Limpiar"> 
					</form>
				</div>
			</fieldset>
		</section>
	</main>
</body>
</html>