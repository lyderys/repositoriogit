package com.ad.jdbc.dto;

public class Articulos {
	//Propiedades de la clase
	private Integer codigo_articulo;
	private String descripcion;
	private Double precio_unidad;
	private Integer cantidad;
	
	//Metodos accesores
	public Integer getCodigo_articulo() {
		return codigo_articulo;
	}
	public void setCodigo_articulo(Integer codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getPrecio_unidad() {
		return precio_unidad;
	}
	public void setPrecio_unidad(Double precio_unidad) {
		this.precio_unidad = precio_unidad;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
	
}
