package pl.gambeat007.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gambeat007.blog.model.Article;
import pl.gambeat007.blog.model.ArticleDto;
import pl.gambeat007.blog.service.utility.ArticleFromFile;
import pl.gambeat007.blog.service.utility.ArticleToFile;

import java.io.IOException;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    default void saveArticleToFile(ArticleDto articleDto) throws IOException {
        ArticleToFile articleToFile = new ArticleToFile();
        articleToFile.saveArticleToFile(articleDto);
    }

    default List<String> readArticleFromFile() throws IOException {
        ArticleFromFile articleFromFile = new ArticleFromFile();
        return articleFromFile.readArticleFromFile();
    }

}