package com.example.feroz.androidcms.cmsslide;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

import java.io.Serializable;
import java.util.ArrayList;



public class CMSHTMLTable implements Serializable {
	@Element(name = "rows", required = false)
	ArrayList<CMSHTMLTableRow> rows = new ArrayList<CMSHTMLTableRow>();

	@Attribute(name = "title", required = false)
	String title;
	
	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<CMSHTMLTableRow> getRows() {
		return rows;
	}

	public void setRows(ArrayList<CMSHTMLTableRow> rows) {
		this.rows = rows;
	}
}
