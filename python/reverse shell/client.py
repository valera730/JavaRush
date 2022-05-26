import socket
import subprocess

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect(('127.0.0.1', 8888))
#s.send(b'<YOUR MESSAGE>')
s.send(b'Run notepad.exe')
s.close()

#str = 'Run notepad.exe'
#s.sendto(str.encode('utf-8'), ('127.0.0.1', 8888))