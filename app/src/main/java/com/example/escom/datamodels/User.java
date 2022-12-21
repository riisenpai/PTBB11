package com.example.escom.datamodels;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("role")
	private Object role;

	@SerializedName("active")
	private int active;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("email_verified_at")
	private Object emailVerifiedAt;

	@SerializedName("current_team_id")
	private Object currentTeamId;

	@SerializedName("avatar")
	private Object avatar;

	@SerializedName("type")
	private int type;

	@SerializedName("token")
	private Object token;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("two_factor_recovery_codes")
	private Object twoFactorRecoveryCodes;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("profile_photo_path")
	private Object profilePhotoPath;

	@SerializedName("two_factor_secret")
	private Object twoFactorSecret;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public Object getRole(){
		return role;
	}

	public int getActive(){
		return active;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public Object getEmailVerifiedAt(){
		return emailVerifiedAt;
	}

	public Object getCurrentTeamId(){
		return currentTeamId;
	}

	public Object getAvatar(){
		return avatar;
	}

	public int getType(){
		return type;
	}

	public Object getToken(){
		return token;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public Object getTwoFactorRecoveryCodes(){
		return twoFactorRecoveryCodes;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public Object getProfilePhotoPath(){
		return profilePhotoPath;
	}

	public Object getTwoFactorSecret(){
		return twoFactorSecret;
	}

	public String getEmail(){
		return email;
	}

	public String getUsername(){
		return username;
	}
}