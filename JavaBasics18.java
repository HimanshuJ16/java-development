public class JavaBasics18 {
  public static int gridWays(int i, int j, int n, int m) {
    //base case
    if(i == n-1 && j == m-1) {
      return 1;
    } else if(i == n || j == n) {
      return 0;
    }

    int w1 = gridWays(i+1, j, n, m);
    int w2 = gridWays(i, j+1, n, m);
    return w1 + w2;
  }

  public static int factorial(int n) {
    // base case
    if(n == 0 || n == 1) {
      return 1;
    }
    return n * factorial(n-1);
  }
  public static void main(String[] args) {
    int n = 3, m = 3;
    // method with time complexity of O(2^(n + m))
    System.out.println(gridWays(0, 0, n, m));

    //linear method with time complexity of O(n + m)
    int gridways = factorial(n+m-2) / (factorial(n-1) * factorial(m-1));
    System.out.println(gridways);
  }
}