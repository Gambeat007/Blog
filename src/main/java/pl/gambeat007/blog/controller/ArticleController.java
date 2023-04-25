package pl.gambeat007.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gambeat007.blog.model.Article;
import pl.gambeat007.blog.model.ArticleDto;
import pl.gambeat007.blog.model.ReviewDto;
import pl.gambeat007.blog.service.ArticleService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/v1/articles/all")
    public ResponseEntity<Page<ArticleDto>> getAllArticles(@RequestParam int page) {
        try {
            return ResponseEntity.ok(articleService.getAllArticles(page));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/v1/articles/{id}/reviews")
    public ResponseEntity<Optional<Article>> getArticleReviews(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(articleService.getArticleReviews(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/v1/articles/archive")
    public ResponseEntity<List<String>> getBlogArchive() {
        try {
            return ResponseEntity.ok(articleService.getBlogArchive());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/v1/articles/add")
    public ResponseEntity<ArticleDto> addNewArticle(@RequestBody ArticleDto articleDto) {
        try {
            articleService.addNewArticle(articleDto);
            articleService.saveArticleToFile(articleDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/v1/articles/{id}/reviews")
    public ResponseEntity<ArticleDto> addNewReview(@PathVariable("id") long id, @RequestBody ReviewDto reviewDto) {
        try {
            articleService.addNewReview(id, reviewDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("v1/articles/{id}/reviews")
    public ResponseEntity<String> deleteReview(@PathVariable("id") Long articleId) {
        try {
            articleService.deleteReview(articleId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("No reviews found.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
