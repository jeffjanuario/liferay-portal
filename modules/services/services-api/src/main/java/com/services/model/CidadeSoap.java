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
 * This class is used by SOAP remote services, specifically {@link com.services.service.http.CidadeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CidadeSoap implements Serializable {

	public static CidadeSoap toSoapModel(Cidade model) {
		CidadeSoap soapModel = new CidadeSoap();

		soapModel.setCidadeId(model.getCidadeId());
		soapModel.setNome(model.getNome());
		soapModel.setEstadoId(model.getEstadoId());

		return soapModel;
	}

	public static CidadeSoap[] toSoapModels(Cidade[] models) {
		CidadeSoap[] soapModels = new CidadeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CidadeSoap[][] toSoapModels(Cidade[][] models) {
		CidadeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CidadeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CidadeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CidadeSoap[] toSoapModels(List<Cidade> models) {
		List<CidadeSoap> soapModels = new ArrayList<CidadeSoap>(models.size());

		for (Cidade model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CidadeSoap[soapModels.size()]);
	}

	public CidadeSoap() {
	}

	public long getPrimaryKey() {
		return _cidadeId;
	}

	public void setPrimaryKey(long pk) {
		setCidadeId(pk);
	}

	public long getCidadeId() {
		return _cidadeId;
	}

	public void setCidadeId(long cidadeId) {
		_cidadeId = cidadeId;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public long getEstadoId() {
		return _estadoId;
	}

	public void setEstadoId(long estadoId) {
		_estadoId = estadoId;
	}

	private long _cidadeId;
	private String _nome;
	private long _estadoId;

}