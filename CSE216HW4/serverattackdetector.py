import csv
import io
import datetime
import os

class ServerAttackDetector:
    
    def __init__(self, path):
        self._d = path

    def display(self):
        print(self._d)

    def detect(self):
        with open(self._d) as file:
            #data = file.readlines()
            reader = csv.reader(file)
            data = list(reader) 
        count = 2
                
        print("------------------------------------------------------")
        
        while count < len(data):
            print("Count" + str(count))
            lstTimePrev = data[count-1][0]
            lstTimeCurr = data[count][0]

            date_timePrevious_obj = datetime.datetime.strptime(lstTimePrev, '%Y-%m-%d %H:%M:%S.%f')
            date_timeCurrent_obj = datetime.datetime.strptime(lstTimeCurr, '%Y-%m-%d %H:%M:%S.%f')

            timeDiff = date_timeCurrent_obj-date_timePrevious_obj
            print("Time: -----------------------------------------------------")

            oneSec = datetime.datetime.strptime('0:00:01.00', '%H:%M:%S.%f')

            print(oneSec)
            print("TimeDelt: ")
            print(timeDiff<=datetime.timedelta(seconds=1))

            print(date_timePrevious_obj)
            print(date_timeCurrent_obj)
            
            print("Filtered: -----------------------------------------------------")

            print("||" + data[count][2] + "||")
            print("||" + data[count][12] + "||")
            print(float(data[count][1]))
            print("||" + data[count][2].strip(" ") + "||")

            print(data[count][2].strip(" ") == 'UDP')
            print(data[count][12].strip(" ") == 'suspicious')
            print(float(data[count][1]) < .001)

            
            if(data[count][2].strip(" ") == 'UDP' and data[count][12].strip(" ") == 'suspicious' and float(data[count][1]) < 1.00 and timeDiff<=datetime.timedelta(seconds=1) and data[count-1][2].strip(" ") == 'UDP' and data[count-1][12].strip(" ") == 'suspicious'):
                yield (count, data[count])
                break
            count += 1

        

obj = ServerAttackDetector("C:/Users/meruv/CSE 216 HW/CSE216HW4/hw4testfile.csv")
#obj = ServerAttackDetector("C:/Users/meruv/CSE 216 HW/CSE216HW4/kaggle-serverlogs/CIDDS-001-external-week1.csv")
obj.display()
print("--------------")
output = obj.detect()
for i in output:
    print((i)[0])
    print((i)[1])


print("--------------")


