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

    public static void codeFile(String inFileName, String outFileName, char[] code, String logName){
        String s;
        char[] chars;
        try {
            FileWriter writer = new FileWriter(outFileName);
            FileReader reader = new FileReader(inFileName);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String strFromFile = scanner.nextLine();
                chars = strFromFile.toCharArray();
//                System.out.println("--"+strFromFile.length());
                s = "";
                for (int i=0;i<strFromFile.length();i++){
                    //just to test:
//                    s += code[(int)chars[i]-100];
                    //H10:
                    s += code[(int)chars[i]];
                    //try simple first:
//                    s += chars[i];
//                    System.out.println(i);
                }

                writer.write(s+"\n");
                // test, write to writer:
//                System.out.println(s);

            }
            reader.close();
            writer.close();
        } catch(IOException e){
            try {
                FileWriter logFile = new FileWriter(logName);
                logFile.write(e.getMessage());
//                logFile.write("error in file");
                System.out.println("try : "+e.getMessage());
                //doesn't work w/o close()
                logFile.close();
            } catch (IOException ioException) {
                System.out.println("catch : ioException");
                throw new RuntimeException(" throw new");

            }

        }
        //return i;
    }

    public static void main(String[] args) {
// to test with code[(int)chars[i]-100]:
        String path1 = "SourceFile.txt";
        String path2 = "OutputFile.txt";
        String path3 = "LogFile.txt";
        // попробовал кодироват из ограниченного шифра и исходника - работает
        char[] ch = {'l', 'i', 'f', 'e', 'k', 'm', 'g', 'h'};
        codeFile(path1, path2, ch, path3);
    }

}
