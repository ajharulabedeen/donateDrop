package com.donatedrop.articles.old;

import java.util.List;

import com.donatedrop.articles.Articles;

public interface IArticleService {
     List<Articles> getAllArticles();
//     List getAllArticles();
     Articles getArticleById(int articleId);
     boolean addArticle(Articles article);
     void updateArticle(Articles article);
     void deleteArticle(int articleId);
}
