from datetime import datetime

my_date_string = "Wed 17 2024 23:27PM"

datetime_object = datetime.strptime(my_date_string, '%b %d %Y %I:%M%p')

print(type(datetime_object))
print(datetime_object)