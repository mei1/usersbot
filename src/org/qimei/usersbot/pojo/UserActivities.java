package org.qimei.usersbot.pojo;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable (tableName="UserActivities")
public class UserActivities {
	
	@DatabaseField(foreign=true, foreignColumnName = "id", canBeNull = false, useGetSet = true)
	private User user;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String appId;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String activityId;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String appData;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private Date timeStamp;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getAppData() {
		return appData;
	}
	public void setAppData(String appData) {
		this.appData = appData;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
