import random
import string

# Функция для генерации случайной строки
def generate_random_string(length):
    return ''.join(random.choice(string.ascii_letters) for _ in range(length))

# Вероятность для строки "GeekBrains" (20%)
probability = 0.2

# Генерация 50 файлов
for i in range(1, 51):
    filename = f'File-{str(i).zfill(2)}.txt'
    content = generate_random_string(2048)
    
    # Расположение строки "GeekBrains" с вероятностью 20%
    if random.random() < probability:
        # Получение случайной позиции для вставки строки
        position = random.randint(0, 2048 - len("GeekBrains"))
        content = content[:position] + 'GeekBrains' + content[position:]
    
    with open(filename, 'w') as file:
        file.write(content)

    # print(f'Создан файл: {filename}')

print('Генерация файлов завершена!')