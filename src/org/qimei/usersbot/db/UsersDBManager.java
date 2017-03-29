package org.qimei.usersbot.db;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.qimei.usersbot.pojo.User;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.SqliteDatabaseType;
import com.j256.ormlite.jdbc.DataSourceConnectionSource;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class UsersDBManager {

	private static UsersDBManager dbManager;
	private static Dao<User, Object> userDao;
	private static ConnectionSource connectionSource;

	private UsersDBManager() {
		super();
	}

	public static UsersDBManager getInstance() {
		if (null == dbManager) {
			dbManager = new UsersDBManager();
		}

		return dbManager;
	}

	public void initDbConnection(String jndiString, boolean isJndi) throws SQLException, NamingException {

		if (isJndi) {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup(jndiString);
			connectionSource = new DataSourceConnectionSource(dataSource, new SqliteDatabaseType());
		} else {
			connectionSource = new JdbcConnectionSource(jndiString);
		}

		initDaoAndTables();
	}

	private void initDaoAndTables() throws SQLException {
		dbManager.createDaoObjects();
		dbManager.createTablesIfNotExist();
	}

	private void createDaoObjects() throws SQLException {
		userDao = DaoManager.createDao(connectionSource, User.class);
	}

	private void createTablesIfNotExist() throws SQLException {
		TableUtils.createTableIfNotExists(connectionSource, User.class);
	}

	public Dao<User, Object> getUserDao() {
		return userDao;
	}
}
