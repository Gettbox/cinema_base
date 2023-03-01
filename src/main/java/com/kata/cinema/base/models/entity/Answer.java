package com.kata.cinema.base.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JoinColumn(name = "question_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Question question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "is_right")
    private Boolean isRight;
}
