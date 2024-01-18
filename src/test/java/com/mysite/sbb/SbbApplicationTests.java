package com.mysite.sbb;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testJpa() {
        Question q1 = new Question();
        q1.setSubject("sbb는 무엇인가요?");
        q1.setContent("sbb에 대해 알고싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("sbb2는 무엇인가요?");
        q2.setContent("sbb2에 대해 알고싶습니다.");
        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2);
    }

    @Test
    void testFindAllJpa() {
        List<Question> questionList = this.questionRepository.findAll();
        assertEquals(2, questionList.size());

        Question question = questionList.get(0);
        assertEquals("sbb는 무엇인가요?", question.getSubject());
    }

    @Test
    void testFindOneJpa() {
        Optional<Question> question = this.questionRepository.findById(1);

        if (question.isPresent()) {
            Question q = question.get();
            assertEquals("sbb는 무엇인가요?", q.getSubject());
        }
    }

    @Test
    void testFindBySubject() {
        Question question = this.questionRepository.findBySubject("sbb는 무엇인가요?");

        assertEquals(1, question.getId());
    }

    @Test
    void testFindBySubjectAndCotent(){
        List<Question> questionList = this.questionRepository.findBySubjectLike("%sbb%");
        Question question = questionList.get(0);
        assertEquals("sbb는 무엇인가요?", question.getSubject());
    }

    @Test
    void testUpdate(){
        Optional<Question> question = this.questionRepository.findById(1);
        assertTrue(question.isPresent());

        Question q = question.get();
        q.setSubject("sdd는");
        this.questionRepository.save(q);
    }

    @Test
    void testDelete(){
        assertEquals(2,this.questionRepository.count());
        Optional<Question> question = this.questionRepository.findById(7);
        assertTrue(question.isPresent());

        Question q = question.get();
        this.questionRepository.delete(q);
        assertEquals(1,this.questionRepository.count());
    }

    @Transactional
    @Test
    void knowDifferentLazyAndEager(){
        Optional<Question> question = this.questionRepository.findById(8);
        assertTrue(question.isPresent());
        Question q = question.get();

        List<Answer> answerList = q.getAnswerList();
        assertEquals(1, answerList.size());
        assertEquals("answer Content test", answerList.get(0).getContent());
    }
}
