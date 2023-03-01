package com.kata.cinema.base.models.entity;

import com.kata.cinema.base.models.enums.Category;
import com.kata.cinema.base.models.enums.Privacy;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "folders_movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FolderMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fm_seq")
    @SequenceGenerator(name = "fm_seq",
            sequenceName = "fm_sequence",
            initialValue = 1, allocationSize = 1000)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    private Privacy privacy;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "folder_movies_to_movie",
            joinColumns = @JoinColumn(name = "folder_movies_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FolderMovie that = (FolderMovie) o;
        return id.equals(that.id) && name.equals(that.name) && description.equals(that.description) && privacy.equals(that.privacy) && category.equals(that.category);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
