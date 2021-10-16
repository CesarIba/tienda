package model;

public class detalleventasDTO {

	private int cant_producto;
	private Long cod_producto;
	private Long cod_venta;
	private double valor_total;
	private double valor_venta;
	private double valor_iva;

	public detalleventasDTO(int cant_producto, Long cod_producto, Long cod_venta, double valor_total, double valor_venta,
			double valor_iva) {
		super();
		this.cant_producto = cant_producto;
		this.cod_producto = cod_producto;
		this.cod_venta = cod_venta;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.valor_iva = valor_iva;
	}

	public int getCant_producto() {
		return cant_producto;
	}

	public void setCant_producto(int cant_producto) {
		this.cant_producto = cant_producto;
	}

	public Long getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(Long cod_producto) {
		this.cod_producto = cod_producto;
	}

	public Long getCod_venta() {
		return cod_venta;
	}

	public void setCod_venta(Long cod_venta) {
		this.cod_venta = cod_venta;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public double getValor_iva() {
		return valor_iva;
	}

	public void setValor_iva(double valor_iva) {
		this.valor_iva = valor_iva;
	}
}
