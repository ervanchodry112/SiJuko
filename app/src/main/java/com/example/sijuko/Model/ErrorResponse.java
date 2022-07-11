package com.example.sijuko.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ErrorResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("data_anggota")
	private List<Object> dataAnggota;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private boolean status;

	public Data getData(){
		return data;
	}

	public List<Object> getDataAnggota(){
		return dataAnggota;
	}

	public String getMessage(){
		return message;
	}

	public boolean isStatus(){
		return status;
	}
}