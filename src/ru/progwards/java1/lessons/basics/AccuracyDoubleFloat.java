package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {
    public static double volumeBallDouble(double radius){
        return 3.14*radius*radius*radius*4/3;
    }
    public static float volumeBallFloat(float radius){
        return 3.14f*radius*radius*radius*4/3;
    }
    public static double calculateAccuracy(double radius){
        return volumeBallDouble(radius)-volumeBallFloat((float)radius);
    }

    public static void main(String[] args) {
        System.out.println(calculateAccuracy(6371.2));
    }

}
