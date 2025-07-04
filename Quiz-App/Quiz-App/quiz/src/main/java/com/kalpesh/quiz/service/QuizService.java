package com.kalpesh.quiz.service;

import com.kalpesh.quiz.entity.QuizQuestion;
import com.kalpesh.quiz.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuestionRepo QuestionRepo;

    public List<QuizQuestion> getQuestionsByPackage(QuizPackage quizPackage) {
        return QuestionRepo.findByQuizPackage(quizPackage);
    }

    public QuizQuestion getQuestionById(Long id) {
        Optional<QuizQuestion> optionalQuestion = QuestionRepo.findById(id);
        return optionalQuestion.orElse(null); // Or throw an exception if you prefer
    }

    public QuizQuestion createQuestion(QuizQuestion question) {
        return QuestionRepo.save(question);
    }

    public QuizQuestion updateQuestion(Long id, QuizQuestion updatedQuestion) {
        if (QuestionRepo.existsById(id)) {
            updatedQuestion.setId(id); // Ensure the ID is set
            return QuestionRepo.save(updatedQuestion);
        }
        return null; // Or throw an exception
    }

    public void deleteQuestion(Long id) {
        QuestionRepo.deleteById(id);
    }

    public List<QuizQuestion> getAllQuestions() {
        return QuestionRepo.findAll();
    }

    public List<QuizQuestion> getRandomQuestionsByPackage(QuizPackage quizPackage, int numberOfQuestions) {
        List<QuizQuestion> allQuestions = QuestionRepo.findByQuizPackage(quizPackage);
        if (allQuestions.size() <= numberOfQuestions) {
            return allQuestions; // Return all if there are not enough questions
        }
        List<QuizQuestion> randomQuestions = new java.util.ArrayList<>();
        java.util.Random random = new java.util.Random();
        while (randomQuestions.size() < numberOfQuestions) {
            int randomIndex = random.nextInt(allQuestions.size());
            QuizQuestion randomQuestion = allQuestions.get(randomIndex);
            if (!randomQuestions.contains(randomQuestion)) {
                randomQuestions.add(randomQuestion);
            }
        }
        return randomQuestions;
    }
}
