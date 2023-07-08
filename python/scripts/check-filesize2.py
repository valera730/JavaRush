from pathlib import Path

file = Path('file.ext')
print(file.stat().st_size)