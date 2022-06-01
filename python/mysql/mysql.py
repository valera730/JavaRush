import pymysql
conn = pymysql.connect(host='127.0.0.1', user='root', port=3307, password=None, db='mysql2', charset='utf8mb4') 
cur = conn.cursor()
cur.execute('USE mysql2')
cur.execute('SELECT * FROM pages WHERE ID=1')
print(cur.fetchone())
cur.close()
conn.close()