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

package com.services.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.services.exception.NoSuchEstadoException;
import com.services.model.Estado;
import com.services.model.impl.EstadoImpl;
import com.services.model.impl.EstadoModelImpl;
import com.services.service.persistence.EstadoPersistence;
import com.services.service.persistence.impl.constants.ContatosPersistenceConstants;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the estado service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = EstadoPersistence.class)
public class EstadoPersistenceImpl
	extends BasePersistenceImpl<Estado> implements EstadoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EstadoUtil</code> to access the estado persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EstadoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public EstadoPersistenceImpl() {
		setModelClass(Estado.class);

		setModelImplClass(EstadoImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the estado in the entity cache if it is enabled.
	 *
	 * @param estado the estado
	 */
	@Override
	public void cacheResult(Estado estado) {
		entityCache.putResult(
			entityCacheEnabled, EstadoImpl.class, estado.getPrimaryKey(),
			estado);

		estado.resetOriginalValues();
	}

	/**
	 * Caches the estados in the entity cache if it is enabled.
	 *
	 * @param estados the estados
	 */
	@Override
	public void cacheResult(List<Estado> estados) {
		for (Estado estado : estados) {
			if (entityCache.getResult(
					entityCacheEnabled, EstadoImpl.class,
					estado.getPrimaryKey()) == null) {

				cacheResult(estado);
			}
			else {
				estado.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all estados.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EstadoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the estado.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Estado estado) {
		entityCache.removeResult(
			entityCacheEnabled, EstadoImpl.class, estado.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Estado> estados) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Estado estado : estados) {
			entityCache.removeResult(
				entityCacheEnabled, EstadoImpl.class, estado.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, EstadoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new estado with the primary key. Does not add the estado to the database.
	 *
	 * @param estadoId the primary key for the new estado
	 * @return the new estado
	 */
	@Override
	public Estado create(long estadoId) {
		Estado estado = new EstadoImpl();

		estado.setNew(true);
		estado.setPrimaryKey(estadoId);

		return estado;
	}

	/**
	 * Removes the estado with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param estadoId the primary key of the estado
	 * @return the estado that was removed
	 * @throws NoSuchEstadoException if a estado with the primary key could not be found
	 */
	@Override
	public Estado remove(long estadoId) throws NoSuchEstadoException {
		return remove((Serializable)estadoId);
	}

	/**
	 * Removes the estado with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the estado
	 * @return the estado that was removed
	 * @throws NoSuchEstadoException if a estado with the primary key could not be found
	 */
	@Override
	public Estado remove(Serializable primaryKey) throws NoSuchEstadoException {
		Session session = null;

		try {
			session = openSession();

			Estado estado = (Estado)session.get(EstadoImpl.class, primaryKey);

			if (estado == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEstadoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(estado);
		}
		catch (NoSuchEstadoException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Estado removeImpl(Estado estado) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(estado)) {
				estado = (Estado)session.get(
					EstadoImpl.class, estado.getPrimaryKeyObj());
			}

			if (estado != null) {
				session.delete(estado);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (estado != null) {
			clearCache(estado);
		}

		return estado;
	}

	@Override
	public Estado updateImpl(Estado estado) {
		boolean isNew = estado.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(estado);

				estado.setNew(false);
			}
			else {
				estado = (Estado)session.merge(estado);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, EstadoImpl.class, estado.getPrimaryKey(),
			estado, false);

		estado.resetOriginalValues();

		return estado;
	}

	/**
	 * Returns the estado with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the estado
	 * @return the estado
	 * @throws NoSuchEstadoException if a estado with the primary key could not be found
	 */
	@Override
	public Estado findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEstadoException {

		Estado estado = fetchByPrimaryKey(primaryKey);

		if (estado == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEstadoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return estado;
	}

	/**
	 * Returns the estado with the primary key or throws a <code>NoSuchEstadoException</code> if it could not be found.
	 *
	 * @param estadoId the primary key of the estado
	 * @return the estado
	 * @throws NoSuchEstadoException if a estado with the primary key could not be found
	 */
	@Override
	public Estado findByPrimaryKey(long estadoId) throws NoSuchEstadoException {
		return findByPrimaryKey((Serializable)estadoId);
	}

	/**
	 * Returns the estado with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param estadoId the primary key of the estado
	 * @return the estado, or <code>null</code> if a estado with the primary key could not be found
	 */
	@Override
	public Estado fetchByPrimaryKey(long estadoId) {
		return fetchByPrimaryKey((Serializable)estadoId);
	}

	/**
	 * Returns all the estados.
	 *
	 * @return the estados
	 */
	@Override
	public List<Estado> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Estado> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Estado> findAll(
		int start, int end, OrderByComparator<Estado> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Estado> findAll(
		int start, int end, OrderByComparator<Estado> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Estado> list = null;

		if (useFinderCache) {
			list = (List<Estado>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ESTADO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ESTADO;

				sql = sql.concat(EstadoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Estado>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the estados from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Estado estado : findAll()) {
			remove(estado);
		}
	}

	/**
	 * Returns the number of estados.
	 *
	 * @return the number of estados
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ESTADO);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "estadoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ESTADO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EstadoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the estado persistence.
	 */
	@Activate
	public void activate() {
		EstadoModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		EstadoModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EstadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, EstadoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(EstadoImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ContatosPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.services.model.Estado"),
			true);
	}

	@Override
	@Reference(
		target = ContatosPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ContatosPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ESTADO =
		"SELECT estado FROM Estado estado";

	private static final String _SQL_COUNT_ESTADO =
		"SELECT COUNT(estado) FROM Estado estado";

	private static final String _ORDER_BY_ENTITY_ALIAS = "estado.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Estado exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		EstadoPersistenceImpl.class);

	static {
		try {
			Class.forName(ContatosPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}