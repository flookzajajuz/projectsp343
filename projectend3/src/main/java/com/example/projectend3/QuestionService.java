package com.example.projectend3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    // ฟังก์ชันเพิ่มคำถามใหม่
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    // ฟังก์ชันดึงข้อมูลคำถามทั้งหมด
    public List<Question> getAllQuestions() {
        try {
            return questionRepository.findAll();
        } catch (Exception e) {
            // เพิ่ม log หรือการจับข้อผิดพลาดที่ดีขึ้น
            throw new RuntimeException("Database error while fetching questions", e);
        }
    }

    // ฟังก์ชันดึงคำถามตาม ID
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    // ฟังก์ชันตรวจสอบคำตอบ
    public boolean checkAnswer(Long questionId, int selectedAnswer) {
        Optional<Question> question = questionRepository.findById(questionId);
        if (question.isPresent()) {
            return question.get().getCorrectAnswer() == selectedAnswer;
        }
        return false;
    }
}
