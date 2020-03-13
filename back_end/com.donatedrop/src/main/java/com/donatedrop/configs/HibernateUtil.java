package com.donatedrop.configs;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil
    {
    public static SessionFactory getSessionFactory()
        {        
            SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();        
            return sessionfactory;
        }
    }
