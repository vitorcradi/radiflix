package br.com.radiflix.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import br.com.radiflix.model.MovieDTO;

public interface MovieService {

	List<MovieDTO> findMovies(String genre, String keyword) throws ConstraintViolationException ;

    MovieDTO findMovieBy(Integer id) throws ConstraintViolationException ;

    void updateMovie(Integer id, MovieDTO movie) throws ConstraintViolationException ;

    List<MovieDTO> findPopularMoviesByCategory(Integer id) throws ConstraintViolationException ;

    List<MovieDTO> findWatchedMovies() throws ConstraintViolationException ;

}
