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

package com.services.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Cidade}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Cidade
 * @generated
 */
public class CidadeWrapper
	extends BaseModelWrapper<Cidade> implements Cidade, ModelWrapper<Cidade> {

	public CidadeWrapper(Cidade cidade) {
		super(cidade);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cidadeId", getCidadeId());
		attributes.put("nome", getNome());
		attributes.put("estadoId", getEstadoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cidadeId = (Long)attributes.get("cidadeId");

		if (cidadeId != null) {
			setCidadeId(cidadeId);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		Long estadoId = (Long)attributes.get("estadoId");

		if (estadoId != null) {
			setEstadoId(estadoId);
		}
	}

	/**
	 * Returns the cidade ID of this cidade.
	 *
	 * @return the cidade ID of this cidade
	 */
	@Override
	public long getCidadeId() {
		return model.getCidadeId();
	}

	/**
	 * Returns the estado ID of this cidade.
	 *
	 * @return the estado ID of this cidade
	 */
	@Override
	public long getEstadoId() {
		return model.getEstadoId();
	}

	/**
	 * Returns the nome of this cidade.
	 *
	 * @return the nome of this cidade
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this cidade.
	 *
	 * @return the primary key of this cidade
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cidade ID of this cidade.
	 *
	 * @param cidadeId the cidade ID of this cidade
	 */
	@Override
	public void setCidadeId(long cidadeId) {
		model.setCidadeId(cidadeId);
	}

	/**
	 * Sets the estado ID of this cidade.
	 *
	 * @param estadoId the estado ID of this cidade
	 */
	@Override
	public void setEstadoId(long estadoId) {
		model.setEstadoId(estadoId);
	}

	/**
	 * Sets the nome of this cidade.
	 *
	 * @param nome the nome of this cidade
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this cidade.
	 *
	 * @param primaryKey the primary key of this cidade
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected CidadeWrapper wrap(Cidade cidade) {
		return new CidadeWrapper(cidade);
	}

}