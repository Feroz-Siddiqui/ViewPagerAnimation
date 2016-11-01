package com.example.feroz.androidcms.cmsslide;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;

@Root(name="presentation")

public class Presentation implements Serializable {

	
	@ElementList(name = "slide",required = false,inline = true)

	private ArrayList<CMSSlide> cmslide;

	public Presentation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Presentation(ArrayList<CMSSlide> cmslide) {
		super();
		this.cmslide = cmslide;
	}

	public ArrayList<CMSSlide> getCmslide() {
		return cmslide;
	}

	public void setCmslide(ArrayList<CMSSlide> cmslide) {
		this.cmslide = cmslide;
	}
	
	
	
}
