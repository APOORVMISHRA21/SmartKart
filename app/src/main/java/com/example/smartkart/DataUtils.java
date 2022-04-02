package com.example.smartkart;

import com.example.smartkart.Models.Category;

import java.util.ArrayList;

public class DataUtils {
    public static ArrayList<Category> categoryList;

    public static ArrayList<Category> getCategoryList(){
        categoryList = new ArrayList<>();
        categoryList.add(new Category("Shoes",
                "Find in endless collection of shoes, boots, slippers and many more footwear items to embrace your foot.",
                R.drawable.shoes));
        categoryList.add(new Category("Clothing",
                "Find in endless collection of shoes, boots, slippers and many more footwear items to embrace your foot.",
                R.drawable.clothing));
        categoryList.add(new Category("Shoes",
                "Find in endless collection of shoes, boots, slippers and many more footwear items to embrace your foot.",
                R.drawable.shoes));

        return categoryList;
    }
}
