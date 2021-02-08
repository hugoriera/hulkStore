/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.modelo.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hulk.modelo.Inventario;
import com.hulk.util.DaoGenericoUtil;

/**
 * Fecha de creacion: 6 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
@Stateless
public class InventarioDao extends DaoGenericoUtil<Inventario> {

	public InventarioDao() {
		super(Inventario.class);
	}

	@PersistenceContext(unitName = "hulk_db")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	/**
	 * Método que actualiza la información del inventario
	 * 
	 * @param inventario
	 * @return
	 */
	public Inventario actualizarInventario(Inventario inventario) {
		return inventario = em.merge(inventario);
	}

	/**
	 * Método que consulta el saldo del inventario
	 * 
	 * @param idProducto
	 * @return
	 */
	public Inventario consultarStockProducto(Integer productoId) {
		StringBuilder sql = new StringBuilder();

		sql.append(" SELECT i ");
		sql.append(" FROM Inventario i ");
		sql.append(" WHERE i.productoId = :productoId ");

		TypedQuery<Inventario> query = em.createQuery(sql.toString(), Inventario.class);
		query.setParameter("productoId", productoId);

		List<Inventario> listaInventarios = query.getResultList();
		if (listaInventarios.isEmpty()) {
			return null;
		} else {
			return listaInventarios.get(0);
		}
	}
}
