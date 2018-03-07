package com.example.codexsstorm.logisticsapp.Other;

import com.example.codexsstorm.logisticsapp.R;

/**
 * Created by codexsstorm on 7/3/18.
 */

public class Data {
    public String[] category = {
            "Tools",
            "Electronics",
            "Stationary",
            "Furniture",
            "Toys",
            "Cutlery",
            "Travel",
            "Books"

    } ;

    public String[] tools = {
            "Claw Harmer",
            "Flathead Screwdriver",
            "Tape Measure",
            "Crescent Wrench",
            "Pliers",
            "Driller",
            "Saw",
            "Blade"
    };



    public int[] imageId = {
            R.drawable.tools,
            R.drawable.cpu,
            R.drawable.archives,
            R.drawable.armchair,
            R.drawable.toys,
            R.drawable.food,
            R.drawable.luggage,
            R.drawable.books,
    };



    public String[] getCategory() {
        return category;
    }

    public int[] getImageId() {
        return imageId;
    }


}
