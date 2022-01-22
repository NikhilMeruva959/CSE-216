import csv
import datetime

class ServerAttackDetector:
    
    def __init__(self, path):
        self._d = path

    def display(self):
        print(self._d)

    def detect(self):
        with open(self._d) as file:
            reader = csv.reader(file)
            data = list(reader) 

        count = 2
                
        for item in data:
            lstTimePrev = data[count-1][0]
            lstTimeCurr = data[count][0]

            date_timePrevious_obj = datetime.datetime.strptime(lstTimePrev, '%Y-%m-%d %H:%M:%S.%f')
            date_timeCurrent_obj = datetime.datetime.strptime(lstTimeCurr, '%Y-%m-%d %H:%M:%S.%f')

            timeDiff = date_timeCurrent_obj-date_timePrevious_obj

            if ((data[count][2].strip(" ") == 'UDP' and float(data[count][1]) < 1.00 and timeDiff<=datetime.timedelta(seconds=1) and data[count-1][2].strip(" ") == 'UDP' and data[count-1][12].strip(" ") == 'suspicious')):
                yield count, data[count]

                
            if(count == len(data)-1):
                break
            count += 1
        
    def detectOutputHelper(x):
        temp = next(x)
        tupleOutput = (temp[0], temp[1])
        return tupleOutput

obj = ServerAttackDetector("C:/Users/meruv/CSE 216 HW/CSE216HW4/hw4testfile.csv")
#obj = ServerAttackDetector("C:/Users/meruv/CSE 216 HW/CSE216HW4/kaggle-serverlogs/CIDDS-001-external-week1.csv")
obj.display()
print("----------g----")
output = obj.detect()

#print(sum(1 for _ in output))
print(ServerAttackDetector.detectOutputHelper(output))

print("---------d-----")


