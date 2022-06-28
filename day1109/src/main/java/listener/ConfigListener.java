package listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import util.DBConnect;


@WebListener
public class ConfigListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    //ServletContext 자원 관리하는 객체
    public void contextInitialized(ServletContextEvent sce)  { 
    	DBConnect.getInstance();
    	/*
    	Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			Connection conn = ds.getConnection();
			
			ServletContext sc=sce.getServletContext();
			sc.setAttribute("oracleDB", conn);
			
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		*/
		
    }
	
}