import urllib

resource = urllib.urlopen(img)
out = open("...\img.jpg", 'wb')
out.write(resource.read())
out.close()