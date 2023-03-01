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
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JoinColumn(name = "news_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private News news;

    @Column(name = "position")
    private Integer position;

    @Column(name = "question")
    private String question;
}
