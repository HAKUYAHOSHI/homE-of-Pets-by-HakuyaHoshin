package com.example.pets.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;

public class constant {
    public static final String BASE_URL = "https://api.sunofbeaches.com/shop/";
    public static final String HOMEPAGE_KEY_ID = "messageId";  //这是homeFragemnt的bundle的key。就是请求时候的那边让带的参数。
    public static final String HOMEPAGE_KEY_THEME = "theme";
    public static final List<Map<String,String>> list = new ArrayList<>();

}
