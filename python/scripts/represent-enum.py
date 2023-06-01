from enum import Enum

class Day(Enum):
    SUNDAY = 1
    TUESDAY = 2
    SATURDAY = 3

print(Day.SATURDAY)

print(Day.SATURDAY.name)

print(Day.SATURDAY.value)