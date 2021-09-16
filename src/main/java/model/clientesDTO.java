package model;

public class clientesDTO {
	
	private Long cedula_cliente;
	private String direccion_cliente;
	private String mail_cliente;
	private String nombre_cliente;
	private String tel_cliente;
	
	public clientesDTO(Long cedula_cliente, String direccion_cliente, String mail_cliente, String nombre_cliente,
			String tel_cliente) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.direccion_cliente = direccion_cliente;
		this.mail_cliente = mail_cliente;
		this.nombre_cliente = nombre_cliente;
		this.tel_cliente = tel_cliente;
	}

	public Long getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(Long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getMail_cliente() {
		return mail_cliente;
	}

	public void setMail_cliente(String mail_cliente) {
		this.mail_cliente = mail_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getTel_cliente() {
		return tel_cliente;
	}

	public void setTel_cliente(String tel_cliente) {
		this.tel_cliente = tel_cliente;
	}
	
	
	
}
