/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.servicios.productos;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.hulk.modelo.Producto;
import com.hulk.modelo.dao.ProductoDao;

/**
 * Fecha de creacion: 6 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
@Stateless
public class GestionProductoServicio {

	@EJB
	private ProductoDao productoDao;

	/**
	 * Método de negocio que obtiene el listado de los productos
	 * 
	 * @return
	 */
	public List<Producto> obtenerProductos() {
		return productoDao.obtenerProductos();
	}

}
