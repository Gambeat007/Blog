package pl.gambeat007.blog.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.gambeat007.blog.constant.Constant;
import pl.gambeat007.blog.model.Article;
import pl.gambeat007.blog.model.ArticleDto;
import pl.gambeat007.blog.model.Review;
import pl.gambeat007.blog.model.ReviewDto;
import pl.gambeat007.blog.repository.ArticleRepository;
import pl.gambeat007.blog.repository.ReviewRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ReviewRepository reviewRepository;

    public Page<ArticleDto> getAllArticles(int page) {
        return articleRepository.findAll(PageRequest.of(page, Constant.DefaultBlogPageSize)).map(ArticleDto::map);
    }

    public Optional<Article> getArticleReviews(long id) {
        return articleRepository.findById(id);
    }

    public void addNewArticle(ArticleDto articleDto) {
        articleRepository.save(new Article(articleDto.getPublishedAt(), articleDto.getTitle(), articleDto.getBody(),
                articleDto.getAverageRating()));
    }

    public List<String> getBlogArchive() throws IOException {
        return articleRepository.readArticleFromFile();
    }

    public void addNewReview(long articleId, ReviewDto reviewDto) {
        Article article = articleRepository.getReferenceById(articleId);
        reviewRepository.save(new Review(reviewDto.getPublishedAt(), reviewDto.getBody(), reviewDto.getArticleRating(),
                article));
    }

    public void saveArticleToFile(ArticleDto articleDto) throws IOException {
        articleRepository.saveArticleToFile(articleDto);
    }

    public void deleteReview(Long articleId) {
        Article article = articleRepository.getReferenceById(articleId);
        List<Review> reviews = article.getReviews();
        int lastIndex = reviews.size() - 1;

        reviews.remove(lastIndex);
        articleRepository.save(article);
    }
}
