/**
 * Пакет лабораторної роботи №3
 */
package KI305.Dumitrashchuk.Lab3;

import java.io.*;

/**
 * Інтерфейс Touchable визначає контракт для об'єктів, що можуть обробляти дотики
 * @author Denys Dumitrashchuk
 * @version 1.0
 */
interface Touchable {
    /**
     * Метод для обробки дотику
     * @param x x-координата дотику
     * @param y y-координата дотику
     * @return true, якщо дотик оброблено успішно, false - якщо ні
     */
    boolean touch(int x, int y);
    
    /**
     * Метод для обробки затримання дотику
     * @param x x-координата затримки дотику
     * @param y y-координата затримки дотику
     * @return true, якщо дотик оброблено успішно, false - якщо ні
     */
    boolean hold(int x, int y);
    
    /**
     * Метод забирає затримку дотику
     */
    void release();
    
    /**
     * Метод для отримання останньої x-координати дотику
     * @return остання x-координата дотику
     */
    int getLastTouchedX();

    /**
     * Метод для отримання останньої y-координати дотику
     * @return остання y-координата дотику
     */
    int getLastTouchedY();
    
    /**
     * Метод для отримання x-координати, що утримується
     * @return x-координата дотику, що утримується. Повертає -1 у випадку, якщо дотик не утримується 
     */
    int getHeldX();

    /**
     * Метод для отримання y-координати, що утримується
     * @return y-координата дотику, що утримується. Повертає -1 у випадку, якщо дотик не утримується 
     */
    int getHeldY();
    
    /**
     * Перевіряє, чи є затримка дотику на екрані
     * @return true, якщо є точка затримки дотику
     */
    boolean isHeld();
}

/**
 * Клас <code>SensorScreen</code>, наслідуючи абстрактний клас <code>Monitor</code>, описує предметну область сенсорного екрана
 * @author Denys Dumitrashchuk
 * @version 1.0
 */
public class SensorScreen extends Monitor implements Touchable{
    private TouchScreen touchScreen;

    /**
     * Створює сенсорний екран за заданими параметрами
     * @param f частота оновлення дисплея (в герцах)
     * @param in розмір екрану в дюймах
     * @param x горизонтальна роздільна здатність
     * @param y вертикальна роздільна здатність
     * @param r співвідношення сторін
     * @param s стан кнопки живлення (увімкнено чи вимкнено)
     * @throws FileNotFoundException якщо файл для запису логів не може бути відкрито
     */
    public SensorScreen(int f, float in, int x, int y, Display.Ratio r, boolean s) throws FileNotFoundException {
        super(f, in, x, y, r, s);
        touchScreen = new TouchScreen(this);
    }
    
    /**
     * Створює сенсорний екран з налаштуваннями за замовчуванням.
     * @throws FileNotFoundException якщо файл для запису логів не може бути відкрито
     */
    public SensorScreen() throws FileNotFoundException{
    	this(60, 11, 1920, 1080, Display.Ratio.R16x9, false);
    }

    /**
     * Метод для обробки дотику
     * @param x x-координата дотику
     * @param y y-координата дотику
     * @return true, якщо дотик оброблено успішно, false - якщо ні
     */
    public boolean touch(int x, int y) {
    	boolean res = touchScreen.touch(x, y);
        logAct("Screen was touched at position x:"+touchScreen.getLastTouchedX()+", y:"+touchScreen.getLastTouchedY()+".");
        return res;
    }

    /**
     * Метод для обробки затримання дотику
     * @param x x-координата затримки дотику
     * @param y y-координата затримки дотику
     * @return true, якщо дотик оброблено успішно, false - якщо ні
     */
	public boolean hold(int x, int y) {
		boolean res = touchScreen.hold(x, y);
        logAct("Screen is held at position x:"+touchScreen.getHeldX()+", y:"+touchScreen.getHeldY()+".");
		return res;
	}

	/**
     * Метод забирає затримку дотику
     */
	public void release() {
		touchScreen.release();
		logAct("Screen was released.");
	}

	/**
     * Метод для отримання останньої x-координати дотику
     * @return остання x-координата дотику
     */
	public int getLastTouchedX() {
		logAct("Getting last touched X.");
		return touchScreen.getLastTouchedX();
	}

	/**
     * Метод для отримання останньої y-координати дотику
     * @return остання y-координата дотику
     */
	public int getLastTouchedY() {
		logAct("Getting last touched Y.");
		return touchScreen.getLastTouchedY();
	}

	/**
     * Метод для отримання x-координати, що утримується
     * @return x-координата дотику, що утримується. Повертає -1 у випадку, якщо дотик не утримується 
     */
	public int getHeldX() {
		logAct("Getting currently held X.");
		return touchScreen.getHeldX();
	}

	/**
     * Метод для отримання y-координати, що утримується
     * @return y-координата дотику, що утримується. Повертає -1 у випадку, якщо дотик не утримується 
     */
	public int getHeldY() {
		logAct("Getting currently held Y.");
		return touchScreen.getHeldY();
	}

	/**
     * Перевіряє, чи є затримка дотику на екрані
     * @return true, якщо є точка затримки дотику
     */
	public boolean isHeld() {
		logAct("Checking if Screen is held.");
		return touchScreen.isHeld();
	}
}

/**
 * Клас <code>TouchScreen</code> імітує функціональну частину тачскріна екрана
 * @author Denys Dumitrashchuk
 * @version 1.0
 */

class TouchScreen implements Touchable{
    private int lastTouchedX;
    private int lastTouchedY;
    private int heldX;
    private int heldY;
    private SensorScreen screen;

    public TouchScreen(SensorScreen screen) {
        this.screen = screen;
        lastTouchedX = -1;
        lastTouchedY = -1;
        heldX = -1;
        heldY = -1;
    }

    public boolean touch(int x, int y) {
    	if(heldX != -1) {
    		return false;
    	}
    	else if (checkArea(x,y)) {
            this.lastTouchedX = x;
            this.lastTouchedY = y;
            return true;
        } else {
            return false;
        }
    }


    public int getLastTouchedX() { 
    	return lastTouchedX; 
    }
    public int getLastTouchedY() { 
    	return lastTouchedY; 
    }
    public int getHeldX() { 
    	return heldX;
    }
    public int getHeldY() { 
    	return heldY;
    }

	public boolean hold(int x, int y) {
		if (checkArea(x,y)) {
            this.lastTouchedX = x;
            this.lastTouchedY = y;
            this.heldX = x;
            this.heldY = y;
            return true;
        } else {
            return false;
        }
	}


	public void release() {
            this.heldX = -1;
            this.heldY = -1;
	}

	public boolean isHeld() {
		if(heldX != -1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean checkArea(int x, int y) {
		if (x > 0 && x <= screen.getResolutionX() && y > 0 && y <= screen.getResolutionY()) {
            return true;
        } else {
            return false;
        }
	}
}