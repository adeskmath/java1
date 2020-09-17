package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {

    public static class CacheInfo{
        public int n;
        public int fibo;

        public static CacheInfo getLastFibo(){
            return lastFibo;
        }
        public static void clearLastFibo(){
            lastFibo =null;
        }
    }
    private static CacheInfo lastFibo = new CacheInfo();

    public static int fiboNumber(int n){
        int fidoN=0;
        int f0=0, f1=1;

        if (lastFibo !=null && n== lastFibo.n) return lastFibo.fibo;
        if (n>1) for (int i=1;i<n;i++){
            fidoN=f0+f1;
            f0=f1;
            f1=fidoN;
        } else if (n==1) fidoN=1; // в задаче условие: ряд ЧФ начинается с 1 (не с 0)
        System.out.println("new n= "+n);


        lastFibo.n=n;
        lastFibo.fibo=fidoN;
        return fidoN;
    }




    public static void main(String[] args) {
        System.out.println(lastFibo.fibo);
        System.out.println("---------------------");
        System.out.println(fiboNumber(5));
        System.out.println(lastFibo.n+"-"+ lastFibo.fibo);
        System.out.println("---------------------");
        System.out.println(fiboNumber(15));
        System.out.println(lastFibo.n+"-"+ lastFibo.fibo);
        System.out.println("---------------------");
        System.out.println(fiboNumber(15));
        System.out.println(lastFibo.n+"-"+ lastFibo.fibo);
        System.out.println("---------------------");
        System.out.println(fiboNumber(10));
        System.out.println(lastFibo.n+"-"+ lastFibo.fibo);
        System.out.println("---------------------");
        System.out.println(fiboNumber(10));
        System.out.println(lastFibo.n+"-"+ lastFibo.fibo);
        System.out.println("---------getLastFibo------------");

        System.out.println(CacheInfo.getLastFibo().n+"-"+CacheInfo.getLastFibo().fibo);
        System.out.println("---------------------");

        CacheInfo.clearLastFibo();
        //System.out.println(lastFibo);
        //System.out.println(lastFibo.fibo);
        //System.out.println("---------------------");

        //System.out.println(lastFibo.n+"-"+ lastFibo.fibo);

    }
}
