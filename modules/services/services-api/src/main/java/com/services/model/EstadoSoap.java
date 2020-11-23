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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.services.service.http.EstadoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EstadoSoap implements Serializable {

	public static EstadoSoap toSoapModel(Estado model) {
		EstadoSoap soapModel = new EstadoSoap();

		soapModel.setEstadoId(model.getEstadoId());
		soapModel.setNome(model.getNome());
		soapModel.setUf(model.getUf());

		return soapModel;
	}

	public static EstadoSoap[] toSoapModels(Estado[] models) {
		EstadoSoap[] soapModels = new EstadoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EstadoSoap[][] toSoapModels(Estado[][] models) {
		EstadoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EstadoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EstadoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EstadoSoap[] toSoapModels(List<Estado> models) {
		List<EstadoSoap> soapModels = new ArrayList<EstadoSoap>(models.size());

		for (Estado model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EstadoSoap[soapModels.size()]);
	}

	public EstadoSoap() {
	}

	public long getPrimaryKey() {
		return _estadoId;
	}

	public void setPrimaryKey(long pk) {
		setEstadoId(pk);
	}

	public long getEstadoId() {
		return _estadoId;
	}

	public void setEstadoId(long estadoId) {
		_estadoId = estadoId;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getUf() {
		return _uf;
	}

	public void setUf(String uf) {
		_uf = uf;
	}

	private long _estadoId;
	private String _nome;
	private String _uf;

}