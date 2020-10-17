package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*Задача 3. Класс CharFilter
Создать статический метод public static void filterFile(String inFileName, String outFileName, String filter),
в котором прочитать файл inFileName и удалить символы, содержащиеся в String filter, результат записать в выходной файл.
В случае возникновения ошибки, пробросить стандартное исключение выше, корректно закрыв все ресурсы
Например файл содержит:
Java — строго типизированный объектно-ориентированный язык программирования, разработанный компанией
Sun Microsystems (в последующем приобретённой компанией Oracle).
obscene = " -,.()"
Должен выдать результат:
JavaстроготипизированныйобъектноориентированныйязыкпрограммированияразработанныйкомпаниейSunMicrosystemsвпоследующемприобретённойкомпаниейOracle*/
public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter){
        char[] filterArray;
        String s="";

        try {
            FileReader reader = new FileReader(inFileName);
            try {
                FileWriter writer = new FileWriter(outFileName);
                filterArray = filter.toCharArray();
                int i;
                while ((i = reader.read()) != -1){
                    int n=0;
                    for (int j=0;j<filter.length();j++){
                        if ((char)i==filterArray[j]){
                            n=n+1;
                           break;
                        }
                    }
                    if (n==0) s += (char)i;
                }
//              System.out.println(s);
                writer.write(s);
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
//            00000000000000000000000000000000000000000
            reader.close();
        } catch(IOException e){
            System.out.println("catch : ioException");
            throw new RuntimeException("Невозможно открыть/записать файл ");
        }
    }
    public static void main(String[] args) {

        String path1 = "SourceFileFilter.txt";
        String path2 = "OutputFileFilter000.txt";
        String obscene = " -,.()—";
        filterFile(path1,path2,obscene);

    }
}
