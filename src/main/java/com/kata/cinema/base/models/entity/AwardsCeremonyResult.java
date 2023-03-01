package com.kata.cinema.base.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "awards_ceremony_result")
public class AwardsCeremonyResult {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "awcr_seq")
    @SequenceGenerator(name = "awcr_seq",
            sequenceName = "awcr_sequence",
            initialValue = 1, allocationSize = 30)
    private Long id;

    @Column(name = "nomination_status")
    private String nominationStatus;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nomination_id")
    private Nomination nomination;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "awards_ceremony_id")
    private AwardsCeremony awardCeremony;

}
