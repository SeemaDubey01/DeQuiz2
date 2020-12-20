package com.dequiz.DeQuiz.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.dequiz.DeQuiz.dto.DeQuizMaster;
@Repository
public interface DeQuizMasterDBRepo extends JpaRepository <DeQuizMaster, Integer>{
	
//	@Transactional
	public List<DeQuizMaster> findByDeqmQuizId(Integer deqmQuizId);
	@Transactional
	@Modifying
	public void deleteByDeqmQuizId(Integer deqmQuizId);
	
	public DeQuizMaster findByDeqmQuizIdAndDeqmQuestionNo(Integer deqmQuizId, Integer deqmQuestionNo );
	
	public List<DeQuizMaster> findByDqlUserId(String dqlUserId); 
	
}
