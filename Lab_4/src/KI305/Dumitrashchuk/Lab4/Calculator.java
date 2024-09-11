/**
 * Пакет лабораторної роботи №4
 */
package KI305.Dumitrashchuk.Lab4;

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
public class Calculator {
	/**
	* Метод обчислює вираз con(x)/tan(x)
	* @param x Кут в градусах(дробове число)
	* @return результат обчислення виразу
	* @throws CalcException якщо виникла арифметична проблема під час обчислення виразу
	*/
	public double calculate(double x) throws CalcException{
		double y, striped_x, rad;
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
