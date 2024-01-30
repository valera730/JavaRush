ip_str = 'To bite the bullet is to endure a painful or difficult situation with courage and resilience, often involving facing uncomfortable emotions or challenges.'

ip_str = ip_str.casefold()

count = {x:sum([1 for char in ip_str if char == x]) for x in 'aeiou'}

print(count)