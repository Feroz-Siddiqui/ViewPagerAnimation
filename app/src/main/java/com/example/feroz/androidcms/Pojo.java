package com.example.feroz.androidcms;

/**
 * Created by Feroz on 21-10-2016.
 */

public class Pojo {
    private String name;
    private String title;
    private String subtitle;

    public Pojo() {
    }

    public Pojo(String name, String title, String subtitle) {
        this.name = name;
        this.title = title;
        this.subtitle = subtitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
}
