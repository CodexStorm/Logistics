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

    public static String tools ="Claw harmer,Flathead Screwdriver,Tape measure,Crescent wrench,Pliers,Driller,Saw,Blade";
    public static String toolsq = "4,6,2,5,1,7,8,9";
    public static String electronics = "Laptop,Mobile,TV,Music Player,Watch,Speaker,Bluetooth";
    public static String elctronicsq = "1,5,2,4,6,8,9";
    public static String stationary = "Pen,Pencil,Rubber,Sharpener,Ink,Scale,Stensils,Paper";
    public static String stationaryq = "4,6,2,5,1,7,8,9";
    public static String furniture = "Sofa,Bed,Cupboard,Chair,Table,Curtains,Side table,Lamp stand";
    public static String furnitureq = "4,6,2,5,1,7,8,9";
    public static String toys = "Baby toys,Cars,Puzzles,Board,Marker,Pictionary,Monopoly";
    public static String toysq = "4,6,2,5,1,7,8,9";
    public static String cutlery = "Plane,Spoon,Fork,Tea Cup,Saucer,Plates,Cups,Box";
    public static String cutleryq = "4,6,2,5,1,7,8,9";
    public static String travel = "Bags,Suitcases,Ropes,Maps";
    public static String travelq = "5,2,4,1";
    public static String books = "A,B,C,D,E,F,G,H";
    public static String booksq = "4,6,2,5,1,7,8,9";

    public static String getElectronics() {
        return electronics;
    }

    public static String getElctronicsq() {
        return elctronicsq;
    }

    public static String getStationary() {
        return stationary;
    }

    public static String getStationaryq() {
        return stationaryq;
    }

    public static String getFurniture() {
        return furniture;
    }

    public static String getFurnitureq() {
        return furnitureq;
    }

    public static String getToys() {
        return toys;
    }

    public static String getToysq() {
        return toysq;
    }

    public static String getCutlery() {
        return cutlery;
    }

    public static String getCutleryq() {
        return cutleryq;
    }

    public static String getTravel() {
        return travel;
    }

    public static String getTravelq() {
        return travelq;
    }

    public static String getBooks() {
        return books;
    }

    public static String getBooksq() {
        return booksq;
    }

    public static String getToolsq() {
        return toolsq;
    }

    public static String getTools() {
        return tools;
    }

    public String[] getCategory() {
        return Category;
    }


    public int[] getImageId() {
        return ImageId;
    }
}
