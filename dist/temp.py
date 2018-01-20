import smtplib
conn = smtplib.SMTP('smtp.gmail.com', 587)
type(conn)
conn.ehlo()
conn.starttls()
conn.login('armadylians@gmail.com','pishaban')
conn.sendmail('armadylians@gmail.com','wingezda@gmail.com','Subject: whats up,\n\n sdfdsfhoi')
conn.quit()
