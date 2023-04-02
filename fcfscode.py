arrival_time_list = []
burst_time_list = []
top = 0

n = int(input("Enter number of processes: "))
for i in range(n):
    pat = int(input("Enter P%d Arrival Time: " % (i)))
    arrival_time_list.append(pat)

    pbt = int(input("Enter P%d Burst Time: " % (i)))
    burst_time_list.append(pbt)

finish_time_list = []
turn_around_time_list = []
waiting_time_list = []

for i in range(n):
    if i == 0:
        top = top + burst_time_list[i]
        finish_time_list.append(top)
    elif i > 0:
        if top < arrival_time_list[i]:
            top = arrival_time_list[i] + burst_time_list[i]
            finish_time_list.append(top)
        else:
            top = top + burst_time_list[i]
            finish_time_list.append(top)

for i in range(n):
    tat = finish_time_list[i] - arrival_time_list[i]
    turn_around_time_list.append(tat)
    wt = turn_around_time_list[i]-burst_time_list[i]
    waiting_time_list.append(wt)

av_tat = 0.0
av_wt = 0.0

print("\tProcess\t", "\tArrival Time\t", "\t Burst Time\t", "\tFinish Time\t\t", "Turn Around Time\t", "\tWaiting Time\t")

for i in range(n):
    print("\t" + str(i) + "\t\t\t" + str(arrival_time_list[i]) + "\t\t\t" + str(burst_time_list[i]) + "\t\t\t" + str(finish_time_list[i]) + "\t\t\t"+ str(turn_around_time_list[i]) + "\t\t\t  " +str(waiting_time_list[i]))
    av_tat = av_tat + turn_around_time_list[i]
    av_wt = av_wt + waiting_time_list[i]

av_tat=float(av_tat)/n
av_wt = av_wt/n

print("Average Turn Around Time: %f" % av_tat)
print("Average Waiting Time: %f" % av_wt)