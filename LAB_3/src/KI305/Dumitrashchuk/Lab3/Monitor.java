/**
 * Пакет лабораторної роботи №3
 */
package KI305.Dumitrashchuk.Lab3;

import java.io.*;

/**
 * Абстрактний лас <code>Monitor</code> описує монітор з можливістю керування живленням, підключенням портів та налаштуванням дисплея.
 * @author Denys Dumitrashchuk
 * @version 1.0.abstract
 */
abstract public class Monitor {
    private Button button;
    private Ports ports;
    private Display display;
    protected PrintWriter fout;
    static private int monitor_count = 0;

    /**
     * Створює монітор з заданими параметрами.
     * @param f частота оновлення дисплея (в герцах)
     * @param in розмір екрану в дюймах
     * @param x горизонтальна роздільна здатність
     * @param y вертикальна роздільна здатність
     * @param r співвідношення сторін
     * @param s стан кнопки живлення (увімкнено чи вимкнено)
     * @throws FileNotFoundException якщо файл для запису логів не може бути відкрито
     */
    public Monitor(int f, float in, int x, int y, Display.Ratio r, boolean s) throws FileNotFoundException {
        button = new Button(s);
        ports = new Ports();
        display = new Display(f, in, x, y, r);
        monitor_count++;
        fout = new PrintWriter(new File("Log"+monitor_count+".txt"));
    }

    /**
     * Створює монітор з налаштуваннями за замовчуванням.
     * @throws FileNotFoundException якщо файл для запису логів не може бути відкрито
     */
    public Monitor() throws FileNotFoundException {
        this(60, 11, 1920, 1080, Display.Ratio.R16x9, false);
    }

    /**
     * Створює монітор з налаштуваннями за замовчуванням та встановленим станом кнопки живлення.
     * @param s стан кнопки живлення (увімкнено чи вимкнено)
     * @throws FileNotFoundException якщо файл для запису логів не може бути відкрито
     */
    public Monitor(boolean s) throws FileNotFoundException {
        this(60, 11, 1920, 1080, Display.Ratio.R16x9, s);
    }

    /**
     * Перевіряє, чи підключений USB.
     * @return true, якщо USB підключено
     */
    public boolean isUsbConnected() {
        logAct("Checking if USB is connected.");
        return ports.isUsbConnected();
    }

    /**
     * Перевіряє, чи підключений HDMI.
     * @return true, якщо HDMI підключено
     */
    public boolean isHdmiConnected() {
        logAct("Checking if HDMI is connected.");
        return ports.isHdmiConnected();
    }

    /**
     * Підключає USB до монітора.
     */
    public void connectUsb() {
        logAct("USB connected.");
        ports.connectUsb();
    }

    /**
     * Підключає HDMI до монітора.
     */
    public void connectHdmi() {
        logAct("HDMI connected.");
        ports.connectHdmi();
    }

    /**
     * Відключає USB від монітора.
     */
    public void disconnectUsb() {
        logAct("USB disconnected.");
        ports.disconnectUsb();
    }

    /**
     * Відключає HDMI від монітора.
     */
    public void disconnectHdmi() {
        logAct("HDMI disconnected.");
        ports.disconnectHdmi();
    }

    /**
     * Перевіряє, чи монітор увімкнено.
     * @return true, якщо монітор увімкнено
     */
    public boolean isTurnedOn() {
        logAct("Checking if monitor is turned on.");
        return button.getState();
    }

    /**
     * Вмикає або вимикає монітор.
     */
    public void togglePower() {
        logAct("Toggling power.");
        button.push();
    }

    /**
     * Отримує частоту оновлення дисплея.
     * @return частота в герцах
     */
    public int getFreq() {
        logAct("Getting display frequency.");
        return display.getFreq();
    }

    /**
     * Отримує розмір екрану в дюймах.
     * @return розмір екрану в дюймах
     */
    public float getInches() {
        logAct("Getting display size in inches.");
        return display.getInches();
    }

    /**
     * Отримує повну роздільну здатність дисплея у форматі "ширинаХвисота".
     * @return роздільна здатність
     */
    public String getFullResolution() {
        logAct("Getting full display resolution.");
        return display.getFullResolution();
    }

