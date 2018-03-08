package com.example.codexsstorm.logisticsapp.Other;

import com.example.codexsstorm.logisticsapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by codexsstorm on 7/3/18.
 */

public class Data {

    public static String[] Category = {
            "Tools",
            "Electronics",
            "Stationary",
            "Furniture",
            "Toys",
            "Cutlery",
            "Travel",
            "Books"
    };

    public static int[] ImageId = {
            R.drawable.tools,
            R.drawable.cpu,
            R.drawable.archives,
            R.drawable.armchair,
            R.drawable.toys,
            R.drawable.food,
            R.drawable.luggage,
            R.drawable.books
    };

    public static List tools = Arrays.asList("Claw Harmer",
            "Flathead Screwdriver",
            "Tape Measure",
            "Crescent Wrench",
            "Pliers",
            "Driller",
            "Saw",
            "Blade");



    public List getTools() {
        return tools;
    }

    public String[] getCategory() {
        return Category;
    }


    public int[] getImageId() {
        return ImageId;
    }
}
