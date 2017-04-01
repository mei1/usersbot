package test;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.qimei.usersbot.db.UsersDBHelper;
import org.qimei.usersbot.db.UsersDBManager;
import org.qimei.usersbot.pojo.User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDBTests {

	private static final Logger logger = Logger.getLogger(UserDBTests.class);

	UsersDBManager dbManager = null;
	UsersDBHelper dbHelper = null;

	static ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setUp() throws Exception {
		dbManager = UsersDBManager.getInstance();
		dbManager.initDbConnection("jdbc:sqlite:User.db", false);
		dbHelper = UsersDBHelper.getInstance();
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertUsers() throws SQLException {

		User user = new User();
		user.setId(null);
		user.setEmailId("qimei24@gmail.com");
		user.setFbId("1234");
		user.setLastLoginTime(Calendar.getInstance().getTime());
		user.setUserName("Tan Qi Mei");

		int rowCount = dbHelper.insertIntoUsers(user);

		assert (rowCount > 0);
	}
	
	@Test
	public void testGetAllUsersFromDB() throws SQLException, JsonProcessingException {
		List <User> userDatas = dbHelper.getAllUsersFromDB();
		logger.info(mapper.writeValueAsString(userDatas));

		assert (userDatas.size() > 0);
	}
}
