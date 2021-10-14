package model;

public class detalleventasDTO {

	private Long cant_producto;
	private Long cod_producto;
	private Long cod_venta;
	private Long valor_total;
	private Long valor_venta;
	private Long valor_iva;

	public detalleventasDTO(Long cant_producto, Long cod_producto, Long cod_venta, Long valor_total, Long valor_venta,
			Long valor_iva) {
		super();
		this.cant_producto = cant_producto;
		this.cod_producto = cod_producto;
		this.cod_venta = cod_venta;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.valor_iva = valor_iva;
	}

	public Long getCant_producto() {
		return cant_producto;
	}

	public void setCant_producto(Long cant_producto) {
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

	public Long getValor_total() {
		return valor_total;
	}

	public void setValor_total(Long valor_total) {
		this.valor_total = valor_total;
	}

	public Long getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Long valor_venta) {
		this.valor_venta = valor_venta;
	}

	public Long getValor_iva() {
		return valor_iva;
	}

	public void setValor_iva(Long valor_iva) {
		this.valor_iva = valor_iva;
	}
}
