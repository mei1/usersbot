package test;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.qimei.usersbot.db.UsersDBHelper;
import org.qimei.usersbot.db.UsersDBManager;
import org.qimei.usersbot.pojo.User;
import org.qimei.usersbot.pojo.UserLoginHistory;
import org.qimei.usersbot.pojo.UserNewsPreferences;
import org.qimei.usersbot.pojo.UserNewsSourcesPreferences;
import org.qimei.usersbot.pojo.UserPreferences;

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
		dbManager.initDbConnection("jdbc:sqlite:usersbot.db", false);
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
		user.setCreationDate(Calendar.getInstance().getTime());
		user.setUserName("Tan Qi Mei");

		int rowCount = dbHelper.insertIntoUsers(user);

		assert (rowCount > 0);
	}
	
	@Test
	public void testInsertUserLoginHistory() throws SQLException {
		
		User user = new User();
		UserLoginHistory userLoginHistory = new UserLoginHistory();
		user.setId(UUID.fromString("db93d7cc-c171-4a82-b6d0-357611727172"));
		userLoginHistory.setUser(user);
		userLoginHistory.setLastLoginTime(Calendar.getInstance().getTime());
		
		int rowCount = dbHelper.insertIntoUserLoginHistory(userLoginHistory);
		
		assert (rowCount > 0);
	}
	
	@Test
	public void testInsertUserNewsPreferences() throws SQLException {
		
		User user = new User();
		UserNewsPreferences userNewsPreferences = new UserNewsPreferences();
		user.setId(UUID.fromString("db93d7cc-c171-4a82-b6d0-357611727172"));
		userNewsPreferences.setUser(user);
		userNewsPreferences.setArticleId("1231231");
		userNewsPreferences.setViewTime(Calendar.getInstance().getTime());
		
		int rowCount = dbHelper.insertIntoUserNewsPreferences(userNewsPreferences);
		
		assert (rowCount > 0);
	}
	
	@Test
	public void testInsertUserPreferences() throws SQLException {
		
		User user = new User();
		UserPreferences userPreferences = new UserPreferences();
		user.setId(UUID.fromString("db93d7cc-c171-4a82-b6d0-357611727172"));
		userPreferences.setUser(user);
		userPreferences.setUserPreferences("Politics");
		
		int rowCount = dbHelper.insertIntoUserPreferences(userPreferences);
		
		assert (rowCount > 0);
	}
	
	@Test
	public void testInsertUserNewsSourcesPreferences() throws SQLException {
		
		User user = new User();
		UserNewsSourcesPreferences userNewsSourcesPreferences = new UserNewsSourcesPreferences();
		user.setId(UUID.fromString("db93d7cc-c171-4a82-b6d0-357611727172"));
		userNewsSourcesPreferences.setUser(user);
		userNewsSourcesPreferences.setNewsSourceId("34234646745333");
		userNewsSourcesPreferences.setAddedTime(Calendar.getInstance().getTime());
		
		int rowCount = dbHelper.intertIntoUserNewsSourcesPreferences(userNewsSourcesPreferences);
		
		assert (rowCount > 0);
	}
	
	@Test
	public void testGetAllUsersFromDB() throws SQLException, JsonProcessingException {
		List <User> userDatas = dbHelper.getAllUsersFromDB();
		logger.info(mapper.writeValueAsString(userDatas));

		assert (userDatas.size() > 0);
	}
}
