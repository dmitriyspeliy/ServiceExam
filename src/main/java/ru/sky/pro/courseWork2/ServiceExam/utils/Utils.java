package ru.sky.pro.courseWork2.ServiceExam.utils;

import java.util.Random;

public class Utils {
    public static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}