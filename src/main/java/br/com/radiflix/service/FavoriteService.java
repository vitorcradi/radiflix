package br.com.radiflix.service;

import java.util.List;

import br.com.radiflix.model.MovieDTO;

public interface FavoriteService {

	List<MovieDTO> getfavoritos();

	List<MovieDTO> inputFavorito();

}
