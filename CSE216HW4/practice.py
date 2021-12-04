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
                
        print((data[1][0]))

        print(data[1])

        
        #filt = list(filter(lambda x: x[2].strip(" ") == 'UDP' and x[12].strip(" ") == 'suspicious' and float(x[1].strip(" ")) < .001, data[4]))
        #filt = [item for item in data if item[2].strip(" ") == 'UDP' and item[12].strip(" ") == 'suspicious' and float(item[1].strip(" ")) < .001]
        #print(len(filt))
        print("------------------------------------------------------")
        #print(filt)
        #print(" || x[2]: " + data[4][2].strip(" ") + " || x[12]: " + data[4][12].strip(" ") + " || float(x[1]) < .001: " + data[4][1].strip(" "))
        
        #lstTimePrev = data[count-1][0]
        #lstTimeCurr = data[count][0]

        #date_timePrevious_obj = datetime.datetime.strptime(lstTimePrev, '%Y-%m-%d %H:%M:%S.%f')
        #date_timeCurrent_obj = datetime.datetime.strptime(lstTimeCurr, '%Y-%m-%d %H:%M:%S.%f')

        #timeDiff = date_timeCurrent_obj-date_timePrevious_obj
        
        #print(timeDiff)
        #print(date_timePrevious_obj)
        #print(date_timeCurrent_obj)
        
        
        
        #lstCurrTime = data[count][0].split(" ")
        #if(lstTimePrev[0] == lstCurrTime[0] and lstTimePrev[1] - lstCurrTime[1])
        #print(float(data[count-1][0]) - float(data[count][0]))
        while count < len(data):
            #prevRow = data[count-1].split(',')
            print("count " + str(count))
            #print("PrevRow " + str(prevRow))
            #print(prevRow[2].strip(" ") + "gggggg" + prevRow[1].strip(" ") +"gggggg")
            lstTimePrev = data[count-1][0]
            lstTimeCurr = data[count][0]

            date_timePrevious_obj = datetime.datetime.strptime(lstTimePrev, '%Y-%m-%d %H:%M:%S.%f')
            date_timeCurrent_obj = datetime.datetime.strptime(lstTimeCurr, '%Y-%m-%d %H:%M:%S.%f')

            timeDiff = date_timeCurrent_obj-date_timePrevious_obj
            print("Time: -----------------------------------------------------")

            print(timeDiff)
            print(date_timePrevious_obj)
            print(date_timeCurrent_obj)
            #oneSec = datetime.datetime.strptime('0:00:1', '%H:%M:%S')
            #print("Time diffy:")
            #print(timeDiff>oneSec)
            
            #if timeDiff < oneSec:
        
        #tempList = [data[1].split(','), data[2].split(','), data[7].split(',')]
        #print(tempList)
        #print(data[1].split(',')[2].strip(" "))
            print("||" + data[count][2] + "||")
            print("||" + data[count][12] + "||")
            print(float(data[count][1]))
            print("||" + data[count][2].strip(" ") + "||")

            print(data[count][2].strip(" ") == 'UDP')
            print(data[count][12].strip(" ") == 'suspicious')
            print(float(data[count][1]) < .001)

            filtered = list(filter(lambda x: x[2].strip(" ") == 'UDP' and x[12].strip(" ") == 'suspicious' and float(x[1]) < .001, data[count]))
            print(filtered)
            #prevTimeComp = data[count-1]
            
            filtered = [item for item in data[count] if item[2].strip(" ") == 'UDP' and item[12].strip(" ") == 'suspicious' and float(item[1].strip(" ")) < .001]            

            #filteredList = list(filtered)
            print("Filtered: -----------------------------------------------------")

#            print(data[count])
#            print(" || x[2]: " + data[count][2].strip(" ") + " || x[12]: " + data[count][12].strip(" ") + " || float(x[1]) < .001: " + (data[count][1]))
#            print(filtered)
#            print(data[count][2].strip(" ") == 'UDP')
#            print(data[count][12].strip(" ") == 'suspicious')
#            print(float(data[count][1].strip(" ")) < .001)
#            print("--------------")


            count += 1
            print("count " + str(count))

            print(type(filtered))
            if(count == 33):
                print("Hi")
                temp = tuple(filtered)
                print(temp)
                print("Bye")

        
        #filtered = filter(lambda p: 'UDP' == p[2] and p[1] < .001, reader)

        #print(list(filtered))
        #csv.writer(open(self._d,'r'),delimiter=' ').writerows(filtered)

        #strippedLine = (line.strip() for line in open(self._d).readline() if line != " ")

        

obj = ServerAttackDetector("C:/Users/meruv/CSE 216 HW/CSE216HW4/hw4testfile.csv")
obj.display()
print("--------------")
obj.detect()
print("--------------")


