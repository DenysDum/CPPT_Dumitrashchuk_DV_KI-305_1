import CalcFIO as calc
try:
    x = float(input("Введіть значення x в градусах: "))
    result = calc.calculate(x)
    print(f"Результат обчислення: {result}")

    calc.write_txt(result, "result.txt")
    read_result = calc.read_txt("result.txt")
    if read_result is not None:
        print(f"Прочитаний результат з текстового файлу: {read_result}")

    calc.write_bin(result, "result.bin")
    bin_result = calc.read_bin("result.bin")
    if bin_result is not None:
        print(f"Прочитаний результат з бінарного файлу: {bin_result}")

except ValueError as e:
    print(f"Помилка при обчисленні: {e}")
