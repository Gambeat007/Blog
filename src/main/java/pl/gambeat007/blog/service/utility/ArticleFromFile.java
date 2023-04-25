package pl.gambeat007.blog.service.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArticleFromFile {

    public List<String> readArticleFromFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("BlogArchive.txt"));
        List<String> articles = new ArrayList<>();

        String input;
        while ((input = bufferedReader.readLine()) != null) {
            articles.add(input);
        }
        bufferedReader.close();
        return articles;
    }
}