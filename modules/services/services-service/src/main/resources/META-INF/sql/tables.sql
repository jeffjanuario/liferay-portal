create table Cidade (
	cidadeId LONG not null primary key,
	nome VARCHAR(75) null,
	estadoId LONG
);

create table Contato (
	contatoId LONG not null primary key,
	nome VARCHAR(75) null,
	email VARCHAR(75) null,
	telefone VARCHAR(75) null,
	Mensagem VARCHAR(75) null,
	cidadeId LONG
);

create table Estado (
	estadoId LONG not null primary key,
	nome VARCHAR(75) null,
	uf VARCHAR(75) null
);