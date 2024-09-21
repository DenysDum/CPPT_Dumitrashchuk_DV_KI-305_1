# Видаляємо імпорт Touchable з sensor_screen.py
from monitor import Monitor
from touch_screen import TouchScreen
from display import Ratio


class SensorScreen(Monitor):
    """Клас, що представляє сенсорний екран з функціональністю монітора."""

    def __init__(self, freq=60, inches=11, res_x=1920, res_y=1080, ratio=Ratio.R16x9, state=False):
        """
        Ініціалізує об'єкт SensorScreen.

        Аргументи:
        freq (int): Частота оновлення екрану в Гц. За замовчуванням 60.
        inches (int): Розмір екрану в дюймах. За замовчуванням 11.
        res_x (int): Горизонтальна роздільна здатність. За замовчуванням 1920.
        res_y (int): Вертикальна роздільна здатність. За замовчуванням 1080.
        ratio (Ratio): Співвідношення сторін екрану. За замовчуванням 16:9.
        state (bool): Початковий стан екрану (увімкнено/вимкнено). За замовчуванням False.
        """
        super().__init__(freq, inches, res_x, res_y, ratio, state)
        self.touch_screen = TouchScreen(self)

    def touch(self, x, y):
        """
        Реєструє дотик до екрану.

        Аргументи:
        x (int): x-координата дотику.
        y (int): y-координата дотику.

        Повертає:
        bool: True, якщо дотик успішно зареєстровано, інакше False.
        """
        return self.touch_screen.touch(x, y)

    def hold(self, x, y):
        """
        Реєструє утримання дотику на екрані.

        Аргументи:
        x (int): x-координата утримання.
        y (int): y-координата утримання.

        Повертає:
        bool: True, якщо утримання успішно зареєстровано, інакше False.
        """
        return self.touch_screen.hold(x, y)

    def release(self):
        """
        Реєструє відпускання дотику.
        """
        self.touch_screen.release()

    def get_last_touched_x(self):
        """
        Отримує x-координату останнього дотику.

        Повертає:
        int: x-координата останнього дотику.
        """
        return self.touch_screen.get_last_touched_x()

    def get_last_touched_y(self):
        """
        Отримує y-координату останнього дотику.

        Повертає:
        int: y-координата останнього дотику.
        """
        return self.touch_screen.get_last_touched_y()

    def get_held_x(self):
        """
        Отримує x-координату утримуваного дотику.

        Повертає:
        int: x-координата утримуваного дотику.
        """
        return self.touch_screen.get_held_x()

    def get_held_y(self):
        """
        Отримує y-координату утримуваного дотику.

        Повертає:
        int: y-координата утримуваного дотику.
        """
        return self.touch_screen.get_held_y()

    def is_held(self):
        """
        Перевіряє, чи утримується дотик.

        Повертає:
        bool: True, якщо дотик утримується, інакше False.
        """
        return self.touch_screen.is_held()
