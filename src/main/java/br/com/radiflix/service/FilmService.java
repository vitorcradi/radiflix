package br.com.radiflix.service;

import java.util.List;

import br.com.radiflix.model.FilmDTO;

public interface FilmService {

	List<FilmDTO> fildAllMovies(FilmDTO movie);

	List<FilmDTO> findMovieByGenre(String genre);

}
