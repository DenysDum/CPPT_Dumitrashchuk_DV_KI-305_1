/**
 * Пакет лабораторної роботи №5
 */
package KI305.Dumitrashchuk.Lab5;

import java.io.*;
/**
 * Клас-драйвер для демонстрації роботи CalculatorFIO
 * @author Denys Dumitrashchuk
 * @version 1.0
 */
public class CalculatorFIOApp {

	/**
	 * Головний метод для демонстрації роботи класу <code>CalculatorFIO</code>
	 * @param args у даній програмі не використовується
	 */
	public static void main(String[] args) {
		CalculatorFIO calcFIO = new CalculatorFIO();
        
        // Демонстрація обчислення
        System.out.println("Демонстрація обчислення:");
        calcFIO.calculate(45);
        System.out.println("Результат обчислення для x = 45: " + calcFIO.getResult());
        
        // Демонстрація запису у текстовий файл
        System.out.println("\nЗапис результату у текстовий файл:");
        calcFIO.writeTxt("result.txt");
        
        // Демонстрація читання з текстового файлу
        System.out.println("\nЧитання результату з текстового файлу:");
        calcFIO.readTxt("result.txt");
        System.out.println("Прочитаний результат: " + calcFIO.getResult());
        
        // Демонстрація запису у бінарний файл
        System.out.println("\nЗапис результату у бінарний файл:");
        calcFIO.writeBin("result.bin");
        
        // Демонстрація читання з бінарного файлу
        System.out.println("\nЧитання результату з бінарного файлу:");
        calcFIO.readBin("result.bin");
        System.out.println("Прочитаний результат: " + calcFIO.getResult());
    }

}
