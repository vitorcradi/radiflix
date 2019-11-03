package br.com.radiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.radiflix.model.LikeEntity;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Integer> {

}

