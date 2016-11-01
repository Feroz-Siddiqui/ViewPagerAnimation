package com.example.feroz.androidcms.cmsslide;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Root(name="slide")
public class CMSSlide  implements Serializable{

	//@Element(required = false)
	
	
	@Attribute(name = "background", required = false)
	String background = "null";
	@Attribute(name = "image_bg", required = false)
	String image_BG;
	@Attribute(name = "background_transition", required = false)
	String backgroundTransition = "zoom";
	@Attribute(name = "template", required = false)
	String templateName;
	@Attribute(name = "transition", required = false)
	String transition = "zoom";
	@Attribute(name = "position", required = false)
	String position;
	
	@Element(name = "h1", required = false)
	String title;
	@Element(name = "h2", required = false)
	String title2;
	@Element(name = "p", required = false)
	String paragraph;
	
	
	@Element(name = "img", required = false)
	CMSImage image;
	
	
	@Element(name = "tables", required = false)
	List<CMSHTMLTable> tables = new ArrayList<CMSHTMLTable>();
	
	@Element(name = "ul", required = false)
	CMSList list;
	
	
	@Element(name = "video", required = false)
	CMSVideo video;
	
	
	@Element(name = "teacher_notes", required = false)
	String teacherNotes;
	@Element(name = "student_notes", required = false)
	String studentNotes;
	@Element(name = "slide_audio", required = false)
	String audioUrl;
	@Element(name = "duration", required = false)
	int slideDuration;
	public CMSSlide() {
	ArrayList<CMSTextItem>	items =new ArrayList<CMSTextItem>();
		items.add(new CMSTextItem("",""));
		items.add(new CMSTextItem("",""));
		items.add(new CMSTextItem("",""));
		items.add(new CMSTextItem("",""));
		items.add(new CMSTextItem("",""));
		list = new CMSList();
		list.setItems(items);
	}
	
	public CMSSlide(String[] options) {
		ArrayList<CMSTextItem>	items = new ArrayList<CMSTextItem>();
		for(String option : options) {
			try {
				if(option.startsWith("#####")) {
					items.add(new CMSTextItem(option.replace("#####", ""), 1));
				} else {
					items.add(new CMSTextItem(option,0));
				}
			} catch (Exception e) {
				items.add(new CMSTextItem(option,0));
			}
		}
		
		items.add(new CMSTextItem("",""));
		items.add(new CMSTextItem("",""));
		list = new CMSList();
		list.setItems(items);
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getImage_BG() {
		return image_BG;
	}

	public void setImage_BG(String image_BG) {
		this.image_BG = image_BG;
	}

	public String getBackgroundTransition() {
		return backgroundTransition;
	}

	public void setBackgroundTransition(String backgroundTransition) {
		this.backgroundTransition = backgroundTransition;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTransition() {
		return transition;
	}

	public void setTransition(String transition) {
		this.transition = transition;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public String getParagraph() {
		return paragraph;
	}

	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}

	public CMSImage getImage() {
		return image;
	}

	public void setImage(CMSImage image) {
		this.image = image;
	}

	public List<CMSHTMLTable> getTables() {
		return tables;
	}

	public void setTables(List<CMSHTMLTable> tables) {
		this.tables = tables;
	}

	public CMSList getList() {
		return list;
	}

	public void setList(CMSList list) {
		this.list = list;
	}

	public CMSVideo getVideo() {
		return video;
	}

	public void setVideo(CMSVideo video) {
		this.video = video;
	}

	public String getTeacherNotes() {
		return teacherNotes;
	}

	public void setTeacherNotes(String teacherNotes) {
		this.teacherNotes = teacherNotes;
	}

	public String getStudentNotes() {
		return studentNotes;
	}

	public void setStudentNotes(String studentNotes) {
		this.studentNotes = studentNotes;
	}

	public String getAudioUrl() {
		return audioUrl;
	}

	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}

	public int getSlideDuration() {
		return slideDuration;
	}

	public void setSlideDuration(int slideDuration) {
		this.slideDuration = slideDuration;
	}

	
	
	
	
}
