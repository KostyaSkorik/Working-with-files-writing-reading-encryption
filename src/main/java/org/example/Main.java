package org.example;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        boolean isExistWorkDir = FileUtils.chekWorkDirectory("C:\\", "Skorik");
        System.out.println("Exist work directory: "+isExistWorkDir);

        if (isExistWorkDir){
            String data = "Example string";
            try {
                FileUtils.writeStringToFile("C:\\Skorik\\test.txt", data);
            }catch (IOException ex){
                System.out.println("При записи возникла ошибка: "+ ex.getMessage());
            }
        }

        try {
            byte [] array = FileUtils.readBytesFromFile("C:\\Skorik\\test.txt");
            System.out.println("Array len "+array.length);
            for (int i=0; i<array.length; i++){
                array[i] = (byte) (array[i]*0x1A);//шифрование массива байтов
            }
            FileUtils.writeNewFile("C:\\Skorik\\test.txt",array);//запись зашифрованных данных
        }catch (IOException ex){
            System.out.println("Ошибка: " + ex.getMessage());
        }


    }
}