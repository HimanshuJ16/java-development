import java.util.*;

public class JavaBasics5 {
  public static void printHelloWorld() {
    System.out.println("Hello World!");
  }

  public static int calculateSum(int num1, int num2) {
    int sum = num1 + num2;
    return sum;
  }

  public static int calculateProduct(int num1, int num2) {
    int pro = num1 * num2;
    return pro;
  }

  public static void swap(int a, int b) {
    int c = a;
    a = b;
    b = c;

    System.out.println("a = " + a);
    System.out.println("b = " + b);
  }

  public static int factorial(int n) {
    int f = 1;

    for(int i=1; i<=n; i++) {
      f = f * i;
    }
    return f;
  }

  public static int bincoeff(int n, int r) {
    int nfact = factorial(n);
    int rfact = factorial(r);
    int nmrfact = factorial(n - r);
    int bino = nfact / (rfact * nmrfact);
    return bino;
  }

  public static int sum(int a, int b) {
    return a + b ;
  }
  public static int sum(int a, int b, int c) {
    return a + b + c ;
  }
  public static float sum(float a, float b) {
    return a + b ;
  }

  // public static boolean isPrime(int n) {
  //   for(int i=2; i<=n-1; i++) {
  //     if(n % i == 0) {
  //       return false;
  //     }
  //   }
  //   return true;
  // }
  public static boolean isPrime(int n) {
    if(n == 2) {
      return true;
    }
    for(int i=2; i<=Math.sqrt(n); i++) {
      if(n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void primeInRange(int n) {
    for(int i=2; i<=n; i++) {
      if(isPrime(i)) {
        System.out.print(i + " ");
      }
    }
  }
  
  public static void binToDec(int binNum) {
    int myNum = binNum;
    int pow = 0;
    int decNum = 0;

    while(binNum > 0) {
      int lastDigit = binNum % 10;
      decNum = decNum + (lastDigit * (int)Math.pow(2, pow));
      pow++;
      binNum = binNum/10;
    }
    System.out.println("decimal of " + myNum + " = " + decNum);
  }

  public static void decToBin(int decNum) {
    int myNum = decNum;
    int pow = 0;
    int binNum = 0;

    while(decNum > 0) {
      int rem = decNum % 2;
      binNum = binNum + (rem * (int)Math.pow(10, pow));
      pow++;
      decNum = decNum/2;
    }
    System.out.println("binary of " + myNum + " = " + binNum);
  }

  public static double average( double x, double y, double z) {
    return (x + y + z) / 3;
  }

  public static boolean isEven(int number) {
    if(number%2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean isPalindrome(int number) { 
    int palindrome = number;// copied number intovariable
    int reverse = 0;
    while(palindrome != 0) {
      int remainder = palindrome % 10;
      reverse = reverse*10 + remainder;
      palindrome = palindrome / 10;
    }
    if(number == reverse) {
      return true;
    } 
    return false;
  }

  public static int sumDigits(int n) {
    int sumOfDigits = 0;
    while(n > 0) {
      int lastDigit = n % 10;
      sumOfDigits += lastDigit;
      n /= 10;
    }
    return sumOfDigits;
  }
  public static void main(String args[]) {
    // printHelloWorld();

    // // code2
    // Scanner sc = new Scanner(System.in);
    // int a = sc.nextInt();
    // int b = sc.nextInt();
    // int sum = calculateSum(a, b);
    // System.out.println("sum is: " + sum);
    
    // // code3
    // Scanner sc = new Scanner(System.in);
    // int a = sc.nextInt();
    // int b = sc.nextInt();

    // swap(a, b);

    // // code4
    // Scanner sc = new Scanner(System.in);
    // int a = sc.nextInt();
    // int b = sc.nextInt();
    // int pro = calculateProduct(a, b);
    // System.out.println("product is: " + pro);


    // System.out.println(factorial(10));


    // System.out.println(bincoeff(5, 2));


    // System.out.println(sum(53, 2));
    // System.out.println(sum(53, 2, 54));
    // System.out.println(sum(53.284f, 2.845f));


    // System.out.println(isPrime(6));

    // primeInRange(200);

    // binToDec(101);
    // decToBin(5);

    // // assign1
    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter the first number: ");
    // double x = sc.nextDouble();
    // System.out.println("Enter the second number: ");
    // double y = sc.nextDouble();
    // System.out.println("Enter the third number: ");
    // double z = sc.nextDouble();
    // System.out.println("The average value is : " + average(x, y, z));

    // // assign2
    // Scanner sc = new Scanner(System.in);
    // int num;
    // System.out.print("Enter an integer: ");
    // num = sc.nextInt();
    // if(isEven(num)) {
    //   System.out.println("The number is even!");
    // } else {
    //   System.out.println("the number is odd!");
    // }
    
    // // assign3
    // System.out.println("Please Enter a number :");
    // Scanner sc = new Scanner(System.in);
    // int palindrome = sc.nextInt();
    // if(isPalindrome(palindrome)) {
    //   System.out.println("Number : " + palindrome + " is a palindrome");
    // } else {
    //   System.out.println("Number : " + palindrome + " is not a palindrome");
    // }

    // // assign5
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Input an integer: ");
    // int digits = sc.nextInt();
    // System.out.println("The sum is " + sumDigits(digits));
  }
}
