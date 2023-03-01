package com.kata.cinema.base.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "professions")
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prof_seq")
    @SequenceGenerator(name = "prof_seq",
            sequenceName = "prof_sequence",
            initialValue = 1, allocationSize = 100)
    private Long id;

    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profession that = (Profession) o;
        return id.equals(that.id) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
