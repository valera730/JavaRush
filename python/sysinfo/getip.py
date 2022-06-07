import socket
from requests import get

#получаем адрес устройства в сети
hostname = socket.gethostname()

#получаем локальный (внутри сети) IP-адрес
local_ip = socket.gethostbyname(hostname)

#получаем глобальный (публичный/в интернете) IP-адрес
public_ip = get('https://api.ipify.org').text

print(f'Хост: {hostname}')
print(f'Локальный IP: {local_ip}')
print(f'Публичный IP: {public_ip}')