vowels = 'oeuai'

ip_str = 'When you understand the words one by one, but not what they mean together, use this question.'

ip_str = ip_str.casefold()

count = {}.fromkeys(vowels,0)

for char in ip_str:
   if char in count:
       count[char] += 1

print(count)