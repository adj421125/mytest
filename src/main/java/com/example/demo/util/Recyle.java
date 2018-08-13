package com.example.demo.util;

public class Recyle {
    private static Recyle recyle = null;

    private Recyle() {
    }

    public static Recyle getInstan() {
        if (recyle == null)
            recyle = new Recyle();
        return recyle;
    }

    public static void delete(String para) {
        System.out.println(para + "已经经过回收站处理");
    }
}