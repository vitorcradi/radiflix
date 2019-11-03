package br.com.radiflix.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.radiflix.model.LikeDTO;
import br.com.radiflix.repository.LikeRepository;

@Service
public class LikeServiceImpl implements LikeService{

    private LikeRepository likeRepository;
    
	@Override
	public void inputLike(List<LikeDTO> likes) {
//	    LikeEntity entity = new LikeEntity();
//	    entity.setClientId(like);
//	    
//	    
//	    
//	    
//	    likeRepository.save(like)
	}

}
