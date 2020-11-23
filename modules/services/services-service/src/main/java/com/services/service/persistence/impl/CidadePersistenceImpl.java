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
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.services.exception.NoSuchCidadeException;
import com.services.model.Cidade;
import com.services.model.impl.CidadeImpl;
import com.services.model.impl.CidadeModelImpl;
import com.services.service.persistence.CidadePersistence;
import com.services.service.persistence.impl.constants.ContatosPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the cidade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CidadePersistence.class)
public class CidadePersistenceImpl
	extends BasePersistenceImpl<Cidade> implements CidadePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CidadeUtil</code> to access the cidade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CidadeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByestadoId;
	private FinderPath _finderPathWithoutPaginationFindByestadoId;
	private FinderPath _finderPathCountByestadoId;

	/**
	 * Returns all the cidades where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @return the matching cidades
	 */
	@Override
	public List<Cidade> findByestadoId(long estadoId) {
		return findByestadoId(
			estadoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Cidade> findByestadoId(long estadoId, int start, int end) {
		return findByestadoId(estadoId, start, end, null);
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
	@Override
	public List<Cidade> findByestadoId(
		long estadoId, int start, int end,
		OrderByComparator<Cidade> orderByComparator) {

		return findByestadoId(estadoId, start, end, orderByComparator, true);
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
	@Override
	public List<Cidade> findByestadoId(
		long estadoId, int start, int end,
		OrderByComparator<Cidade> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByestadoId;
				finderArgs = new Object[] {estadoId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByestadoId;
			finderArgs = new Object[] {estadoId, start, end, orderByComparator};
		}

		List<Cidade> list = null;

		if (useFinderCache) {
			list = (List<Cidade>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Cidade cidade : list) {
					if (estadoId != cidade.getEstadoId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CIDADE_WHERE);

			sb.append(_FINDER_COLUMN_ESTADOID_ESTADOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CidadeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(estadoId);

				list = (List<Cidade>)QueryUtil.list(
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
	 * Returns the first cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cidade
	 * @throws NoSuchCidadeException if a matching cidade could not be found
	 */
	@Override
	public Cidade findByestadoId_First(
			long estadoId, OrderByComparator<Cidade> orderByComparator)
		throws NoSuchCidadeException {

		Cidade cidade = fetchByestadoId_First(estadoId, orderByComparator);

		if (cidade != null) {
			return cidade;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("estadoId=");
		sb.append(estadoId);

		sb.append("}");

		throw new NoSuchCidadeException(sb.toString());
	}

	/**
	 * Returns the first cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cidade, or <code>null</code> if a matching cidade could not be found
	 */
	@Override
	public Cidade fetchByestadoId_First(
		long estadoId, OrderByComparator<Cidade> orderByComparator) {

		List<Cidade> list = findByestadoId(estadoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cidade
	 * @throws NoSuchCidadeException if a matching cidade could not be found
	 */
	@Override
	public Cidade findByestadoId_Last(
			long estadoId, OrderByComparator<Cidade> orderByComparator)
		throws NoSuchCidadeException {

		Cidade cidade = fetchByestadoId_Last(estadoId, orderByComparator);

		if (cidade != null) {
			return cidade;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("estadoId=");
		sb.append(estadoId);

		sb.append("}");

		throw new NoSuchCidadeException(sb.toString());
	}

	/**
	 * Returns the last cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cidade, or <code>null</code> if a matching cidade could not be found
	 */
	@Override
	public Cidade fetchByestadoId_Last(
		long estadoId, OrderByComparator<Cidade> orderByComparator) {

		int count = countByestadoId(estadoId);

		if (count == 0) {
			return null;
		}

		List<Cidade> list = findByestadoId(
			estadoId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Cidade[] findByestadoId_PrevAndNext(
			long cidadeId, long estadoId,
			OrderByComparator<Cidade> orderByComparator)
		throws NoSuchCidadeException {

		Cidade cidade = findByPrimaryKey(cidadeId);

		Session session = null;

		try {
			session = openSession();

			Cidade[] array = new CidadeImpl[3];

			array[0] = getByestadoId_PrevAndNext(
				session, cidade, estadoId, orderByComparator, true);

			array[1] = cidade;

			array[2] = getByestadoId_PrevAndNext(
				session, cidade, estadoId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Cidade getByestadoId_PrevAndNext(
		Session session, Cidade cidade, long estadoId,
		OrderByComparator<Cidade> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CIDADE_WHERE);

		sb.append(_FINDER_COLUMN_ESTADOID_ESTADOID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CidadeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(estadoId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(cidade)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Cidade> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cidades where estadoId = &#63; from the database.
	 *
	 * @param estadoId the estado ID
	 */
	@Override
	public void removeByestadoId(long estadoId) {
		for (Cidade cidade :
				findByestadoId(
					estadoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cidade);
		}
	}

	/**
	 * Returns the number of cidades where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @return the number of matching cidades
	 */
	@Override
	public int countByestadoId(long estadoId) {
		FinderPath finderPath = _finderPathCountByestadoId;

		Object[] finderArgs = new Object[] {estadoId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CIDADE_WHERE);

			sb.append(_FINDER_COLUMN_ESTADOID_ESTADOID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(estadoId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ESTADOID_ESTADOID_2 =
		"cidade.estadoId = ?";

	public CidadePersistenceImpl() {
		setModelClass(Cidade.class);

		setModelImplClass(CidadeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cidade in the entity cache if it is enabled.
	 *
	 * @param cidade the cidade
	 */
	@Override
	public void cacheResult(Cidade cidade) {
		entityCache.putResult(
			entityCacheEnabled, CidadeImpl.class, cidade.getPrimaryKey(),
			cidade);

		cidade.resetOriginalValues();
	}

	/**
	 * Caches the cidades in the entity cache if it is enabled.
	 *
	 * @param cidades the cidades
	 */
	@Override
	public void cacheResult(List<Cidade> cidades) {
		for (Cidade cidade : cidades) {
			if (entityCache.getResult(
					entityCacheEnabled, CidadeImpl.class,
					cidade.getPrimaryKey()) == null) {

				cacheResult(cidade);
			}
			else {
				cidade.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cidades.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CidadeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cidade.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Cidade cidade) {
		entityCache.removeResult(
			entityCacheEnabled, CidadeImpl.class, cidade.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Cidade> cidades) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Cidade cidade : cidades) {
			entityCache.removeResult(
				entityCacheEnabled, CidadeImpl.class, cidade.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, CidadeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new cidade with the primary key. Does not add the cidade to the database.
	 *
	 * @param cidadeId the primary key for the new cidade
	 * @return the new cidade
	 */
	@Override
	public Cidade create(long cidadeId) {
		Cidade cidade = new CidadeImpl();

		cidade.setNew(true);
		cidade.setPrimaryKey(cidadeId);

		return cidade;
	}

	/**
	 * Removes the cidade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cidadeId the primary key of the cidade
	 * @return the cidade that was removed
	 * @throws NoSuchCidadeException if a cidade with the primary key could not be found
	 */
	@Override
	public Cidade remove(long cidadeId) throws NoSuchCidadeException {
		return remove((Serializable)cidadeId);
	}

	/**
	 * Removes the cidade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cidade
	 * @return the cidade that was removed
	 * @throws NoSuchCidadeException if a cidade with the primary key could not be found
	 */
	@Override
	public Cidade remove(Serializable primaryKey) throws NoSuchCidadeException {
		Session session = null;

		try {
			session = openSession();

			Cidade cidade = (Cidade)session.get(CidadeImpl.class, primaryKey);

			if (cidade == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCidadeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cidade);
		}
		catch (NoSuchCidadeException noSuchEntityException) {
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
	protected Cidade removeImpl(Cidade cidade) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cidade)) {
				cidade = (Cidade)session.get(
					CidadeImpl.class, cidade.getPrimaryKeyObj());
			}

			if (cidade != null) {
				session.delete(cidade);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (cidade != null) {
			clearCache(cidade);
		}

		return cidade;
	}

	@Override
	public Cidade updateImpl(Cidade cidade) {
		boolean isNew = cidade.isNew();

		if (!(cidade instanceof CidadeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cidade.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(cidade);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cidade proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Cidade implementation " +
					cidade.getClass());
		}

		CidadeModelImpl cidadeModelImpl = (CidadeModelImpl)cidade;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(cidade);

				cidade.setNew(false);
			}
			else {
				cidade = (Cidade)session.merge(cidade);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {cidadeModelImpl.getEstadoId()};

			finderCache.removeResult(_finderPathCountByestadoId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByestadoId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((cidadeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByestadoId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					cidadeModelImpl.getOriginalEstadoId()
				};

				finderCache.removeResult(_finderPathCountByestadoId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByestadoId, args);

				args = new Object[] {cidadeModelImpl.getEstadoId()};

				finderCache.removeResult(_finderPathCountByestadoId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByestadoId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CidadeImpl.class, cidade.getPrimaryKey(),
			cidade, false);

		cidade.resetOriginalValues();

		return cidade;
	}

	/**
	 * Returns the cidade with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cidade
	 * @return the cidade
	 * @throws NoSuchCidadeException if a cidade with the primary key could not be found
	 */
	@Override
	public Cidade findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCidadeException {

		Cidade cidade = fetchByPrimaryKey(primaryKey);

		if (cidade == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCidadeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cidade;
	}

	/**
	 * Returns the cidade with the primary key or throws a <code>NoSuchCidadeException</code> if it could not be found.
	 *
	 * @param cidadeId the primary key of the cidade
	 * @return the cidade
	 * @throws NoSuchCidadeException if a cidade with the primary key could not be found
	 */
	@Override
	public Cidade findByPrimaryKey(long cidadeId) throws NoSuchCidadeException {
		return findByPrimaryKey((Serializable)cidadeId);
	}

	/**
	 * Returns the cidade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cidadeId the primary key of the cidade
	 * @return the cidade, or <code>null</code> if a cidade with the primary key could not be found
	 */
	@Override
	public Cidade fetchByPrimaryKey(long cidadeId) {
		return fetchByPrimaryKey((Serializable)cidadeId);
	}

	/**
	 * Returns all the cidades.
	 *
	 * @return the cidades
	 */
	@Override
	public List<Cidade> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Cidade> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Cidade> findAll(
		int start, int end, OrderByComparator<Cidade> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Cidade> findAll(
		int start, int end, OrderByComparator<Cidade> orderByComparator,
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

		List<Cidade> list = null;

		if (useFinderCache) {
			list = (List<Cidade>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CIDADE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CIDADE;

				sql = sql.concat(CidadeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Cidade>)QueryUtil.list(
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
	 * Removes all the cidades from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Cidade cidade : findAll()) {
			remove(cidade);
		}
	}

	/**
	 * Returns the number of cidades.
	 *
	 * @return the number of cidades
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CIDADE);

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
		return "cidadeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CIDADE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CidadeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cidade persistence.
	 */
	@Activate
	public void activate() {
		CidadeModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CidadeModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CidadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CidadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByestadoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CidadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByestadoId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByestadoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CidadeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByestadoId",
			new String[] {Long.class.getName()},
			CidadeModelImpl.ESTADOID_COLUMN_BITMASK);

		_finderPathCountByestadoId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByestadoId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CidadeImpl.class.getName());

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
				"value.object.column.bitmask.enabled.com.services.model.Cidade"),
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

	private static final String _SQL_SELECT_CIDADE =
		"SELECT cidade FROM Cidade cidade";

	private static final String _SQL_SELECT_CIDADE_WHERE =
		"SELECT cidade FROM Cidade cidade WHERE ";

	private static final String _SQL_COUNT_CIDADE =
		"SELECT COUNT(cidade) FROM Cidade cidade";

	private static final String _SQL_COUNT_CIDADE_WHERE =
		"SELECT COUNT(cidade) FROM Cidade cidade WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cidade.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Cidade exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Cidade exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CidadePersistenceImpl.class);

	static {
		try {
			Class.forName(ContatosPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}