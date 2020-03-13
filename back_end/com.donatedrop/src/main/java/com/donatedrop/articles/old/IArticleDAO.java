package com.donatedrop.articles.old;

import java.util.List;

import com.donatedrop.articles.Articles;

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
