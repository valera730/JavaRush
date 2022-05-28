#• Отдельная функция getLinks принимает URL статьи «Википедии» в формате /wiki/<Название_статьи> и возвращает список всех URL, на которые ссылается эта статья, в том же формате.
#• Основная функция, которая вызывает getLinks с первоначальной статьей, выбирает из возвращенного списка случайную ссылку и снова вызывает getLinks, пока пользователь не остановит программу или пока не окажется, что на очередной странице нет ссылок.

from urllib.request import urlopen
from bs4 import BeautifulSoup

import datetime
import random
import re

random.seed(datetime.datetime.now())
def getLinks(articleUrl):
    html = urlopen('http://en.wikipedia.org{}'.format(articleUrl))
    bs = BeautifulSoup(html, 'html.parser')

    return bs.find('div',{'id':'bodyContent'}).find_all('a',href=re.compile('^(/wiki/)((?!:).)*$'))

links = getLinks('/wiki/Kevin_Bacon')
while len(links) > 0:
    newArticle = links[random.randint(0, len(links)-1)].attrs['href']
    print(newArticle)
links = getLinks(newArticle)

#Сбор информации со всего сайта - стр. 72