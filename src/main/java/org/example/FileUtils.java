package org.example;

import java.io.*;

public class FileUtils {


    //проверка наличия директории, и в случае её отсутвия, создание директории в указанном пути
    public static boolean chekWorkDirectory(String path,String dirName){
        File workDir = new File(path + dirName);
        if (workDir.exists()){
            return true;
        }else{
            return workDir.mkdir();
        }
    }
    //запись текста в текстовый документ, который создается автоматически
    public static void writeStringToFile(String path, String str) throws IOException {
        FileWriter fw = new FileWriter(path);
        fw.write(str);
        fw.close();
    }

    public static byte[] readBytesFromFile(String path) throws FileNotFoundException,IOException{

        File file = new File(path);
        if (file.exists()){ // проверка что файл существует
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[fis.available()]; //available возвращает количество
                                                     // доступных для чтения байтов из входного
                                                    //потока

            fis.read(data);// чтение из потока в массив data
            fis.close(); //закрытие потока
            return data;
        }else{
            // если файл не существует, то метод возвращает пустой массив
            return new byte[]{};
        }
    }

    public static void writeNewFile(String path, byte[] array) throws IOException{
        File file = new File(path);
        if (file.exists()){
            FileOutputStream fos = new FileOutputStream(file);
            for (byte x:array){
                fos.write(x);//Запись байтов в файл
            }

        }else {
            System.out.println("Файла не существует");
        }

    }
}
