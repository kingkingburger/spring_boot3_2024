package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
//    Question findBySubject(String subject);
//    Question findBySubjectAndContent(String subject, String content);
//    List<Question> findBySubjectLike(String subject);
}
