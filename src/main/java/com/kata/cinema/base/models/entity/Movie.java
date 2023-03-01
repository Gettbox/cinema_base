package com.kata.cinema.base.models.entity;

import com.kata.cinema.base.models.enums.MPAA;
import com.kata.cinema.base.models.enums.RARS;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "m_seq")
    @SequenceGenerator(name = "m_seq",
            sequenceName = "m_sequence",
            initialValue = 1, allocationSize = 5000)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "countries")
    private String countries;

    @Column(name = "data_release")
    private LocalDate dataRelease;

    @Column(name = "rars")
    @Enumerated(EnumType.STRING)
    private RARS rars;

    @Column(name = "mpaa")
    @Enumerated(EnumType.STRING)
    private MPAA mpaa;

    @Column(name = "time")
    private String time;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "description")
    private String description;

    @Column(name = "original_name")
    private String originName;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    @ToString.Exclude
    @ManyToMany(mappedBy = "movies")
    private Set<FolderMovie> folderMovies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie that = (Movie) o;
        return id.equals(that.id) && name.equals(that.name)
                && description.equals(that.description) && countries.equals(that.countries) && dataRelease.equals(that.dataRelease) &&
                rars.equals(that.rars) && mpaa.equals(that.mpaa) && time.equals(that.time) && originName.equals(that.originName);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

