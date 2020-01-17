/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gobeshona.articles.old;

import org.gobeshona.articles.Articles;
import java.util.List;
import org.gobeshona.articles.Articles;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dell-3460
 */
public interface Article_I_CRUD_Repo extends CrudRepository<Articles, Long>
    {
        List<Articles> findAll();
    }
