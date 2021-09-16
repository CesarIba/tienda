<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://i.icomoon.io/public/temp/08a8bd0ce2/UntitledProject/style.css">
<link rel="stylesheet" href="CSS/stylesmenu.css" type="text/css"/>
<title>MENÚ PRINCIPAL</title>
</head>
<body>
<div class="cont_subtitulo">
	<h2>Tienda genérica</h2>
</div>
<div class="vertical-menu">
<nav>
<ul>
	<li><a href="GestionUsuarios.jsp"><span class="icon-users"></span>Módulo Gestión de Usuarios</a></li>
	<li><a href="#"><span class="icon-address-book"></span>Módulo Gestión de Clientes</a></li>
	<li><a href="#"><span class="icon-truck"></span>Módulo Gestión de Proveedores</a></li>
	<li><a href="#"><span class="icon-database"></span>Módulo Gestión de Productos</a></li>
	<li><a href="#"><span class="icon-cart"></span>Módulo Gestión de Ventas</a></li>
	<li><a href="#"><span class="icon-stats-dots"></span>Módulo Gestión de Consultas y Reportes</a></li>
	</ul>
</nav>
</div>
<%
String dato=request.getParameter("dat");
%>

</body>
</html>