package com.kopmaul.sijuko.Article;

import com.google.gson.annotations.SerializedName;

public class WpAttachmentItem{

	@SerializedName("href")
	private String href;

	public String getHref(){
		return href;
	}
}