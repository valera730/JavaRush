punctuations = '''!()-[]{};:'"\,<>./?@#$%^&*_~'''

my_str = "Additionally, comparisons are complicated because place names may be considered words, technical terms may be arbitrarily long, and the addition of suffixes and prefixes may extend the length of words to create grammatically correct but unused or novel words. Different dictionaries include and omit different words."

no_punct = ""
for char in my_str:
   if char not in punctuations:
       no_punct = no_punct + char

print(no_punct)