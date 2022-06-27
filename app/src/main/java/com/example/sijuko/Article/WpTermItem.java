package com.example.sijuko.Article;

import com.google.gson.annotations.SerializedName;

public class WpTermItem{

	@SerializedName("taxonomy")
	private String taxonomy;

	@SerializedName("href")
	private String href;

	@SerializedName("embeddable")
	private boolean embeddable;

	public String getTaxonomy(){
		return taxonomy;
	}

	public String getHref(){
		return href;
	}

	public boolean isEmbeddable(){
		return embeddable;
	}
}