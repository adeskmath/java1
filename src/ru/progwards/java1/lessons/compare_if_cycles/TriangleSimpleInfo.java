package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {
    /*
    1.1 Реализовать функцию, которая получает параметрами длины сторон треугольника,
    а вернуть должна наибольшую длину стороны.
     */
    public static int maxSide(int a, int b, int c){
        return Math.max(Math.max(a,b),c);
    }
    /*
    1.2 Реализовать функцию, которая получает параметрами длины сторон треугольника,
    а вернуть должна наименьшую длину стороны.
     */
    public static int minSide(int a, int b, int c){
        return Math.min(Math.min(a,b),c);
    }
    /*
    1.3 Реализовать функцию, которая получает параметрами длины сторон треугольника,
    а вернуть должна true, если треугольник равносторонний и false в противном случае.
     */
    public static boolean isEquilateralTriangle(int a, int b, int c){
        return a==b && b==c;
    }

    public static void main(String[] args) {
        final int A1=144, B1=89, C1=55;
        System.out.println("Test maxSide function:");
        System.out.println("Max side of the triangle = "+maxSide(A1,B1,C1));
        System.out.println("Max side of the triangle = "+maxSide(B1,B1,B1));
        System.out.println("Max side of the triangle = "+maxSide(B1,C1,A1));
        System.out.println("Max side of the triangle = "+maxSide(C1,A1,B1));
        System.out.println("Test minSide function:");
        System.out.println("Min side of the triangle = "+minSide(A1,B1,C1));
        System.out.println("Min side of the triangle = "+minSide(B1,B1,B1));
        System.out.println("Min side of the triangle = "+minSide(B1,C1,A1));
        System.out.println("Min side of the triangle = "+minSide(C1,A1,B1));
        System.out.println("Test isEquilateralTriangle function:");
        System.out.println("Triangle is equilateral - "+ isEquilateralTriangle(A1,B1,C1));
        System.out.println("Triangle is equilateral - "+ isEquilateralTriangle(B1,B1,B1));
        System.out.println("Triangle is equilateral - "+ isEquilateralTriangle(A1,B1,A1));
    }
}
