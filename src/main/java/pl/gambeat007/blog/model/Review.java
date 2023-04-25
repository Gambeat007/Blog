package pl.gambeat007.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "reviews")
public class Review extends BlogBase {

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "published_at", nullable = false, updatable = false)
    private Date publishedAt;

    @Column(length = 10000, nullable = false)
    private String body;

    @Column(name = "article_rating")
    private double articleRating;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "article", referencedColumnName = "id", nullable = false)
    private Article article;
    
}
