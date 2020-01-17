package org.gobeshona.articles.old;

import java.util.Date;
import org.gobeshona.articles.Articles;
import org.gobeshona.articles.old.IArticleService;
import java.util.List;
import org.gobeshona.articles.Articles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("user")
@RequestMapping("test")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @GetMapping("article/{id}")
    public ResponseEntity<Articles> getArticleById(@PathVariable("id") Integer id) {
        System.out.println("Alhumdulilah...!");
        Articles article = articleService.getArticleById(id);
        return new ResponseEntity<Articles>(article, HttpStatus.OK);
    }

    @GetMapping("articles")
    public ResponseEntity<List<Articles>> getAllArticles() {
        List<Articles> list = articleService.getAllArticles();
        return new ResponseEntity<List<Articles>>(list, HttpStatus.OK);
    }

    @PostMapping("article")
    public ResponseEntity<Void> addArticle(@RequestBody Articles article, UriComponentsBuilder builder) {
        boolean flag = articleService.addArticle(article);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PostMapping("article2")
    public String addArticle2(@RequestBody Articles article, UriComponentsBuilder builder) {
        boolean flag = articleService.addArticle(article);
        String done = "";
        if (flag == true) {
            done = "done";
        }
        if (flag == false) {
            done = "fail";
        }
        return done;
    }

    @PutMapping("article")
    public ResponseEntity<Articles> updateArticle(@RequestBody Articles article) {
        articleService.updateArticle(article);
        return new ResponseEntity<Articles>(article, HttpStatus.OK);
    }

    @DeleteMapping("article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

//    Start : Added .......
    @GetMapping("test")
    public String test() {
        return "AllOK!" + new Date().toString();
    }
//    End : Added .......

}
