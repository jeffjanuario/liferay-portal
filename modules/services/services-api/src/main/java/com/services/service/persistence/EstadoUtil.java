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

import com.services.model.Estado;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the estado service. This utility wraps <code>com.services.service.persistence.impl.EstadoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EstadoPersistence
 * @generated
 */
public class EstadoUtil {

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
	public static void clearCache(Estado estado) {
		getPersistence().clearCache(estado);
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
	public static Map<Serializable, Estado> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Estado> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Estado> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Estado> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Estado> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Estado update(Estado estado) {
		return getPersistence().update(estado);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Estado update(Estado estado, ServiceContext serviceContext) {
		return getPersistence().update(estado, serviceContext);
	}

	/**
	 * Caches the estado in the entity cache if it is enabled.
	 *
	 * @param estado the estado
	 */
	public static void cacheResult(Estado estado) {
		getPersistence().cacheResult(estado);
	}

	/**
	 * Caches the estados in the entity cache if it is enabled.
	 *
	 * @param estados the estados
	 */
	public static void cacheResult(List<Estado> estados) {
		getPersistence().cacheResult(estados);
	}

	/**
	 * Creates a new estado with the primary key. Does not add the estado to the database.
	 *
	 * @param estadoId the primary key for the new estado
	 * @return the new estado
	 */
	public static Estado create(long estadoId) {
		return getPersistence().create(estadoId);
	}

	/**
	 * Removes the estado with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param estadoId the primary key of the estado
	 * @return the estado that was removed
	 * @throws NoSuchEstadoException if a estado with the primary key could not be found
	 */
	public static Estado remove(long estadoId)
		throws com.services.exception.NoSuchEstadoException {

		return getPersistence().remove(estadoId);
	}

	public static Estado updateImpl(Estado estado) {
		return getPersistence().updateImpl(estado);
	}

	/**
	 * Returns the estado with the primary key or throws a <code>NoSuchEstadoException</code> if it could not be found.
	 *
	 * @param estadoId the primary key of the estado
	 * @return the estado
	 * @throws NoSuchEstadoException if a estado with the primary key could not be found
	 */
	public static Estado findByPrimaryKey(long estadoId)
		throws com.services.exception.NoSuchEstadoException {

		return getPersistence().findByPrimaryKey(estadoId);
	}

	/**
	 * Returns the estado with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param estadoId the primary key of the estado
	 * @return the estado, or <code>null</code> if a estado with the primary key could not be found
	 */
	public static Estado fetchByPrimaryKey(long estadoId) {
		return getPersistence().fetchByPrimaryKey(estadoId);
	}

	/**
	 * Returns all the estados.
	 *
	 * @return the estados
	 */
	public static List<Estado> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the estados.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EstadoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of estados
	 * @param end the upper bound of the range of estados (not inclusive)
	 * @return the range of estados
	 */
	public static List<Estado> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the estados.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EstadoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of estados
	 * @param end the upper bound of the range of estados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of estados
	 */
	public static List<Estado> findAll(
		int start, int end, OrderByComparator<Estado> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the estados.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EstadoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of estados
	 * @param end the upper bound of the range of estados (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of estados
	 */
	public static List<Estado> findAll(
		int start, int end, OrderByComparator<Estado> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the estados from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of estados.
	 *
	 * @return the number of estados
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static EstadoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EstadoPersistence, EstadoPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EstadoPersistence.class);

		ServiceTracker<EstadoPersistence, EstadoPersistence> serviceTracker =
			new ServiceTracker<EstadoPersistence, EstadoPersistence>(
				bundle.getBundleContext(), EstadoPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}