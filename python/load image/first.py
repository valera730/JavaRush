from urllib.request import urlopen

resource = urlopen(img)
out = open("...\img.jpg", 'wb')
out.write(resource.read())
out.close()