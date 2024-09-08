/**
 * Пакет лабораторної роботи №2
 */
package KI305.Dumitrashchuk.Lab2;


import java.io.*;
/**
 * Клас <code>MonitorApp</code> виконує тестування та демонстрацію роботи класу Monitor.
 * @author Denys Dumitrashchuk
 * @version 1.0
 */
public class MonitorApp {

	/**
	 * Є вхідною точкою програми
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException{
		// Створення монітора за замовчуванням
        Monitor monitor1 = new Monitor();
        System.out.println("Monitor 1 створено за замовчуванням.");
        logMonitorState(monitor1);

        // Увімкнення монітора
        monitor1.togglePower();

        // Підключення USB та HDMI
        monitor1.connectUsb();
        monitor1.connectHdmi();

        // Встановлення нової роздільної здатності
        monitor1.setFullResolution(2560, 1440);

        // Встановлення нової частоти
        monitor1.setFreq(144);

        // Встановлення нового співвідношення сторін
        monitor1.setRatio(Display.Ratio.R3x4);
        logMonitorState(monitor1);
        
        // Створення другого монітору за допомогою іншого конструктора
        Monitor monitor2 = new Monitor(80, (float)13.5, 1920, 1080, Display.Ratio.R3x4,true);
        logMonitorState(monitor2);

        // Закриття ресурсу для логування
        monitor1.dispose();
        monitor2.dispose();
        System.out.println("Логування закінчено, ресурси звільнено.");
        
	}
	
	/**
     * Допоміжний метод для виведення стану монітора на консоль.
     * @param <code>monitor</code> монітор, стан якого необхідно вивести
     */
    private static void logMonitorState(Monitor monitor) {
        System.out.println("Стан монітора:");
        System.out.println("Увімкнений: " + monitor.isTurnedOn());
        System.out.println("USB підключено: " + monitor.isUsbConnected());
        System.out.println("HDMI підключено: " + monitor.isHdmiConnected());
        System.out.println("Частота: " + monitor.getFreq() + " Гц");
        System.out.println("Розмір дисплея: " + monitor.getInches() + " дюймів");
        System.out.println("Роздільна здатність: " + monitor.getFullResolution());
        System.out.println("Співвідношення сторін: " + monitor.getRatio());
        System.out.println();
    }

}
