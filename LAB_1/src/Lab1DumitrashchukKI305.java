import java.io.*;
import java.util.*;

/**
 * Клас <code>Lab1DumitrashchukKI305</code> виконує програму до завдання лабораторної роботи №1.
 * Програма створює квадратну матрицю з символів, заданого користувачем, і зберігає її у файл.
 * @author Denys Dumitrashchuk
 * @version 1.0
 */
public class Lab1DumitrashchukKI305 {

    /**
     * <code>main</code> є точкою входу в програму.
     * @param args Аргументи командного рядка (не використовуються в даній програмі).
     * @throws FileNotFoundException Якщо файл не може бути створений або відкритий для запису.
     */
    public static void main(String[] args) throws FileNotFoundException {
        int rows;
        String filler;
        Scanner in = new Scanner(System.in);

        /*
         *  Блок для введення розміру матриці
         */
        EnterRows: {
            System.out.print("Введіть розмір квадратної матриці (бажано парне число): ");
            rows = in.nextInt();
            in.nextLine();
            /*
             *  Перевірка, чи розмір більше нуля
             */
            if (rows > 0) {
                break EnterRows;
            }
            System.out.print("Розмір має бути більше нуля.");
        }

        /*
         *  Блок для введення символу-заповнювача
         */
        EnterChar: {
            System.out.print("Введіть символ-заповнювач: ");
            filler = in.nextLine();
            /*
             *  Перевірка, чи символ-заповнювач складається з одного символу
             */
            if (filler.length() == 1) {
                break EnterChar;
            }
            if (filler.length() == 0) {
                System.out.print("Не введено символ-заповнювач.");
            } else {
                System.out.print("Символ-заповнювач має складатися тільки з одного символу.");
            }
            return;
        }

        /*
         *  Створення масиву для матриці символів
         */
        char arr[][] = new char[rows][];
        int mid = rows / 2, temp = rows - mid;
        File dataFile = new File("Lab1_file.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        /*
         *  Заповнення матриці і виведення її в консоль та у файл
         */
        for (int i = 0; i < rows; i++) {
            if (i < mid) {
                arr[i] = new char[mid];
                for (int j = 0; j < temp; j++) {
                    System.out.print("  ");
                    fout.print("  ");
                }
                for (int j = 0; j < mid; j++) {
                    arr[i][j] = (char) filler.codePointAt(0);
                    System.out.print(arr[i][j] + " ");
                    fout.print(arr[i][j] + " ");
                }
            } else {
                arr[i] = new char[temp];
                for (int j = 0; j < temp; j++) {
                    arr[i][j] = (char) filler.codePointAt(0);
                    System.out.print(arr[i][j] + " ");
                    fout.print(arr[i][j] + " ");
                }
            }
            fout.println();
            System.out.println();
        }
        // Закриття файлу після запису
        fout.flush();
        fout.close();
    }
}
