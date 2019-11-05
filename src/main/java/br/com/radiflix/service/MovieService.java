package br.com.radiflix.service;

import java.util.List;

import br.com.radiflix.model.MovieDTO;

public interface MovieService {

	List<MovieDTO> findMovies(String genre, String keyword);

    MovieDTO findMovieBy(Integer id);

    void updateMovie(Integer id, MovieDTO movie);

    List<MovieDTO> findPopularMoviesByCategory(Integer id);

}
