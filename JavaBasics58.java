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

  public static int coinChange(int[] coins, int sum) {
    int n = coins.length;
    int dp[][] = new int[n+1][sum+1];
    for(int i=0; i<n+1; i++) {
      dp[i][0] = 1;
    }
    for(int i=1; i<n+1; i++) {
      dp[0][i] = 0;
    }

    for(int i=1; i<n+1; i++) {
      for(int j=1; j<sum+1; j++) {
        if(coins[i-1] <= j) {
          dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
        } else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    print(dp);
    return dp[n][sum];
  }

  public static int rodCutting(int length[], int price[], int totRod) {
    int n = price.length;
    int dp[][] = new int[n+1][totRod+1];
    for(int i=0; i<n+1; i++) {
      for(int j=0; j<totRod+1; j++) {
        if(i==0 || j==0) {
          dp[i][j] = 0;
        } else if(length[i-1] <= j) {
          dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
        } else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    print(dp);
    return dp[n][totRod];
  }

  public static int lcs(String s1, String s2, int n, int m) {
    if (n == 0 || m == 0) {
      return 0;
    }

    if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
      return 1 + lcs(s1, s2, n - 1, m - 1);
    } else {
      return Math.max(lcs(s1, s2, n, m - 1), lcs(s1, s2, n - 1, m));
    }
  }

  public static int lcsMemoization(String s1, String s2, int n, int m, int dp[][]) {
    if (n == 0 || m == 0) {
      return 0;
    }

    if (dp[n][m] != -1) {
      return dp[n][m];
    }

    if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
      return dp[n][m] = 1 + lcsMemoization(s1, s2, n - 1, m - 1, dp);
    } else {
      return dp[n][m] = Math.max(lcsMemoization(s1, s2, n, m - 1, dp), lcsMemoization(s1, s2, n - 1, m, dp));
    }
  }

  public static int lcsTabulation(String s1, String s2, int n, int m) {
    int dp[][] = new int[n+1][m+1];
    for(int i=0; i<n+1; i++) {
      for(int j=0; j<m+1; j++) {
        if(i==0 || j==0) {
          dp[i][j] = 0;
        } else if(s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i][j] = 1 + dp[i-1][j-1];
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    print(dp);
    return dp[n][m];
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
    // int val[] = {15, 14, 10, 45, 30};
    // int weight[] = {2, 5, 1, 3, 4};
    // int W = 7;
    // System.out.println(unboundedKnapsack(val, weight, W));
  
    // // CODE6
    // int coins[] = {1, 2, 3};
    // int sum = 4;
    // System.out.println(coinChange(coins, sum));

    // // CODE7
    // int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
    // int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
    // int totRod = 8;
    // System.out.println(rodCutting(length, price, totRod));
  
    // // CODE8
    String str1 = "abcdge";
    String str2 = "abedg";
    int dp[][] = new int[str1.length()+1][str2.length()+1];
    for(int i=0; i<str1.length()+1; i++) {
      for(int j=0; j<str2.length()+1; j++) {
        dp[i][j] = -1;
      }
    }
    System.out.println(lcs(str1, str2, str1.length(), str2.length()));
    System.out.println(lcsMemoization(str1, str2, str1.length(), str2.length(), dp));
    System.out.println(lcsTabulation(str1, str2, str1.length(), str2.length()));
  }
}
