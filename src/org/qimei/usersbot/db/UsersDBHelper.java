package org.qimei.usersbot.db;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.qimei.usersbot.pojo.User;
import org.qimei.usersbot.pojo.UserLoginHistory;
import org.qimei.usersbot.pojo.UserNewsPreferences;
import org.qimei.usersbot.pojo.UserPreferences;

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
	
	public int insertIntoUserLoginHistory(UserLoginHistory userLoginHistory) throws SQLException {
		int rowCount = UsersDBManager.getInstance().getUserLoginHistoryDao().create(userLoginHistory);

		return rowCount;
	}
	
	public int insertIntoUserNewsPreferences(UserNewsPreferences userNewsPreferences) throws SQLException {
		int rowCount = UsersDBManager.getInstance().getUserNewsPreferencesDao().create(userNewsPreferences);

		return rowCount;
	}
	
	public int insertIntoUserPreferences(UserPreferences userPreferences) throws SQLException {
		int rowCount = UsersDBManager.getInstance().getUserPreferencesDao().create(userPreferences);

		return rowCount;
	}

	public int updateUserById(UUID id, String columnName, Object columnValue) throws SQLException {

		UpdateBuilder<User, Object> updateBuilder = UsersDBManager.getInstance().getUserDao().updateBuilder();
		updateBuilder.updateColumnValue(columnName, columnValue);
		updateBuilder.where().eq("id", id);
		return updateBuilder.update();

	}
	
	public int updateUserLoginHistoryById(UUID id, String columnName, Object columnValue) throws SQLException {

		UpdateBuilder<UserLoginHistory, Object> updateBuilder = UsersDBManager.getInstance().getUserLoginHistoryDao().updateBuilder();
		updateBuilder.updateColumnValue(columnName, columnValue);
		updateBuilder.where().eq("id", id);
		return updateBuilder.update();

	}
	
	public int updateUserNewsPreferencesById(UUID id, String columnName, Object columnValue) throws SQLException {

		UpdateBuilder<UserNewsPreferences, Object> updateBuilder = UsersDBManager.getInstance().getUserNewsPreferencesDao().updateBuilder();
		updateBuilder.updateColumnValue(columnName, columnValue);
		updateBuilder.where().eq("id", id);
		return updateBuilder.update();

	}
	
	public int updateUserPreferencesById(UUID id, String columnName, Object columnValue) throws SQLException {

		UpdateBuilder<UserPreferences, Object> updateBuilder = UsersDBManager.getInstance().getUserPreferencesDao().updateBuilder();
		updateBuilder.updateColumnValue(columnName, columnValue);
		updateBuilder.where().eq("id", id);
		return updateBuilder.update();

	}
	
	public List<User> getAllUsersFromDB() throws SQLException {
		return UsersDBManager.getInstance().getUserDao().queryForAll();
	}
	
	public List<UserLoginHistory> getAllUserLoginHistoryFromDB() throws SQLException {
		return UsersDBManager.getInstance().getUserLoginHistoryDao().queryForAll();
	}
	
	public List<UserNewsPreferences> getAllUserNewsPreferencesFromDB() throws SQLException {
		return UsersDBManager.getInstance().getUserNewsPreferencesDao().queryForAll();
	}
	
	public List<UserPreferences> getAllUserPreferencesFromDB() throws SQLException {
		return UsersDBManager.getInstance().getUserPreferencesDao().queryForAll();
	}
	
	public List<User> getUserById(UUID id) throws SQLException {
		return UsersDBManager.getInstance().getUserDao().queryForEq("id", id);
	}
	
	public List<UserLoginHistory> getUserLoginHistoryById(UUID id) throws SQLException {
		return UsersDBManager.getInstance().getUserLoginHistoryDao().queryForEq("id", id);
	}
	
	public List<UserNewsPreferences> getUserNewsPreferencesById(UUID id) throws SQLException {
		return UsersDBManager.getInstance().getUserNewsPreferencesDao().queryForEq("id", id);
	}
	
	public List<UserPreferences> getUserPreferencesById(UUID id) throws SQLException {
		return UsersDBManager.getInstance().getUserPreferencesDao().queryForEq("id", id);
	}
	
}
