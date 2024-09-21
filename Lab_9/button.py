class Button:
    """Клас, що представляє кнопку з двома станами."""

    def __init__(self, state=False):
        """
        Ініціалізує об'єкт Button.

        Аргументи:
        state (bool): Початковий стан кнопки. За замовчуванням False.
        """
        self.state = state

    def push(self):
        """
        Змінює стан кнопки на протилежний.
        """
        self.state = not self.state

    def set_state(self, state):
        """
        Встановлює стан кнопки.

        Аргументи:
        state (bool): Новий стан кнопки.
        """
        self.state = state

    def get_state(self):
        """
        Отримує поточний стан кнопки.

        Повертає:
        bool: Поточний стан кнопки.
        """
        return self.state