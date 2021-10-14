package model;

public class productosDTO {
	
	private Long cod_producto;
	private double iva_compra;
	private Long nit_proveedor;
	private String nombre_producto;
	private double precio_compra;
	private double precio_venta;
	
	public productosDTO(Long cod_producto, double iva_compra, Long nit_proveedor, String nombre_producto,
			double precio_compra, double precio_venta) {
		super();
		this.cod_producto = cod_producto;
		this.iva_compra = iva_compra;
		this.nit_proveedor = nit_proveedor;
		this.nombre_producto = nombre_producto;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
	}
	
	public productosDTO(Long cod_producto) {
		this.cod_producto = cod_producto;
	}
	
	public Long getCod_producto() {
		return cod_producto;
	}
	public void setCod_producto(Long cod_producto) {
		this.cod_producto = cod_producto;
	}
	public double getIva_compra() {
		return iva_compra;
	}
	public void setIva_compra(double iva_compra) {
		this.iva_compra = iva_compra;
	}
	public Long getNit_proveedor() {
		return nit_proveedor;
	}
	public void setNit_proveedor(Long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}	
	
}
