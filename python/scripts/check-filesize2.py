from pathlib import Path

file = Path('file.name')
print(file.stat().st_size)