package com.api.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContatoInput {
	private long contatoId;
	@NotBlank
	private String nome;
	@NotNull
	private long cidadeId;
	@NotBlank
	private String telefone;
	@NotBlank
	private String mensagem;
	private String protocolo;

	public long getContatoId() {
		return contatoId;
	}

	public void setContatoId(long contatoId) {
		this.contatoId = contatoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(long cidadeId) {
		this.cidadeId = cidadeId;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

}
