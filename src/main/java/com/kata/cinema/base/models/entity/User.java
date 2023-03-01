package com.kata.cinema.base.models.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "us_seq")
    @SequenceGenerator(name = "us_seq",
            sequenceName = "us_sequence",
            initialValue = 1, allocationSize = 3000)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
              joinColumns = {@JoinColumn(name = "user_id")},
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id.equals(that.id) && email.equals(that.email) && firstName.equals(that.firstName) && lastName.equals(that.lastName)
                && password.equals(that.password) && birthday.equals(that.birthday);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
