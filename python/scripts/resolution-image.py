def jpeg_res(filename):
   """"This function prints the resolution of the jpeg image file passed into it"""

   with open(filename,'rb') as img_file:
       img_file.seek(163)

       a = img_file.read(2)

       height = (a[0] << 8) + a[1]

       a = img_file.read(2)

       width = (a[0] << 8) + a[1]

   print("Image resolution is ", width, "x" ,height)

jpeg_res("img1.jpg")