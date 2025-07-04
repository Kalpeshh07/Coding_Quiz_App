package com.kalpesh.quiz.controller;

import com.kalpesh.quiz.entity.QuizQuestion;
import com.kalpesh.quiz.service.QuizPackage;
import com.kalpesh.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/{quizPackage}")
    public List<QuizQuestion> getQuestions(@PathVariable QuizPackage quizPackage) {
        System.out.println("Controller called for package: " + quizPackage);
        return quizService.getQuestionsByPackage(quizPackage);
    }

    @GetMapping("/question/{id}")
    public QuizQuestion getQuestionById(@PathVariable Long id) {
        return quizService.getQuestionById(id);
    }

    @PostMapping("/")
    public QuizQuestion createQuestion(@RequestBody QuizQuestion question) {
        return quizService.createQuestion(question);
    }

    @PutMapping("/{id}")
    public QuizQuestion updateQuestion(@PathVariable Long id, @RequestBody QuizQuestion updatedQuestion) {
        return quizService.updateQuestion(id, updatedQuestion);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        quizService.deleteQuestion(id);
    }

    @GetMapping("/")
    public List<QuizQuestion> getAllQuestions() {
        return quizService.getAllQuestions();
    }
    @GetMapping("/random/{quizPackage}/{numberOfQuestions}")
    public List<QuizQuestion> getRandomQuestionsByPackage(@PathVariable QuizPackage quizPackage, @PathVariable int numberOfQuestions) {
        return quizService.getRandomQuestionsByPackage(quizPackage, numberOfQuestions);
    }
}
