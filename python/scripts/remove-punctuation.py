punctuations = '''!()-[]{};:'"\,<>./?@#$%^&*_~'''

my_str = "I like fruit, but my sister doesn’t like it."

no_punct = ""
for char in my_str:
   if char not in punctuations:
       no_punct = no_punct + char

print(no_punct)