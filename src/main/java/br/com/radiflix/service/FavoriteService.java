package br.com.radiflix.service;

import java.util.List;

import br.com.radiflix.model.FilmDTO;

public interface FavoriteService {

	List<FilmDTO> getfavoritos();

	List<FilmDTO> inputFavorito();

}
