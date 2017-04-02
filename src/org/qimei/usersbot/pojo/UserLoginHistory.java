package org.qimei.usersbot.pojo;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable (tableName="UserLoginHistory")
public class UserLoginHistory {

	@DatabaseField(foreign=true, foreignColumnName = "id", canBeNull = false, useGetSet = true)
	private User user;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private Date lastLoginTime;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
}
