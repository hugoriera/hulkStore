/**
* Copyright (C) 2021 - Todos los derechos reservados.
* Todo 1 Systems
*/
package com.hulk.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Fecha de creacion: 6 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
@Table(name = "tbl_tipo_producto", schema = "hulk")
public class TipoProducto implements Serializable {

	private static final long serialVersionUID = 3669622564126522352L;

	@Id
	@Column(name = "tipo_producto_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;

	@Column(name = "descripcion")
	private String Descripcion;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

}
