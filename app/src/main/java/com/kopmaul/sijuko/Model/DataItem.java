package com.kopmaul.sijuko.Model;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("poin")
	private String poin;

	@SerializedName("simpanan_wajib")
	private String simpananWajib;

	public String getPoin(){
		return poin;
	}

	public String getSimpananWajib(){
		return simpananWajib;
	}
}