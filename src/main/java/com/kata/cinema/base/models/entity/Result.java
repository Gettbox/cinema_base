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
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JoinColumn(name = "question_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Question question;

    @Column(name = "count_right_answers")
    private Integer countRightAnswer;

    @Column(name = "results")
    private String result;
}
