from datetime import datetime

my_date_string = "Fri 28 2023 23:44PM"

datetime_object = datetime.strptime(my_date_string, '%b %d %Y %I:%M%p')

print(type(datetime_object))
print(datetime_object)