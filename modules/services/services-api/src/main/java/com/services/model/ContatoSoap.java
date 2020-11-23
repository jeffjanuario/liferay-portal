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
 * This class is used by SOAP remote services, specifically {@link com.services.service.http.ContatoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContatoSoap implements Serializable {

	public static ContatoSoap toSoapModel(Contato model) {
		ContatoSoap soapModel = new ContatoSoap();

		soapModel.setContatoId(model.getContatoId());
		soapModel.setNome(model.getNome());
		soapModel.setEmail(model.getEmail());
		soapModel.setTelefone(model.getTelefone());
		soapModel.setMensagem(model.getMensagem());
		soapModel.setCidadeId(model.getCidadeId());

		return soapModel;
	}

	public static ContatoSoap[] toSoapModels(Contato[] models) {
		ContatoSoap[] soapModels = new ContatoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ContatoSoap[][] toSoapModels(Contato[][] models) {
		ContatoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ContatoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ContatoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ContatoSoap[] toSoapModels(List<Contato> models) {
		List<ContatoSoap> soapModels = new ArrayList<ContatoSoap>(
			models.size());

		for (Contato model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ContatoSoap[soapModels.size()]);
	}

	public ContatoSoap() {
	}

	public long getPrimaryKey() {
		return _contatoId;
	}

	public void setPrimaryKey(long pk) {
		setContatoId(pk);
	}

	public long getContatoId() {
		return _contatoId;
	}

	public void setContatoId(long contatoId) {
		_contatoId = contatoId;
	}

	public String getNome() {
		return _nome;
	}

	public void setNome(String nome) {
		_nome = nome;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getTelefone() {
		return _telefone;
	}

	public void setTelefone(String telefone) {
		_telefone = telefone;
	}

	public String getMensagem() {
		return _Mensagem;
	}

	public void setMensagem(String Mensagem) {
		_Mensagem = Mensagem;
	}

	public long getCidadeId() {
		return _cidadeId;
	}

	public void setCidadeId(long cidadeId) {
		_cidadeId = cidadeId;
	}

	private long _contatoId;
	private String _nome;
	private String _email;
	private String _telefone;
	private String _Mensagem;
	private long _cidadeId;

}