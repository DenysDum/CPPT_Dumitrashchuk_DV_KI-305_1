/**
 * Пакет лабораторної роботи №3
 */
package KI305.Dumitrashchuk.Lab3;

import java.io.*;

/**
 * Клас-драйвер демонструє функціонал класу <code>SensorScreen</code>
 */
public class SensorMonitorApp {

	/**
	 * <code>main</code> є вхідною точкою в програму
	 * @param args не використовується у даній програмі
	 */
	public static void main(String[] args) {
		try {
            // Створення об'єкта SensorScreen
            SensorScreen screen = new SensorScreen(120, 15.6f, 1920, 1080, Display.Ratio.R16x9, true);
            
            // Демонстрація методів успадкованих від Monitor
            System.out.println("Монітор увімкнено: " + screen.isTurnedOn());
            System.out.println("Роздільна здатність: " + screen.getFullResolution());
            
            // Підключення портів
            screen.connectUsb();
            screen.connectHdmi();
            System.out.println("USB підключено: " + screen.isUsbConnected());
            System.out.println("HDMI підключено: " + screen.isHdmiConnected());
            
            // Демонстрація сенсорних можливостей
            System.out.println("\nДемонстрація сенсорних можливостей:");
            
            // Дотик до екрану
            boolean touchResult = screen.touch(500, 500);
            System.out.println("Дотик до координат (500, 500): " + (touchResult ? "успішно" : "невдало"));
            System.out.println("Останній дотик X: " + screen.getLastTouchedX());
            System.out.println("Останній дотик Y: " + screen.getLastTouchedY());
            
            // Утримання дотику
            boolean holdResult = screen.hold(600, 600);
            System.out.println("\nУтримання на координатах (600, 600): " + (holdResult ? "успішно" : "невдало"));
            System.out.println("Координати утримання X: " + screen.getHeldX());
            System.out.println("Координати утримання Y: " + screen.getHeldY());
            System.out.println("Екран утримується: " + screen.isHeld());
            
            // Спроба нового дотику під час утримання
            touchResult = screen.touch(700, 700);
            System.out.println("\nСпроба нового дотику під час утримання (700, 700): " + (touchResult ? "успішно" : "невдало"));
            
            // Звільнення екрану
            screen.release();
            System.out.println("\nЕкран звільнено");
            System.out.println("Екран утримується: " + screen.isHeld());
            
            // Спроба дотику поза межами екрану
            touchResult = screen.touch(2000, 2000);
            System.out.println("\nСпроба дотику поза межами екрану (2000, 2000): " + (touchResult ? "успішно" : "невдало"));
            
            // Завершення роботи
            screen.dispose();
            System.out.println("\nРоботу завершено, ресурси звільнено");
            
        } catch (FileNotFoundException e) {
            System.err.println("Помилка при створенні файлу логу: " + e.getMessage());
        }

	}

}
