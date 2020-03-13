package com.donatedrop.articles.old;

import com.donatedrop.articles.Articles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Service
@Component
@Qualifier("dummyService")
public class DummyArticleService implements IArticleService {

    @Autowired
    private IArticleDAO articleDAO;

    @Override
    public Articles getArticleById(int articleId) {
        Articles obj = articleDAO.getArticleById(articleId);
        return obj;
    }

    @Override
    public List<Articles> getAllArticles() {
        System.out.println("Class Name: " + getClass().toString());
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
        return false;
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
