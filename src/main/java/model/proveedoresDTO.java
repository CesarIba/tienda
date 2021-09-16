package model;

public class proveedoresDTO {
	
	private Long nit_proveedor;
	private String ciudad_priveedor;
	private String direccion_proveedor;
	private String nombre_proveedor;
	private String tel_proveedor;
	
	public proveedoresDTO(Long nit_proveedor, String ciudad_priveedor, String direccion_proveedor,
			String nombre_proveedor, String tel_proveedor) {
		super();
		this.nit_proveedor = nit_proveedor;
		this.ciudad_priveedor = ciudad_priveedor;
		this.direccion_proveedor = direccion_proveedor;
		this.nombre_proveedor = nombre_proveedor;
		this.tel_proveedor = tel_proveedor;
	}

	public Long getNit_proveedor() {
		return nit_proveedor;
	}

	public void setNit_proveedor(Long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}

	public String getCiudad_priveedor() {
		return ciudad_priveedor;
	}

	public void setCiudad_priveedor(String ciudad_priveedor) {
		this.ciudad_priveedor = ciudad_priveedor;
	}

	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}

	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getTel_proveedor() {
		return tel_proveedor;
	}

	public void setTel_proveedor(String tel_proveedor) {
		this.tel_proveedor = tel_proveedor;
	}
	
	
	
}
