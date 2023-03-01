package com.kata.cinema.base.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "awards")
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aw_seq")
    @SequenceGenerator(name = "aw_seq",
            sequenceName = "aw_sequence",
            initialValue = 1, allocationSize = 20)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Award that = (Award) o;
        return id.equals(that.id) && name.equals(that.name) && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
