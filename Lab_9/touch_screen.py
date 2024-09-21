class TouchScreen:
    """Клас, що представляє сенсорний екран."""

    def __init__(self, screen):
        """
        Ініціалізує об'єкт TouchScreen.

        Аргументи:
        screen: Об'єкт екрану, з яким пов'язаний сенсорний екран.
        """
        self.screen = screen
        self.last_touched_x = -1
        self.last_touched_y = -1
        self.held_x = -1
        self.held_y = -1

    def touch(self, x, y):
        """
        Реєструє дотик до екрану.

        Аргументи:
        x (int): x-координата дотику.
        y (int): y-координата дотику.

        Повертає:
        bool: True, якщо дотик успішно зареєстровано, інакше False.
        """
        if self.held_x != -1:
            return False
        elif self._check_area(x, y):
            self.last_touched_x = x
            self.last_touched_y = y
            return True
        else:
            return False

    def hold(self, x, y):
        """
        Реєструє утримання дотику на екрані.

        Аргументи:
        x (int): x-координата утримання.
        y (int): y-координата утримання.

        Повертає:
        bool: True, якщо утримання успішно зареєстровано, інакше False.
        """
        if self._check_area(x, y):
            self.last_touched_x = x
            self.last_touched_y = y
            self.held_x = x
            self.held_y = y
            return True
        else:
            return False

    def release(self):
        """
        Реєструє відпускання дотику.
        """
        self.held_x = -1
        self.held_y = -1

    def get_last_touched_x(self):
        """
        Отримує x-координату останнього дотику.

        Повертає:
        int: x-координата останнього дотику.
        """
        return self.last_touched_x

    def get_last_touched_y(self):
        """
        Отримує y-координату останнього дотику.

        Повертає:
        int: y-координата останнього дотику.
        """
        return self.last_touched_y

    def get_held_x(self):
        """
        Отримує x-координату утримуваного дотику.

        Повертає:
        int: x-координата утримуваного дотику.
        """
        return self.held_x

    def get_held_y(self):
        """
        Отримує y-координату утримуваного дотику.

        Повертає:
        int: y-координата утримуваного дотику.
        """
        return self.held_y

    def is_held(self):
        """
        Перевіряє, чи утримується дотик.

        Повертає:
        bool: True, якщо дотик утримується, інакше False.
        """
        return self.held_x != -1

    def _check_area(self, x, y):
        """
        Перевіряє, чи знаходиться точка в межах екрану.

        Аргументи:
        x (int): x-координата точки.
        y (int): y-координата точки.

        Повертає:
        bool: True, якщо точка в межах екрану, інакше False.
        """
        return 0 < x <= self.screen.get_resolution_x() and 0 < y <= self.screen.get_resolution_y()