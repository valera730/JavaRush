dt = {2:54, 3:68, 7:14}

sorted_dt = {key: value for key, value in sorted(dt.items(), key=lambda item: item[1])}

print(sorted_dt)