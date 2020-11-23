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

package com.services.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.services.model.Estado;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Estado in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EstadoCacheModel implements CacheModel<Estado>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EstadoCacheModel)) {
			return false;
		}

		EstadoCacheModel estadoCacheModel = (EstadoCacheModel)object;

		if (estadoId == estadoCacheModel.estadoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, estadoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{estadoId=");
		sb.append(estadoId);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", uf=");
		sb.append(uf);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Estado toEntityModel() {
		EstadoImpl estadoImpl = new EstadoImpl();

		estadoImpl.setEstadoId(estadoId);

		if (nome == null) {
			estadoImpl.setNome("");
		}
		else {
			estadoImpl.setNome(nome);
		}

		if (uf == null) {
			estadoImpl.setUf("");
		}
		else {
			estadoImpl.setUf(uf);
		}

		estadoImpl.resetOriginalValues();

		return estadoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		estadoId = objectInput.readLong();
		nome = objectInput.readUTF();
		uf = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(estadoId);

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (uf == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uf);
		}
	}

	public long estadoId;
	public String nome;
	public String uf;

}