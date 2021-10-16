$(document).ready(function() {
	//alert("json");
	//consultarUsuarios();
	$('.consultar').on('click',function(){
		//alert("click1");
		consultarUsuarios();	
	});
	$('.consultarClientes').on('click',function(){
		//alert("click2");
		consultarClientes();	
	});
	$('.consultarVentas').on('click',function(){
		//alert("click3");
		consultarVentas();	
	});
	
	function consultarUsuarios() {

		$.ajax({
			url: "servletReportes",
			type: "POST",
			dataType: "json",
			success: function(result) {
				console.log(result);

				let tablaRes=document.getElementById("resultado");
				console.log(tablaRes);
				tablaRes.innerHTML = "";
				tablaRes.innerHTML = `<tr><th>Cedula</th>
								   <th>Nombres</th>
									<th>Correo</th>
									<th>Usuario</th>
									<th>Clave</th></tr>`;
				for (let i of result) {
					tablaRes.innerHTML += `<tr><th>${i.cedula_usuario}</th>
								   <th>${i.nombre_usuario}</th>
									<th>${i.mail_usuario}</th>
									<th>${i.usuario}</th>
									<th>${i.clave}</th></tr>`;
				}
			}
		});
	}
	
	function consultarClientes() {

		$.ajax({
			url: "servletReportesCli",
			type: "POST",
			dataType: "json",
			success: function(result) {
				console.log(result);

				let tablaRes=document.getElementById("resultado");
				console.log(tablaRes);
				tablaRes.innerHTML = "";
				tablaRes.innerHTML = `<tr><th>Cedula</th>
								   <th>Nombres</th>
									<th>Correo</th>
									<th>Direccion</th>
									<th>Telefono</th></tr>`;
				for (let i of result) {
					tablaRes.innerHTML += `<tr><th style="width:150px">${i.cedula_cliente}</th>
								   <th style="width:150px">${i.nombre_cliente}</th>
									<th style="width:150px">${i.mail_cliente}</th>
									<th>${i.direccion_cliente}</th>
									<th>${i.tel_cliente}</th></tr>`;
				}
			}
		});
	}
	
	function consultarVentas() {

		$.ajax({
			url: "servletReportesUsu",
			type: "POST",
			dataType: "json",
			success: function(result) {
				console.log(result);

				let tablaRes=document.getElementById("resultado");
				console.log(tablaRes);
				tablaRes.innerHTML = "";
				tablaRes.innerHTML = `<tr><th style="width:150px">Cedula</th>
								   <th style="width:250px">Nombres</th>
									<th>Cod. Venta</th>
									<th>Valor total venta</th>`;
				for (let i of result) {
					tablaRes.innerHTML += `<tr><th>${i.cedula_usuario}</th>
								   <th>${i.nombre_cli}</th>
									<th>${i.cod_venta}</th>
									<th>${i.valor_ventas}</th></tr>`;
				}
			}
		});
	}

});