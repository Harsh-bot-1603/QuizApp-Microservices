package com.harsh.questionservice.dao;

import com.harsh.questionservice.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDao extends JpaRepository<Questions,Integer> {

    List<Questions> findByCategory(String category);
    @Query(value="Select q.id From questions q where q.category=:category Order By Rand() Limit :numQ",nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category, int numQ);
}
