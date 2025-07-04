package com.kalpesh.quiz.repo;

import com.kalpesh.quiz.entity.QuizQuestion;
import com.kalpesh.quiz.service.QuizPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<QuizQuestion, Long> {
    List<QuizQuestion> findByQuizPackage(QuizPackage quizPackage);
}