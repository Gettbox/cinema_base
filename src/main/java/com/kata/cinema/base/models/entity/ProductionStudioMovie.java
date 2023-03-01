package com.kata.cinema.base.models.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Table(name = "production_studio_movies")
public class ProductionStudioMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movies_id", insertable = false, updatable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "production_studios_id", insertable = false, updatable = false)
    private ProductionStudio studio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studio_performances_id")
    private StudioPerformance performance;
}