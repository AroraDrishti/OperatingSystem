import java.io.*;
import java.util.Scanner;

class rrcode {
    public static void main(String args[]) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        int i, j, k, q, sum = 0;
        System.out.println("Enter number of process:");
        int n = sc.nextInt();
        int bt[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];
        int a[] = new int[n];
        int at[] = new int[n];
        System.out.println("Enter burst Time:");
        for (i = 0; i < n; i++) 
        {
            System.out.println("Enter burst Time for " + (i + 1));
            bt[i] = sc.nextInt();
            System.out.println("Enter arrival time Time for " + (i + 1));
            at[i] = sc.nextInt();
        }
        System.out.println("Enter Time quantum:");
        q = sc.nextInt();
        for (i = 0; i < n; i++)
            a[i] = bt[i];
        for (i = 0; i < n; i++)
            wt[i] = 0;
        do {
            for (i = 0; i < n; i++) {
                if (bt[i] > q) {
                    bt[i] -= q;
                    for (j = 0; j < n; j++) {
                        if ((j != i) && (bt[j] != 0))
                            wt[j] += q;
                    }
                } else {
                    for (j = 0; j < n; j++) {
                        if ((j != i) && (bt[j] != 0))
                            wt[j] += bt[i];
                    }
                    bt[i] = 0;
                }
            }
            sum = 0;
            for (k = 0; k < n; k++)
                sum = sum + bt[k];
        } while (sum != 0);
        for (i = 0; i < n; i++)
            tat[i] = wt[i] + a[i];
        System.out.println("process\t\tAT\tBT\tWT\tTAT");
        for (i = 0; i < n; i++) {
            System.out.println("process" + (i + 1) + "\t" + at[i] + "\t" + a[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
        float avg_wt = 0;
        float avg_tat = 0;
        for (j = 0; j < n; j++) {
            avg_wt += wt[j];
        }
        for (j = 0; j < n; j++) {
            avg_tat += tat[j];
        }
        System.out.println("average waiting time " + (avg_wt / n) + "\n Average turn around time" + (avg_tat / n));
    }
}
