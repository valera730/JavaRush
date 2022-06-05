#Взлом шифра Цезаря

message = 'guv6Jv6Jz!J6rp5r7Jzr66ntrM'
SYMBOLS = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890 !?.'

#Цикл по всем возможным значениям ключа
for key in range(len(SYMBOLS)):
    #Нужно присвоить пустую строку переменной translated, чтобы очистить её от значения из предыдущей итерации
    translated = ''

    #Цикл по всем символам сообщения
    for symbol in message:
        if symbol in SYMBOLS:
            symbolIndex = SYMBOLS.find(symbol)

            translatedIndex = symbolIndex - key

            #Обработать завёртывание, если нужно
            if translatedIndex < 0:
                translatedIndex = translatedIndex + len(SYMBOLS)

            translated = translated + SYMBOLS[translatedIndex]
        else:
            #Присоединить символ без шифрования/дешифрования
            translated = translated + symbol

    #Показать каждый возможный вариант расшифровки
    print('Key #%s: %s' % (key, translated))