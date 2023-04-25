package pl.gambeat007.blog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ReviewDto {

    private Long id;
    private Date publishedAt;
    private String body;
    private double articleRating;
    private Long articleId;

    public static ReviewDto map(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .publishedAt(review.getPublishedAt())
                .body(review.getBody())
                .articleId(review.getArticle().getId())
                .articleRating(review.getArticleRating())
                .build();
    }
}
