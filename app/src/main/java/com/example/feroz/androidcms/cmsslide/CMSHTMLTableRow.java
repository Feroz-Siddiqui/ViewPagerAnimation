package com.example.feroz.androidcms.cmsslide;

import org.simpleframework.xml.Element;

import java.io.Serializable;
import java.util.ArrayList;

public class CMSHTMLTableRow implements Serializable {
	
	
	@Element(name = "cell", required = false)
	ArrayList<String> cells = new ArrayList<String>();

	public ArrayList<String> getCells() {
		return cells;
	}

	public void setCells(ArrayList<String> cells) {
		this.cells = cells;
	}
	
}
