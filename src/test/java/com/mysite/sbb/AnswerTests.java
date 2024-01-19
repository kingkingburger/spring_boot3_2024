package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AnswerTests {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    public void testJpa(){
        Optional<Question> question = this.questionRepository.findById(8);
        assertTrue(question.isPresent());
        Question q = question.get();

        Answer a = new Answer();
        a.setContent("answer Content test");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());

//        this.answerRepository.save(a);
    }

    @Test
    public void testFindQuestionIdByAnswer() {
        Optional<Answer> answer = this.answerRepository.findById(1);
        assertTrue(answer.isPresent());
        Answer a = answer.get();
        assertEquals(8, a.getQuestion().getId());
    }

}
