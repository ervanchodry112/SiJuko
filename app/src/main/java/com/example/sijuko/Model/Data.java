package com.example.sijuko.Model;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("password")
	private String password;

	@SerializedName("passdb")
	private String passdb;

	public String getPassword(){
		return password;
	}

	public String getPassdb(){
		return passdb;
	}
}