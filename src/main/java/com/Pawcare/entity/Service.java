package com.pawcare.entity;

public class Service {
    private String id;
    private String title;
    private String description;
    private String imagePath;

    public Service(String id, String title, String description, String imagePath) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }
}

