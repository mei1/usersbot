package org.qimei.usersbot.listeners;

import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.qimei.usersbot.db.UsersDBManager;

public class UserContextListener implements ServletContextListener {

	private static Logger logger = Logger.getLogger(UserContextListener.class);
	private static final String JNDI_USERSBOT_DB = "java:comp/env/jdbc/usersbotDb";

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			UsersDBManager.getInstance().initDbConnection(JNDI_USERSBOT_DB, true);
		} catch (SQLException e) {
			logger.error(e, e);
		} catch (NamingException e) {
			logger.error(e, e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}
	
}
