#Шифр Цезаря

import pyperclip

#Строка, подлежащая шифрованию/дешифрованию
message = 'This is my secret message'

#Ключ шифрования/дешифрования
key = 13

#Установка режима работы - шифрование или дешифрование
mode = 'encrypt'    #или decrypt

#Все символы, которые могут быть зашифрованы
SYMBOLS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!?.'

#Зашифрованная/дешифрованная форма сообщения
translated = ''

for symbol in message:
    #Шифровать/дешифровать можно только символы из строки SYMBOLS
    if symbol in SYMBOLS:
        symbolIndex = SYMBOLS.find(symbol)

        #Зашифровать/дешифровать
        if mode == 'encrypt':
            translateIndex = symbolIndex + key
        elif mode == 'decrypt':
            translateIndex = symbolIndex - key

        #Обработать завёртывание, если нужно
        if translateIndex >= len(SYMBOLS):
            translateIndex = translateIndex - len(SYMBOLS)
        elif translateIndex < 0:
            translateIndex = translateIndex + len(SYMBOLS)

        translated = translated + SYMBOLS[translateIndex]
    else:
        #Присоединить символ без шифрования/дешифрования
        translated = translated + symbol

print(translated)
pyperclip.copy(translated)