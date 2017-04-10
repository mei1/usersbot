package org.qimei.usersbot.pojo;

public class UserInputs {
	
	User user;
	UserLoginHistory userLoginHistory;
	UserPreferences userPreferences;
	UserActivities userActivities;
	UserNewsSourcesPreferences userNewsSourcesPreferences;
	String columnName;
	Object columnValue;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserLoginHistory getUserLoginHistory() {
		return userLoginHistory;
	}
	public void setUserLoginHistory(UserLoginHistory userLoginHistory) {
		this.userLoginHistory = userLoginHistory;
	}
	public UserPreferences getUserPreferences() {
		return userPreferences;
	}
	public void setUserPreferences(UserPreferences userPreferences) {
		this.userPreferences = userPreferences;
	}
	public UserActivities getUserActivities() {
		return userActivities;
	}
	public void setUserActivities(UserActivities userActivities) {
		this.userActivities = userActivities;
	}
	public UserNewsSourcesPreferences getUserNewsSourcesPreferences() {
		return userNewsSourcesPreferences;
	}
	public void setUserNewsSourcesPreferences(UserNewsSourcesPreferences userNewsSourcesPreferences) {
		this.userNewsSourcesPreferences = userNewsSourcesPreferences;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Object getColumnValue() {
		return columnValue;
	}
	public void setColumnValue(Object columnValue) {
		this.columnValue = columnValue;
	}

}
