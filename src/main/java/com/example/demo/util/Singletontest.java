package com.example.demo.util;

public class Singletontest {
    private static String instance = null;

    public static synchronized String getInstance() {
        if (instance == null) {
            instance = new String();
        }
        return instance;
    }
}