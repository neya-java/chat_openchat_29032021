package client;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class LogFile {
    private static PrintWriter pwout;

    private static String getLogFileName(String login) {
        String logFileName = "client/history_" + login + ".txt";
        return logFileName;
    }

    public static void createLogFile(String login) {
        try {
            pwout = new PrintWriter(new FileOutputStream(getLogFileName(login), true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeInLogFile(String text) {
        pwout.println(text);
    }

    public static void stopLogFile() {
        pwout.close();
    }

}

//    FileWriter fileWriter;
//
//    public void createLogFile(String login, File file) {
//        try {
//            //File file = new File("client/history_" +login+ ".txt");
//            file.createNewFile();
//
////            fileWriter = new FileWriter("client/history_" +login+ ".txt", true);
////            fileWriter.write("text");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void addTextLogFiles(String text, String nickname) {
//        try {
//            File file = new File("client/history_" + nickname + ".txt");
//            FileWriter writer = new FileWriter(file);
//            writer.write(text);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

//    public static void main(String args[])throws IOException {
//        File file = new File("Example.txt");
//
//        // Создание файла
//        file.createNewFile();
//
//        // Создание объекта FileWriter
//        FileWriter writer = new FileWriter(file);
//
//        // Запись содержимого в файл
//        writer.write("Это простой пример,\n в котором мы осуществляем\n с помощью языка Java\n запись в файл\n и чтение из файла\n");
//        writer.flush();
//        writer.close();
//
//        // Создание объекта FileReader
//        FileReader fr = new FileReader(file);
//        char [] a = new char[200];   // Количество символов, которое будем считывать
//        fr.read(a);   // Чтение содержимого в массив
//
//        for(char c : a)
//            System.out.print(c);   // Вывод символов один за другими
//        fr.close();
//    }