package br.com.radiflix.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.service.RabbitMQSender;

import br.com.radiflix.model.LikeDTO;
import br.com.radiflix.service.LikeService;

@RestController
public class LikesController {
    @Autowired
    RabbitMQSender rabbitMQSender;
	@Autowired
	private LikeService likeService;

	@ResponseBody
	@RequestMapping(value = "/likes", method = POST)
	public void inputLike(@RequestBody List<LikeDTO> likes) throws ConstraintViolationException {
		likeService.inputLike(likes);
	}

}
