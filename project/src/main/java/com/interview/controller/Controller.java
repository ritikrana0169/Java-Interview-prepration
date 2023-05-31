package com.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.model.Interview;
import com.interview.service.InterviewService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@CrossOrigin
@RestController
public class Controller {
    @Autowired
	private InterviewService interviewService;
	
	@PostMapping("/questions")
	public ResponseEntity<Interview> addNewQuestionHandler(@RequestBody @Valid Interview intrv){
		Interview intr=interviewService.addNewQuestion(intrv);
		return new ResponseEntity<>(intr,HttpStatus.CREATED);
	}
	
	@GetMapping("/questions/{levelId}")
	public ResponseEntity<List<Interview>> getQuestionByLevelHandler(@PathVariable Integer levelId){
		List<Interview> iList=interviewService.getQuestionByLevel(levelId);
		return new ResponseEntity<>(iList,HttpStatus.OK);
	}
	
}
