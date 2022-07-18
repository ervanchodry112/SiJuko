package com.kopmaul.sijuko.Article;

import com.google.gson.annotations.SerializedName;

public class CuriesItem{

	@SerializedName("templated")
	private boolean templated;

	@SerializedName("name")
	private String name;

	@SerializedName("href")
	private String href;

	public boolean isTemplated(){
		return templated;
	}

	public String getName(){
		return name;
	}

	public String getHref(){
		return href;
	}
}