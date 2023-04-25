package pl.gambeat007.blog.model;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "articles")
public class Article extends BlogBase {

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "published_at", nullable = false, updatable = false)
    @SerializedName("publishedAt")
    private Date publishedAt;

    @SerializedName("title")
    private String title;

    @Column(length = 50000)
    @SerializedName("body")
    private String body;

    @Transient
    @SerializedName("averageRating")
//    @Formula(value = "SELECT AVG(r.article_rating) FROM reviews r WHERE r.article = :id")
    private double averageRating;

    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @SerializedName("reviews")
    private List<Review> reviews;

    public Article(Date publishedAt, String title, String body, double averageRating) {
        this.publishedAt = publishedAt;
        this.title = title;
        this.body = body;
        this.averageRating = averageRating;
    }

    @PostLoad
    private void postLoad() {
        this.averageRating = this.reviews.stream().mapToDouble(Review::getArticleRating).average().orElse(0.0);
    }

}


