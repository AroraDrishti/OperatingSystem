import java.util.*;
 
public class sjfcode
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println ("enter no of process:");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n]; // at means arrival time
        int bt[] = new int[n]; // bt means burst time
        int ct[] = new int[n]; // ct means complete time
        int ta[] = new int[n]; // ta means turn around time
        int wt[] = new int[n];  //wt means waiting time
        float avgwt=0, avgta=0;
 
        for(int i=0;i<n;i++)
        {
            System.out.println ("enter process " + (i+1) + " arrival time:");
            at[i] = sc.nextInt();
            System.out.println ("enter process " + (i+1) + " brust time:");
            bt[i] = sc.nextInt();
            pid[i] = i+1;
        }
        int temp;
        for(int i=0;i<=n;i++)
        {
            for (int j = 0; j < n - 1; j++) 
            {
                if (bt[j] > bt[j + 1]) 
                {
                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;           
                }
        
            }
        }

        for (int i = 0; i < n; i++) 
        {
            for (int j = 0; j < n - 1; j++)
            {
                if (at[j] > at[j + 1])
                {
                    temp = at[j];
                    at[j] = at[j + 1];
                    at[j + 1] = temp;
                    temp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) 
        {
            if (i == 0) 
            {
                ct[i] = at[i] + bt[i];
            } 
            else 
            {
                if (at[i] > ct[i - 1]) 
                {
                    ct[i] = at[i] + bt[i];
                } 
                else
                {
                    ct[i] = ct[i - 1] + bt[i];
                }
                            
            }
            
            ta[i] = ct[i] - at[i]; // turnaround time= completion time- arrival time
            wt[i] = ta[i] - bt[i]; // waiting time= turnaround time- burst time
            avgwt += wt[i]; // total waiting time
            avgta += ta[i]; // total turnaround time
        }

        System.out.println("\npid  arrival burst  complete turn waiting");
        for(int i=0;i<n;i++)
        {
            System.out.println(pid[i]+"\t"+at[i]+"\t"+bt[i]+"\t"+ct[i]+"\t"+ta[i]+"\t"+wt[i]);
        }
        System.out.println ("\naverage tat is "+ (float)(avgta/n));
        System.out.println ("average wt is "+ (float)(avgwt/n));
        sc.close();
    }
}
