package com.donatedrop.configs;


import org.springframework.context.ApplicationContext;

public interface SpringApplicationContextInterface 
{
//    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("gobeshonabdSpringBeans.xml");
    ApplicationContext applicationContext = SpringContextSingletron.getApplicationContext();
            
    
}
