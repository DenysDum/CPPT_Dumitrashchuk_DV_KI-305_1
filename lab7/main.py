import pattern as pat

size = pat.get_matrix_size()
fill_char = pat.get_fill_char()
arr = pat.gen_arr(size, fill_char)
print("Сформований патерн:")
pat.print_pattern(arr, size)


