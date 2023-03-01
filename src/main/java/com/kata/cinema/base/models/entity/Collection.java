package com.kata.cinema.base.models.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "collections")
@ToString
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "col_seq")
    @SequenceGenerator(name = "col_seq",
            sequenceName = "col_sequence",
            initialValue = 1, allocationSize = 1000)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "enable")
    private Boolean enable;

    public Collection(String name, Boolean enable) {
        this.name = name;
        this.enable = enable;
    }

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "collections_movies",
            joinColumns = @JoinColumn(name = "collections_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movies_id", referencedColumnName = "id"))
    @ToString.Exclude
    private Set<Movie> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection that = (Collection) o;
        return id.equals(that.id) && name.equals(that.name) && enable.equals(that.enable);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}