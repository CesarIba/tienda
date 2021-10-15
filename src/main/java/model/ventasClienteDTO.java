package model;

public class ventasClienteDTO {
	
	private Long cedula_usuario;
	private String nombre_cli;
	private int cod_venta;
	private double valor_ventas;
	
	public ventasClienteDTO(Long cedula_usuario, String nombre_cli, int cod_venta, double valor_ventas) {
		super();
		this.cedula_usuario = cedula_usuario;
		this.nombre_cli = nombre_cli;
		this.cod_venta = cod_venta;
		this.valor_ventas = valor_ventas;
	}

	public Long getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(Long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public String getNombre_cli() {
		return nombre_cli;
	}

	public void setNombre_cli(String nombre_cli) {
		this.nombre_cli = nombre_cli;
	}

	public double getValor_ventas() {
		return valor_ventas;
	}

	public void setValor_ventas(double valor_ventas) {
		this.valor_ventas = valor_ventas;
	}

	public int getCod_venta() {
		return cod_venta;
	}

	public void setCod_venta(int cod_venta) {
		this.cod_venta = cod_venta;
	}
	
	
}


