package com.example.sijuko.Article;

import com.google.gson.annotations.SerializedName;

public class AuthorItem{

	@SerializedName("href")
	private String href;

	@SerializedName("embeddable")
	private boolean embeddable;

	public String getHref(){
		return href;
	}

	public boolean isEmbeddable(){
		return embeddable;
	}
}