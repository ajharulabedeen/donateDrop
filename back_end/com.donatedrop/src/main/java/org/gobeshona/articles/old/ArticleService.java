package org.gobeshona.articles.old;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.gobeshona.articles.old.IArticleDAO;
import org.gobeshona.articles.Articles;
import org.gobeshona.articles.Articles;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Service
@Component
@Qualifier("realService")
public class ArticleService implements IArticleService {

    @Autowired
    private IArticleDAO articleDAO;

    @Override
    public Articles getArticleById(int articleId) {
        Articles obj = articleDAO.getArticleById(articleId);
        return obj;
    }

    @Override
    public List<Articles> getAllArticles() {
        System.out.println("Class Name: " + getClass().toString() + ".........\n\n");
        return articleDAO.getAllArticles();
    }

    @Override
    public synchronized boolean addArticle(Articles article) {
//        if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
//            return false;
//        } else {
//            articleDAO.addArticle(article);
//            return true;
//        }
        return true;
    }

    @Override
    public void updateArticle(Articles article) {
        articleDAO.updateArticle(article);
    }

    @Override
    public void deleteArticle(int articleId) {
        articleDAO.deleteArticle(articleId);
    }
}
