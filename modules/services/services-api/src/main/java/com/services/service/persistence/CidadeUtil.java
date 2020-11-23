/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.services.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.services.model.Cidade;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cidade service. This utility wraps <code>com.services.service.persistence.impl.CidadePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CidadePersistence
 * @generated
 */
public class CidadeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Cidade cidade) {
		getPersistence().clearCache(cidade);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Cidade> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Cidade> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Cidade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Cidade> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Cidade> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Cidade update(Cidade cidade) {
		return getPersistence().update(cidade);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Cidade update(Cidade cidade, ServiceContext serviceContext) {
		return getPersistence().update(cidade, serviceContext);
	}

	/**
	 * Returns all the cidades where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @return the matching cidades
	 */
	public static List<Cidade> findByestadoId(long estadoId) {
		return getPersistence().findByestadoId(estadoId);
	}

	/**
	 * Returns a range of all the cidades where estadoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CidadeModelImpl</code>.
	 * </p>
	 *
	 * @param estadoId the estado ID
	 * @param start the lower bound of the range of cidades
	 * @param end the upper bound of the range of cidades (not inclusive)
	 * @return the range of matching cidades
	 */
	public static List<Cidade> findByestadoId(
		long estadoId, int start, int end) {

		return getPersistence().findByestadoId(estadoId, start, end);
	}

	/**
	 * Returns an ordered range of all the cidades where estadoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CidadeModelImpl</code>.
	 * </p>
	 *
	 * @param estadoId the estado ID
	 * @param start the lower bound of the range of cidades
	 * @param end the upper bound of the range of cidades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cidades
	 */
	public static List<Cidade> findByestadoId(
		long estadoId, int start, int end,
		OrderByComparator<Cidade> orderByComparator) {

		return getPersistence().findByestadoId(
			estadoId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cidades where estadoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CidadeModelImpl</code>.
	 * </p>
	 *
	 * @param estadoId the estado ID
	 * @param start the lower bound of the range of cidades
	 * @param end the upper bound of the range of cidades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cidades
	 */
	public static List<Cidade> findByestadoId(
		long estadoId, int start, int end,
		OrderByComparator<Cidade> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByestadoId(
			estadoId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cidade
	 * @throws NoSuchCidadeException if a matching cidade could not be found
	 */
	public static Cidade findByestadoId_First(
			long estadoId, OrderByComparator<Cidade> orderByComparator)
		throws com.services.exception.NoSuchCidadeException {

		return getPersistence().findByestadoId_First(
			estadoId, orderByComparator);
	}

	/**
	 * Returns the first cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cidade, or <code>null</code> if a matching cidade could not be found
	 */
	public static Cidade fetchByestadoId_First(
		long estadoId, OrderByComparator<Cidade> orderByComparator) {

		return getPersistence().fetchByestadoId_First(
			estadoId, orderByComparator);
	}

	/**
	 * Returns the last cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cidade
	 * @throws NoSuchCidadeException if a matching cidade could not be found
	 */
	public static Cidade findByestadoId_Last(
			long estadoId, OrderByComparator<Cidade> orderByComparator)
		throws com.services.exception.NoSuchCidadeException {

		return getPersistence().findByestadoId_Last(
			estadoId, orderByComparator);
	}

	/**
	 * Returns the last cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cidade, or <code>null</code> if a matching cidade could not be found
	 */
	public static Cidade fetchByestadoId_Last(
		long estadoId, OrderByComparator<Cidade> orderByComparator) {

		return getPersistence().fetchByestadoId_Last(
			estadoId, orderByComparator);
	}

	/**
	 * Returns the cidades before and after the current cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param cidadeId the primary key of the current cidade
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cidade
	 * @throws NoSuchCidadeException if a cidade with the primary key could not be found
	 */
	public static Cidade[] findByestadoId_PrevAndNext(
			long cidadeId, long estadoId,
			OrderByComparator<Cidade> orderByComparator)
		throws com.services.exception.NoSuchCidadeException {

		return getPersistence().findByestadoId_PrevAndNext(
			cidadeId, estadoId, orderByComparator);
	}

	/**
	 * Removes all the cidades where estadoId = &#63; from the database.
	 *
	 * @param estadoId the estado ID
	 */
	public static void removeByestadoId(long estadoId) {
		getPersistence().removeByestadoId(estadoId);
	}

	/**
	 * Returns the number of cidades where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @return the number of matching cidades
	 */
	public static int countByestadoId(long estadoId) {
		return getPersistence().countByestadoId(estadoId);
	}

	/**
	 * Caches the cidade in the entity cache if it is enabled.
	 *
	 * @param cidade the cidade
	 */
	public static void cacheResult(Cidade cidade) {
		getPersistence().cacheResult(cidade);
	}

	/**
	 * Caches the cidades in the entity cache if it is enabled.
	 *
	 * @param cidades the cidades
	 */
	public static void cacheResult(List<Cidade> cidades) {
		getPersistence().cacheResult(cidades);
	}

	/**
	 * Creates a new cidade with the primary key. Does not add the cidade to the database.
	 *
	 * @param cidadeId the primary key for the new cidade
	 * @return the new cidade
	 */
	public static Cidade create(long cidadeId) {
		return getPersistence().create(cidadeId);
	}

	/**
	 * Removes the cidade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cidadeId the primary key of the cidade
	 * @return the cidade that was removed
	 * @throws NoSuchCidadeException if a cidade with the primary key could not be found
	 */
	public static Cidade remove(long cidadeId)
		throws com.services.exception.NoSuchCidadeException {

		return getPersistence().remove(cidadeId);
	}

	public static Cidade updateImpl(Cidade cidade) {
		return getPersistence().updateImpl(cidade);
	}

	/**
	 * Returns the cidade with the primary key or throws a <code>NoSuchCidadeException</code> if it could not be found.
	 *
	 * @param cidadeId the primary key of the cidade
	 * @return the cidade
	 * @throws NoSuchCidadeException if a cidade with the primary key could not be found
	 */
	public static Cidade findByPrimaryKey(long cidadeId)
		throws com.services.exception.NoSuchCidadeException {

		return getPersistence().findByPrimaryKey(cidadeId);
	}

	/**
	 * Returns the cidade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cidadeId the primary key of the cidade
	 * @return the cidade, or <code>null</code> if a cidade with the primary key could not be found
	 */
	public static Cidade fetchByPrimaryKey(long cidadeId) {
		return getPersistence().fetchByPrimaryKey(cidadeId);
	}

	/**
	 * Returns all the cidades.
	 *
	 * @return the cidades
	 */
	public static List<Cidade> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cidades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CidadeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cidades
	 * @param end the upper bound of the range of cidades (not inclusive)
	 * @return the range of cidades
	 */
	public static List<Cidade> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cidades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CidadeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cidades
	 * @param end the upper bound of the range of cidades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cidades
	 */
	public static List<Cidade> findAll(
		int start, int end, OrderByComparator<Cidade> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cidades.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CidadeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cidades
	 * @param end the upper bound of the range of cidades (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cidades
	 */
	public static List<Cidade> findAll(
		int start, int end, OrderByComparator<Cidade> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cidades from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cidades.
	 *
	 * @return the number of cidades
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CidadePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CidadePersistence, CidadePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CidadePersistence.class);

		ServiceTracker<CidadePersistence, CidadePersistence> serviceTracker =
			new ServiceTracker<CidadePersistence, CidadePersistence>(
				bundle.getBundleContext(), CidadePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}