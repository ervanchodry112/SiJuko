package com.example.sijuko.Model;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("password")
	private String password;

	@SerializedName("npm")
	private String npm;

	@SerializedName("username")
	private String username;

	public String getPassword(){
		return password;
	}

	public String getNpm(){
		return npm;
	}

	public String getUsername(){
		return username;
	}
}