package com.example.sijuko.Article;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Links{

	@SerializedName("curies")
	private List<CuriesItem> curies;

	@SerializedName("replies")
	private List<RepliesItem> replies;

	@SerializedName("version-history")
	private List<VersionHistoryItem> versionHistory;

	@SerializedName("author")
	private List<AuthorItem> author;

	@SerializedName("wp:term")
	private List<WpTermItem> wpTerm;

	@SerializedName("about")
	private List<AboutItem> about;

	@SerializedName("self")
	private List<SelfItem> self;

	@SerializedName("wp:featuredmedia")
	private List<WpFeaturedmediaItem> wpFeaturedmedia;

	@SerializedName("collection")
	private List<CollectionItem> collection;

	@SerializedName("wp:attachment")
	private List<WpAttachmentItem> wpAttachment;

	public List<CuriesItem> getCuries(){
		return curies;
	}

	public List<RepliesItem> getReplies(){
		return replies;
	}

	public List<VersionHistoryItem> getVersionHistory(){
		return versionHistory;
	}

	public List<AuthorItem> getAuthor(){
		return author;
	}

	public List<WpTermItem> getWpTerm(){
		return wpTerm;
	}

	public List<AboutItem> getAbout(){
		return about;
	}

	public List<SelfItem> getSelf(){
		return self;
	}

	public List<WpFeaturedmediaItem> getWpFeaturedmedia(){
		return wpFeaturedmedia;
	}

	public List<CollectionItem> getCollection(){
		return collection;
	}

	public List<WpAttachmentItem> getWpAttachment(){
		return wpAttachment;
	}
}