<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.conexion"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://i.icomoon.io/public/temp/e2a4690ac5/UntitledProject/style.css">
<link rel="stylesheet" href="CSS/stylesGestion.css" type="text/css" />
<title>CLIENTES</title>
</head>
<body>
	<%
	String ced = "", nom = "", mail = "", dir = "", tel = "";
	if (request.getParameter("ced") != null) {
		ced = request.getParameter("ced");
		nom = request.getParameter("nom");
		mail = request.getParameter("mail");
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
						<li><a href="GestionUsuarios.jsp"><span class="icon-users"></span>Módulo
								Gestión de Usuarios</a></li>
						<li><a href="#"><span class="icon-address-book"></span>Módulo
								Gestión de Clientes</a></li>
						<li><a href="#"><span class="icon-truck"></span>Módulo
								Gestión de Proveedores</a></li>
						<li><a href="#"><span class="icon-database"></span>Módulo
								Gestión de Productos</a></li>
						<li><a href="#"><span class="icon-cart"></span>Módulo
								Gestión de Ventas</a></li>
						<li><a href="Reportes.jsp"><span class="icon-stats-dots"></span>Módulo
								Gestión de Consultas y Reportes</a></li>
						<li><a href="index.jsp"><span class="icon-exit"></span>Salir</a></li>
					</ul>
				</nav>
			</div>
		</section>
		<section class="section2" id="s2">
			<fieldset>
				<legend>Clientes</legend>
				<div class="gestion-usuarios">
					<form action="servletGestionClient" method="POST">
						<input type="text" name="cedula" value="<%=ced%>" placeholder="Cedula"><br> 
						<input type="text" name="nombre" value="<%=nom%>" placeholder="Nombres"><br>
						<input type="text" name="email" value="<%=mail%>" placeholder="Correo"><br> 
						<input type="text" name="dir_cli" value="<%=dir%>" placeholder="Direccion"><br>
						<input type="text" name="tel_cli" value="<%=tel%>" placeholder="Telefono"><br> <br> <br> 
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