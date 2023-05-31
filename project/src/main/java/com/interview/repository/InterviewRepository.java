package com.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.model.Interview;
@Repository
public interface InterviewRepository extends JpaRepository<Interview,Integer>{

	public List<Interview> findBylevel(Integer id);
}
