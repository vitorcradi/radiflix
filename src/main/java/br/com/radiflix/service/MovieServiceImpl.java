package br.com.radiflix.service;

import java.util.ArrayList;
import java.util.List;

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
    public List<MovieDTO> findMovies(String genre, String keyword) {
        List<MovieEntity> moviesEntity = null;
        
        if((keyword != null && !keyword.isEmpty()) && (genre != null && !genre.isEmpty())) {
            moviesEntity = movieRepository.findByGenreAndKeyword(keyword, genre);
        } else if (genre != null && !genre.isEmpty() && (keyword == null || keyword.isEmpty())) {
            moviesEntity = movieRepository.findByGenre(genre);
        } else if (keyword != null && !keyword.isEmpty() && (genre == null || genre.isEmpty())) {
            moviesEntity = movieRepository.findByKeyword(keyword);
        } else {
            moviesEntity = this.movieRepository.findAll();
        }

        return formatMovieEntityListToDTOList(moviesEntity);
    }

    @Override
    public List<MovieDTO> findPopularMoviesByCategory(Integer genreId) {
        List<MovieEntity> moviesEntity = movieRepository.findByGenreId(genreId);
        return formatMovieEntityListToDTOList(moviesEntity);
    }
    
    
    @Override
    public MovieDTO findMovieBy(Integer id) {
        MovieEntity moviesEntity = this.movieRepository.findById(id).orElse(new MovieEntity());
        MovieDTO dto = formatMovieEntityToDTO(moviesEntity);
        return dto;
    }
    
    @Override
    public void updateMovie(Integer id, MovieDTO movie) {
        MovieEntity entity = movieRepository.findById(id).orElse(new MovieEntity());
        entity.setDetail(movie.getDetail());
        entity.setGenre(movie.getGenre());
        entity.setName(movie.getName());
        entity.setToWatch(movie.isToWatch());
        entity.setGenreId(movie.getGenreId());
        
        movieRepository.save(entity);
    }
    

    private MovieDTO formatMovieEntityToDTO(MovieEntity moviesEntity) {
        MovieDTO dto = new MovieDTO();
        dto.setDetail(moviesEntity.getDetail());
        dto.setGenre(moviesEntity.getGenre());
        dto.setName(moviesEntity.getName());
        dto.setToWatch(moviesEntity.isToWatch());
        dto.setGenreId(moviesEntity.getGenreId());
        return dto;
    }

    private List<MovieDTO> formatMovieEntityListToDTOList(List<MovieEntity> moviesEntity) {
        List<MovieDTO> moviesDTO = new ArrayList<MovieDTO>();
        MovieDTO dto = null;
        for (MovieEntity entity : moviesEntity) {
            dto = new MovieDTO();
            dto.setGenre(entity.getGenre());
            dto.setGenreId(entity.getGenreId());
            dto.setName(entity.getName());
            dto.setToWatch(entity.isToWatch());
            dto.setWatched(entity.getWatched());
            moviesDTO.add(dto);
        }
        return moviesDTO;
    }

}
