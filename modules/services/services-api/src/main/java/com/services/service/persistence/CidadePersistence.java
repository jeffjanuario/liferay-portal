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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.services.exception.NoSuchCidadeException;
import com.services.model.Cidade;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cidade service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CidadeUtil
 * @generated
 */
@ProviderType
public interface CidadePersistence extends BasePersistence<Cidade> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CidadeUtil} to access the cidade persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cidades where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @return the matching cidades
	 */
	public java.util.List<Cidade> findByestadoId(long estadoId);

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
	public java.util.List<Cidade> findByestadoId(
		long estadoId, int start, int end);

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
	public java.util.List<Cidade> findByestadoId(
		long estadoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cidade>
			orderByComparator);

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
	public java.util.List<Cidade> findByestadoId(
		long estadoId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cidade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cidade
	 * @throws NoSuchCidadeException if a matching cidade could not be found
	 */
	public Cidade findByestadoId_First(
			long estadoId,
			com.liferay.portal.kernel.util.OrderByComparator<Cidade>
				orderByComparator)
		throws NoSuchCidadeException;

	/**
	 * Returns the first cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cidade, or <code>null</code> if a matching cidade could not be found
	 */
	public Cidade fetchByestadoId_First(
		long estadoId,
		com.liferay.portal.kernel.util.OrderByComparator<Cidade>
			orderByComparator);

	/**
	 * Returns the last cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cidade
	 * @throws NoSuchCidadeException if a matching cidade could not be found
	 */
	public Cidade findByestadoId_Last(
			long estadoId,
			com.liferay.portal.kernel.util.OrderByComparator<Cidade>
				orderByComparator)
		throws NoSuchCidadeException;

	/**
	 * Returns the last cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cidade, or <code>null</code> if a matching cidade could not be found
	 */
	public Cidade fetchByestadoId_Last(
		long estadoId,
		com.liferay.portal.kernel.util.OrderByComparator<Cidade>
			orderByComparator);

	/**
	 * Returns the cidades before and after the current cidade in the ordered set where estadoId = &#63;.
	 *
	 * @param cidadeId the primary key of the current cidade
	 * @param estadoId the estado ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cidade
	 * @throws NoSuchCidadeException if a cidade with the primary key could not be found
	 */
	public Cidade[] findByestadoId_PrevAndNext(
			long cidadeId, long estadoId,
			com.liferay.portal.kernel.util.OrderByComparator<Cidade>
				orderByComparator)
		throws NoSuchCidadeException;

	/**
	 * Removes all the cidades where estadoId = &#63; from the database.
	 *
	 * @param estadoId the estado ID
	 */
	public void removeByestadoId(long estadoId);

	/**
	 * Returns the number of cidades where estadoId = &#63;.
	 *
	 * @param estadoId the estado ID
	 * @return the number of matching cidades
	 */
	public int countByestadoId(long estadoId);

	/**
	 * Caches the cidade in the entity cache if it is enabled.
	 *
	 * @param cidade the cidade
	 */
	public void cacheResult(Cidade cidade);

	/**
	 * Caches the cidades in the entity cache if it is enabled.
	 *
	 * @param cidades the cidades
	 */
	public void cacheResult(java.util.List<Cidade> cidades);

	/**
	 * Creates a new cidade with the primary key. Does not add the cidade to the database.
	 *
	 * @param cidadeId the primary key for the new cidade
	 * @return the new cidade
	 */
	public Cidade create(long cidadeId);

	/**
	 * Removes the cidade with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cidadeId the primary key of the cidade
	 * @return the cidade that was removed
	 * @throws NoSuchCidadeException if a cidade with the primary key could not be found
	 */
	public Cidade remove(long cidadeId) throws NoSuchCidadeException;

	public Cidade updateImpl(Cidade cidade);

	/**
	 * Returns the cidade with the primary key or throws a <code>NoSuchCidadeException</code> if it could not be found.
	 *
	 * @param cidadeId the primary key of the cidade
	 * @return the cidade
	 * @throws NoSuchCidadeException if a cidade with the primary key could not be found
	 */
	public Cidade findByPrimaryKey(long cidadeId) throws NoSuchCidadeException;

	/**
	 * Returns the cidade with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cidadeId the primary key of the cidade
	 * @return the cidade, or <code>null</code> if a cidade with the primary key could not be found
	 */
	public Cidade fetchByPrimaryKey(long cidadeId);

	/**
	 * Returns all the cidades.
	 *
	 * @return the cidades
	 */
	public java.util.List<Cidade> findAll();

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
	public java.util.List<Cidade> findAll(int start, int end);

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
	public java.util.List<Cidade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cidade>
			orderByComparator);

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
	public java.util.List<Cidade> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Cidade>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the cidades from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cidades.
	 *
	 * @return the number of cidades
	 */
	public int countAll();

}