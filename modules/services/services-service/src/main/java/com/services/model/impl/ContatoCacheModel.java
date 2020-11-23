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

import com.services.model.Contato;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Contato in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ContatoCacheModel implements CacheModel<Contato>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ContatoCacheModel)) {
			return false;
		}

		ContatoCacheModel contatoCacheModel = (ContatoCacheModel)object;

		if (contatoId == contatoCacheModel.contatoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, contatoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{contatoId=");
		sb.append(contatoId);
		sb.append(", nome=");
		sb.append(nome);
		sb.append(", email=");
		sb.append(email);
		sb.append(", telefone=");
		sb.append(telefone);
		sb.append(", Mensagem=");
		sb.append(Mensagem);
		sb.append(", cidadeId=");
		sb.append(cidadeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Contato toEntityModel() {
		ContatoImpl contatoImpl = new ContatoImpl();

		contatoImpl.setContatoId(contatoId);

		if (nome == null) {
			contatoImpl.setNome("");
		}
		else {
			contatoImpl.setNome(nome);
		}

		if (email == null) {
			contatoImpl.setEmail("");
		}
		else {
			contatoImpl.setEmail(email);
		}

		if (telefone == null) {
			contatoImpl.setTelefone("");
		}
		else {
			contatoImpl.setTelefone(telefone);
		}

		if (Mensagem == null) {
			contatoImpl.setMensagem("");
		}
		else {
			contatoImpl.setMensagem(Mensagem);
		}

		contatoImpl.setCidadeId(cidadeId);

		contatoImpl.resetOriginalValues();

		return contatoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		contatoId = objectInput.readLong();
		nome = objectInput.readUTF();
		email = objectInput.readUTF();
		telefone = objectInput.readUTF();
		Mensagem = objectInput.readUTF();

		cidadeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(contatoId);

		if (nome == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nome);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (telefone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(telefone);
		}

		if (Mensagem == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Mensagem);
		}

		objectOutput.writeLong(cidadeId);
	}

	public long contatoId;
	public String nome;
	public String email;
	public String telefone;
	public String Mensagem;
	public long cidadeId;

}