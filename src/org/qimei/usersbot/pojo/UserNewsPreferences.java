package org.qimei.usersbot.pojo;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable (tableName="UserNewsPreferences")
public class UserNewsPreferences {
	
	@DatabaseField(foreign=true, foreignColumnName = "id", canBeNull = false, useGetSet = true)
	private User user;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String articleId;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private Date viewTime;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public Date getViewTime() {
		return viewTime;
	}
	public void setViewTime(Date viewTime) {
		this.viewTime = viewTime;
	}

}
