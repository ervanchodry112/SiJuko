package com.example.sijuko.Model;

import com.google.gson.annotations.SerializedName;

public class PresensiResponse{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("status")
	private String status;

	public String getPesan(){
		return pesan;
	}

	public String getStatus(){
		return status;
	}
}