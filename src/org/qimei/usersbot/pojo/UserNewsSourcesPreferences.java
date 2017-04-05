package org.qimei.usersbot.pojo;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable (tableName="UserNewsSourcesPreferences")
public class UserNewsSourcesPreferences {

	@DatabaseField(foreign=true, foreignColumnName = "id", canBeNull = false, useGetSet = true)
	private User user;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String newsSourceId;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private Date addedTime;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNewsSourceId() {
		return newsSourceId;
	}
	public void setNewsSourceId(String newsSourceId) {
		this.newsSourceId = newsSourceId;
	}
	public Date getAddedTime() {
		return addedTime;
	}
	public void setAddedTime(Date addedTime) {
		this.addedTime = addedTime;
	}
}
