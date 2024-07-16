from datetime import datetime

my_date_string = "Tue 16 2024 23:53PM"

datetime_object = datetime.strptime(my_date_string, '%b %d %Y %I:%M%p')

print(type(datetime_object))
print(datetime_object)