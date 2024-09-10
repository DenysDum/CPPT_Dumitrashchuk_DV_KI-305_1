import java.io.*;
import java.util.*;

/**
 * Клас <code>Lab1DumitrashchukKI305</code> виконує програму до завдання лабораторної роботи №1.
 * Програма створює квадратну матрицю з символів, заданого користувачем, і зберігає її у файл.
 * @author Denys Dumitrashchuk
 * @version 2.0.methods
 */
public class Lab1DumitrashchukKI305 {

    /**
     * <code>main</code> є точкою входу в програму.
     * @param args Аргументи командного рядка (не використовуються в даній програмі).
     * @throws FileNotFoundException Якщо файл не може бути створений або відкритий для запису.
     */
    public static void main(String[] args) throws FileNotFoundException {
        int rows;
        char filler;
        Scanner in = new Scanner(System.in);

        rows = getRows(in);
        filler = getFiller(in);

        char arr[][] = createArr(rows, filler);
        
        outInConsole(arr, rows);
        outInFile(arr, rows);
        
    }
    
    /**
     * Метод для введення розміру масиву
     * @param in об'єкт класу Scanner для введення даних
     * @return розмір масиву
     */
    
    private static int getRows(Scanner in) {
        int rows;
    	while(true) {
	    	System.out.print("Введіть розмір квадратної матриці (бажано парне число): ");
	        rows = in.nextInt();
	        in.nextLine();

	        if (rows > 0) {
	            return rows;
	        }
	        System.out.println("Розмір має бути більше нуля.");
    	}
    }
    
    /**
     * Метод для введення символу-заповнювача
     * @param in об'єкт класу Scanner для введення даних
     * @return символ-заповнювач
     */
    private static char getFiller(Scanner in) {
    	String filler;
    	while(true) {
	    	System.out.print("Введіть символ-заповнювач: ");
            filler = in.nextLine();
                
                if (filler.length() == 1) {
                    in.close();
                    return filler.charAt(0);
                }
                if (filler.length() == 0) {
                    System.out.println("Не введено символ-заповнювач.");
                } else {
                    System.out.println("Символ-заповнювач має складатися тільки з одного символу.");
                }
	    }
    }
    
    /**
     * Метод для створення масиву, заповненого символом-заповнювачем
     * @param rows розмір масиву
     * @param filler символ-заповнювач
     * @return масив, заповнений символом-заповнювачем
     */
    private static char[][] createArr(int rows, char filler) {
    	char arr[][] = new char[rows][];
    	int mid = rows / 2, temp = rows - mid;
    	for (int i = 0; i < rows; i++) {
            if (i < mid) {
                arr[i] = new char[mid];
                for (int j = 0; j < mid; j++) {
                    arr[i][j] = filler;
                }
            } else {
                arr[i] = new char[temp];
                for (int j = 0; j < temp; j++) {
                    arr[i][j] = filler;
                }
            }
        }
    	return arr;
    }
    
    /**
     * Метод для виведення масиву в консоль
     * @param arr масив для виведення
     * @param rows розмір масиву
     */
    private static void outInConsole(char arr[][], int rows) {
    	int mid = rows / 2, temp = rows - mid;
    	for (int i = 0; i < rows; i++) {
            if (i < mid) {
                for (int j = 0; j < temp; j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j < mid; j++) {
                    System.out.print(arr[i][j] + " ");
 
                }
            } else {
                for (int j = 0; j < temp; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    /**
     * Метод для виведення масиву у текстовий файл
     * @param arr масив для виведення
     * @param rows розмір масиву
     * @throws FileNotFoundException якщо неможливо створити або відкрити файл
     */
    private static void outInFile(char arr[][], int rows) throws FileNotFoundException{
        File dataFile = new File("Lab1_file.txt");
        PrintWriter fout = new PrintWriter(dataFile);
    	int mid = rows / 2, temp = rows - mid;
        for (int i = 0; i < rows; i++) {
            if (i < mid) {
                for (int j = 0; j < temp; j++) {
                    fout.print("  ");
                }
                for (int j = 0; j < mid; j++) {
                    fout.print(arr[i][j] + " ");
                }
            } else {
                for (int j = 0; j < temp; j++) {
                    fout.print(arr[i][j] + " ");
                }
            }
            fout.println();
        }
        fout.flush();
        fout.close();
    }
    
}

