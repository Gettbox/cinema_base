package com.kata.cinema.base.models.entity;

import com.kata.cinema.base.models.enums.Type;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "content")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cont_seq")
    @SequenceGenerator(name = "cont_seq",
            sequenceName = "cont_sequence",
            initialValue = 1, allocationSize = 100)
    private Long id;

    @Column(name = "content_url")
    private String contentUrl;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Content that = (Content) o;
        return id.equals(that.id) && type.equals(that.type) && contentUrl.equals(that.contentUrl);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}