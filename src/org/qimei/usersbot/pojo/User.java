package org.qimei.usersbot.pojo;

import java.util.Date;
import java.util.UUID;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable (tableName="Users")
public class User {

	@DatabaseField(generatedId = true, canBeNull = false, useGetSet = true)
	private UUID id;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String fbId;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String emailId;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String userName;
	@DatabaseField(canBeNull = false, useGetSet = true)
	private Date creationDate;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFbId() {
		return fbId;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
