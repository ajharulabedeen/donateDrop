package org.gobeshona.configs;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public interface SpringApplicationContextInterface 
{
//    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("gobeshonabdSpringBeans.xml");
    ApplicationContext applicationContext = SpringContextSingletron.getApplicationContext();
            
    
}
