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
  public static void main(String[] args) {
    // // CODE1
    // int n = 5;
    // int f[] = new int[n+1];
    // System.out.println(fib(n, f));
    // System.out.println(fibTabulation(n));

    // // CODE2
    int n = 5;
    int ways[] = new int[n+1];
    Arrays.fill(ways, -1);
    System.out.println(countWays(n, ways));
    countWaysTabulation(n);
  }
}
