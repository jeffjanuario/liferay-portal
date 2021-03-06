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
 * The base model interface for the Estado service. Represents a row in the &quot;Estado&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.services.model.impl.EstadoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.services.model.impl.EstadoImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Estado
 * @generated
 */
@ProviderType
public interface EstadoModel extends BaseModel<Estado> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a estado model instance should use the {@link Estado} interface instead.
	 */

	/**
	 * Returns the primary key of this estado.
	 *
	 * @return the primary key of this estado
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this estado.
	 *
	 * @param primaryKey the primary key of this estado
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the estado ID of this estado.
	 *
	 * @return the estado ID of this estado
	 */
	public long getEstadoId();

	/**
	 * Sets the estado ID of this estado.
	 *
	 * @param estadoId the estado ID of this estado
	 */
	public void setEstadoId(long estadoId);

	/**
	 * Returns the nome of this estado.
	 *
	 * @return the nome of this estado
	 */
	@AutoEscape
	public String getNome();

	/**
	 * Sets the nome of this estado.
	 *
	 * @param nome the nome of this estado
	 */
	public void setNome(String nome);

	/**
	 * Returns the uf of this estado.
	 *
	 * @return the uf of this estado
	 */
	@AutoEscape
	public String getUf();

	/**
	 * Sets the uf of this estado.
	 *
	 * @param uf the uf of this estado
	 */
	public void setUf(String uf);

}