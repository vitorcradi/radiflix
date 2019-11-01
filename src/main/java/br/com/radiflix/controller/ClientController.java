package br.com.radiflix.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.radiflix.model.FilmDTO;
import br.com.radiflix.service.ClientService;

@RestController
public class ClientController {
	@Autowired
	private ClientService clientService;

	@ResponseBody
	@RequestMapping(value = "/clients", method = GET)
	public List<FilmDTO> findAllMovies() throws ConstraintViolationException {
		return clientService.getClientes();
	}
}
