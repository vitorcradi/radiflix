package br.com.radiflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.radiflix.model.FilmEntity;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {

	List<FilmEntity> findByGenre(String genero);
	
}