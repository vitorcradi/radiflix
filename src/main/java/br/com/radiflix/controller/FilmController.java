package br.com.radiflix.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.radiflix.model.FilmDTO;
import br.com.radiflix.service.FilmService;


@RestController
public class FilmController {
	@Autowired
	private FilmService movieService;

	@ResponseBody
	@RequestMapping(value = "/filmes", method = GET)
	public List<FilmDTO> findMovieByGenre(@RequestParam String genre) throws ConstraintViolationException {
		return movieService.findMovieByGenre(genre);
	}
}