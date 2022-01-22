import csv
import datetime

class ServerAttackDetector:
    
    def __init__(self, path):
        self._d = path

    def detectHelper(self):
        with open(self._d) as file:
            reader = csv.reader(file)
            data = list(reader) 

        count = 2
                
        for item in data:
            date_timePrevious_obj = datetime.datetime.strptime(data[count-1][0], '%Y-%m-%d %H:%M:%S.%f')
            date_timeCurrent_obj = datetime.datetime.strptime(data[count][0], '%Y-%m-%d %H:%M:%S.%f')

            timeDiff = date_timeCurrent_obj-date_timePrevious_obj

            if ((data[count][2].strip(" ") == 'UDP' and float(data[count][1]) < 1.00 and timeDiff<=datetime.timedelta(seconds=1) and data[count-1][2].strip(" ") == 'UDP' and data[count-1][12].strip(" ") == 'suspicious')):
                yield count, data[count]

            if(count == len(data)-1):
                yield 'none','none'
                break
            count += 1
        
    def detect(self):
        temp = next(ServerAttackDetector.detectHelper(self))
        if(temp[1] != 'none'):
            line = "" + temp[1][0] + "," + temp[1][1] + "," + temp[1][2] + "," + temp[1][3] + "," + temp[1][4] + "," + temp[1][5] + "," + temp[1][6] + "," + temp[1][7] +", " + temp[1][8] + "," + temp[1][9] + "," + temp[1][10] + "," + temp[1][11] + "," + temp[1][12] + "," + temp[1][13] + "," + temp[1][14] + "," + temp[1][15] 
            return (temp[0], line)
        return (temp[0], temp[1])
