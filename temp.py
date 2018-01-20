import smtplib
conn = smtplib.SMTP('smtp.gmail.com', 587)
type(conn)
conn.ehlo()
conn.starttls()
conn.login('wingezda@gmail.com','b4inailurU_')
conn.sendmail('wingezda@gmail.com','wingezda@gmail.com','Subject: dsfdsf\n\n dfsdfsd')
conn.quit()
