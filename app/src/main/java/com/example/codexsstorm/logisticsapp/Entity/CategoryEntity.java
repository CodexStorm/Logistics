package com.example.codexsstorm.logisticsapp.Entity;

/**
 * Created by codexsstorm on 8/3/18.
 */

public class CategoryEntity {
    String Name;
    int imageId;

    public CategoryEntity(String name, int imageId) {
        Name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return Name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
