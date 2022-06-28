package com.green.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.session.SqlSessionFactory;

import com.green.mybatis.MybatisConfig;

/**
 * Application Life cycle Listener implementation class ConfigListener
 *
 */
@WebListener
public class ConfigListener implements ServletContextListener {
    public ConfigListener() {
        // TODO Auto-generated constructor stub
    }
    public void contextDestroyed(ServletContextEvent sce)  { 
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext application=sce.getServletContext();
    	String path=application.getContextPath();
    	
    	application.setAttribute("ROOT", path);
    	
    	System.out.println("ROOT : "+path);
    	
    }
	
}