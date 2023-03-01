package com.kata.cinema.base.models.entity;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "per_seq")
    @SequenceGenerator(name = "per_seq",
            sequenceName = "per_sequence",
            initialValue = 1, allocationSize = 1000)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "height")
    private Double height;

    @Column(name = "date_birth")
    @Type(type = "org.hibernate.type.LocalDateType")
    private LocalDate dateBirth;

    @Column(name = "place_of_birth")
    private String placeBirth;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "person_profession",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "profession_id"))
    private Set<Profession> professions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return id.equals(that.id) && firstName.equals(that.firstName) && lastName.equals(that.lastName) &&
                height.equals(that.height) && dateBirth.equals(that.dateBirth) && placeBirth.equals(that.placeBirth);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
