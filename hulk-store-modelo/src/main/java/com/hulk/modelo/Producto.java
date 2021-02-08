/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Fecha de creacion: 6 feb. 2021
 *
 * @author Hugo Riera Campos
 * 
 */
@Entity
@Table(name = "tbl_producto", schema = "hulk")
public class Producto implements Serializable {

	private static final long serialVersionUID = -4472117744743843222L;

	@Id
	@Column(name = "producto_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "tipo_producto_id")
	private Integer tipoProductoId;

	@Column(name = "modelo_id")
	private Integer modeloId;

	@Column(name = "precio")
	private Integer precio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "producto_id", updatable = false, insertable = false)
	private Inventario inventario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

}
