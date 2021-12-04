import datetime

oneSec = datetime.datetime.strptime('0:00:01.00', '%H:%M:%S.%f')
oneMin = datetime.datetime.strptime('0:01:00.00', '%H:%M:%S.%f')

print(oneMin -oneSec)