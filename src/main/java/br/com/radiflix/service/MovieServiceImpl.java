package br.com.radiflix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.radiflix.model.MovieDTO;
import br.com.radiflix.model.MovieEntity;
import br.com.radiflix.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    public MovieRepository movieRepository;

    @Override
    public List<MovieDTO> findMovies(String genre) {
        List<MovieEntity> moviesEntity = null;

        if (genre == null || genre.isEmpty()) {
            moviesEntity = this.movieRepository.findAll();
        } else {
            moviesEntity = this.movieRepository.findByGenre(genre);
        }
        List<MovieDTO> moviesDTO = formatMovieEntityListToDTOList(moviesEntity);

        return moviesDTO;
    }

    @Override
    public MovieDTO findMovieBy(Integer id) {
        MovieEntity moviesEntity = this.movieRepository.findById(id).orElse(new MovieEntity());
        MovieDTO dto = formatMovieEntityToDTO(moviesEntity);
        return dto;
    }

    private MovieDTO formatMovieEntityToDTO(MovieEntity moviesEntity) {
        MovieDTO dto = new MovieDTO();
        dto.setDetails(moviesEntity.getDetails());
        dto.setGenre(moviesEntity.getGenre());
        dto.setLikes(moviesEntity.getLikes());
        dto.setName(moviesEntity.getName());
        dto.setWatched(moviesEntity.getWatched());
        return dto;
    }

    private List<MovieDTO> formatMovieEntityListToDTOList(List<MovieEntity> moviesEntity) {
        List<MovieDTO> moviesDTO = new ArrayList<MovieDTO>();
        MovieDTO dto = null;
        for (MovieEntity entity : moviesEntity) {
            dto = new MovieDTO();
            dto.setGenre(entity.getGenre());
            dto.setName(entity.getName());
            moviesDTO.add(dto);
        }
        return moviesDTO;
    }

}
