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
        char[] chars;
        char[] filterArray;
        String s;

        try {
            FileWriter writer = new FileWriter(outFileName);
            FileReader reader = new FileReader(inFileName);
            Scanner scanner = new Scanner(reader);
            filterArray = filter.toCharArray();
//            System.out.println("filter "+filterArray[2]);
            while (scanner.hasNextLine()) {
                String strFromFile = scanner.nextLine();
                chars = strFromFile.toCharArray();
                System.out.println(chars);
//                System.out.println("--"+strFromFile.length());
                s = "";

                for (int i=0;i<chars.length;i++){
                    int n=0;
                    for (int j=0;j<filter.length();j++){
//                        System.out.println("filter----> "+filterArray[j]);
//                        System.out.println(j+" filter "+filterArray[j]);

                        if (chars[i]==filterArray[j]){
                            n=n+1;
//                            System.out.println("matched "+chars[i]+"=="+filterArray[j]);
                           break;
                        }


                    }
                    if (n==0) s += chars[i];

                }
                writer.write(s+"\n");
            }
            reader.close();
            writer.close();
        } catch(IOException e){
            System.out.println("catch : ioException");
            throw new RuntimeException("Невозможно открыть/записать файл ");
        }
    }
    public static void main(String[] args) {

        String path1 = "SourceFileFilter.txt";
        String path2 = "OutputFileFilter2.txt";
        String obscene = " -,.()—";
        filterFile(path1,path2,obscene);

    }
}
