package br.com.radiflix.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import br.com.radiflix.model.LikeDTO;

public interface LikeService {
	void inputLike(List<LikeDTO> likes) throws ConstraintViolationException ;
}
