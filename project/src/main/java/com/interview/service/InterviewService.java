package com.interview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.exception.NoLevelFoundException;
import com.interview.model.Interview;
import com.interview.repository.InterviewRepository;

import jakarta.validation.Valid;

@Service
public class InterviewService {

	@Autowired
	private InterviewRepository interviewRepository;

	public Interview addNewQuestion(@Valid Interview interview) {
		Interview intr=interviewRepository.save(interview);
		return intr;
	}

	public List<Interview> getQuestionByLevel(Integer levelId) throws NoLevelFoundException{
		List<Interview> iList=interviewRepository.findBylevel(levelId);
		if(iList.isEmpty()) {
		throw new NoLevelFoundException("No Level found With the given Value");
		}
		return iList;
	}
	
	
}
