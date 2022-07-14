package com.example.sijuko.Model;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("poin")
	private int poin;

	@SerializedName("simpanan_wajib")
	private String simpananWajib;

	public int getPoin(){
		return poin;
	}

	public String getSimpananWajib(){
		return simpananWajib;
	}
}