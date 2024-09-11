/**
 * Пакет лабораторної роботи №5
 */
package KI305.Dumitrashchuk.Lab5;

import java.io.*;
import java.util.*;

/**
 * Клас <code>CalculatorFIO</code> забезпечує операції з калькулятором та файловим введенням/виведенням
 * @author Denys Dumitrashchuk
 * @version 1.0
 */
public class CalculatorFIO {
	private Calculator calc;
	private double res;
	
	/**
     * Конструктор за замовчуванням
     */
	CalculatorFIO(){
		calc = new Calculator();
	}
	
	/**
     * Записує результат у текстовий файл
     * @param name ім'я файлу
     */
	public void writeTxt(String name){
		try{
			PrintWriter f = new PrintWriter(name);
			f.printf("%f ",res);
			f.close();
			System.out.println("Результат був успішно записаний до текстового файлу.");
		}
		catch(FileNotFoundException ex) {
			System.out.println("Неможливо було створити файл або відкрити існуючий файл.");
		}
		
	}
	
	/**
     * Читає результат з текстового файлу
     * @param name ім'я файлу
     */
	public void readTxt(String name){
		try{
		File f = new File (name);
			if (f.exists()){
				Scanner s = new Scanner(f);
				res = s.nextDouble();
				s.close();
				System.out.println("Результат був успішно зчитаний з текстового файлу.");
			}
			else throw new FileNotFoundException("Файл з ім'ям " + name + " не був знайдений");
		}
		catch (FileNotFoundException ex){
			System.out.print(ex.getMessage());
		}
	}
	
	/**
     * Записує результат у бінарний файл
     * @param name ім'я файлу
     */
	public void writeBin(String name){
		try {
			DataOutputStream f = new DataOutputStream(new FileOutputStream(name));
			f.writeDouble(res);
			f.close();
			System.out.println("Результат був успішно записаний до бінарного файлу.");
		}
		catch(FileNotFoundException ex1) {
			System.out.println("Неможливо було створити файл або відкрити існуючий файл.");
		}
		catch(IOException ex2) {
			System.out.println("Виникла проблема з потоком вводу/виведення.");
		}

	}
	
	 /**
     * Читає результат з бінарного файлу
     * @param name ім'я файлу
     */
	public void readBin(String name){
		
		try {
			DataInputStream f = new DataInputStream(new FileInputStream(name));
			res = f.readDouble();
			f.close();
			System.out.println("Результат був успішно зчитаний з бінарного файлу.");
		}
		catch(FileNotFoundException ex1) {
			System.out.println("Неможливо відкрити файл з ім'ям "+name+".");
		}
		catch(IOException ex2) {
			System.out.println("Виникла проблема з потоком вводу/виведення.");
		}
	}
	
	/**
     * Обчислює вираз через клас <code>Calculator</code> та зберігає результат в середині класу <code>CalculatorFIO</code>
     * @param x Кут в градусах(дробове число)
     */
	public void calculate(double x) {
		try{
			res = calc.calculate(x);
		}
		catch(CalcException e) {
			System.err.println("Помилка при обчисленні виразу: " + e.getMessage());
		}
	}
	
	/**
     * Повертає поточний результат
     * @return поточний результат
     */
    public double getResult() {
        return res;
    }

}



/**
* Клас <code>CalcException</code> представляє спеціальне виключення для обчислень.
* @author Denys Dumitrashchuk
* @version 1.0
*/
class CalcException extends ArithmeticException
{
	/**
     * Конструктор за замовчуванням.
     */
	public CalcException(){}
	/**
     * Конструктор з параметром.
     * @param cause причина виключення
     */
	public CalcException(String cause){
		super(cause);
	}
}

/**
 * Клас <code>Calculator</code> реалізує метод обчислення виразу згідно з варіантом
 * @author Denys Dumitrashchuk
 * @version 1.0
 */
class Calculator {
	/**
	 * Конструктор за замовчуванням
	 */
	public Calculator() {
	}
	
	/**
	* Метод обчислює вираз con(x)/tan(x)
	* @param x Кут в градусах(дробове число)
	* @return результат обчислення виразу
	* @throws CalcException якщо виникла арифметична проблема під час обчислення виразу
	*/
	public double calculate(double x) throws CalcException{
		double y = 0, striped_x, rad;
		// Обмежуємо значення x до діапазону [0, 360]
		striped_x = x % 360.0;
		try{
			// Перевіряємо допустимість значення x
			if (striped_x % 90.0 == 0) throw new ArithmeticException();
			// Якщо перевірка пройшла успішно, обчислюємо вираз
			rad = striped_x * Math.PI / 180.0;
			y = 1.0 / Math.tan(rad) / Math.tan(rad);
		}
		catch (ArithmeticException ex){
			// Обробник виключення вищого рівня
			if (striped_x == 90.0 || striped_x == 270.0) throw new CalcException("Причина виключення: заборонене значення X для обрахунку значення тангенса.");
			else if (striped_x == 0.0 || striped_x == 180.0 || striped_x == 360.0) throw new CalcException("Причина виключення: заборонене значення X для обрахунку значення котангенса.");
			else throw new CalcException("Причина виключення: невідома.");
		}
		return y;
	}

}