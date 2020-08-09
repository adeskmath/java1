package ru.progwards.java1.lessons.basics;

public class ReverseDigits {
    public static int reverseDigits(int number){
        return number%10*100+(number/10)%10*10+number/100;
                /* особенности деления целых чисел number=abc
               1: number%10 * 100 : abc%10=c
               2: (number/10)%10*10
               3: number/100 - остается целая часть : abc/100=a
               можно еще варианты подобрать
               контроль условия число д.б. 3х значное в задаче не указан
                 */
    }

    public static void main(String[] args) {
        System.out.println(reverseDigits(567));
    }
}
