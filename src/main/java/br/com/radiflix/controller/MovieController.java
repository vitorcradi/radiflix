package br.com.radiflix.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.radiflix.model.MovieDTO;
import br.com.radiflix.service.MovieService;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @ResponseBody
    @RequestMapping(value = "/movies", method = GET)
    public List<MovieDTO> findMovies(
        @RequestParam(required = false) String genre,
        @RequestParam(required = false) String keyword, 
        @RequestParam(required = false) Boolean watched
    ) throws ConstraintViolationException {
        return movieService.findMovies(genre, keyword);
    }

    @ResponseBody
    @RequestMapping(value = "/movies/genre/{id}", method = GET)
    public List<MovieDTO> findPopularMoviesByGenre(@PathVariable final Integer id) throws ConstraintViolationException {
        return movieService.findPopularMoviesByCategory(id);
    }

    @ResponseBody
    @RequestMapping(value = "/movies/watched", method = GET)
    public List<MovieDTO> findWatchedMovies() throws ConstraintViolationException {
        return movieService.findWatchedMovies();
    }

    @ResponseBody
    @RequestMapping(value = "/movie/{id}", method = GET)
    public MovieDTO findMovie(@PathVariable final Integer id) throws ConstraintViolationException {
        return movieService.findMovieBy(id);
    }

    @ResponseBody
    @RequestMapping(value = "/movie/{id}", method = PUT)
    public void updateMovie(@RequestBody MovieDTO movie, @PathVariable final Integer id) throws ConstraintViolationException {
        movieService.updateMovie(id, movie);
    }

}