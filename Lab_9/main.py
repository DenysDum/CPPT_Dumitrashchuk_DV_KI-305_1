from sensor_screen import SensorScreen
from display import Ratio

"""
Головна функція для демонстрації роботи класу SensorScreen.
"""

print("Створення SensorScreen...")
screen = SensorScreen()

print("\n--- Демонстрація базових властивостей ---")
print(f"Стан живлення екрану: {'Увімкнено' if screen.is_turned_on() else 'Вимкнено'}")
print(f"Роздільна здатність екрану: {screen.get_full_resolution()}")
print(f"Співвідношення сторін екрану: {screen.get_ratio()}")
print(f"Частота оновлення: {screen.get_freq()} Гц")
print(f"Розмір екрану: {screen.get_inches()} дюймів")

print("\n--- Демонстрація сенсорних можливостей ---")
print("Дотик до екрану в точці (100, 100)...")
screen.touch(100, 100)
print(f"Координати останнього дотику: ({screen.get_last_touched_x()}, {screen.get_last_touched_y()})")

print("\nУтримання екрану в точці (500, 500)...")
screen.hold(500, 500)
print(f"Координати утримання: ({screen.get_held_x()}, {screen.get_held_y()})")
print(f"Чи утримується екран? {screen.is_held()}")

print("\nВідпускання екрану...")
screen.release()
print(f"Чи утримується екран? {screen.is_held()}")

print("\n--- Демонстрація зміни налаштувань ---")
print("Зміна роздільної здатності...")
screen.set_full_resolution(3840, 2160)
print(f"Нова роздільна здатність: {screen.get_full_resolution()}")

print("\nЗміна частоти оновлення...")
screen.set_freq(144)
print(f"Нова частота оновлення: {screen.get_freq()} Гц")

print("\nЗміна розміру екрану...")
screen.set_inches(17)
print(f"Новий розмір екрану: {screen.get_inches()} дюймів")

print("\n--- Демонстрація роботи з портами ---")
print("Підключення USB...")
screen.connect_usb()
print(f"USB підключено? {screen.is_usb_connected()}")

print("\nПідключення HDMI...")
screen.connect_hdmi()
print(f"HDMI підключено? {screen.is_hdmi_connected()}")

print("\nВідключення USB...")
screen.disconnect_usb()
print(f"USB підключено? {screen.is_usb_connected()}")

print("\n--- Завершальна демонстрація ---")
print("Вимкнення екрану...")
screen.toggle_power()
print(f"Стан живлення екрану: {screen.is_turned_on()}")

