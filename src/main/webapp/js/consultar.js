$(document).ready(function() {
	//alert("json");
	//consultarUsuarios();
	$('.consultar').on('click',function(){
		//alert("click");
		consultarUsuarios();	
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

});