package com.example.projectend3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionRepository2 questionRepository2;

    // ดึงคำถามทั้งหมด
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // ดึงคำถามภาษาอังกฤษ (จาก questions2)
    @GetMapping("/questions2")
    public List<Question2> getEnglishQuestions() {
        try {
            return questionRepository2.findRandom10(); // ดึงคำถามแบบสุ่ม 10 ข้อ
        } catch (Exception e) {
            System.out.println("Error fetching English questions: " + e.getMessage());
            return new ArrayList<>(); // คืนค่าลิสต์ว่างหากมีข้อผิดพลาด
        }
    }

    // ดึงคำถามโดย ID
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Optional<Question> question = questionService.getQuestionById(id);
        if (question.isPresent()) {
            return ResponseEntity.ok(question.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // เพิ่มคำถามใหม่
    @PostMapping
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    // ตรวจสอบคำตอบ
    @PostMapping("/check/{id}")
    public ResponseEntity<String> checkAnswer(@PathVariable Long id, @RequestBody int selectedAnswer) {
        boolean isCorrect = questionService.checkAnswer(id, selectedAnswer);
        if (isCorrect) {
            return ResponseEntity.ok("Correct answer!");
        } else {
            return ResponseEntity.ok("Incorrect answer. Try again.");
        }
    }
}
