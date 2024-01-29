ip_str = 'No matter which role a phrase is playing, it’s achieving one simple goal: making your sentences richer by giving your words context, detail, and clarity.'

ip_str = ip_str.casefold()

count = {x:sum([1 for char in ip_str if char == x]) for x in 'aeiou'}

print(count)