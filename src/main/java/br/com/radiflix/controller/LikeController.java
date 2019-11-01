package br.com.radiflix.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.radiflix.model.LikeDTO;
import br.com.radiflix.service.LikeService;

@RestController
public class LikeController {
	
	@Autowired
	private LikeService movieService;

	@ResponseBody
	@RequestMapping(value = "/like", method = POST)
	public void inputLike(@RequestBody List<LikeDTO> movie) throws ConstraintViolationException {
		movieService.inputLike(movie);
	}

}
