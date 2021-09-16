package model;

public class usuariosDTO {
	
	private Long cedula_usuario;
	private String mail_usuario;
	private String nombre_usuario;
	private String clave;
	private String usuario;
	
	public usuariosDTO(Long cedula_usuario, String mail_usuario, String nombre_usuario, String clave, String usuario) {
		super();
		this.cedula_usuario = cedula_usuario;
		this.mail_usuario = mail_usuario;
		this.nombre_usuario = nombre_usuario;
		this.clave = clave;
		this.usuario = usuario;
	}
	
	public Long getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(Long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public String getMail_usuario() {
		return mail_usuario;
	}
	public void setMail_usuario(String mail_usuario) {
		this.mail_usuario = mail_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
