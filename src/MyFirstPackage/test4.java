package MyFirstPackage;
/*
сложение int чисел как строк и потом обратно
 */
public class test4 {
    static int addAsStrings(int n1, int n2){

        return Integer.valueOf(Integer.toString(n1)+Integer.toString(n2));
    }

    static String textGrade(int grade){
        String str1="не определено";
        if (grade==0) str1="не оценено";
        if (grade>0 && grade<21) str1=  "очень плохо";
        if (grade>20 && grade<41) str1=  "плохо";
        if (grade>40 && grade<61) str1=  "удовлетворительно";
        if (grade>60 && grade<81) str1=  "хорошо";
        if (grade>80 && grade<101) str1=  "отлично";
        return str1;

    }

    static long factorial(long n){
        long f1 = 1;
            for (long i=0;i<=n;i++){
                if (n==0) break;
                if (i==0) continue;
                f1*=i;
                }
            return f1;
    }

    public static void main(String[] args) {
        System.out.println(addAsStrings(9283,6574));
        System.out.println(textGrade(8));
        System.out.println(factorial(62));
        int i = (int)765.567;
        System.out.println(i);
    }
}
