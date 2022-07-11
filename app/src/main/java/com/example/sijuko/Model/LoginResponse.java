package com.example.sijuko.Model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("data_anggota")
	private DataAnggota dataAnggota;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public Data getData(){
		return data;
	}

	public DataAnggota getDataAnggota(){
		return dataAnggota;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}