package br.com.radiflix.service;

import java.util.List;

import br.com.radiflix.model.MovieDTO;

public interface MovieService {

	List<MovieDTO> findMovies(String genre);

    MovieDTO findMovieBy(Integer id);

}
