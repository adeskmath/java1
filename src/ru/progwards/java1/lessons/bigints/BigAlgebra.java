package ru.progwards.java1.lessons.bigints;

/*
Задача 1. Класс BigAlgebra
Реализовать класс BigAlgebra, содержащий следующие статические методы:

1.1 Метод BigDecimal fastPow(BigDecimal num, int pow)
Реализовать алгоритм быстрого возведения в степень pow числа num в BigDecimal,
описание алгоритма можно прочитать например в Википедии

1.2 Метод BigInteger fibonacci(int n)
Реализовать алгоритм вычисления n-го числа фибоначчи в BigInteger.
Последовательность чисел Фибоначчи, это когда каждое последующее число равно сумме двух предыдущих чисел.
Первые 2 числа последовательности 1, 1. Итого получаем 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 и т.д.
*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {
    static BigDecimal fastPow(BigDecimal num, int pow){
        BigDecimal res = new BigDecimal(1);
        while (pow>0){
            if (pow %2 ==0) {
                pow /=2;
                num = num.multiply(num);

            }
            else {
                pow--;
                res = res.multiply(num);
            }

        }
        return res;
    }


    static BigInteger fibonacci(int n){
        BigInteger fidoN= new BigInteger("0");
        BigInteger f0=new BigInteger("0");
        BigInteger f1=new BigInteger("1");
        if (n>1) for (int i=1;i<n;i++){
            fidoN=f0.add(f1);
            f0=f1;
            f1=fidoN;
        } else if (n==1) fidoN=new BigInteger("1"); // в задаче условие: ряд ЧФ начинается с 1 (не с 0)
        return fidoN;
    }


    public static void main(String[] args) {
        BigDecimal a = fastPow(new BigDecimal("1.1"),9);
        System.out.println(a);

        final int n = 30;
        System.out.print("First "+n+" Fibonacci numbers: ");
        for (int i=1;i<=n;i++){
            System.out.print(fibonacci(i)+" ");
        }

    }
}