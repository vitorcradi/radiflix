package br.com.radiflix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.radiflix.model.FilmDTO;
import br.com.radiflix.model.FilmEntity;
import br.com.radiflix.repository.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	public FilmRepository movieRepository;
	
	@Override
	public List<FilmDTO> fildAllMovies(FilmDTO movie) {
		List<FilmEntity> moviesEntity = this.movieRepository.findAll();
		List<FilmDTO> moviesDTO = formatMovieEntityToDTO(moviesEntity);
		
		return moviesDTO;
	}

	@Override
	public List<FilmDTO> findMovieByGenre(String genre) {
		List<FilmEntity> moviesEntity = this.movieRepository.findByGenre(genre);
		List<FilmDTO> moviesDTO = formatMovieEntityToDTO(moviesEntity);

		return moviesDTO;
	}
	
	
	private List<FilmDTO> formatMovieEntityToDTO(List<FilmEntity> moviesEntity) {
		List<FilmDTO> moviesDTO = new ArrayList<FilmDTO>();	
		moviesEntity.stream().forEach(movieEntity -> {
			moviesDTO.stream().forEach(movieDto -> {
				movieDto.setGenre(movieEntity.getGenre());
				movieDto.setDetails(movieEntity.getDetails());
				movieDto.setName(movieEntity.getName());
				movieDto.setReleaseYear(movieEntity.getReleaseYear());
				movieDto.setWatched(movieEntity.getWatched());
			});
		});
		return moviesDTO;
	}

}
