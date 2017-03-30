package org.qimei.usersbot.svc;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.qimei.usersbot.db.UsersDBHelper;
import org.qimei.usersbot.pojo.User;
import org.qimei.usersbot.pojo.UserInputs;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UsersSvc {

	private static final Logger logger = Logger.getLogger(UsersSvc.class);

	@RequestMapping(value = "insertuserdata", method = RequestMethod.POST, produces = "application/json")
	public int insertIntoUser(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Insert into emp request");
		return UsersDBHelper.getInstance().insertIntoUsers(userInputs.getUser());
	}

	@RequestMapping(value = "alluser", method = RequestMethod.GET, produces = "application/json")
	public List<User> getAllEmp() throws SQLException {
		logger.info("All user request");
		return UsersDBHelper.getInstance().getAllUsersFromDB();
	}

	@RequestMapping(value = "userbyid", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public List<User> getUserById(@RequestBody User userIdObj) throws JSONException, SQLException {
		logger.info("All user request by ID - " + userIdObj);
		return UsersDBHelper.getInstance().getUserById((UUID) userIdObj.getId());
	}

	@RequestMapping(value = "updateuser", method = RequestMethod.POST, produces = "application/json")
	public int updateUserById(@RequestBody UserInputs userInputs) throws SQLException {
		logger.info("Update user request");
		return UsersDBHelper.getInstance().updateUserById(userInputs.getUser().getId(), userInputs.getColumnName(),
				userInputs.getColumnValue());
	}

}
