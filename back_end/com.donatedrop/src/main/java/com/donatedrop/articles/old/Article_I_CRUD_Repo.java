/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donatedrop.articles.old;

import com.donatedrop.articles.Articles;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Dell-3460
 */
public interface Article_I_CRUD_Repo extends CrudRepository<Articles, Long>
    {
        List<Articles> findAll();
    }
