package ru.progwards.java1.lessons.bigints;

/* 2.1 Реализовать класс AbsInteger - абстрактное целое число
2.2 Реализовать потомков ByteInteger, ShortInteger, IntInteger,
* хранящих значение целого числа соответствующего типа. У каждого типа реализовать конструктор,
* принимающей значение числа соответствующего типа, для ByteInteger - byte, ShortInteger - short и
* IntInteger - int. Реализовать унаследованные публичные методы String toString(),
* посредством которых возвращать приведенное к строке значение соответствующего классу типа.

2.3 У класса AbsInteger реализовать метод static AbsInteger add(AbsInteger num1, AbsInteger num2)
* - который вычисляет сумму num1 и num2. При этом надо учесть, что num1 и num2 могут быть разных типов.
* Для того, чтобы это реализовать продумать, какие дополнительные методы нужно сделать у AbsInteger и его потомков.
// задача не до конца понятна
Привести результат к наиболее подходящему типу, т.е. -128..127 это ByteInteger и т.д.
 */


class AbsInteger{
    long num;
    AbsInteger (long num){
        this.num = num;
    }
    public long getNum() {
        return num;
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2){
        long sum = num1.getNum()+num2.getNum();
        //-128..127
        if (sum>=-128 && sum<=127) {
            return new ByteInteger((byte) sum);
            //-32768 до 32767
        } else if (sum>=-32768 && sum<=32767){
            return new ShortInteger((short) sum);
        }
        //-2147483648 до 2147483647
         else if (sum>=-2147483648 && sum<=2147483647) {
             return new IntInteger((int)sum);
        }
         else return new AbsInteger(sum);

    }
    @Override
    public String toString() {
        return "AbsInteger{" +
                "num=" + num +
                '}';
    }
}

class ByteInteger extends AbsInteger{
    byte num;
    ByteInteger (byte num){
        super(num);
        this.num=num;
    }

    @Override
    public String toString() {
        return "ByteInteger{" +
                "num=" + num +
                '}';
        }

}

class ShortInteger extends AbsInteger{
    short num;
    ShortInteger (short num){
        super(num);
        this.num=num;
    }

    @Override
    public String toString() {
        return "ShortInteger{" +
                "num=" + num +
                '}';
    }
}

class IntInteger extends AbsInteger{
    int num;
    IntInteger (int num){
        super(num);
        this.num=num;
    }
    @Override
    public String toString() {
        return "IntInteger{" +
                "num=" + num +
                '}';
    }
}
class test{
    public static void main(String[] args) {
        AbsInteger a1 = new AbsInteger(2147483647);
        ByteInteger a = new ByteInteger((byte) 77);
        ShortInteger b = new ShortInteger((short)32000);
        IntInteger c = new IntInteger(1000000);
        AbsInteger d = new AbsInteger(9223372036854775807L);

        System.out.println(AbsInteger.add(a,a1));
        System.out.println(AbsInteger.add(a,b));
        System.out.println(AbsInteger.add(a,c));
        System.out.println(AbsInteger.add(c,b));
        System.out.println(AbsInteger.add(c,d));


    }
}