    /**
     * Отримує горизонтальну роздільну здатність дисплея.
     * @return горизонтальна роздільна здатність
     */
    public int getResolutionX() {
        logAct("Getting display horizontal resolution.");
        return display.getResolutionX();
    }

    /**
     * Отримує вертикальну роздільну здатність дисплея.
     * @return вертикальна роздільна здатність
     */
    public int getResolutionY() {
        logAct("Getting display vertical resolution.");
        return display.getResolutionY();
    }

    /**
     * Отримує співвідношення сторін дисплея.
     * @return співвідношення сторін у вигляді рядка
     */
    public String getRatio() {
        logAct("Getting display aspect ratio.");
        return display.getRatio();
    }

    /**
     * Встановлює частоту оновлення дисплея.
     * @param f нова частота
     */
    public void setFreq(int f) {
        logAct("Setting display frequency to " + f + "Hz.");
        display.setFreq(f);
    }

    /**
     * Встановлює розмір екрану в дюймах.
     * @param in новий розмір екрану
     */
    public void setInches(int in) {
        logAct("Setting display size to " + in + " inches.");
        display.setInches(in);
    }

    /**
     * Встановлює нову роздільну здатність дисплея.
     * @param x нова ширина
     * @param y нова висота
     */
    public void setFullResolution(int x, int y) {
        logAct("Setting full display resolution to " + x + "x" + y + ".");
        display.setFullResolution(x, y);
    }

    /**
     * Встановлює горизонтальну роздільну здатність дисплея.
     * @param x нова ширина
     */
    public void setResolutionX(int x) {
        logAct("Setting display horizontal resolution to " + x + ".");
        display.setResolutionX(x);
    }

    /**
     * Встановлює вертикальну роздільну здатність дисплея.
     * @param y нова висота
     */
    public void setResolutionY(int y) {
        logAct("Setting display vertical resolution to " + y + ".");
        display.setResolutionY(y);
    }

    /**
     * Встановлює співвідношення сторін дисплея.
     * @param r нове співвідношення сторін
     */
    public void setRatio(Display.Ratio r) {
        display.setRatio(r);
        logAct("Setting display aspect ratio to " + display.getRatio() + ".");
    }
    
    /**
     * Звільнює ресурси, які були використані для роботи з файлом.
     */
    public void dispose() {
    	fout.close();
    }
    
    /**
     * Виводить стрічку тексту у текстовий файл Log#.txt (у # підставляється номер даного монітора)
     * @param str стрічка тексту, що має бути виведена у текстовому файлі
     */
    protected void logAct(String str) {
    	fout.println(str);
        fout.flush();
    }
}

/**
 * Клас <code>Button</code> представляє кнопку живлення монітора.
 * @author Denys Dumitrashchuk
 * @version 1.0
 */
class Button {
    private boolean state;

    /**
     * Створює кнопку живлення з початковим вимкненим станом.
     */
    public Button() {
        state = false;
    }

    /**
     * Створює кнопку живлення з заданим початковим станом.
     * @param s початковий стан кнопки (true - увімкнено, false - вимкнено)
     */
    public Button(boolean s) {
        state = s;
    }

    /**
     * Змінює стан кнопки на протилежний.
     * Якщо було увімкнено, стає вимкнено, і навпаки.
     */
    public void push() {
        state = !state;
    }

    /**
     * Встановлює конкретний стан кнопки.
     * @param s новий стан кнопки (true - увімкнено, false - вимкнено)
     */
    public void setState(boolean s) {
        state = s;
    }

    /**
     * Повертає поточний стан кнопки.
     * @return true, якщо кнопка увімкнена, false - якщо вимкнена
     */
    public boolean getState() {
        return state;
    }
}

/**
 * Клас <code></code>представляє порти для підключення USB та HDMI.
 * @author Denys Dumitrashchuk
 * @version 1.0
 */
class Ports {
    private boolean usbConn;
    private boolean hdmiConn;

    /**
     * Створює об'єкт з відключеними портами USB та HDMI.
     */
    public Ports() {
        usbConn = false;
        hdmiConn = false;
    }

    /**
     * Перевіряє, чи підключений USB.
     * @return true, якщо USB підключено
     */
    public boolean isUsbConnected() {
        return usbConn;
    }

