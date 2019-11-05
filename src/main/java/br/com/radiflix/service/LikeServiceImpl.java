package br.com.radiflix.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.radiflix.model.LikeDTO;
import br.com.radiflix.model.LikeEntity;
import br.com.radiflix.repository.LikeRepository;

@Service
public class LikeServiceImpl implements LikeService {

    @Value("${radiflix.rabbitmq.exchange}")
    private String exchange;
    
    @Value("${radiflix.rabbitmq.routingkey}")
    private String routingKey;  
    
    @Autowired
    private LikeRepository likeRepository;

    private RabbitTemplate rabbitTemplate; 
    
    
    
    
    @Override
    public void inputLike(List<LikeDTO> likes) throws ConstraintViolationException {
        
        LikeEntity entity = null;
        for (LikeDTO like : likes) {
            entity = likeRepository.findById(like.getMovieId()).orElse(new LikeEntity());
            entity.setMovieId(like.getMovieId());
            entity.setLiked(like.isLiked());
            
            rabbitTemplate.convertAndSend(this.exchange,this.routingKey, entity);
            
            
            likeRepository.save(entity);
        };
    }

}
