package com.api.controller.impl;

import com.api.controller.ConvertClassModel;
import com.api.controller.EstadoController;
import com.api.model.EstadoModel;
import com.services.model.Estado;
import com.services.service.EstadoLocalService;

import java.util.List;

import org.osgi.service.component.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoControllerImpl implements EstadoController {
	@Reference
	private EstadoLocalService _estadoLocalService;
	@Autowired
	protected ConvertClassModel<Estado, EstadoModel> entityToModel;
	@Override
	@GetMapping
	public List<EstadoModel> findAll() {
		return entityToModel.toCollection(_estadoLocalService.getEstados(-1, -1), EstadoModel.class) ;
	}

}
