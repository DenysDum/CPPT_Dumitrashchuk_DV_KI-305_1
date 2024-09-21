class Ports:
    """Клас, що представляє порти пристрою."""

    def __init__(self):
        """
        Ініціалізує об'єкт Ports.
        """
        self.usb_conn = False
        self.hdmi_conn = False

    def is_usb_connected(self):
        """
        Перевіряє, чи підключений USB.

        Повертає:
        bool: True, якщо USB підключений, інакше False.
        """
        return self.usb_conn

    def is_hdmi_connected(self):
        """
        Перевіряє, чи підключений HDMI.

        Повертає:
        bool: True, якщо HDMI підключений, інакше False.
        """
        return self.hdmi_conn

    def connect_usb(self):
        """
        Підключає USB.
        """
        self.usb_conn = True

    def connect_hdmi(self):
        """
        Підключає HDMI.
        """
        self.hdmi_conn = True

    def disconnect_usb(self):
        """
        Відключає USB.
        """
        self.usb_conn = False

    def disconnect_hdmi(self):
        """
        Відключає HDMI.
        """
        self.hdmi_conn = False

