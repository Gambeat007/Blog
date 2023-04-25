package pl.gambeat007.blog.service.utility;

import com.google.gson.Gson;
import pl.gambeat007.blog.model.ArticleDto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArticleToFile {

    public void saveArticleToFile(ArticleDto articleDto) throws IOException {
        String jsonArticle = convertArticleToJson(articleDto);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("BlogArchive.txt", true));
        bufferedWriter.write(jsonArticle + "\n");
        bufferedWriter.close();
    }

    private String convertArticleToJson(ArticleDto articleDto) {
        Gson gson = new Gson();
        return gson.toJson(articleDto);
    }
}