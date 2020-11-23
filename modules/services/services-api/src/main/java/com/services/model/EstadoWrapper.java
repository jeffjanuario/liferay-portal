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
 * This class is a wrapper for {@link Estado}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Estado
 * @generated
 */
public class EstadoWrapper
	extends BaseModelWrapper<Estado> implements Estado, ModelWrapper<Estado> {

	public EstadoWrapper(Estado estado) {
		super(estado);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("estadoId", getEstadoId());
		attributes.put("nome", getNome());
		attributes.put("uf", getUf());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long estadoId = (Long)attributes.get("estadoId");

		if (estadoId != null) {
			setEstadoId(estadoId);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String uf = (String)attributes.get("uf");

		if (uf != null) {
			setUf(uf);
		}
	}

	/**
	 * Returns the estado ID of this estado.
	 *
	 * @return the estado ID of this estado
	 */
	@Override
	public long getEstadoId() {
		return model.getEstadoId();
	}

	/**
	 * Returns the nome of this estado.
	 *
	 * @return the nome of this estado
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this estado.
	 *
	 * @return the primary key of this estado
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uf of this estado.
	 *
	 * @return the uf of this estado
	 */
	@Override
	public String getUf() {
		return model.getUf();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the estado ID of this estado.
	 *
	 * @param estadoId the estado ID of this estado
	 */
	@Override
	public void setEstadoId(long estadoId) {
		model.setEstadoId(estadoId);
	}

	/**
	 * Sets the nome of this estado.
	 *
	 * @param nome the nome of this estado
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this estado.
	 *
	 * @param primaryKey the primary key of this estado
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uf of this estado.
	 *
	 * @param uf the uf of this estado
	 */
	@Override
	public void setUf(String uf) {
		model.setUf(uf);
	}

	@Override
	protected EstadoWrapper wrap(Estado estado) {
		return new EstadoWrapper(estado);
	}

}