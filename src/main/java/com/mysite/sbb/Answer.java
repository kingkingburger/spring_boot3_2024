package com.mysite.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length=200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private Question question;
}
