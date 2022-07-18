package com.kopmaul.sijuko.Model;

import com.google.gson.annotations.SerializedName;

public class SimpananResponse{

	@SerializedName("data")
	private DataItem data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private Integer status;

	public DataItem getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}

	public Integer getStatus(){
		return status;
	}
}