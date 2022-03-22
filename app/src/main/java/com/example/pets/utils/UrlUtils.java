package com.example.pets.utils;

public class UrlUtils {
    public static String createhomePageUrl(int themeId,int page){
        return  "discovery/"+themeId+"/"+page;                             //用到外部的路径了！
    }

    public static String getCoverPath(String pict_url,int size) {
        return "https:"+pict_url+"_"+"200x200"+".jpg";
    }
}
