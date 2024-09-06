import java.util.*;

public class JavaBasics58 {
  public static int fib(int n, int f[]) {
    if (n == 0 || n == 1) {
      return n;
    }

    if (f[n] != 0) {
      return f[n];
    }

    f[n] = fib(n-1, f) + fib(n-2, f);
    return f[n];
  }

  public static int fibTabulation(int n) {
    int f[] = new int[n+1];
    f[0] = 0;
    f[1] = 1;
    for (int i = 2; i <= n; i++) {
      f[i] = f[i-1] + f[i-2];
    }
    return f[n];
  }

  public static int countWays(int n, int ways[]) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return 0;
    }

    if(ways[n] != -1) {
      return ways[n];
    }

    ways[n] = countWays(n-1, ways) + countWays(n-2, ways);

    return ways[n];
  }

  public static void countWaysTabulation(int n) {
    int f[] = new int[n+1];
    f[0] = 1;
    f[1] = 1;
    for (int i = 2; i <= n; i++) {
      f[i] = f[i-1] + f[i-2];
    }
    System.out.println(f[n]);
  }

  public static int knapsack(int val[], int wt[], int W, int n, int dp[][]) {
    if (n == 0 || W == 0) {
      return 0;
    }

    if (dp[n][W] != -1) {
      return dp[n][W];
    }

    if (wt[n-1] <= W) {
      return dp[n][W] = Math.max(val[n-1] + knapsack(val, wt, W-wt[n-1], n-1, dp), knapsack(val, wt, W, n-1, dp));
    } else {
      return dp[n][W] = knapsack(val, wt, W, n-1, dp);
    }
  }

  public static void print(int dp[][]) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static int knapsackTabulation(int val[], int wt[], int W, int n) {
    int dp[][] = new int[n+1][W+1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= W; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (wt[i-1] <= j) {
          dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
        } else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }
    print(dp);
    return dp[n][W];
  }

  public static void print1(boolean dp[][]) {
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static boolean targetSumSubset(int arr[], int sum) { 
    int n = arr.length;
    boolean dp[][] = new boolean[n+1][sum+1];
    for(int i=0; i<=n; i++) {
      for(int j=0; j<=sum; j++) {
        if(i==0) {
          dp[i][j] = false;
        }
        if(j==0) {
          dp[i][j] = true;
        }
      }
    }

    for(int i=1; i<=n; i++) {
      for(int j=1; j<=sum; j++) {
        if(arr[i-1] <= j) {
          dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
        } else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    print1(dp);
    return dp[n][sum];
  }

  public static int unboundedKnapsack(int val[], int wt[], int W) {
    int n = val.length;
    int dp[][] = new int[n+1][W+1];

    for(int i=0; i<=n; i++) {
      for(int j=0; j<=W; j++) {
        if(i==0 || j==0) {
          dp[i][j] = 0; 
        } else if(wt[i-1] <= j) {
          dp[i][j] = Math.max(val[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
        } else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    print(dp);
    return dp[n][W];
  }

  public static void main(String[] args) {
    // // CODE1
    // int n = 5;
    // int f[] = new int[n+1];
    // System.out.println(fib(n, f));
    // System.out.println(fibTabulation(n));

    // // CODE2
    // int n = 5;
    // int ways[] = new int[n+1];
    // Arrays.fill(ways, -1);
    // System.out.println(countWays(n, ways));
    // countWaysTabulation(n);

    // // CODE3
    // int val[] = {15, 14, 10, 45, 30};
    // int weight[] = {2, 5, 1, 3, 4};
    // int W = 7;
    // int dp[][] = new int[val.length+1][W+1];
    // for(int i=0; i<dp.length; i++) {
    //   for(int j=0; j<dp[0].length; j++) {
    //     dp[i][j] = -1;
    //   }
    // }
    // System.out.println(knapsack(val, weight, W, val.length, dp));
    // System.out.println(knapsackTabulation(val, weight, W, val.length));
  
    // // CODE4
    // int arr[] = {4, 2, 7, 1, 3};
    // int sum = 10;
    // System.out.println(targetSumSubset(arr, sum));

    // // CODE5
    int val[] = {15, 14, 10, 45, 30};
    int weight[] = {2, 5, 1, 3, 4};
    int W = 7;
    System.out.println(unboundedKnapsack(val, weight, W));
  }
}
