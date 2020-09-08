package ru.progwards.java1.lessons.bitsworld;
/*
1.1 Реализовать функцию public static int sumBits(byte value),
которая суммирует все биты параметра value.
Например, для двоичного числа 0100101 функция должна вернуть 3.

Подсказки:
используйте & с числом 1 для того, чтобы оставить только один правый значащий бит;
используйте сдвиг вправо для того, чтобы проверить следующий бит.
 */

public class SumBits {
    public static int sumBits(byte value){
        int result = 0;
        for (int i=0;i<8;i++) {
            result = result+(value & 0b00000001);
            value = (byte) (value>>1);
            //System.out.println(Integer.toBinaryString(value));
        }

        return result;

    }

    public static void main(String[] args) {
        byte a = 0b01000000;
        System.out.println(sumBits(a));
    }
}
