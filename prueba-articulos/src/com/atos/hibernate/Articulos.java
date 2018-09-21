package com.atos.hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Articulos entity. @author MyEclipse Persistence Tools
 */

public class Articulos implements java.io.Serializable {

	// Fields

	private Integer codigoArticulo;
	private String descripcionArticulo;
	private Double precioUnidadArticulo;
	private Integer cantidad;

	// Constructors

	/** default constructor */
	public Articulos() {
	}

	/** full constructor */
	public Articulos(String descripcionArticulo, Double precioUnidadArticulo, Integer cantidad) {
		this.descripcionArticulo = descripcionArticulo;
		this.precioUnidadArticulo = precioUnidadArticulo;
		this.cantidad = cantidad;
	}

	// Property accessors

	public Integer getCodigoArticulo() {
		return this.codigoArticulo;
	}

	public void setCodigoArticulo(Integer codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getDescripcionArticulo() {
		return this.descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public Double getPrecioUnidadArticulo() {
		return this.precioUnidadArticulo;
	}

	public void setPrecioUnidadArticulo(Double precioUnidadArticulo) {
		this.precioUnidadArticulo = precioUnidadArticulo;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}