vowels = 'oeuai'

ip_str = 'That is why we have gathered some of the most common English idioms and phrases so you will understand the true meaning of them.'

ip_str = ip_str.casefold()

count = {}.fromkeys(vowels,0)

for char in ip_str:
   if char in count:
       count[char] += 1

print(count)