/**
* Copyright (C) 2021 - Todos los derechos reservados.
* TODO 1 Systems
*/
package com.hulk.util;

/**
 * Fecha de creacion: 6 feb. 2021
 *
 * @author Hugo Riera Campos
 *
 */
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class DaoGenericoUtil<T> {

	@Resource
	private SessionContext sessionContext;

	private Class<T> claseEntidad;

	protected abstract EntityManager getEntityManager();

	public DaoGenericoUtil(Class<T> entityClass) {
		this.claseEntidad = entityClass;
	}

	public T crear(T entity) {
		return crear(entity, getEntityManager());
	}

	public T crear(T entity, EntityManager entityManager) {
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		return entity;
	}

	public T actualizar(T entity) {
		return actualizar(entity, getEntityManager());
	}

	public T actualizar(T entity, EntityManager entityManager) {
		return entityManager.merge(entity);
	}

	public void eliminar(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public T obtenerPorId(Object id) {
		return getEntityManager().find(claseEntidad, id);
	}

	protected String obtenerUsuario() {
		return sessionContext.getCallerPrincipal().getName();
	}

	public List<T> findAll() {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(claseEntidad));
		return getEntityManager().createQuery(cq).getResultList();
	}

	public List<T> findRange(int[] range) {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(claseEntidad));
		Query query = getEntityManager().createQuery(cq);
		query.setMaxResults(range[1] - range[0] + 1);
		query.setFirstResult(range[0]);
		return query.getResultList();
	}

	public int count() {
		CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
		Root<T> rt = criteriaQuery.from(claseEntidad);
		criteriaQuery.select(getEntityManager().getCriteriaBuilder().count(rt));
		Query query = getEntityManager().createQuery(criteriaQuery);
		return ((Long) query.getSingleResult()).intValue();
	}

}