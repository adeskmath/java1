package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Coder {
//    Создать статический метод public static void codeFile(String inFileName, String outFileName, char[] code, String logName),
//    в котором прочитать файл inFileName и перекодировать его посимвольно в соответствии с заданным шифром,
//    результат записать в outFileName.
//    Шифр задается маcсивом char[] code, где каждому символу symbol оригинального файла
//    соответствует символ code[(int)symbol] выходного файла.
    // (int)symbol - ASCII value of symbol
//    В случае ошибок, в файл с именем logName вывести название ошибки через метод класса Exception - getMessage()

    // скопировать готовый/протестрованный код из моего ReadWriteTest, убрав лишнее
    public static void codeFile(String inFileName, String outFileName, char[] code, String logName) {
        String s = "";
        char[] chars;
        int i;
        try (FileReader reader = new FileReader(inFileName)) {
// reading try===============================================

            while ((i = reader.read()) != -1) {
                s += code[(char)i];
            }
            //writing---------------------
            try {
                FileWriter writer = new FileWriter(outFileName);
                try {
                    writer.write(s);
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage());
                }finally {
                    writer.close();
                }
                //------------------------------
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (Exception e){
            try {
                FileWriter logFile = new FileWriter(logName);
                logFile.write(e.getMessage());
                logFile.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
//================================================================================
    }



    public static void main(String[] args) {
// to test with code[(char)i-100];
        String path1 = "SourceFile.txt";
        String path2 = "OutputFile.txt";
        String path3 = "LogFile3.txt";
        // попробовал кодироват из ограниченного шифра и исходника - работает
        char[] ch = {'l', 'i', 'f', 'e', 'k', 'm', 'g', 'h', 'j'};
        codeFile(path1, path2, ch, path3);
    }

}
