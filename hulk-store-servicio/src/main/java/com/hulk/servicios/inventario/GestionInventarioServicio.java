/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.servicios.inventario;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.hulk.modelo.Inventario;
import com.hulk.modelo.dao.InventarioDao;

/**
 * Fecha de creacion: 6 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
@Stateless
public class GestionInventarioServicio {

	@EJB
	private InventarioDao inventarioDao;

	/**
	 * Método que actualiza el inventario
	 * 
	 * @param inventario
	 * @return
	 */
	public Inventario actualizarInventario(Inventario inventario) {
		return inventarioDao.actualizarInventario(inventario);
	}

	/**
	 * Método que consulta el stock de un producto
	 * 
	 * @param productoId
	 * @return
	 */
	public Inventario consultarStockProducto(Integer productoId) {
		return inventarioDao.consultarStockProducto(productoId);
	}
}
