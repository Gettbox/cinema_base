package com.kata.cinema.base.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "nomination")
public class Nomination {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nom_seq")
    @SequenceGenerator(name = "nom_seq",
            sequenceName = "nom_sequence",
            initialValue = 1, allocationSize = 60)
    private Long id;

    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nomination that = (Nomination) o;
        return id.equals(that.id) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
