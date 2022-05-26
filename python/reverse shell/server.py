import socket
import subprocess

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind(('127.0.0.1', 8888))
s.listen(5)

while 1:
    try:
        client, addr = s.accept()
    except KeyboardInterrupt:
        s.close
        break
    else:
        result = client.recv(1024)
        print('Message: ', result.decode('utf-8'))

        if result.decode('utf-8') == 'Run notepad.exe':
            subprocess.call('notepad.exe')
            print('Запускаем notepad.exe')

#result = s.recv(1024)

#if result.decode('utf-8') == 'Run notepad.exe':
    #subprocess.call('notepad.exe')
    #print('Запускаем notepad.exe')

#print('Message: ', result.decode('utf-8'))
#s.close()