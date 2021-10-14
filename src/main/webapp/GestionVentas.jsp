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
						<li><a href="Gestionventas.jsp"><span class="icon-cart"></span>M�dulo
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
				<legend>Ventas</legend>
				<div class="gestion-usuarios">
					<form action="servletVentas" method="POST">
						<input type="text" name="cedula" value="" placeholder="Cedula"><br>
						<input class="consultar" type="submit" name="btnConsultar" value="Consultar">
						<input type="text" name="cliente" value="" placeholder="Cliente"><br>
						<input type="text" name="consec" value="" placeholder="Consec"><br>
					<table width="50%" border="1" align="center">
					  <tr>
					    <td>Codigo</td>
					    <td>Consultar</td>
					    <td>Nombre</td>
					    <td>Cant.</td>
					    <td>Vlr. Total</td>
					  </tr>
					  
					  <tr>
					    <td><input type="text" name="cod_prod1" value="" placeholder=""><br> </td>
					    <td><input class="consultar" type="submit" name="btnConsulprod" value="Consultar"></td>
					    <td><input type="text" name="nombre_prod1" value="" placeholder=""><br> </td>
					    <td><input type="text" name="cant_prod1" value="" placeholder=""><br> </td>
					    <td><input type="text" name="valor_prod1" value="" placeholder=""><br> </td>
					  </tr>
					  <tr>
					    <td><input type="text" name="cod_prod2" value="" placeholder=""><br> </td>
					    <td><input class="consultar" type="submit" name="btnConsulprod" value="Consultar"></td>
					    <td><input type="text" name="nombre_prod2" value="" placeholder=""><br> </td>
					    <td><input type="text" name="cant_prod2" value="" placeholder=""><br> </td>
					    <td><input type="text" name="valor_prod2" value="" placeholder=""><br> </td>
					  </tr>
					  <tr>
					    <td><input type="text" name="cod_prod3" value="" placeholder=""><br> </td>
					    <td><input class="consultar" type="submit" name="btnConsulprod" value="Consultar"></td>
					    <td><input type="text" name="nombre_prod3" value="" placeholder=""><br> </td>
					    <td><input type="text" name="cant_prod3" value="" placeholder=""><br> </td>
					    <td><input type="text" name="valor_prod3" value="" placeholder=""><br> </td>
					  </tr>
					  
					  <tr>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td>Total venta</td>
					    <td><input type="text" name="Total_venta" value="" placeholder=""><br> </td>
					   </tr>
					   <tr>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td>Total iva</td>
					    <td><input type="text" name="Total_iva" value="" placeholder=""><br> </td>
					    </tr>
					    <tr>
					    <td></td>
					    <td></td>
					    <td></td>
					    <td>Total con iva</td>
					    <td><input type="text" name="Total_coniva" value="" placeholder=""><br> </td>
					    </tr>
					</table>
					
						<input class="insertar" type="submit" name="btnInsertar" value="Insertar">
						<input class="limpiar" type="reset" name="btnLimpiar" value="Limpiar"> 
					</form>
				</div>
			</fieldset>
		</section>
	</main>
</body>
</html>