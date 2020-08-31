package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class DIntArray {
    private int [] objArray = new int[0];
    //в условии - 3.2 конструктор - по умолчанию.
    // как робот найдет св-во - массив? (3.1 в классе разместить private переменную - массив целых чисел.)
    public DIntArray(){

    }
    // probably can be optimized with less code
    public void add(int num){
        int i;
        int l = objArray.length;
        int [] newArray = new int[l+1];
        for (i=0;i<l;i++){
            newArray[i]=objArray[i];
        }
        newArray[l]=num;
        objArray=newArray;
    }
    // probably can be optimized with less code
    public void atInsert(int pos, int num){
        int i=0;
        int j=0;
        int l = objArray.length;
        if(pos<l+1){
            int [] newArray = new int[l+1];
            while (i<l+1){
                if (i!=pos){
                    newArray[i]=objArray[j];
                    j++;
                } else {
                    newArray[i]=num;
                }
                i++;
            }
            objArray=newArray;
        } else System.out.println("can't insert : pos is out of index");

    }

    // probably can be optimized with less code
    public void atDelete(int pos){
        int i=0;
        int j=0;
        int l = objArray.length;

        if(l>1 && pos<l){

            int [] newArray = new int[l-1];
            while (i<l-1){
                if (i!=pos){
                    newArray[i]=objArray[j];
                } else {
                    j++;
                    newArray[i]=objArray[j];
                }
                i++;
                j++;
            }
            objArray=newArray;
        }else System.out.println("can't delete : pos is out of index or last element");

    }
    public int at(int pos){
        return objArray[pos];
    }

    public static void main(String[] args) {
        DIntArray b = new DIntArray();
        b.atInsert(0,1);
        System.out.println(Arrays.toString(b.objArray));
        b.atDelete(0);
        b.add(-56);
        System.out.println(Arrays.toString(b.objArray));
        b.add(5);
        System.out.println(Arrays.toString(b.objArray));
        b.add(-7);
        System.out.println(Arrays.toString(b.objArray));

        b.atInsert(2,1);
        System.out.println(Arrays.toString(b.objArray));

        b.atInsert(0,11);
        System.out.println(Arrays.toString(b.objArray));

        b.atDelete(0);
        System.out.println(Arrays.toString(b.objArray));

        System.out.println(b.at(0));

        b.objArray = new int[5];
        System.out.println(Arrays.toString(b.objArray));

    }
}
