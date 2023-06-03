from enum import Enum

class Day(Enum):
    MONDAY = 1
    WEDNESDAY = 2
    FRIDAY = 3

print(Day.FRIDAY)

print(Day.FRIDAY.name)

print(Day.FRIDAY.value)