<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="controller.conexion"%>
<%@page import="model.clientesDTO"%>
<%@page import="model.productosDTO"%>
<%@page import="model.ventasDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://i.icomoon.io/public/temp/698f0840d1/UntitledProject/style.css">
<link rel="stylesheet" href="CSS/stylesGestion.css" type="text/css" />
<title>VENTAS</title>
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
		
		<section class="section5" id="s5">
			<fieldset>
				<legend>Ventas</legend>
				<div class="gestion-ventas">
					<form action="servletVentas" method="POST">
						<br><input type="text" name="cedCli" value="${cliente.getCedula_cliente()}" placeholder="CC Cliente">
						<input type="text" name="cliente" value="${cliente.getNombre_cliente()}" placeholder="Cliente"><br>
						<input type="text" hidden="false" name="consec" value="" placeholder="Consec"><br>
						<input class="consultar" type="submit" name="btnConsultar" value="Consultar"><br><br>						
						
					<table>
				
					  <thead>
						  <tr align="center">
						    <th>Codigo </th>
						    <th>Consultar</th>
						    <th>Nombre</th>
						    <th>Cantidad</td>
						    <th>Vlr Total</th>
						  </tr>
						</thead>  
					  <tbody>
					  	  <tr align="center">
						    <td><input type="text" name="cod_prod1" value="${producto1.getCod_producto()}" placeholder="Cod"></td>
						    <td><input class="consultar" type="submit" name="btnConsulprod1" value="Consultar"></td>
						    <td><input type="text" name="nombre_prod1" style="width:150px" value="${producto1.getNombre_producto()}" placeholder="Nombre" readonly="readonly"></td>
						    <td><input type="text" name="cant_prod1" value="${cant1}" style="width:35px;"></td>
						    <td><input type="text" name="valor_prod1" value="${producto1.getPrecio_venta()}" placeholder="Precio" readonly="readonly"></td>
						  </tr>
						  
						  <tr align="center">
						    <td><input type="text" name="cod_prod2" value="${producto2.getCod_producto()}" placeholder="Cod"></td>
						    <td><input class="consultar" type="submit" name="btnConsulprod2" value="Consultar"></td>
						    <td><input type="text" name="nombre_prod2" style="width:150px" value="${producto2.getNombre_producto()}" placeholder="Nombre" readonly="readonly"></td>
						    <td><input type="text" name="cant_prod2" value="${cant2}" placeholder="" style="width : 35px; heigth : 1px"></td>
						    <td><input type="text" name="valor_prod2" value="${producto2.getPrecio_venta()}" placeholder="Precio" readonly="readonly"></td>
						  </tr>
						  
						  <tr align="center">
						    <td><input type="text" name="cod_prod3" value="${producto3.getCod_producto()}" placeholder="Cod"></td>
						    <td><input class="consultar" type="submit" name="btnConsulprod3" value="Consultar"></td>
						    <td><input type="text" name="nombre_prod3" style="width:150px" value="${producto3.getNombre_producto()}" placeholder="Nombre" readonly="readonly"></td>
						    <td><input type="text" name="cant_prod3" value="${cant3}" placeholder="" style="width : 35px; heigth : 1px"></td>
						    <td><input type="text" name="valor_prod3" value="${producto3.getPrecio_venta()}" placeholder="Precio" readonly="readonly"></td>
						  </tr>
					  </tbody>
					</table>
					<table>
					 	<tr>
						  <br><td>Total venta</td>
						  <td><input type="text" name="Total_venta" value="${CotVenta.getValor_venta()}" placeholder=""><br> </td>
						</tr>
						<tr>
						  <td>Total iva</td>
						  <td><input type="text" name="Total_iva" value="${CotVenta.getIva_venta()}" placeholder=""><br> </td>
						</tr>
						<tr>
						  <td>Total con iva</td>
						  <td><input type="text" name="Total_coniva" value="${CotVenta.getTotal_venta()}" placeholder=""><br> </td>
						</tr>
					</table>
						<br><input class="insertar" type="submit" name="btnCotizar" value="Cotizar">				
						<input class="insertar" type="submit" name="btnInsertar" value="Vender">
						<input class="limpiar" type="reset" name="btnLimpiar" value="Limpiar"> 
						<input type="text" hidden="false" name="cedUsu" value="123456789">
					</form>
				</div>
			</fieldset>
		</section>
	</main>
</body>
</html>