from pathlib import Path

file = Path('filename.ext')
print(file.stat().st_size)