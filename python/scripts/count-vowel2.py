ip_str = 'In English grammar, phrases are groups of words that function together as a unit, but do not have a subject and verb combination that makes a complete sentence.'

ip_str = ip_str.casefold()

count = {x:sum([1 for char in ip_str if char == x]) for x in 'aeiou'}

print(count)