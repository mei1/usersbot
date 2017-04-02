package org.qimei.usersbot.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable (tableName="UserPreferences")
public class UserPreferences {
	
	@DatabaseField(foreign=true, foreignColumnName = "id", canBeNull = false, useGetSet = true)
	private User user;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String userPreferences;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUserPreferences() {
		return userPreferences;
	}
	public void setUserPreferences(String userPreferences) {
		this.userPreferences = userPreferences;
	}

}
