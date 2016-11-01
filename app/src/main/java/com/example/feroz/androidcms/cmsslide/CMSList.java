package com.example.feroz.androidcms.cmsslide;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.io.Serializable;
import java.util.ArrayList;


public class CMSList implements Serializable {
	
	
	@ElementList(name = "li",required = false,inline = true)
	ArrayList<CMSTextItem> items;

	@Attribute(name = "list_type", required = false)
	String list_type;

	
	@Attribute(name = "merged_audio", required = false)
	String mergedAudioName;
	
	public ArrayList<CMSTextItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<CMSTextItem> items) {
		this.items = items;
	}

	public String getList_type() {
		return list_type;
	}

	public void setList_type(String list_type) {
		this.list_type = list_type;
	}

	public String getMergedAudioURL() {
		if(mergedAudioName==null) {
			return "";
		}
		return mergedAudioName;
	}

	public void setMergedAudioURL(String mergedAudioName) {
		this.mergedAudioName = mergedAudioName;
	}
}
