package com.example.sijuko.Model;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public String getMessage(){
		return message;
	}

	public int getStatus(){
		return status;
	}
}