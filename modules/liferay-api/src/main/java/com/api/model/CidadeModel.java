package com.api.model;

public class CidadeModel {
	private long cidadeId;
	private String nome;
	private long estadoId;

	public long getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(long cidadeId) {
		this.cidadeId = cidadeId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(long estadoId) {
		this.estadoId = estadoId;
	}

}
