package com.api.controller;

import com.api.input.ContatoInput;
import com.api.model.ContatoModel;

public interface ContatoController {
	ContatoModel save(ContatoInput contato);
}
