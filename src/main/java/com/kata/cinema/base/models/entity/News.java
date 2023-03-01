package com.kata.cinema.base.models.entity;

import com.kata.cinema.base.models.enums.Rubric;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "news")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "n_seq")
    @SequenceGenerator(name = "n_seq",
            sequenceName = "n_sequence",
            initialValue = 1, allocationSize = 5000)
    private Long id;

    @Column(name = "data")
    private String data;

    @Column(name = "title")
    private String title;

    @Column(name = "html_body")
    private String htmlBody;

    @Enumerated(value = EnumType.STRING)
    private Rubric rubric;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News that = (News) o;
        return id.equals(that.id) && data.equals(that.data) && title.equals(that.title) && rubric.equals(that.rubric) && htmlBody.equals(that.htmlBody);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
