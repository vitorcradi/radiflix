package br.com.radiflix.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.radiflix.model.IssueDTO;
import br.com.radiflix.service.IssueService;

@RestController
public class IssueController {
	@Autowired
	private IssueService issueService;

	@ResponseBody
	@RequestMapping(value = "/issue", method = POST)
	public void inputFavorito(@RequestBody IssueDTO issue) throws ConstraintViolationException {
		issueService.submitIssue(issue);
	}
}
