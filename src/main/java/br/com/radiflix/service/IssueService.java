package br.com.radiflix.service;

import org.hibernate.exception.ConstraintViolationException;

import br.com.radiflix.model.IssueDTO;

public interface IssueService {

	void submitIssue(IssueDTO issue) throws ConstraintViolationException ;

}
