dt = {3:27, 2:71, 5:72}

sorted_dt = {key: value for key, value in sorted(dt.items(), key=lambda item: item[1])}

print(sorted_dt)