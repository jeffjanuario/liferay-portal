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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Contato service. Represents a row in the &quot;Contato&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.services.model.impl.ContatoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.services.model.impl.ContatoImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Contato
 * @generated
 */
@ProviderType
public interface ContatoModel extends BaseModel<Contato> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a contato model instance should use the {@link Contato} interface instead.
	 */

	/**
	 * Returns the primary key of this contato.
	 *
	 * @return the primary key of this contato
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this contato.
	 *
	 * @param primaryKey the primary key of this contato
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the contato ID of this contato.
	 *
	 * @return the contato ID of this contato
	 */
	public long getContatoId();

	/**
	 * Sets the contato ID of this contato.
	 *
	 * @param contatoId the contato ID of this contato
	 */
	public void setContatoId(long contatoId);

	/**
	 * Returns the nome of this contato.
	 *
	 * @return the nome of this contato
	 */
	@AutoEscape
	public String getNome();

	/**
	 * Sets the nome of this contato.
	 *
	 * @param nome the nome of this contato
	 */
	public void setNome(String nome);

	/**
	 * Returns the email of this contato.
	 *
	 * @return the email of this contato
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this contato.
	 *
	 * @param email the email of this contato
	 */
	public void setEmail(String email);

	/**
	 * Returns the telefone of this contato.
	 *
	 * @return the telefone of this contato
	 */
	@AutoEscape
	public String getTelefone();

	/**
	 * Sets the telefone of this contato.
	 *
	 * @param telefone the telefone of this contato
	 */
	public void setTelefone(String telefone);

	/**
	 * Returns the mensagem of this contato.
	 *
	 * @return the mensagem of this contato
	 */
	@AutoEscape
	public String getMensagem();

	/**
	 * Sets the mensagem of this contato.
	 *
	 * @param Mensagem the mensagem of this contato
	 */
	public void setMensagem(String Mensagem);

	/**
	 * Returns the cidade ID of this contato.
	 *
	 * @return the cidade ID of this contato
	 */
	public long getCidadeId();

	/**
	 * Sets the cidade ID of this contato.
	 *
	 * @param cidadeId the cidade ID of this contato
	 */
	public void setCidadeId(long cidadeId);

}