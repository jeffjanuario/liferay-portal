package com.api.controller.impl;

import com.api.controller.CidadeController;
import com.api.controller.ConvertClassModel;
import com.api.model.CidadeModel;
import com.services.model.Cidade;
import com.services.service.CidadeLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidade")
public class CidadeControllerImpl implements CidadeController {
	@Reference
	private CidadeLocalService _cidadeLocalService;
	@Autowired
	protected ConvertClassModel<Cidade, CidadeModel> entityToModel;
	@Override
	@GetMapping("/{estadoId}")
	public List<CidadeModel> findCidadesByEstadoId(@PathVariable long estadoId) {
		return entityToModel.toCollection(_cidadeLocalService.findCidadesByEstadoId(estadoId), CidadeModel.class);
	}
}
