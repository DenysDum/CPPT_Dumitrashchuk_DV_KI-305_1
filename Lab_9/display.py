from enum import Enum


class Ratio(Enum):
    """Перелік можливих співвідношень сторін екрану."""
    R3x4 = "3x4"
    R16x9 = "16x9"


class Display:
    """Клас, що представляє дисплей."""

    def __init__(self, freq=60, inches=11, res_x=1920, res_y=1080, ratio=Ratio.R16x9):
        """
        Ініціалізує об'єкт Display.

        Аргументи:
        freq (int): Частота оновлення екрану в Гц. За замовчуванням 60.
        inches (int): Розмір екрану в дюймах. За замовчуванням 11.
        res_x (int): Горизонтальна роздільна здатність. За замовчуванням 1920.
        res_y (int): Вертикальна роздільна здатність. За замовчуванням 1080.
        ratio (Ratio): Співвідношення сторін екрану. За замовчуванням 16:9.
        """
        self.freq = freq
        self.inches = inches
        self.res_x = res_x
        self.res_y = res_y
        self.ratio = ratio

    def get_freq(self):
        """
        Отримує частоту оновлення екрану.

        Повертає:
        int: Частота оновлення екрану в Гц.
        """
        return self.freq

    def get_inches(self):
        """
        Отримує розмір екрану в дюймах.

        Повертає:
        int: Розмір екрану в дюймах.
        """
        return self.inches

    def get_full_resolution(self):
        """
        Отримує повну роздільну здатність екрану.

        Повертає:
        str: Рядок у форматі "ширинахвисота".
        """
        return f"{self.res_x}x{self.res_y}"

    def get_resolution_x(self):
        """
        Отримує горизонтальну роздільну здатність.

        Повертає:
        int: Горизонтальна роздільна здатність.
        """
        return self.res_x

    def get_resolution_y(self):
        """
        Отримує вертикальну роздільну здатність.

        Повертає:
        int: Вертикальна роздільна здатність.
        """
        return self.res_y

    def get_ratio(self):
        """
        Отримує співвідношення сторін екрану.

        Повертає:
        str: Рядкове представлення співвідношення сторін.
        """
        return self.ratio.value

    def set_freq(self, freq):
        """
        Встановлює частоту оновлення екрану.

        Аргументи:
        freq (int): Нова частота оновлення екрану в Гц.

        """
        self.freq = freq

    def set_inches(self, inches):
        """
        Встановлює розмір екрану в дюймах.

        Аргументи:
        inches (int): Новий розмір екрану в дюймах.

        """
        self.inches = inches

    def set_full_resolution(self, x, y):
        """
        Встановлює повну роздільну здатність екрану.

        Аргументи:
        x (int): Нова горизонтальна роздільна здатність.
        y (int): Нова вертикальна роздільна здатність.

        """
        self.res_x = x
        self.res_y = y

    def set_resolution_x(self, x):
        """
        Встановлює горизонтальну роздільну здатність.

        Аргументи:
        x (int): Нова горизонтальна роздільна здатність.

        """
        self.res_x = x

    def set_resolution_y(self, y):
        """
        Встановлює вертикальну роздільну здатність.

        Аргументи:
        y (int): Нова вертикальна роздільна здатність.

        """
        self.res_y = y

    def set_ratio(self, ratio):
        """
        Встановлює співвідношення сторін екрану.

        Аргументи:
        ratio (Ratio): Нове співвідношення сторін екрану.

        """
        self.ratio = ratio