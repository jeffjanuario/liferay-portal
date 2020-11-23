package com.api.controller.impl;

import com.api.controller.ContatoController;
import com.api.controller.ConvertClassModel;
import com.api.input.ContatoInput;
import com.api.model.ContatoModel;
import com.services.model.Contato;
import com.services.service.ContatoLocalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.osgi.service.component.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contato")
public class ContatoControllerImpl implements ContatoController {
	@Reference
	private ContatoLocalService _contatoLocalService;
	@Autowired
	protected ConvertClassModel<ContatoInput, Contato> inputToEntity;
	@Autowired
	protected ConvertClassModel<Contato, ContatoModel> entityToModel;

	@Override
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ContatoModel save(@Valid @RequestBody ContatoInput contato) {
		contato.setProtocolo(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE).concat(contato.getTelefone()));
		return entityToModel.toSimple(_contatoLocalService.addContato(inputToEntity.toSimple(contato, Contato.class)),
				ContatoModel.class);
	}

}
