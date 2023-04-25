package pl.gambeat007.blog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class ArticleDto {

    private Long id;
    private Date publishedAt;
    private String title;
    private String body;
    private double averageRating;
    private List<ReviewDto> reviews;

    public static ArticleDto map(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .publishedAt(article.getPublishedAt())
                .title(article.getTitle())
                .body(article.getBody())
                .averageRating(article.getAverageRating())
                .reviews((article.getReviews() == null) ? null : article.getReviews().stream()
                        .map(ReviewDto::map)
                        .collect(Collectors.toList()))
                .build();
    }

}
