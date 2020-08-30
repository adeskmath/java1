package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    private boolean[] sieve;
    public Eratosthenes(int N){
        sieve = new boolean[N];
        Arrays.fill(sieve,true);
    }
    private void sift(){
        int i, j;
        int n = sieve.length;
        for (i=2;i<n;i++){
            // if false (not simple) take next number
            if (!sieve[i]) {
                continue;
            }
            for (j=i+1;j<n;j++){
                if (sieve[j] && j%i==0) {
                    sieve[j] = false;
                }

            }
        }
    }
    public boolean isSimple(int n){
        return sieve[n];
    }

    public static void main(String[] args) {
        final int N1=100;
        Eratosthenes myArray = new Eratosthenes(N1);
        myArray.sift();
        System.out.println(myArray.isSimple(N1-1));
        int k;
        for (k=0;k<N1;k++){
            System.out.println("["+k+"]"+myArray.isSimple(k));
        }

    }
}
