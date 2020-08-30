package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class ArraySort {

    public static void sort(int[] a){
        int n=a.length;
        int i, j, b;
        for (i=0;i<n;i++){
            for (j=i+1;j<n;j++){
                if (a[i]>a[j]){
                    b=a[i];
                    a[i]=a[j];
                    a[j]=b;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] c = {2,1,6,3,0,-8,-10,0};
        System.out.println(Arrays.toString(c));
        sort(c);
        System.out.println(Arrays.toString(c));

    }
}
