vowels = 'oeuai'

ip_str = 'When you are learning a new language, you will sometimes need to ask clarifying questions to make sure you understood.'

ip_str = ip_str.casefold()

count = {}.fromkeys(vowels,0)

for char in ip_str:
   if char in count:
       count[char] += 1

print(count)