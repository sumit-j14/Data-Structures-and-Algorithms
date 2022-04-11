//Given few Tasks with their associated profits and deadlines
// also given that each task requires 1 unit of time to complete

import java.util.*;

// this is a pair class storing each job's deadlines and profits
class job{
    int deadline=0;
    int profit=0;
    public job(int deadline, int profit)
    {
        this.profit = profit;
        this.deadline= deadline;
    }
}

//runner class
public class jobsequence{
    public static void main(String [] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the number of jobs");
        int num_of_jobs= sc.nextInt();

        // this arraylist stores each job
        ArrayList<job> jobs = new ArrayList<>(num_of_jobs);
        System.out.println("enter deadline, profit pairs one by one");
        for ( int i = 0 ; i<num_of_jobs;i++)
        {
            jobs.add(new job(sc.nextInt(),sc.nextInt()));
        }

        // System.out.println("printing test for given input");
        // for(job current : jobs)
        // {
        //     System.out.print(current.deadline+ " ");
        //     System.out.println(current.profit);
        // }

        // custom sort according to greedy condition of optimization
        Collections.sort(jobs,(a, b) -> b.profit - a.profit);
        int size=0;

        // System.out.println("after sorting");
        for(job current : jobs)
        {
            if(size<current.deadline)
            size=current.deadline;
        }
        System.out.println("max size is "+size);

        int jobstaken[] = new int [size +1];
        int answer= 0;

        // loop according to greedy condition
        for( job current : jobs)
        {
            int position = current.deadline;
            if(jobstaken[position]==0)
            {
            // System.out.println(current.profit);
            jobstaken[position]=current.profit;
            answer+=current.profit;
            }
            else
            {
                while ((--position>=1)&&(jobstaken[position]==0)) {
                    jobstaken[position]=current.profit;
                    // System.out.println("adding "+current.profit);
                    answer+=current.profit;
                    break;
                }
            }
        }
        // printing final answer
        System.out.println("Total profit that can be incurred is "+answer);
        //printing job sequence
        for(int i=1 ; i <= size;i++)
        {
            System.out.println("do job with profit "+jobstaken[i]);
        }
    sc.close();
    }
}
