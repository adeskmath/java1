package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    /*
    2.1 Реализовать функцию public static boolean isTriangle(int a, int b, int c), которая возвращает true,
    если по данным трём сторонам (a, b, c) можно построить треугольник.
    Из геометрии известно, что в треугольнике длина каждой из сторон меньше суммы длин двух других сторон.
    2.2 Реализовать функцию public static boolean isRightTriangle(int a, int b, int c), которая возвращает true,
    если треугольник со сторонами a, b, c является прямоугольным.
    Из геометрии известно, что для прямоугольного треугольника выполняется теорема Пифагора (сумма квадратов катетов равна квадрату гипотенузы).
    2.3 Реализовать функцию public static boolean isIsoscelesTriangle(int a, int b, int c), которая возвращает true,
    если треугольник со сторонами a, b, c является равнобедренным.
    Из геометрии известно, что в равнобедренном треугольнике есть две равные стороны.
     */
    public static boolean isTriangle(int a, int b, int c){
        return (a<b+c && b<a+c && c<a+b);
    }
    public static boolean isRightTriangle(int a, int b, int c){
        return isTriangle(a,b,c) && (a*a==b*b+c*c || b*b==a*a+c*c || c*c==a*a+b*b) ;
    }
    public static boolean isIsoscelesTriangle(int a, int b, int c){
        return isTriangle(a,b,c) && (a==b || a==c || b==c);
    }

    public static void main(String[] args) {
        System.out.println("Can we get a triangle from a,b,c?");
        System.out.println("Triangle - "+isTriangle(4,3,5));
        System.out.println("Triangle - "+isTriangle(4,10,5));

        System.out.println("Pythagoras - "+isRightTriangle(5,12,13));
        System.out.println("Pythagoras - "+isRightTriangle(181,180,20));

        System.out.println("Isosceles - "+isIsoscelesTriangle(20,30,20));
        System.out.println("Isosceles - "+isIsoscelesTriangle(19,30,20));
    }
}
