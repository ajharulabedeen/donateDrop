package com.donatedrop.configs;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactorySingletron
    {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory()
        {
        return sessionFactory;
        }    
//    Not understood why get them into static block  
    {
        try
          {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
          } 
        catch (Exception e)
          {
            System.out.println("\nProblem in creating : sessionFactory \n");
            e.printStackTrace();
            System.out.println("\n\n");
          }
      }

    }
