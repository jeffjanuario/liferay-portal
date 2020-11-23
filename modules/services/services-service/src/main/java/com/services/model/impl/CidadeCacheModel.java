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

import com.services.model.Cidade;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Cidade in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CidadeCacheModel implements CacheModel<Cidade>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CidadeCacheModel)) {
			return false;
		}

		CidadeCacheModel cidadeCacheModel = (CidadeCacheModel)object;

		if (cidadeId == cidadeCacheModel.cidadeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cidadeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{cidadeId=");
		sb.append(cidadeId);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", estadoId=");
		sb.append(estadoId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cidade toEntityModel() {
		CidadeImpl cidadeImpl = new CidadeImpl();

		cidadeImpl.setCidadeId(cidadeId);

		if (nome == null) {
			cidadeImpl.setNome("");
		}
		else {
			cidadeImpl.setNome(nome);
		}

		cidadeImpl.setEstadoId(estadoId);

		cidadeImpl.resetOriginalValues();

		return cidadeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cidadeId = objectInput.readLong();
		nome = objectInput.readUTF();

		estadoId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(cidadeId);

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		objectOutput.writeLong(estadoId);
	}

	public long cidadeId;
	public String nome;
	public long estadoId;

}