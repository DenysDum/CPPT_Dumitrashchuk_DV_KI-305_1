import math
import struct


def calculate(x):
    """
    Обчислює вираз 1 / (tan(x)^2)
    """
    striped_x = x % 360.0
    if striped_x % 90.0 == 0:
        if striped_x in (90.0, 270.0):
            raise ValueError("Заборонене значення X для обрахунку значення тангенса.")
        elif striped_x in (0.0, 180.0, 360.0):
            raise ValueError("Заборонене значення X для обрахунку значення котангенса.")
        else:
            raise ValueError("Невідома помилка.")

    rad = striped_x * math.pi / 180.0
    return 1.0 / math.tan(rad) / math.tan(rad)

def write_txt(result, filename):
    """
    Записує результат у текстовий файл
    """
    try:
        with open(filename, 'w', encoding='utf-8') as f:
            f.write(f"{result}")
        print("Результат був успішно записаний до текстового файлу.")
    except IOError:
        print("Неможливо було створити файл або відкрити існуючий файл.")


def read_txt(filename):
    """
    Читає результат з текстового файлу
    """
    try:
        with open(filename, 'r', encoding='utf-8') as f:
            result = float(f.read())
        print("Результат був успішно зчитаний з текстового файлу.")
        return result
    except FileNotFoundError:
        print(f"Файл з ім'ям {filename} не був знайдений")
    except ValueError:
        print("Неможливо прочитати число з файлу.")
    except IOError as e:
        print(f"Помилка вводу/виводу при читанні файлу: {e}")


def write_bin(result, filename):
    """
    Записує результат у бінарний файл
    """
    try:
        with open(filename, 'wb') as f:
            f.write(struct.pack('d', result))
        print("Результат був успішно записаний до бінарного файлу.")
    except IOError:
        print("Виникла проблема з потоком вводу/виведення.")


def read_bin(filename):
    """
    Читає результат з бінарного файлу
    """
    try:
        with open(filename, 'rb') as f:
            result = struct.unpack('d', f.read())[0]
        print("Результат був успішно зчитаний з бінарного файлу.")
        return result
    except FileNotFoundError:
        print(f"Неможливо відкрити файл з ім'ям {filename}.")
    except IOError:
        print("Виникла проблема з потоком вводу/виведення.")