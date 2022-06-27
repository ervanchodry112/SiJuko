package com.example.sijuko.Article;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ArticleResponse{

	@SerializedName("date")
	private String date;

	@SerializedName("template")
	private String template;

	@SerializedName("modified_gmt")
	private String modifiedGmt;

	@SerializedName("_links")
	private Links links;

	@SerializedName("author")
	private int author;

	@SerializedName("link")
	private String link;

	@SerializedName("format")
	private String format;

	@SerializedName("type")
	private String type;

	@SerializedName("title")
	private Title title;

	@SerializedName("comment_status")
	private String commentStatus;

	@SerializedName("content")
	private Content content;

	@SerializedName("featured_media")
	private int featuredMedia;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("ping_status")
	private String pingStatus;

	@SerializedName("meta")
	private List<Object> meta;

	@SerializedName("sticky")
	private boolean sticky;

	@SerializedName("guid")
	private Guid guid;

	@SerializedName("modified")
	private String modified;

	@SerializedName("id")
	private int id;

	@SerializedName("categories")
	private List<Integer> categories;

	@SerializedName("excerpt")
	private Excerpt excerpt;

	@SerializedName("date_gmt")
	private String dateGmt;

	@SerializedName("slug")
	private String slug;

	@SerializedName("status")
	private String status;

	public String getDate(){
		return date;
	}

	public String getTemplate(){
		return template;
	}

	public String getModifiedGmt(){
		return modifiedGmt;
	}

	public Links getLinks(){
		return links;
	}

	public int getAuthor(){
		return author;
	}

	public String getLink(){
		return link;
	}

	public String getFormat(){
		return format;
	}

	public String getType(){
		return type;
	}

	public Title getTitle(){
		return title;
	}

	public String getCommentStatus(){
		return commentStatus;
	}

	public Content getContent(){
		return content;
	}

	public int getFeaturedMedia(){
		return featuredMedia;
	}

	public List<Object> getTags(){
		return tags;
	}

	public String getPingStatus(){
		return pingStatus;
	}

	public List<Object> getMeta(){
		return meta;
	}

	public boolean isSticky(){
		return sticky;
	}

	public Guid getGuid(){
		return guid;
	}

	public String getModified(){
		return modified;
	}

	public int getId(){
		return id;
	}

	public List<Integer> getCategories(){
		return categories;
	}

	public Excerpt getExcerpt(){
		return excerpt;
	}

	public String getDateGmt(){
		return dateGmt;
	}

	public String getSlug(){
		return slug;
	}

	public String getStatus(){
		return status;
	}
}