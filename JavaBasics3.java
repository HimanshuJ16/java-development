import java.util.*;

public class JavaBasics3 {
  public static void main(String args[]) {
    // // code1
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Enter the number: ");
    // int n = sc.nextInt();
    // int sum = 0;
    // int i = 1;
    // while (i <= n) {
    //   sum += i;
    //   i++;
    // }
    // System.out.println("The sum : " + sum);   
    // sc.close();

    // // code2
    // for(int i=1; i<=10; i++) {
    //   System.out.println("Hello World!");
    // }

    // // code3
    // for(int j=1; j<=4; j++) {
    //   for(int i=1; i<=4; i++) {
    //   System.out.print("*");
    //   }
    //   System.out.println("");
    // } 

    // // code4
    // int n = 10899;
    // while ( n > 0) {
    //   int lastDigit = n % 10;
    //   System.out.print(lastDigit);
    //   n /= 10;
    // }
    // System.out.println();

    // // code5
    // int n = 10899;
    // int rev = 0;
    // while(n > 0) {
    //   int lastDigit = n % 10;
    //   rev  = (rev*10) + lastDigit;
    //   n /= 10;
    // }
    // System.out.println(rev);

    // // code6
    // int num = 1;
    // do {
    //   System.out.println("Hello world");
    //   num++;
    // } while (num <= 10);

    // // code7
    // Scanner sc = new Scanner(System.in);
    // do {
    //   int n = sc.nextInt();
    //   if(n % 10 == 0) {
    //     break;
    //   }
    //   System.out.println(n);
    // } while (true);
    // sc.close();

    // // code8 
    // Scanner sc = new Scanner(System.in);
    // do {
    //   System.out.print("Enter your number: ");
    //   int n = sc.nextInt();
    //   if(n % 10 == 0) {
    //     continue;
    //   }
    //   System.out.println("Number was: " + n);
    // } while(true);

    // // code9
    // Scanner sc = new Scanner(System.in);
    // int n = sc.nextInt();

    // boolean isPrime = true;
    // for(int i=2; i<=Math.sqrt(n); i++) {
    //   if(n%i == 0) {
    //     isPrime = false;
    //   }
    // }
    // if(isPrime == true) {
    //   System.out.println("n is prime");
    // } else {
    //   System.out.println("n is not prime");
    // }
    // sc.close();

    // // assign2
    // Scanner sc = new Scanner(System.in);
    // int number;
    // int choice;
    // int evenSum = 0;
    // int oddSum = 0;
    // do{
    //   System.out.print("Enter the number: ");
    //   number = sc.nextInt();
    //   if(number % 2 == 0) {
    //     evenSum += number;
    //   } else {
    //     oddSum += number;
    //   }
    //   System.out.print("Do you want to continue? Press 1 for yes or 0 for no: ");
    //   choice = sc.nextInt();
    // } while(choice == 1);
    // System.out.println("Sum of even numbers: " + evenSum);
    // System.out.println("Sum of odd numbers: "+oddSum);
    // sc.close();

    // // assign3
    // Scanner sc = new Scanner(System.in); 
    // int num;
    // int fact = 1;
    // System.out.print("Enter any positive number: ");
    // num = sc.nextInt();
    // for(int i=1; i<=num; i++) {
    //   fact *= i;
    // }
    // System.out.println("Factorial: " + fact);
    // sc.close();

    // // assign4
    // Scanner sc = new Scanner(System.in); 
    // System.out.print("Enter a number: ");
    // int n = sc.nextInt();
    // for(int i=1; i<=10; i++) {
    //   System.out.println(n + " * " + i + " = " + n*i);
    // }
    // sc.close();
  }
}
