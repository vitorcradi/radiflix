package br.com.radiflix.service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.radiflix.model.IssueDTO;
import br.com.radiflix.model.IssueEntity;
import br.com.radiflix.repository.IssueRepository;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    public IssueRepository issueRepository;
    
    @Override
    public void submitIssue(IssueDTO issue) throws ConstraintViolationException {
        IssueEntity issueEntity = new IssueEntity();
        issueEntity.setDescription(issue.getDescription());
        issueEntity.setReason(issue.getReason());
        issueRepository.save(issueEntity);
    }

}
