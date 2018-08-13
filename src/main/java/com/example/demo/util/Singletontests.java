package com.example.demo.util;

public class Singletontests {

    private static Singletontests instance = null;

    public static synchronized Singletontests setInstane() {
        if (instance == null) {
            instance = new Singletontests();
        }
        return instance;
    }
}