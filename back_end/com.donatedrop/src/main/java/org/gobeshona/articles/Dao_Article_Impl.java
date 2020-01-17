package org.gobeshona.articles;

import org.gobeshona.articles.Articles;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
/**
 *
 * @author abedeen
 */
@Component
@org.springframework.transaction.annotation.Transactional
@Repository
public class Dao_Article_Impl implements Dao_Article_I 
{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Articles post_Article(Articles articles)
    {
        System.out.println("articles : " + articles.toString());
        entityManager.persist(articles);
        return articles;
    }

    @Override
    public void delete_Article(Integer articleId) 
    {
        entityManager.remove(entityManager.find(Articles.class,articleId));
    }

    @Override
    public void edit_Article(Articles articles) 
    {
        entityManager.merge(articles);
    }
    
}//ArticlePrsistence_Impl
