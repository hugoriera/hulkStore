/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.web.viewModels;

/**
 * Fecha de creacion: 7 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
public class ProductoViewModel {

	private Integer productId;
	private String descripcion;
	private Integer tipoProductoId;
	private Integer modeloId;
	private Integer precio;
	private Integer inventarioId;
	private Integer stock;
	private Integer cantidadSolicitada;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTipoProductoId() {
		return tipoProductoId;
	}

	public void setTipoProductoId(Integer tipoProductoId) {
		this.tipoProductoId = tipoProductoId;
	}

	public Integer getModeloId() {
		return modeloId;
	}

	public void setModeloId(Integer modeloId) {
		this.modeloId = modeloId;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getInventarioId() {
		return inventarioId;
	}

	public void setInventarioId(Integer inventarioId) {
		this.inventarioId = inventarioId;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(Integer cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
}
