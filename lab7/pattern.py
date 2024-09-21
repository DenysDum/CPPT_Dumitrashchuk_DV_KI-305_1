import sys
from typing import List, Any


def get_matrix_size():
    """
    Отримує розмір квадратної матриці від користувача.
    Повертає:
        int: Розмір матриці.
    """
    while True:
        size = int(input("Введіть розмір квадратної матриці (парне число): "))
        if size <= 0:
            print("Розмір має бути більше нуля.")
        elif size % 2 != 0:
            print("Розмір має парним числом.")
        else:
            return size

def get_fill_char():
    """
    Отримує символ-заповнювач від користувача.
    Повертає:
        str: Символ-заповнювач.
    """
    fill_char = input("Введіть символ-заповнювач: ")
    len_char = len(fill_char)
    if len_char == 0:
        print("Не введено символ-заповнювач.")
        sys.exit(1)
    elif len_char > 1:
        print("Забагато символів-заповнювачів.")
        sys.exit(1)
    else:
        return fill_char

    return fill_char

def gen_arr(matrix_size, fill_char):
    """
    Генерує матрицю з патерном відповідно до заданого розміру та символу-заповнювача.
    Параметри:
        matrix_size (int): Розмір квадратної матриці.
        fill_char (str): Символ-заповнювач.
    Повертає:
        list: Матриця заповненна символами-заповнювачами.
    """
    arr = []
    for i in range(matrix_size):
        row = []
        for j in range(int(matrix_size/2)):
            row.append(fill_char)
        arr.append(row)
    return arr

def print_pattern(arr, matrix_size):
    """
    Виводить матрицю в консоль.
    Параметри:
        pattern (list): Матриця для виведення.
        matrix_size: Розмір квадратної матриці.
    """
    int_half = int(matrix_size/2)
    for row in arr[0:int_half]:
        for i in range(int_half):
            print("  ", end="")
        print(*row, sep=" ", end="\n")
    for row in arr[int_half:]:
        print(*row, sep=" ", end="")
        for i in range(int_half):
            print("  ", end="")
        print()