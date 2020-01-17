package org.gobeshona.articles.old;

import java.util.List;
import org.gobeshona.articles.Articles;
import org.gobeshona.articles.Articles;
import org.springframework.data.repository.CrudRepository;

    public interface IArticleDAO 
    {
//    List<Article> getAllArticles();

    List getAllArticles();
    Articles getArticleById(int articleId);
    void addArticle(Articles article);
    void updateArticle(Articles article);
    void deleteArticle(int articleId);
    boolean articleExists(String title, String category);
    }
