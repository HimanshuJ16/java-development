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

  public static int longestCommonSubstring(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int dp[][] = new int[n+1][m+1];
    int ans = 0;
    for(int i=0; i<n+1; i++) {
      for(int j=0; j<m+1; j++) {
        if(i==0 || j==0) {
          dp[i][j] = 0;
        } else if(s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i][j] = 1 + dp[i-1][j-1];
          ans = Math.max(ans, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }

    print(dp);
    return ans;
  }

  public static int lcs(int arr1[], int arr2[]) {
    int n = arr1.length;
    int m = arr2.length;
    int dp[][] = new int[n+1][m+1];
    for(int i=0; i<n+1; i++) {
      for(int j=0; j<m+1; j++) {
        if(i==0 || j==0) {
          dp[i][j] = 0;
        } else if(arr1[i-1] == arr2[j-1]) {
          dp[i][j] = 1 + dp[i-1][j-1];
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }

    print(dp);

    return dp[n][m];
  }

  public static int lis(int arr[]) {
    HashSet<Integer> set = new HashSet<>();
    for(int i=0; i<arr.length; i++) {
      set.add(arr[i]);
    }

    int lis[] = new int[set.size()];
    int i = 0;
    for(int num : set) {
      lis[i] = num;
      i++;
    }

    Arrays.sort(lis);

    return lcs(arr, lis);
  }

  public static int minDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();
    int dp[][] = new int[n+1][m+1];

    for(int i=0; i<n+1; i++) {
      for(int j=0; j<m+1; j++) {
        if(i == 0) {
          dp[i][j] = j;
        }
        if(j == 0) {
          dp[i][j] = i;
        }
      }
    }

    for(int i=1; i<n+1; i++) {
      for(int j=1; j<m+1; j++) {
        if(word1.charAt(i-1) == word2.charAt(j-1)) {
          dp[i][j] = dp[i-1][j-1];
        } else {
          int add = dp[i][j-1] + 1;
          int del = dp[i-1][j] + 1;
          int rep = dp[i-1][j-1] + 1;
          dp[i][j] = Math.min(add, Math.min(del, rep));
        }
      }
    }

    print(dp);
    return dp[n][m];
  }

  public static boolean isMatch(String s, String p) {
    int n = s.length();
    int m = p.length();

    boolean dp[][] = new boolean[n+1][m+1];
    dp[0][0] = true;

    for(int i=1; i<n+1; i++) {
      dp[i][0] = false;
    }

    for(int j=1; j<m+1; j++) {
      if(p.charAt(j-1) == '*') {
        dp[0][j] = dp[0][j-1];
      }
    }
    
    for(int i=1; i<n+1; i++) {
      for(int j=1; j<m+1; j++) {
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
          dp[i][j] = dp[i-1][j-1];
        } else if(p.charAt(j-1) == '*') {
          dp[i][j] = dp[i][j-1] || dp[i-1][j];
        } else {
          dp[i][j] = false;
        }
      }
    }

    print1(dp);
    return dp[n][m];
  }

  public static int catalanRecurion(int n) {
    if(n <= 1) {
      return 1;
    }
    int ans = 0;
    for(int i=0; i<n; i++) {
      ans += catalanRecurion(i) * catalanRecurion(n-i-1);
    }
    return ans;
  }

  public static int catalanMemoization(int n, int dp[]) {
    if(n <= 1) {
      return 1;
    }
    if(dp[n] != -1) {
      return dp[n];
    }
    int ans = 0;
    for(int i=0; i<n; i++) {
      ans += catalanMemoization(i, dp) * catalanMemoization(n-i-1, dp);
    }
    return dp[n] = ans;
  }

  public static int catalanTabulation(int n) {
    int dp[] = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2; i<=n; i++) {
      int ans = 0;
      for(int j=0; j<i; j++) {
        ans += dp[j] * dp[i-j-1];
      }
      dp[i] = ans;
    }
    return dp[n];
  }

  public static int countBST(int n) {
    int dp[] = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2; i<=n; i++) {
      int ans = 0;
      for(int j=0; j<i; j++) {
        ans += dp[j] * dp[i-j-1];
      }
      dp[i] = ans;
    }
    return dp[n];
  }

  public static int mountainRanges(int n) {
    int dp[] = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2; i<=n; i++) {
      int ans = 0;
      for(int j=0; j<i; j++) {
        ans += dp[j] * dp[i-j-1];
      }
      dp[i] = ans;
    }
    return dp[n];
  }

  public static int mcm(int[] arr, int i, int j) {
    if(i >= j) {
      return 0;
    }
    int ans = Integer.MAX_VALUE;
    for(int k=i; k<j; k++) {
      int temp = mcm(arr, i, k) + mcm(arr, k+1, j) + arr[i-1] * arr[k] * arr[j];
      ans = Math.min(ans, temp);
    }
    return ans;
  }

  public static int mcmMemoization(int[] arr, int i, int j, int[][] dp) {
    if(i >= j) {
      return 0;
    }
    if(dp[i][j] != -1) {
      return dp[i][j];
    }
    int ans = Integer.MAX_VALUE;
    for(int k=i; k<j; k++) {
      int temp = mcmMemoization(arr, i, k, dp) + mcmMemoization(arr, k+1, j, dp) + arr[i-1] * arr[k] * arr[j];
      ans = Math.min(ans, temp);
    }
    return dp[i][j] = ans;
  }

  public static int mcmTabulation(int[] arr) {
    int n = arr.length;
    int dp[][] = new int[n][n];
    for(int i=0; i<n; i++) {
      dp[i][i] = 0;
    }
    for(int i=n-1; i>=1; i--) {
      for(int j=i+1; j<n; j++) {
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
          int temp = dp[i][k] + dp[k+1][j] + arr[i-1] * arr[k] * arr[j];
          ans = Math.min(ans, temp);
        }
        dp[i][j] = ans;
      }
    }

    print(dp);
    return dp[1][n-1];
  }

  public static int minPartition(int[] arr) {
    int n = arr.length;
    int sum = 0;
    for(int i=0; i<arr.length; i++) {
      sum += arr[i];
    }

    int W = sum/2;
    int dp[][] = new int[n+1][W+1];
    
    for(int i=1; i<n+1; i++) {
      for(int j=1; j<W+1; j++) {
        if(arr[i-1] <= j) {
          dp[i][j] = Math.max(arr[i-1] + dp[i-1][j-arr[i-1]], dp[i-1][j]);
        } else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    int sum1 = dp[n][W];
    int sum2 = sum - sum1;
    return Math.abs(sum1 - sum2);
  }
  
  public static int minJumps(int[] arr) {
    int n = arr.length;
    int dp[] = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for(int i=1; i<n; i++) {
      for(int j=0; j<i; j++) {
        if(arr[j] + j >= i) {
          dp[i] = Math.min(dp[i], dp[j] + 1);
        }
      }
    }
    for(int i=0; i<dp.length; i++) {
      System.out.print(dp[i] + " ");
    }
    return dp[n-1];
  }

  static void printTrib(int n) {
    int dp[] = new int[n];
    dp[0] = dp[1] = 0;
    dp[2] = 1;
    
    for (int i = 3; i < n; i++) {
      dp[i] = dp[i - 1] +dp[i - 2] +dp[i - 3];
    }
    
    for (int i = 0; i < n; i++) {
      System.out.print(dp[i] + " ");
    }
  }

  static void _printParenthesis(char str[], int pos, int n, int open, int close) {
    if(close == n)  {
      for(int i=0; i<str.length; i++) {
        System.out.print(str[i]);
      }
      System.out.println();
      return;
    } else {
      if(open > close) {
        str[pos] = '}';
        _printParenthesis(str, pos+1, n, open, close+1);
      }
      if(open < n) {
        str[pos] = '{';
        _printParenthesis(str, pos+1, n, open+1, close);
      }
    }
  }
  
  static void printParenthesis(char str[], int n) {
    if(n > 0) {
      _printParenthesis(str, 0, n, 0, 0);
      return;
    }
  }

  static int max_profit(int a[], int b[], int n, int fee) {
    int i, j, profit;
    int l, r, diff_day = 1, sum = 0;
    b[0] = 0;
    b[1] = diff_day;
    
    for(i=1; i<n; i++) {
      l=0;
      r=diff_day;
      sum=0;
      for(j=n-1; j>=i; j--) {
        profit = (a[r] - a[l]) - fee;
        if(profit > 0) {
          sum = sum + profit;
        }
        l++;
        r++;
      }
      
      if(b[0] < sum) {
        b[0] = sum;
        b[1] = diff_day;
      }
      
      diff_day++;
    }
    
    return 0;
  }

  static int LIP(int dp[][], int mat[][], int n, int m, int x, int y) {
    if (dp[x][y] < 0) {
      int result = 0;
      if (x == n - 1 && y == m - 1) {
        return dp[x][y] = 1;
      }
      if (x == n - 1 || y == m - 1) {
        result = 1;
      }
      if (x + 1 < n && mat[x][y] < mat[x + 1][y]) {
        result = 1 + LIP(dp, mat, n, m, x + 1, y);
      }
      if (y + 1 < m && mat[x][y] < mat[x][y + 1]) {
        result = Math.max(result, 1 + LIP(dp, mat, n, m, x, y + 1));
      }
      dp[x][y] = result;
    }
    
    return dp[x][y];
  }
  
  static int wrapper(int mat[][], int n, int m) {
    int dp[][] = new int[10][10];
    for (int i = 0; i < 10; i++) {
      Arrays.fill(dp[i], -1);
    }
    
    return LIP(dp, mat, n, m, 0, 0);
  }

  public static List<String> generateParenthesis(int n) {
    List<List<String>> dp = new ArrayList<>();
    dp.add(List.of(""));

    for (int i = 1; i <= n; i++) {
        List<String> current = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            for (String first : dp.get(j)) {
                for (String second : dp.get(i - 1 - j)) {
                    current.add("(" + first + ")" + second);
                }
            }
        }
        dp.add(current);
    }

    return dp.get(n);
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
    // String str1 = "abcdge";
    // String str2 = "abedg";
    // int dp[][] = new int[str1.length()+1][str2.length()+1];
    // for(int i=0; i<str1.length()+1; i++) {
    //   for(int j=0; j<str2.length()+1; j++) {
    //     dp[i][j] = -1;
    //   }
    // }
    // System.out.println(lcs(str1, str2, str1.length(), str2.length()));
    // System.out.println(lcsMemoization(str1, str2, str1.length(), str2.length(), dp));
    // System.out.println(lcsTabulation(str1, str2, str1.length(), str2.length()));
  
    // // CODE9
    // String str1 = "ABCDE";
    // String str2 = "ABGCE";
    // System.out.println(longestCommonSubstring(str1, str2));
  
    // // CODE10
    // int arr[] = {50, 3, 10, 7, 40, 80};
    // System.out.println(lis(arr));

    // // CODE11
    // String word1 = "intention";
    // String word2 = "execution";
    // System.out.println(minDistance(word1, word2));

    // // CODE12
    // String s = "abc";
    // String p = "**c";
    // System.out.println(isMatch(s, p));

    // // CODE13
    // int n = 5;
    // int dp[] = new int[n+1];
    // Arrays.fill(dp, -1);
    // System.out.println(catalanRecurion(n));
    // System.out.println(catalanMemoization(n, dp));
    // System.out.println(catalanTabulation(n));

    // // CODE14
    // int n = 3;
    // System.out.println(countBST(n));

    // // CODE15
    // int n = 4;
    // System.out.println(mountainRanges(n));

    // // CODE16
    // int arr[] = {1, 2, 3, 4, 3};
    // int n = arr.length;    
    // int dp[][] = new int[n][n];
    // for(int i=0; i<n; i++) {
    //   Arrays.fill(dp[i], -1);
    // }
    // System.out.println(mcm(arr, 1, n-1));
    // System.out.println(mcmMemoization(arr, 1, n-1, dp));
    // System.out.println(mcmTabulation(arr));

    // // CODE17
    // int nums[] = {1, 6, 11, 5};
    // System.out.println(minPartition(nums));

    // // CODE18
    // int arr[] = {2, 3, 1, 1, 4};
    // System.out.println(minJumps(arr));

    // // CODE19
    // int n = 10;
    // printTrib(n);

    // // CODE20
    // int n = 3;
    // char[] str = new char[2 * n];
    // printParenthesis(str, n);

    // // CODE21
    // int arr[] = { 6, 1, 7, 2, 8, 4 };
    // int n = arr.length;
    // int[] b = new int[2];
    // int tranFee = 2;
    // max_profit(arr, b, n, tranFee);
    // System.out.println(b[0]+", "+b[1]);

    // // CODE22
    // int mat[][] = {
    //   { 1, 2, 3, 4 },
    //   { 2, 2, 3, 4 },
    //   { 3, 2, 3, 4 },
    //   { 4, 5, 6, 7 },
    // };
    // int n = 4, m = 4;
    // System.out.println(wrapper(mat, n, m));

    // // CODE23
    // int n = 4;
    // List<String> combinations = generateParenthesis(n);
    // System.out.println("Number of valid combinations: " + combinations.size());
    // System.out.println("Combinations: " + combinations);
  }
}
