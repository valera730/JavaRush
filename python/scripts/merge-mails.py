with open("mail.txt", 'r', encoding='utf-8') as names_file:
    with open("text.txt", 'r', encoding='utf-8') as body_file:
        body = body_file.read()

        for name in names_file:
            mail = "Hello, dear " + name.strip() + "\n" + body

            with open(name.strip()+".txt", 'w', encoding='utf-8') as mail_file:
                mail_file.write(mail)