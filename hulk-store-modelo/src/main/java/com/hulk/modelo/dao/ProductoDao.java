/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.modelo.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hulk.modelo.Producto;
import com.hulk.util.DaoGenericoUtil;

/**
 * Fecha de creacion: 6 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
@Stateless
public class ProductoDao extends DaoGenericoUtil<Producto> {

	public ProductoDao() {
		super(Producto.class);
	}

	private static final Logger LOG = Logger.getLogger(ProductoDao.class.getName());

	@PersistenceContext(unitName = "hulk_db")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	/**
	 * Método que obtiene el listado de productos de la base de datos
	 * 
	 * @return
	 */
	public List<Producto> obtenerProductos() {
		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT p ");
		sql.append(" FROM Producto p");

		TypedQuery<Producto> query = em.createQuery(sql.toString(), Producto.class);
		return query.getResultList();
	}

}
