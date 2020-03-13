package com.donatedrop.articles;

/**
 *
 * @author abedeen
 */
public interface Dao_Article_I 
{
    public Articles post_Article(Articles articles);
    public void delete_Article(Integer articleId);
    public void edit_Article(Articles articles);    
}//ArticlePersistence_I
