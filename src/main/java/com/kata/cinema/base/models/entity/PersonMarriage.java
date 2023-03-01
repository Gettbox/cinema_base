package com.kata.cinema.base.models.entity;

import liquibase.pro.packaged.J;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "persons_marriage")
@ToString
public class PersonMarriage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perm_seq")
    @SequenceGenerator(name = "perm_seq",
            sequenceName = "perm_sequence",
            initialValue = 1, allocationSize = 1000)
    private Long id;

    @Column(name = "marriageStatus")
    private String marriageStatus;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "human_id")
    private Person human;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonMarriage that = (PersonMarriage) o;
        return id.equals(that.id) && marriageStatus.equals(that.marriageStatus);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
