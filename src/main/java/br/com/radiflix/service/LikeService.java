package br.com.radiflix.service;

import java.util.List;

import br.com.radiflix.model.LikeDTO;

public interface LikeService {
	void inputLike(List<LikeDTO> movie);
}
