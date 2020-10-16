package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {
//    Создать статический метод public static int calcEmpty(String fileName),
//    в котором посчитать количество пустых строк в файле. В случае возникновения ошибок, вернуть -1
    public static int calcEmpty(String fileName){
        int i = 0;
        try {
            FileReader reader = new FileReader(fileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String strFromFile = scanner.nextLine();
                if (strFromFile.equals("")) i++;

            }
            reader.close();
        } catch(IOException e){
            return -1;

        }
        return i;
    }
}
