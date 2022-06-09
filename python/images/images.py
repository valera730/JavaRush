import requests
from os.path  import basename
from bs4 import BeautifulSoup

headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'}
r = requests.get("...", headers=headers)

soup = BeautifulSoup(r.content)

for link in soup.select("img[src^=http]"):
    lnk = link["src"]

    if "/jpg_" in lnk:
        with open(basename(lnk),"wb") as f:
            f.write(requests.get(lnk).content)