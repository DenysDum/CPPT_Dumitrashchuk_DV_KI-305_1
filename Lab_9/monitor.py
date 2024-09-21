from button import Button
from ports import Ports
from display import Display, Ratio


class Monitor:
    """Клас, що представляє монітор."""

    def __init__(self, freq=60, inches=11, res_x=1920, res_y=1080, ratio=Ratio.R16x9, state=False):
        """
        Ініціалізує об'єкт Monitor.

        Аргументи:
        freq (int): Частота оновлення екрану в Гц. За замовчуванням 60.
        inches (int): Розмір екрану в дюймах. За замовчуванням 11.
        res_x (int): Горизонтальна роздільна здатність. За замовчуванням 1920.
        res_y (int): Вертикальна роздільна здатність. За замовчуванням 1080.
        ratio (Ratio): Співвідношення сторін екрану. За замовчуванням 16:9.
        state (bool): Початковий стан монітора (увімкнено/вимкнено). За замовчуванням False.
        """
        self.button = Button(state)
        self.ports = Ports()
        self.display = Display(freq, inches, res_x, res_y, ratio)

    def is_usb_connected(self):
        """
        Перевіряє, чи підключений USB.

        Повертає:
        bool: True, якщо USB підключений, інакше False.
        """
        return self.ports.is_usb_connected()

    def is_hdmi_connected(self):
        """
        Перевіряє, чи підключений HDMI.

        Повертає:
        bool: True, якщо HDMI підключений, інакше False.
        """
        return self.ports.is_hdmi_connected()

    def connect_usb(self):
        """
        Підключає USB.
        """
        self.ports.connect_usb()

    def connect_hdmi(self):
        """
        Підключає HDMI.
        """
        self.ports.connect_hdmi()

    def disconnect_usb(self):
        """
        Відключає USB.
        """
        self.ports.disconnect_usb()

    def disconnect_hdmi(self):
        """
        Відключає HDMI.
        """
        self.ports.disconnect_hdmi()

    def is_turned_on(self):
        """
        Перевіряє, чи увімкнений монітор.

        Повертає:
        bool: True, якщо монітор увімкнений, інакше False.
        """
        return self.button.get_state()

    def toggle_power(self):
        """
        Перемикає стан живлення монітора.
        """
        self.button.push()

    def get_freq(self):
        """
        Отримує частоту оновлення екрану.

        Повертає:
        int: Частота оновлення екрану в Гц.
        """
        return self.display.get_freq()

    def get_inches(self):
        """
        Отримує розмір екрану в дюймах.

        Повертає:
        int: Розмір екрану в дюймах.
        """
        return self.display.get_inches()

    def get_full_resolution(self):
        """
        Отримує повну роздільну здатність екрану.

        Повертає:
        str: Рядок у форматі "ширинахвисота".
        """
        return self.display.get_full_resolution()

    def get_resolution_x(self):
        """
        Отримує горизонтальну роздільну здатність.

        Повертає:
        int: Горизонтальна роздільна здатність.
        """
        return self.display.get_resolution_x()

    def get_resolution_y(self):
        """
        Отримує вертикальну роздільну здатність.

        Повертає:
        int: Вертикальна роздільна здатність.
        """
        return self.display.get_resolution_y()

    def get_ratio(self):
        """
        Отримує співвідношення сторін екрану.

        Повертає:
        str: Рядкове представлення співвідношення сторін.
        """
        return self.display.get_ratio()

    def set_freq(self, freq):
        """
        Встановлює частоту оновлення екрану.

        Аргументи:
        freq (int): Нова частота оновлення екрану в Гц.
        """
        self.display.set_freq(freq)

    def set_inches(self, inches):
        """
        Встановлює розмір екрану в дюймах.

        Аргументи:
        inches (int): Новий розмір екрану в дюймах.
        """
        self.display.set_inches(inches)

    def set_full_resolution(self, x, y):
        """
        Встановлює повну роздільну здатність екрану.

        Аргументи:
        x (int): Нова горизонтальна роздільна здатність.
        y (int): Нова вертикальна роздільна здатність.
        """
        self.display.set_full_resolution(x, y)

    def set_resolution_x(self, x):
        """
        Встановлює горизонтальну роздільну здатність.

        Аргументи:
        x (int): Нова горизонтальна роздільна здатність.
        """
        self.display.set_resolution_x(x)

    def set_resolution_y(self, y):
        """
        Встановлює вертикальну роздільну здатність.

        Аргументи:
        y (int): Нова вертикальна роздільна здатність.
        """
        self.display.set_resolution_y(y)

    def set_ratio(self, ratio):
        """
        Встановлює співвідношення сторін екрану.

        Аргументи:
        ratio (Ratio): Нове співвідношення сторін екрану.
        """
        self.display.set_ratio(ratio)