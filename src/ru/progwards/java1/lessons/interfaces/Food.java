package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public class Food implements CompareWeight {
    int weight;
    Food(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        switch (Integer.compare(getWeight(), (int) ((Food) smthHasWeigt).getWeight())){
            case -1:
                return CompareResult.LESS;

            case 0:
                return CompareResult.EQUAL;

            default: return CompareResult.GREATER;
        }
    }

    public static void sort(CompareWeight[] a){
        Food[] food = (Food []) a;

        int n=food.length;
        int i, j, b;
        for (i=0;i<n;i++){
            for (j=i+1;j<n;j++){
                if (food[i].getWeight()>food[j].getWeight()){
                    b=food[i].getWeight();
                    food[i].weight=food[j].getWeight();
                    food[j].weight=b;
                }
            }
        }

    }
/*
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
 */


    public static void printInfo(Food f1) {
       // System.out.println(f1);
        System.out.print(f1.getWeight()+" ");
       // System.out.println("");
    }

    public static void main(String[] args) {
        Food food1 = new Food(55);
        Food food2 = new Food(33);
        Food food3 = new Food(22);
        Food food4 = new Food(11);
        Food food5 = new Food(44);
        System.out.println(food1.getWeight()+" is "+food1.compareWeight(food2)+ " than "+food2.getWeight());
        System.out.println(food1.getWeight()+" is "+food1.compareWeight(food3)+ " than "+food3.getWeight());
        System.out.println(food2.getWeight()+" is "+food2.compareWeight(food3)+ " than "+food3.getWeight());

        Food[] foodArray = {food1, food2, food3, food4, food5};

        for (var food: foodArray) {
            printInfo(food);
        }
        System.out.println("");
        sort(foodArray);
        for (var food: foodArray) {
            printInfo(food);
        }


    }
}
