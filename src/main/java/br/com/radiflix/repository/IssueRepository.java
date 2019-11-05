package br.com.radiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.radiflix.model.IssueEntity;

@Repository
public interface IssueRepository extends JpaRepository<IssueEntity, Integer> {

}

