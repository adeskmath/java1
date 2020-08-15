package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {
    /* H4
    3.1 Реализовать функцию public static boolean containsDigit(int number, int digit),
    которая будет возвращать true, если число number содержит цифру digit.

    Теперь проведём исследование. Есть ли у Золотого треугольника связь с числами Фибоначчи.
    Золотой треугольник это равнобедренный треугольник у которого
    ребро относится к основанию как 1.61803 (приблизительно),
    то есть по правилу Золотого сечения.
    Числа Фибоначчи это ряд чисел 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
    в котором первые два элемента равны 1, а каждый следующий равен сумме двух предыдущих.
    Для проведения этого исследования нам придётся решить две задачи.

    3.2 Реализовать, используя любой цикл, функцию public static int fiboNumber(int n),
    которая будет возвращать n-ое число Фибоначчи
    (нумерация начинается с 1, то есть при n = 3 должно вернуться число Фибоначчи 2, а при n = 10 число 55).

    3.3 Реализовать функцию public static boolean isGoldenTriangle(int a, int b, int c),
    которая будет возвращать true, если треугольник со сторонами a, b, c является Золотым.
    Определим критерии. Он должен быть равнобедренным и отношение ребра к основанию
    должно лежать между значениями 1.61703 и 1.61903.

    Далее в функции public static void main(String[] args) вывести на консоль, используя цикл, 15 первых чисел Фибоначчи.
    После этого, используя вложенные циклы, определить:
    есть ли среди треугольников, длины сторон которых являются натуральными числами не превышающими 100, Золотые треугольники.
    И если есть, вывести на консоль длины основания и рёбер этих треугольников.
    Если всё получилось, посмотрите на консоль и сделайте вывод: есть ли связь между числами Фибоначчи и Золотыми треугольниками.
     */
    public static boolean containsDigit(int number, int digit){
        boolean eXist=false;
        if (number==digit) eXist=true; else{
            while (number!=0){
                if (number%10==digit) {
                    eXist=true;
                    break;
                }
                number/=10;
                //System.out.println("test "+number);
            }
        }

        return eXist;
    }
    public static int fiboNumber(int n){
        int fidoN=0;
        int f0=0, f1=1;
        if (n>1) for (int i=1;i<n;i++){
            fidoN=f0+f1;
            f0=f1;
            f1=fidoN;
        } else if (n==1) fidoN=1; // в задаче условие: ряд ЧФ начинается с 1 (не с 0)
        return fidoN;
        }

    public static boolean isGoldenTriangle(int a, int b, int c){
        double ratio=0;
        boolean result;
        if (TriangleInfo.isIsoscelesTriangle(a,b,c)){
            //find ration edge/base, first find edge,base
            if (a==b) ratio=(double) a/c;
            if (a==c) ratio=(double) a/b;
            if (b==c) ratio=(double) b/a;
            result= (ratio>1.61703 && ratio<1.61903);
        //  System.out.println(ratio); //test
            } else result=false;
        return result;
    }

    public static void main(String[] args) {
        /* tests 3.1
        System.out.println(containsDigit(14589087,1));
        System.out.println(containsDigit(14589087,7));
        System.out.println(containsDigit(14589087,0));
        System.out.println(containsDigit(14589087,8));
        System.out.println(containsDigit(14589087,3));
        System.out.println(containsDigit(0,0));
        System.out.println(0%10);
         */
        System.out.print("First 15 Fibonacci numbers: ");
        for (int i=1;i<=15;i++){
            System.out.print(fiboNumber(i)+" ");
        }
        System.out.println();

        System.out.println("Golden Triange? - "+isGoldenTriangle(5,3,5));

        // looking for golden triangles a,b,c sides <=100
        for (int i=1;i<=100;i++){
            for (int j=1;j<=100;j++){
                for (int k=1;k<=100;k++) {
                    if (isGoldenTriangle(i, j, k)) System.out.println("Golden Triangle: "+i + "-" + j + "-" + k+
                            " edge="+TriangleSimpleInfo.maxSide(i,j,k)+" base="+TriangleSimpleInfo.minSide(i,j,k));
                }
            }
        }

    }

}
