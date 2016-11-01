package com.example.feroz.androidcms.cmsslide;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.io.Serializable;

public class CMSVideo implements Serializable {
	@Attribute(name = "url", required = false)
	String url;
	@Element(name = "description", required = false)
	String description;
	@Attribute(name = "title", required = false)
	String title;
	public CMSVideo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CMSVideo(String url, String description, String title) {
		super();
		this.url = url;
		this.description = description;
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
