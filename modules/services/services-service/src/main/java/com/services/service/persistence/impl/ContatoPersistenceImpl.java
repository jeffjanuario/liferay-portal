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

import com.services.exception.NoSuchContatoException;
import com.services.model.Contato;
import com.services.model.impl.ContatoImpl;
import com.services.model.impl.ContatoModelImpl;
import com.services.service.persistence.ContatoPersistence;
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
 * The persistence implementation for the contato service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ContatoPersistence.class)
public class ContatoPersistenceImpl
	extends BasePersistenceImpl<Contato> implements ContatoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ContatoUtil</code> to access the contato persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ContatoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ContatoPersistenceImpl() {
		setModelClass(Contato.class);

		setModelImplClass(ContatoImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the contato in the entity cache if it is enabled.
	 *
	 * @param contato the contato
	 */
	@Override
	public void cacheResult(Contato contato) {
		entityCache.putResult(
			entityCacheEnabled, ContatoImpl.class, contato.getPrimaryKey(),
			contato);

		contato.resetOriginalValues();
	}

	/**
	 * Caches the contatos in the entity cache if it is enabled.
	 *
	 * @param contatos the contatos
	 */
	@Override
	public void cacheResult(List<Contato> contatos) {
		for (Contato contato : contatos) {
			if (entityCache.getResult(
					entityCacheEnabled, ContatoImpl.class,
					contato.getPrimaryKey()) == null) {

				cacheResult(contato);
			}
			else {
				contato.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all contatos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ContatoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the contato.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Contato contato) {
		entityCache.removeResult(
			entityCacheEnabled, ContatoImpl.class, contato.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Contato> contatos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Contato contato : contatos) {
			entityCache.removeResult(
				entityCacheEnabled, ContatoImpl.class, contato.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, ContatoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new contato with the primary key. Does not add the contato to the database.
	 *
	 * @param contatoId the primary key for the new contato
	 * @return the new contato
	 */
	@Override
	public Contato create(long contatoId) {
		Contato contato = new ContatoImpl();

		contato.setNew(true);
		contato.setPrimaryKey(contatoId);

		return contato;
	}

	/**
	 * Removes the contato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contatoId the primary key of the contato
	 * @return the contato that was removed
	 * @throws NoSuchContatoException if a contato with the primary key could not be found
	 */
	@Override
	public Contato remove(long contatoId) throws NoSuchContatoException {
		return remove((Serializable)contatoId);
	}

	/**
	 * Removes the contato with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contato
	 * @return the contato that was removed
	 * @throws NoSuchContatoException if a contato with the primary key could not be found
	 */
	@Override
	public Contato remove(Serializable primaryKey)
		throws NoSuchContatoException {

		Session session = null;

		try {
			session = openSession();

			Contato contato = (Contato)session.get(
				ContatoImpl.class, primaryKey);

			if (contato == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchContatoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(contato);
		}
		catch (NoSuchContatoException noSuchEntityException) {
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
	protected Contato removeImpl(Contato contato) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(contato)) {
				contato = (Contato)session.get(
					ContatoImpl.class, contato.getPrimaryKeyObj());
			}

			if (contato != null) {
				session.delete(contato);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (contato != null) {
			clearCache(contato);
		}

		return contato;
	}

	@Override
	public Contato updateImpl(Contato contato) {
		boolean isNew = contato.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(contato);

				contato.setNew(false);
			}
			else {
				contato = (Contato)session.merge(contato);
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
			entityCacheEnabled, ContatoImpl.class, contato.getPrimaryKey(),
			contato, false);

		contato.resetOriginalValues();

		return contato;
	}

	/**
	 * Returns the contato with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contato
	 * @return the contato
	 * @throws NoSuchContatoException if a contato with the primary key could not be found
	 */
	@Override
	public Contato findByPrimaryKey(Serializable primaryKey)
		throws NoSuchContatoException {

		Contato contato = fetchByPrimaryKey(primaryKey);

		if (contato == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchContatoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return contato;
	}

	/**
	 * Returns the contato with the primary key or throws a <code>NoSuchContatoException</code> if it could not be found.
	 *
	 * @param contatoId the primary key of the contato
	 * @return the contato
	 * @throws NoSuchContatoException if a contato with the primary key could not be found
	 */
	@Override
	public Contato findByPrimaryKey(long contatoId)
		throws NoSuchContatoException {

		return findByPrimaryKey((Serializable)contatoId);
	}

	/**
	 * Returns the contato with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contatoId the primary key of the contato
	 * @return the contato, or <code>null</code> if a contato with the primary key could not be found
	 */
	@Override
	public Contato fetchByPrimaryKey(long contatoId) {
		return fetchByPrimaryKey((Serializable)contatoId);
	}

	/**
	 * Returns all the contatos.
	 *
	 * @return the contatos
	 */
	@Override
	public List<Contato> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the contatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @return the range of contatos
	 */
	@Override
	public List<Contato> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the contatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of contatos
	 */
	@Override
	public List<Contato> findAll(
		int start, int end, OrderByComparator<Contato> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the contatos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ContatoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of contatos
	 * @param end the upper bound of the range of contatos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of contatos
	 */
	@Override
	public List<Contato> findAll(
		int start, int end, OrderByComparator<Contato> orderByComparator,
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

		List<Contato> list = null;

		if (useFinderCache) {
			list = (List<Contato>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CONTATO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CONTATO;

				sql = sql.concat(ContatoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Contato>)QueryUtil.list(
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
	 * Removes all the contatos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Contato contato : findAll()) {
			remove(contato);
		}
	}

	/**
	 * Returns the number of contatos.
	 *
	 * @return the number of contatos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CONTATO);

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
		return "contatoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONTATO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ContatoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the contato persistence.
	 */
	@Activate
	public void activate() {
		ContatoModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ContatoModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ContatoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ContatoImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.services.model.Contato"),
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

	private static final String _SQL_SELECT_CONTATO =
		"SELECT contato FROM Contato contato";

	private static final String _SQL_COUNT_CONTATO =
		"SELECT COUNT(contato) FROM Contato contato";

	private static final String _ORDER_BY_ENTITY_ALIAS = "contato.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Contato exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ContatoPersistenceImpl.class);

	static {
		try {
			Class.forName(ContatosPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}