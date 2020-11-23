package com.api.controller;

import com.api.model.CidadeModel;

import java.util.List;

import javax.ws.rs.PathParam;

public interface CidadeController {
	List<CidadeModel> findCidadesByEstadoId(@PathParam("estadoId") long estadoId);
}
