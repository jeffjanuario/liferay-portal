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
 * This class is a wrapper for {@link Contato}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Contato
 * @generated
 */
public class ContatoWrapper
	extends BaseModelWrapper<Contato>
	implements Contato, ModelWrapper<Contato> {

	public ContatoWrapper(Contato contato) {
		super(contato);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("contatoId", getContatoId());
		attributes.put("nome", getNome());
		attributes.put("email", getEmail());
		attributes.put("telefone", getTelefone());
		attributes.put("Mensagem", getMensagem());
		attributes.put("cidadeId", getCidadeId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long contatoId = (Long)attributes.get("contatoId");

		if (contatoId != null) {
			setContatoId(contatoId);
		}

		String nome = (String)attributes.get("nome");

		if (nome != null) {
			setNome(nome);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String telefone = (String)attributes.get("telefone");

		if (telefone != null) {
			setTelefone(telefone);
		}

		String Mensagem = (String)attributes.get("Mensagem");

		if (Mensagem != null) {
			setMensagem(Mensagem);
		}

		Long cidadeId = (Long)attributes.get("cidadeId");

		if (cidadeId != null) {
			setCidadeId(cidadeId);
		}
	}

	/**
	 * Returns the cidade ID of this contato.
	 *
	 * @return the cidade ID of this contato
	 */
	@Override
	public long getCidadeId() {
		return model.getCidadeId();
	}

	/**
	 * Returns the contato ID of this contato.
	 *
	 * @return the contato ID of this contato
	 */
	@Override
	public long getContatoId() {
		return model.getContatoId();
	}

	/**
	 * Returns the email of this contato.
	 *
	 * @return the email of this contato
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the mensagem of this contato.
	 *
	 * @return the mensagem of this contato
	 */
	@Override
	public String getMensagem() {
		return model.getMensagem();
	}

	/**
	 * Returns the nome of this contato.
	 *
	 * @return the nome of this contato
	 */
	@Override
	public String getNome() {
		return model.getNome();
	}

	/**
	 * Returns the primary key of this contato.
	 *
	 * @return the primary key of this contato
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the telefone of this contato.
	 *
	 * @return the telefone of this contato
	 */
	@Override
	public String getTelefone() {
		return model.getTelefone();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cidade ID of this contato.
	 *
	 * @param cidadeId the cidade ID of this contato
	 */
	@Override
	public void setCidadeId(long cidadeId) {
		model.setCidadeId(cidadeId);
	}

	/**
	 * Sets the contato ID of this contato.
	 *
	 * @param contatoId the contato ID of this contato
	 */
	@Override
	public void setContatoId(long contatoId) {
		model.setContatoId(contatoId);
	}

	/**
	 * Sets the email of this contato.
	 *
	 * @param email the email of this contato
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the mensagem of this contato.
	 *
	 * @param Mensagem the mensagem of this contato
	 */
	@Override
	public void setMensagem(String Mensagem) {
		model.setMensagem(Mensagem);
	}

	/**
	 * Sets the nome of this contato.
	 *
	 * @param nome the nome of this contato
	 */
	@Override
	public void setNome(String nome) {
		model.setNome(nome);
	}

	/**
	 * Sets the primary key of this contato.
	 *
	 * @param primaryKey the primary key of this contato
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the telefone of this contato.
	 *
	 * @param telefone the telefone of this contato
	 */
	@Override
	public void setTelefone(String telefone) {
		model.setTelefone(telefone);
	}

	@Override
	protected ContatoWrapper wrap(Contato contato) {
		return new ContatoWrapper(contato);
	}

}