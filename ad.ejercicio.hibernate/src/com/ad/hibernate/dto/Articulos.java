package com.ad.hibernate.dto;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Articulos implements java.io.Serializable {
	
	@Id
	private int codigo_articulo;
	private String descripcion_articulo;
	private double precio_unidad_articulo;
	private int cantidad;
	
	public Articulos(int codigo_articulo, String descripcion_articulo, double precio_unidad_articulo, int cantidad) {
		super();
		this.codigo_articulo = codigo_articulo;
		this.descripcion_articulo = descripcion_articulo;
		this.precio_unidad_articulo = precio_unidad_articulo;
		this.cantidad = cantidad;
	}
	
	public int getCodigo_articulo() {
		return codigo_articulo;
	}
	public void setCodigo_articulo(int codigo_articulo) {
		this.codigo_articulo = codigo_articulo;
	}
	public String getDescripcion_articulo() {
		return descripcion_articulo;
	}
	public void setDescripcion_articulo(String descripcion_articulo) {
		this.descripcion_articulo = descripcion_articulo;
	}
	public double getPrecio_unidad_articulo() {
		return precio_unidad_articulo;
	}
	public void setPrecio_unidad_articulo(double precio_unidad_articulo) {
		this.precio_unidad_articulo = precio_unidad_articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