    /**
     * Перевіряє, чи підключений HDMI.
     * @return true, якщо HDMI підключено
     */
    public boolean isHdmiConnected() {
        return hdmiConn;
    }

    /**
     * Підключає USB до монітора.
     */
    public void connectUsb() {
        usbConn = true;
    }

    /**
     * Підключає HDMI до монітора.
     */
    public void connectHdmi() {
        hdmiConn = true;
    }

    /**
     * Відключає USB від монітора.
     */
    public void disconnectUsb() {
        usbConn = false;
    }

    /**
     * Відключає HDMI від монітора.
     */
    public void disconnectHdmi() {
        hdmiConn = false;
    }
}

/**
 * Клас <code>Display</code> що представляє дисплей монітора.
 * @author Denys Dumitrashchuk
 * @version 1.0
 */
class Display {
    /**
     * Перерахування можливих співвідношень сторін екрану.
     */
    public enum Ratio {R3x4, R16x9}

    private int freq;      // Частота оновлення дисплея (в герцах)
    private float inches;  // Розмір екрану в дюймах
    private int res_x;     // Горизонтальна роздільна здатність
    private int res_y;     // Вертикальна роздільна здатність
    private Ratio ratio;   // Співвідношення сторін

    /**
     * Створює дисплей з налаштуваннями за замовчуванням:
     * частота - 60 Гц, розмір - 11 дюймів, роздільна здатність - 1920x1080, співвідношення - 16x9.
     */
    public Display() {
        this(60, 11, 1920, 1080, Ratio.R16x9);
    }

    /**
     * Створює дисплей з заданими параметрами.
     * @param f частота оновлення дисплея (в герцах)
     * @param in розмір екрану в дюймах
     * @param x горизонтальна роздільна здатність
     * @param y вертикальна роздільна здатність
     * @param r співвідношення сторін
     */
    public Display(int f, float in, int x, int y, Ratio r) {
        freq = f;
        inches = in;
        res_x = x;
        res_y = y;
        ratio = r;
    }

    /**
     * Повертає частоту оновлення дисплея.
     * @return частота оновлення в герцах
     */
    public int getFreq() {
        return freq;
    }

    /**
     * Повертає розмір екрану в дюймах.
     * @return розмір екрану
     */
    public float getInches() {
        return inches;
    }

    /**
     * Повертає повну роздільну здатність дисплея у форматі "ширинаxвисота".
     * @return роздільна здатність
     */
    public String getFullResolution() {
        return res_x + "x" + res_y;
    }

    /**
     * Повертає горизонтальну роздільну здатність дисплея.
     * @return горизонтальна роздільна здатність
     */
    public int getResolutionX() {
        return res_x;
    }

    /**
     * Повертає вертикальну роздільну здатність дисплея.
     * @return вертикальна роздільна здатність
     */
    public int getResolutionY() {
        return res_y;
    }

    /**
     * Повертає співвідношення сторін дисплея.
     * @return співвідношення сторін у вигляді рядка ("3x4" або "16x9")
     */
    public String getRatio() {
        if (ratio == Ratio.R3x4) {
            return "3x4";
        } else {
            return "16x9";
        }
    }

    /**
     * Встановлює частоту оновлення дисплея.
     * @param f нова частота в герцах
     */
    public void setFreq(int f) {
        freq = f;
    }

    /**
     * Встановлює розмір екрану в дюймах.
     * @param in новий розмір екрану
     */
    public void setInches(int in) {
        inches = in;
    }

    /**
     * Встановлює нову роздільну здатність дисплея.
     * @param x нова горизонтальна роздільна здатність
     * @param y нова вертикальна роздільна здатність
     */
    public void setFullResolution(int x, int y) {
        res_x = x;
        res_y = y;
    }

    /**
     * Встановлює нову горизонтальну роздільну здатність дисплея.
     * @param x нова ширина
     */
    public void setResolutionX(int x) {
        res_x = x;
    }

    /**
     * Встановлює нову вертикальну роздільну здатність дисплея.
     * @param y нова висота
     */
    public void setResolutionY(int y) {
        res_y = y;
    }

    /**
     * Встановлює нове співвідношення сторін дисплея.
     * @param r нове співвідношення сторін
     */
    public void setRatio(Ratio r) {
        ratio = r;
    }
}
