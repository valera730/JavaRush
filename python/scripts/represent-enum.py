from enum import Enum

class Day(Enum):
    MONDAY = 1
    WEDNESDAY = 2
    THURSDAY = 3

print(Day.THURSDAY)

print(Day.THURSDAY.name)

print(Day.THURSDAY.value)