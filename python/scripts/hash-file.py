import hashlib

def hash_file(filename):
   """"Function returns SHA-1 hash of the file (for example, 633d7356947eec543c50b76a1852f92427f4dca9)"""

   h = hashlib.sha1()

   with open(filename,'rb') as file:
       chunk = 0
       while chunk != b'':
           chunk = file.read(1024)
           h.update(chunk)

   return h.hexdigest()

message = hash_file("somefile.txt")
print(message)