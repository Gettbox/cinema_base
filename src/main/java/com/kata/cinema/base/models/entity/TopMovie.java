package com.kata.cinema.base.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "top_movies")
public class TopMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, optional = false)
    @MapsId
    private Movie movie;

    @Column(name = "rating")
    private Integer rating;
}

