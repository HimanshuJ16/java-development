import java.util.*;

public class JavaBasics37 {
  public static void activitySelection(int start[], int end[]) {
    int activities[][] = new int[start.length][3];
    for(int i=0; i<start.length; i++) {
      activities[i][0] = i;
      activities[i][1] = start[i];
      activities[i][2] = end[i];
    }

    Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

    int maxAct = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    maxAct = 1;
    ans.add(activities[0][0]);
    int lastEnd = activities[0][2];
    for(int i=1; i<end.length; i++) {
      if (activities[i][1] >= lastEnd) {
        maxAct++;
        ans.add(activities[i][0]);
        lastEnd = activities[i][2];
      }
    }

    System.out.println("max activities = " + maxAct);
    for(int i=0; i<ans.size(); i++) {
      System.out.print("A" + ans.get(i) + " ");
    }
    System.out.println();
  }

  public static void fractionalKnapsack(int val[], int weight[], int W) {
    double ratio[][] = new double[val.length][2];

    for(int i=0; i<val.length; i++) {
      ratio[i][0] = i;
      ratio[i][1] = val[i]/(double)weight[i];
    }

    Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

    int capacity = W;
    int finalVal = 0;

    for(int i=ratio.length-1; i>=0; i--) {
      int idx = (int)ratio[i][0];
      if (capacity >= weight[idx]) {
        finalVal += val[idx];
        capacity -= weight[idx];
      } else {
        finalVal += (ratio[i][1] * capacity);
        capacity = 0;
        break;
      }
    }

    System.out.println("the final value = " + finalVal);
  }
  public static void main(String[] args) {
    // CODE1
    int start[] = {1, 3, 0, 5, 8, 5};
    int end[] = {2, 4, 6, 7, 9, 9};
    activitySelection(start, end);

    // CODE2
    int val[] = {60, 100, 120};
    int weight[] = {10, 20, 30};
    int W = 50;
    fractionalKnapsack(val, weight, W);    
  }
}
