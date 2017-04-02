package org.qimei.usersbot.svc;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.qimei.usersbot.db.UsersDBHelper;
import org.qimei.usersbot.pojo.User;
import org.qimei.usersbot.pojo.UserInputs;
import org.qimei.usersbot.pojo.UserLoginHistory;
import org.qimei.usersbot.pojo.UserNewsPreferences;
import org.qimei.usersbot.pojo.UserPreferences;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UsersSvc {

	private static final Logger logger = Logger.getLogger(UsersSvc.class);

	@RequestMapping(value = "insertuserdata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoUser(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Insert into user request");
		return UsersDBHelper.getInstance().insertIntoUsers(userInputs.getUser());
	}

	@RequestMapping(value = "insertuserloginhistorydata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoUserLoginHistory(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Insert into user login history request");
		return UsersDBHelper.getInstance().insertIntoUserLoginHistory(userInputs.getUserLoginHistory());
	}

	@RequestMapping(value = "insertusernewspreferencesdata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoUserNewsPreferences(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Insert into user news preferences request");
		return UsersDBHelper.getInstance().insertIntoUserNewsPreferences(userInputs.getUserNewsPreferences());
	}

	@RequestMapping(value = "insertuserpreferencesdata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoUserPreferences(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Insert into user preferences request");
		return UsersDBHelper.getInstance().insertIntoUserPreferences(userInputs.getUserPreferences());
	}

	@RequestMapping(value = "alluser", method = RequestMethod.GET, produces = "application/json")
	public List<User> getAllUser() throws SQLException {
		logger.info("All user request");
		return UsersDBHelper.getInstance().getAllUsersFromDB();
	}

	@RequestMapping(value = "alluserloginhistory", method = RequestMethod.GET, produces = "application/json")
	public List<UserLoginHistory> getAllUserLoginHistory() throws SQLException {
		logger.info("All user login history request");
		return UsersDBHelper.getInstance().getAllUserLoginHistoryFromDB();
	}

	@RequestMapping(value = "allusernewspreferences", method = RequestMethod.GET, produces = "application/json")
	public List<UserNewsPreferences> getAllUserNewsPreferences() throws SQLException {
		logger.info("All user news preferences request");
		return UsersDBHelper.getInstance().getAllUserNewsPreferencesFromDB();
	}

	@RequestMapping(value = "alluserpreferences", method = RequestMethod.GET, produces = "application/json")
	public List<UserPreferences> getAllUserPreferences() throws SQLException {
		logger.info("All user preferences request");
		return UsersDBHelper.getInstance().getAllUserPreferencesFromDB();
	}

	@RequestMapping(value = "userbyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<User> getUserById(@RequestBody User userIdObj) throws JSONException, SQLException {
		logger.info("All user request by ID - " + userIdObj);
		return UsersDBHelper.getInstance().getUserById((UUID) userIdObj.getId());
	}

	@RequestMapping(value = "userloginhistorybyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<UserLoginHistory> getUserLoginHistoryById(@RequestBody User userIdObj)
			throws JSONException, SQLException {
		logger.info("All user login history request by ID - " + userIdObj);
		return UsersDBHelper.getInstance().getUserLoginHistoryById((UUID) userIdObj.getId());
	}

	@RequestMapping(value = "usernewspreferencesbyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<UserNewsPreferences> getUserNewsPreferencesById(@RequestBody User userIdObj)
			throws JSONException, SQLException {
		logger.info("All user login history request by ID - " + userIdObj);
		return UsersDBHelper.getInstance().getUserNewsPreferencesById((UUID) userIdObj.getId());
	}

	@RequestMapping(value = "userpreferencesbyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<UserPreferences> getUserPreferencesById(@RequestBody User userIdObj)
			throws JSONException, SQLException {
		logger.info("All user login history request by ID - " + userIdObj);
		return UsersDBHelper.getInstance().getUserPreferencesById((UUID) userIdObj.getId());
	}

	@RequestMapping(value = "updateuser", method = RequestMethod.POST, produces = "application/json")
	public int updateUserById(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Update user request");
		return UsersDBHelper.getInstance().updateUserById(userInputs.getUser().getId(), userInputs.getColumnName(),
				userInputs.getColumnValue());
	}

	@RequestMapping(value = "updateuserloginhistory", method = RequestMethod.POST, produces = "application/json")
	public int updateUserLoginHistoryById(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Update user login history request");
		return UsersDBHelper.getInstance().updateUserLoginHistoryById(
				userInputs.getUserLoginHistory().getUser().getId(), userInputs.getColumnName(),
				userInputs.getColumnValue());
	}

	@RequestMapping(value = "updateusernewspreferences", method = RequestMethod.POST, produces = "application/json")
	public int updateUserNewsPreferencesById(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Update user news preferences request");
		return UsersDBHelper.getInstance().updateUserNewsPreferencesById(
				userInputs.getUserNewsPreferences().getUser().getId(), userInputs.getColumnName(),
				userInputs.getColumnValue());
	}
	
	@RequestMapping(value = "updateuserpreferences", method = RequestMethod.POST, produces = "application/json")
	public int updateUserPreferencesById(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Update user preferences request");
		return UsersDBHelper.getInstance().updateUserPreferencesById(
				userInputs.getUserPreferences().getUser().getId(), userInputs.getColumnName(),
				userInputs.getColumnValue());
	}

}
