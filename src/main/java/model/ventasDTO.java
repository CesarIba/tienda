package model;

public class ventasDTO {
	
	private Long cedula_usuario;
	private double iva_venta;
	private double total_venta;
	private double valor_venta;
	private Long cedula_cliente;
	private int codigo;
	
	public ventasDTO(Long cedula_cliente, Long cedula_usuario, double iva_venta, double total_venta, double valor_venta) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.iva_venta = iva_venta;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}
	
	public ventasDTO(int codigo, long cedula, long cedula_Usuario, double ivaventa, double totalventa, double valorventa) {
		super();
		this.codigo = codigo;
		this.cedula_cliente = cedula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.iva_venta = iva_venta;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}


	
	public Long getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(Long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public Long getCedula_usuario() {
		return cedula_usuario;
	}

	public void setCedula_usuario(Long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}

	public double getIva_venta() {
		return iva_venta;
	}

	public void setIva_venta(double iva_venta) {
		this.iva_venta = iva_venta;
	}

	public double getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}


