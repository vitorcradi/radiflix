package br.com.radiflix.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.radiflix.model.FilmDTO;
import br.com.radiflix.service.FavoriteService;

@RestController
public class FavoriteController {
	@Autowired
	private FavoriteService favoritosService;

	@ResponseBody
	@RequestMapping(value = "/favoritos", method = GET)
	public List<FilmDTO> findAllMovies() throws ConstraintViolationException {
		return favoritosService.getfavoritos();
	}
	
	@ResponseBody
	@RequestMapping(value = "/favorito", method = POST)
	public List<FilmDTO> inputFavorito() throws ConstraintViolationException {
		return favoritosService.inputFavorito();
	}
}
