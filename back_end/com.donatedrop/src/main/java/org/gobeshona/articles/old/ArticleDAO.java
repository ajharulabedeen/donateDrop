package org.gobeshona.articles.old;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.gobeshona.articles.Articles;
import org.gobeshona.articles.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {

    @PersistenceContext
    private EntityManager entityManager;
//added : 
//    @Autowired
//    DataSource dataSource;

    @Autowired
    Article_I_CRUD_Repo articleRepository;
//added :     

    @Override
    public Articles getArticleById(int articleId) {
        return entityManager.find(Articles.class, articleId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List getAllArticles() {
        System.out.println("GetAll Articles working!");
        String hql = "FROM Article as atcl ORDER BY atcl.articleId";
        String nativeSql = "SELECT articles.category, articles.title FROM articles";
//        System.out.println("\n nativeSql:" + nativeSql + "\n");
//        List al = new ArrayList();
//        List l = entityManager.createNativeQuery(nativeSql).getResultList();
//        for (int i = 0; i < l.size(); i++)
//          {
//            Object[] obects = (Object[]) l.get(i);
//            Map m = new HashMap();
//            m.put("catagory", obects[0]);
//            m.put("title", obects[1]);
//            al.add(m);
//          }
//        return al;
        System.out.println("entityManager : " + entityManager);
        return (List<Articles>) entityManager.createQuery(hql).getResultList();
//        return (List<Article>) entityManager.createNativeQuery(nativeSql).getResultList();

//start : added
//            System.out.println("Alhumdulilah...CruD REPO...!");
//        return articleRepository.findAll();
//end   : added
    }

    @Override
    public void addArticle(Articles article) {
        entityManager.persist(article);
    }

    @Override
    public void updateArticle(Articles article) {
        Articles artcl = getArticleById(article.getArticleId());
//        artcl.setTitle(article.getTitle());
//        artcl.setCategory(article.getCategory());
        entityManager.flush();
    }

    @Override
    public void deleteArticle(int articleId) {
        entityManager.remove(getArticleById(articleId));
    }

    @Override
    public boolean articleExists(String title, String category) {
        String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
        int count = entityManager.createQuery(hql).setParameter(1, title).setParameter(2, category).getResultList().size();
        return count > 0 ? true : false;
    }
}
