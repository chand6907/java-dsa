package greedyalgo;
import java.util.*;
public class activityselection {
    

    public static void main (String args[]){
        int start[] = {1,3,0,5,8,5};
        int end[] = {9,9,6,7,2,4};

        //sorting 
        int activities[][] = new int[start.length][3];
        for (int i = 0 ; i < start.length ; i++){   
            activities[i][0] = i; //index
            activities[i][1] = start[i]; //start time
            activities[i][2] = end[i]; //end time
        }
        Arrays.sort(activities, (a,b) -> a[2] - b[2]);

           //end time base sorting 
        int maxAct = 0 ;
        ArrayList<Integer> ans = new ArrayList<>();

        //for unsorted array
        //1st activity
        // maxAct = 1;
        // ans.add(0);

        // int lastEnd = end[0];
        // for (int i = 1 ; i < end.length ; i++){
        //     if(start[i]>=lastEnd){
        //         maxAct++;
        //         ans.add(i);
        //         lastEnd = end[i];
        //     }
        // }


        //for sorted array

        maxAct = 1 ;
        ans.add(activities[0][0]);

        int lastEnd = activities[0][2];

        for(int i  = 1 ; i < activities.length ; i++){
            if(activities[i][1]>=lastEnd){
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }
        System.out.println("Maximum activities: " + maxAct);
       for (int i = 0; i < ans.size(); i++) {
            int idx = ans.get(i);
            System.out.println("Activity " + idx + 
                " (Start: " + start[idx] + ", End: " + end[idx] + ")");
        }
        System.out.println();
    }
}
