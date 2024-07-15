from datetime import datetime

my_date_string = "Mon 15 2024 22:13PM"

datetime_object = datetime.strptime(my_date_string, '%b %d %Y %I:%M%p')

print(type(datetime_object))
print(datetime_object)