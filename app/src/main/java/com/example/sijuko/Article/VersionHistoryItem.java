package com.example.sijuko.Article;

import com.google.gson.annotations.SerializedName;

public class VersionHistoryItem{

	@SerializedName("count")
	private int count;

	@SerializedName("href")
	private String href;

	public int getCount(){
		return count;
	}

	public String getHref(){
		return href;
	}
}