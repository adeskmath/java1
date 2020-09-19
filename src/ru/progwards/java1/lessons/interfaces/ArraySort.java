package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public class ArraySort implements CompareWeight{

/*
3.8 Скопировать реализацию сортировки из класса ArraySort из задачи 2 урока 6
и переделать сортировку массива целых чисел на сортировку через
интерфейс CompareWeight public static void sort(CompareWeight[] a)
 */
    int b;
    ArraySort(int b){
        this.b = b;
    }
    public int getArraySort(){
        return b;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        //perhaps could be more simple way
        switch (Integer.compare(getArraySort(), ((ArraySort) smthHasWeigt).getArraySort())){
            case -1:
                return CompareResult.LESS;
            case 1:
                return CompareResult.GREATER;

            default: return CompareResult.EQUAL;
        }

    }
    public static void sort(CompareWeight[] a){

        int n=a.length;
        int i, j;
        CompareWeight b;
        for (i=0;i<n;i++){
            for (j=i+1;j<n;j++){
                if (a[i].compareWeight(a[j])==CompareResult.GREATER){
                    b=a[i];
                    a[i]=a[j];
                    a[j]=b;
                }
            }
        }

        /* original
                for (i=0;i<n;i++){
            for (j=i+1;j<n;j++){
                if (a[i]>a[j]){
                    b=a[i];
                    a[i]=a[j];
                    a[j]=b;
                }
            }
        }
         */

    }
    /*
    in case needed
            CompareWeight a1 = new ArraySort(5);
     ....
        CompareWeight[] testArray = {a1,a2,a3,a4,a5,a5,a2,a4};

    public static void printInfoC(CompareWeight[] a){
        System.out.print("[");
        for (int i=0;i< a.length;i++){

            System.out.print(" "+(int) ((ArraySort) a[i]).getArraySort());
        }
        System.out.print("]");
    }
     */
    public static void printInfoA(ArraySort[] a){
        System.out.print("[");
        for (int i=0;i< a.length;i++){

            System.out.print(" "+a[i].getArraySort());
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ArraySort a1 = new ArraySort(5);
        ArraySort a2 = new ArraySort(9);
        ArraySort a3 = new ArraySort(0);
        ArraySort a4 = new ArraySort(-1);
        ArraySort a5 = new ArraySort(7);
        ArraySort[] testArray = {a1,a2,a3,a4,a5,a5,a2,a4};

        printInfoA(testArray);
        System.out.println("Result of soft");
        sort(testArray);
        printInfoA(testArray);

    }


}
