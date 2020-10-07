package ru.progwards.java1.lessons.bigints;

/*
Задача 3. Класс ArrayInteger

Реализовать класс ArrayInteger - целого числа произвольной длины на массиве byte[] digits;
Каждый элемент массива digits[i] может хранить только цифру, то есть число от 0 до 9.
Например, число 159 должно занять 3 ячейки массива digits[0] = 9; digits[1] = 5; digits[2] = 1;
Реализовать методы:
3.1 ArrayInteger(int n) - инициализирует класс, с максимальной точностью n цифр (размер массива)

3.2 void fromInt(BigInteger value) - установить свое значение,
взяв его из value (уложить BigInteger во внутренний массив)

3.3 BigInteger toInt() - привести свое значение к BigInteger (преобразовать из массива в BigInteger)

3.4 boolean add(ArrayInteger num) - сложить 2 числа, не используя BigInteger,
а  используя массив digits, результат поместить в экземпляр ArrayInteger,
у которого был вызван метод. При переполнении вернуть false, при этом само число сбросить в 0
*/

import java.math.BigInteger;
import java.util.Arrays;

public class ArrayInteger {
    byte[] digits;

    @Override
    public String toString() {
        return "ArrayInteger{" +
                "digits=" + Arrays.toString(digits) +
                '}';
    }

    ArrayInteger(int n) {
        digits = new byte[n];
    }

    void fromInt(BigInteger value) {
        int aLength = digits.length;
        if (aLength!=lengthBigInteger(value)) {
            System.out.println("oops");
            return;
        }
//        System.out.println(aLength);

        for (int i = 0; i < aLength; i++) {
            digits[i] = value.mod(BigInteger.TEN).byteValue();
            value = value.divide(BigInteger.TEN);
        }
    }

    BigInteger toInt(){
        int aLength = digits.length;
        long value=0;

        for (int i = 0; i < aLength; i++) {
            value+= digits[i] *Math.pow(10,i);
        }
        return BigInteger.valueOf(value);
    }

    boolean add(ArrayInteger num){
        byte plus=0;
        long l1 = this.digits.length;
        long l2 = num.digits.length;
        if (l1<l2) {
            System.out.println("this < next");
            this.zeroArrayInteger();
            return false;
        }
        System.out.println("-------------"+l1);
        for (int i = 0; i < l1; i++) {
            if (i<l2){
                this.digits[i] = (byte) (this.digits[i]+num.digits[i]+plus);
            } else {
                this.digits[i] += plus;
            }
            plus = (byte) (this.digits[i]/10);
            if (plus>0) this.digits[i]-=10;

        }
        if (plus>0) {
            this.zeroArrayInteger();
            return false;
        }else return true;
    }

    void zeroArrayInteger(){
        Arrays.fill(this.digits, (byte) 0);
    }

    static int lengthBigInteger(BigInteger value) {
        int digits = 0;
        while (!value.equals(BigInteger.ZERO)) {
            value = value.divide(BigInteger.TEN);
            digits++;
        }
        return digits;
    }
}
class testArrayInteger{
    public static void main(String[] args) {

        BigInteger a = new BigInteger("12345");
        BigInteger b = new BigInteger("232");
        System.out.println("a="+a);
        System.out.println("b="+b);

//        System.out.println(ArrayInteger.lengthBigInteger(b));

        ArrayInteger c = new ArrayInteger(ArrayInteger.lengthBigInteger(a));
        ArrayInteger d = new ArrayInteger(ArrayInteger.lengthBigInteger(b));
//        System.out.println("a->"+c);
//        System.out.println("b->"+d);
        c.fromInt(a);
        d.fromInt(b);
        System.out.println("a->"+c);
        System.out.println("b->"+d);
        System.out.println(c.toInt());
        System.out.println(d.toInt());
        c.add(d);
        System.out.println(c);
        System.out.println(c.toInt());
        c.add(c);
        System.out.println(c);
        System.out.println(c.toInt());
        c.add(c);
        System.out.println(c);
        System.out.println(c.toInt());
        c.add(c);
        System.out.println(c);
        System.out.println(c.toInt());

    }
}