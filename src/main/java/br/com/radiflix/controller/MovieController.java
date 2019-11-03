package br.com.radiflix.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<MovieDTO> findMovies(@RequestParam(required = false) String genre) throws ConstraintViolationException {
        return movieService.findMovies(genre);
    }

    @ResponseBody
    @RequestMapping(value = "/movie/{id}", method = GET)
    public MovieDTO findMovie(@PathVariable final Integer id) throws ConstraintViolationException {
        return movieService.findMovieBy(id);
    }

}