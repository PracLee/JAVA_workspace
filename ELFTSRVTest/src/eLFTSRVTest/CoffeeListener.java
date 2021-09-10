package eLFTSRVTest;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class Coffee
 *
 */
@WebListener
public class CoffeeListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CoffeeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        ServletContext context = sce.getServletContext();
        ArrayList<String> coffee = new ArrayList<String>();
        coffee.add("�Ƹ޸�ī��");
        coffee.add("ī���");
        coffee.add("īǪġ��");
        context.setAttribute("coffee", coffee);
    }
	
}
