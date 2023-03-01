package com.kata.cinema.base.models.entity;
import com.kata.cinema.base.models.enums.TypeCharacter;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Embeddable
@ToString
@Table(name = "movie_person")
public class MoviePerson {
    @Getter
    @Setter
    @NoArgsConstructor
    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "person_id")
        private Long personId;

        @Column(name = "movie_id")
        private Long movieId;

        public Id(Long personId, Long movieId) {
            this.personId = personId;
            this.movieId = movieId;
        }
    }
    @EmbeddedId
    private Id id;

    @ToString.Exclude
    @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", insertable = false, updatable = false)
    private Person person;

    @ToString.Exclude
    @ManyToOne(targetEntity = Movie.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", insertable = false, updatable = false)
    private Movie movie;

    @ToString.Exclude
    @ManyToOne(targetEntity = Profession.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "profession_id", insertable = false, updatable = false)
    private Profession professions;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_character")
    private TypeCharacter type;

    @Column(name = "name_role")
    private String nameRole;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviePerson that = (MoviePerson) o;
        return id.equals(that.id) && type.equals(that.type) && nameRole.equals(that.nameRole);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}




