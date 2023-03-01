package com.kata.cinema.base.models.entity;
import com.kata.cinema.base.models.enums.Privacy;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "folders_persons")
public class FolderPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fp_seq")
    @SequenceGenerator(name = "fp_seq",
            sequenceName = "fp_sequence",
            initialValue = 1, allocationSize = 1000)
    private Long id;

    @Column(name = "favourites")
    private boolean favourites;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "privacy")
    @Enumerated(EnumType.STRING)
    private Privacy privacy;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FolderPerson that = (FolderPerson) o;
        return id.equals(that.id) && name.equals(that.name) && description.equals(that.description) && privacy.equals(that.privacy);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
