<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/stylesindex.css" type="text/css" />
<title>INICIO DE SESI�N</title>
</head>

<body>

	<div class="login-box">

		<img class="avatar" alt="Logo tienda" src="IMG/icon.png">
		<h1>Bienvenidos a la Tienda Gen�rica</h1>
		<h2>Iniciar sesi�n</h2>

		<form action="Servletlogin" method="post">

			<!-- USERNAME -->
			<label for="usuario"> USUARIO </label> <input type="text" name="usu"
				placeholder=" Ingrese usuario"><br>
			<br>

			<!-- PASSWORD  -->
			<label for="contrase�a"> CONTRASE�A </label> <input type="password"
				name="pass" placeholder=" Ingrese contrase�a"><br>
			<br> <input class="button" type="submit" name="btnlog"
				value="Ingresar"><br> <input type="reset"
				name="btncancel" value="Cancelar"><br> <a href="#">Olvid�
				mi contrase�a</a><br> <a href="#">Crear cuenta</a>
		</form>
	</div>
</body>
</html>