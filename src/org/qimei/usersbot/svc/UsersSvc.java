package org.qimei.usersbot.svc;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.qimei.usersbot.db.UsersDBHelper;
import org.qimei.usersbot.pojo.User;
import org.qimei.usersbot.pojo.UserActivities;
import org.qimei.usersbot.pojo.UserInputs;
import org.qimei.usersbot.pojo.UserLoginHistory;
import org.qimei.usersbot.pojo.UserNewsSourcesPreferences;
import org.qimei.usersbot.pojo.UserPreferences;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

	@RequestMapping(value = "insertuseractivitiesdata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoUserActivities(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Insert into user activities request");
		return UsersDBHelper.getInstance().insertIntoUserActivities(userInputs.getUserActivities());
	}

	@RequestMapping(value = "insertuserpreferencesdata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoUserPreferences(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Insert into user preferences request");
		return UsersDBHelper.getInstance().insertIntoUserPreferences(userInputs.getUserPreferences());
	}
	
	@RequestMapping(value = "insertusernewssourcespreferencesdata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoUserNewsSourcesPreferences(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Insert into user news sources preferences request");
		return UsersDBHelper.getInstance().intertIntoUserNewsSourcesPreferences(userInputs.getUserNewsSourcesPreferences());
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

	@RequestMapping(value = "alluseractivities", method = RequestMethod.GET, produces = "application/json")
	public List<UserActivities> getAllUserActivities() throws SQLException {
		logger.info("All user activities request");
		return UsersDBHelper.getInstance().getAllUserActivitiesFromDB();
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

	@RequestMapping(value = "useractivitiesbyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<UserActivities> getUserNewsPreferencesById(@RequestBody User userIdObj)
			throws JSONException, SQLException {
		logger.info("All user activities request by ID - " + userIdObj);
		return UsersDBHelper.getInstance().getUserActivitiesById((UUID) userIdObj.getId());
	}

	@RequestMapping(value = "userpreferencesbyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<UserPreferences> getUserPreferencesById(@RequestBody User userIdObj)
			throws JSONException, SQLException {
		logger.info("All user preferences request by ID - " + userIdObj);
		return UsersDBHelper.getInstance().getUserPreferencesById((UUID) userIdObj.getId());
	}
	
	@RequestMapping(value = "usernewssourcespreferencesbyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<UserNewsSourcesPreferences> getUserNewsSourcesPreferencesById(@RequestBody User userIdObj)
			throws JSONException, SQLException {
		logger.info("All user news sources preferences request by ID - " + userIdObj);
		return UsersDBHelper.getInstance().getUserNewsSourcesPreferencesById((UUID) userIdObj.getId());
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

	@RequestMapping(value = "updateuseractivities", method = RequestMethod.POST, produces = "application/json")
	public int updateUserActivitiesById(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Update user activities request");
		return UsersDBHelper.getInstance().updateUserActivitiesById(
				userInputs.getUserActivities().getUser().getId(), userInputs.getColumnName(),
				userInputs.getColumnValue());
	}
	
	@RequestMapping(value = "updateuserpreferences", method = RequestMethod.POST, produces = "application/json")
	public int updateUserPreferencesById(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Update user preferences request");
		return UsersDBHelper.getInstance().updateUserPreferencesById(
				userInputs.getUserPreferences().getUser().getId(), userInputs.getColumnName(),
				userInputs.getColumnValue());
	}
	
	@RequestMapping(value = "updateusernewssourcespreferences", method = RequestMethod.POST, produces = "application/json")
	public int updateUserNewsSourcesPreferencesById(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Update user news sources preferences request");
		return UsersDBHelper.getInstance().updateUserNewsSourcesPreferencesById(
				userInputs.getUserNewsSourcesPreferences().getUser().getId(), userInputs.getColumnName(),
				userInputs.getColumnValue());
	}

}
