package br.com.radiflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.radiflix.model.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    List<MovieEntity> findByGenre(String genre);

    @Query(value = "SELECT * FROM movie WHERE detail regexp ?1 OR name regexp ?1", nativeQuery = true)
    List<MovieEntity> findByKeyword(String keyword);
    
    @Query(value = "SELECT * FROM movie WHERE genre = ?1 AND (detail regexp ?2 OR name regexp ?2)", nativeQuery = true)
    List<MovieEntity> findByGenreAndKeyword(String keyword, String genre);
    
    @Query(value = "SELECT * FROM movie WHERE genre_id = ?1 ORDER BY watched DESC", nativeQuery = true)
    List<MovieEntity> findByGenreId(Integer genreId);
}

