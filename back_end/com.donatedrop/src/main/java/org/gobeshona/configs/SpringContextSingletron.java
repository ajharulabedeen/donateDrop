package org.gobeshona.configs;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextSingletron 
{
    static ApplicationContext applicationContext;
    
    public static ApplicationContext getApplicationContext()
    {
        if(  applicationContext == null )
        {
            applicationContext = new ClassPathXmlApplicationContext("gobeshonabdSpringBeans.xml");
        }
        return applicationContext;
    }
}
