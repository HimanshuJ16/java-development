public class JavaBasics14 {
  public static void printDec(int n) {
    if(n == 1) {
      System.out.println(1);
      return;
    }
    System.out.print(n + " ");
    printDec(n-1);
  }

  public static void printInc(int n) {
    if(n == 1) {
      System.out.print(n + " ");
      return;
    }
    printInc(n-1);
    System.out.print(n + " ");
  }

  public static int fact(int n) {
    if(n == 0) {
      return 1;
    }
    int fnm1 = fact(n-1);
    int fn = n * fnm1;
    return fn;
  }

  public static int calcSum(int n) {
    if(n == 1) {
      return 1;
    }
    int Snm1 = calcSum(n-1);
    int Sn = n + Snm1;
    return Sn;
  }

  public static int fib(int n) {
    if(n == 0 || n == 1) {
      return n;
    }
    int fnm1 = fib(n-1);
    int fnm2 = fib(n-2);
    int fn = fnm1 + fnm2;
    return fn;
  }

  public static boolean isSorted(int arr[], int i) {
    if(i == arr.length-1) {
      return true;
    }
    if(arr[i] > arr[i+1]) {
      return false;
    }
    return isSorted(arr, i+1);
  }
  
  public static int firstOccurence(int arr[], int key, int i) {
    if(i == arr.length) {
      return -1;
    }
    if(arr[i] == key) {
      return i;
    }
    return firstOccurence(arr, key, i+1);
  }

  public static int lastOccurence(int arr[], int key, int i) {
    if(i == arr.length) {
      return -1;
    }
    int isFound = lastOccurence(arr, key, i+1);
    if(isFound == -1 && arr[i] == key) {
      return i;
    }
    return isFound;
  }

  public static int power(int x, int n) {
    if(n == 0) {
      return 1;
    }
    return x * power(x, n-1);
  }

  public static int optimizedPower(int a, int n) {
    if(n == 0) {
      return 1;
    }
    int halfPower = optimizedPower(a, n/2);
    int halfPowerSq = halfPower * halfPower;
    if(n % 2 != 0) {
      halfPowerSq = a * halfPowerSq;
    }
    return halfPowerSq;
  }
  
  public static int tilingProblem(int n) {
    if(n == 0 || n == 1) {
      return 1;
    }
    return tilingProblem(n-1) + tilingProblem(n-2);
  }

  public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]) {
    if(idx == str.length()) {
      System.out.println(newStr);
      return;
    }
    char currChar = str.charAt(idx);
    if(map[currChar-'a'] == true) {
      removeDuplicates(str, idx+1, newStr, map);
    } else {
      map[currChar-'a'] = true;
      removeDuplicates(str, idx+1, newStr.append(currChar), map);
    }
  }

  public static int friendsPairing(int n) {
    if(n == 0 || n == 1) {
      return 1;
    }
    return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
  }

  public static void printBinaryStrings(int n, int lastPlace, String str) {
    if(n == 0) {
      System.out.println(str);
      return;
    }
    printBinaryStrings(n-1, 0, str+"0");
    if(lastPlace == 0) {
      printBinaryStrings(n-1, 1, str+"1");
    }
  }
  public static void main(String[] args) {
    // // code1
    // int n = 25;
    // printDec(n);
    // printInc(n);
    // System.out.println("");
    // System.out.println(fact(n));
    // System.out.println(calcSum(n));
    // System.out.println(fib(n));

    // // code2
    // int arr[] = {8, 3, 4, 9, 5, 10, 2, 5, 3};
    // System.out.println(isSorted(arr, 0));
    // System.out.println(firstOccurence(arr, 4, 0));
    // System.out.println(lastOccurence(arr, 5, 0));
  
    // // code3
    // System.out.println(power(2, 10));
    // System.out.println(optimizedPower(2, 10));

    // // code4
    // System.out.println(tilingProblem(3));

    // // code5
    // String str = "hhimaanshhujjaangggiir";
    // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);
  
    // // code6
    // System.out.println(friendsPairing(3));

    // // code7
    printBinaryStrings(3, 0, "");
  }
}
