package br.com.radiflix.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.radiflix.model.LikeDTO;
import br.com.radiflix.service.LikeService;

@RestController
public class LikesController {

    @Autowired
    private LikeService likeService;    

    @Value("${radiflix.rabbitmq.exchange}")
    private String exchange;
    
    @Value("${radiflix.rabbitmq.routingkey}")
    private String routingKey;  

    private RabbitTemplate rabbitTemplate; 

    @ResponseBody
    @RequestMapping(value = "/likes", method = POST)
    public void inputLike(@RequestBody List<LikeDTO> likes) throws ConstraintViolationException {
        rabbitTemplate.convertAndSend(this.exchange,this.routingKey, likes);
        likeService.inputLike(likes);
    }

}
