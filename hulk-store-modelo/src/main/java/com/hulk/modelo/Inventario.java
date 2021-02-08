/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Fecha de creacion: 6 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
@Entity
@Table(name = "tbl_inventario", schema = "hulk")
public class Inventario implements Serializable {

	private static final long serialVersionUID = 7617806181728104276L;

	@Id
	@Column(name = "inventario_id")
	private Integer id;

	@Column(name = "stock")
	private Integer stock;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// public Integer getProductoId() {
	// return productoId;
	// }
	//
	// public void setProductoId(Integer productoId) {
	// this.productoId = productoId;
	// }

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
