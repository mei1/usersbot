package org.qimei.usersbot.db;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.qimei.usersbot.pojo.User;

import com.j256.ormlite.stmt.UpdateBuilder;

public class UsersDBHelper {

	private static UsersDBHelper usersDBHelper = null;

	private UsersDBHelper() {
		super();
	}

	public static UsersDBHelper getInstance() {
		if (usersDBHelper == null) {
			usersDBHelper = new UsersDBHelper();
		}
		return usersDBHelper;
	}

	public int insertIntoUsers(User user) throws SQLException {
		int rowCount = UsersDBManager.getInstance().getUserDao().create(user);

		return rowCount;
	}

	public int updateUserById(UUID id, String columnName, Object columnValue) throws SQLException {

		UpdateBuilder<User, Object> updateBuilder = UsersDBManager.getInstance().getUserDao().updateBuilder();
		updateBuilder.updateColumnValue(columnName, columnValue);
		updateBuilder.where().eq("id", id);
		return updateBuilder.update();

	}
	
	public List<User> getAllUsersFromDB() throws SQLException {
		return UsersDBManager.getInstance().getUserDao().queryForAll();
	}
	
	public List<User> getUserById(UUID id) throws SQLException {
		return UsersDBManager.getInstance().getUserDao().queryForEq("id", id);
	}
}
