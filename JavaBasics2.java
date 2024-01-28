import java.util.*;

public class JavaBasics2 {
  public static void main(String args[]) {
    // // code1
    // int age = 16;
    // if (age >= 18) {
    //   System.out.println("adult : drive, vote");
    // }
    // else if (age > 13 && age < 18) {
    //   System.out.println("teenager");
    // }
    // else {
    //   System.out.println("not-adult");
    // }

    // // code2
    // Scanner sc = new Scanner(System.in);
    // int a = sc.nextInt();
    // if (a % 2 == 0) {
    //   System.out.println("The given number is even");
    // } else {
    //   System.out.println("The given number is odd");
    // }
    // sc.close();

    // // code3
    // Scanner sc = new Scanner(System.in);
    // int inc = sc.nextInt();
    // int tax;
    // if (inc < 500000) {
    //   tax = 0;
    // } else if (inc >= 500000 && inc < 1000000) {
    //   tax = (int) (inc * 0.2);
    // } else {
    //   tax = (int) (inc * 0.3); 
    // }
    // System.out.println("Your income tax is " + tax);
    // sc.close();

    // // code4
    // int a = 1;
    // int b = 3;
    // int c = 6;
    // if ((a >= b) && (a >= c)) {
    //   System.out.println("The largest of all three is a");
    // }
    // else if (b >= c) {
    //   System.out.println("The largest of all three is b");
    // }
    // else {
    //   System.out.println("The largest of all three is c");
    // }

    // // code5
    // int num = 4;
    // String type = ((num % 2) == 0) ? "even" : "odd";
    // System.out.println(type);

    // // code6
    // int marks = 40;
    // String type = (marks >= 33) ? "pass" : "fail";
    // System.out.println(type);

    // // code7
    // int num = 3;
    // switch (num) {
    //   case 1: System.out.println("samosa");
    //   break;
    //   case 2: System.out.println("burger");
    //   break;
    //   case 3: System.out.println("pizza");
    //   break;
    //   default : System.out.println("we wake up");
    // }

    // // code8
    // Scanner sc = new Scanner(System.in);
    // System.out.println("Enter a : ");
    // int a = sc.nextInt();
    // System.out.println("Enter b : ");
    // int b = sc.nextInt();
    // System.out.println("Enter operator : ");
    // char operator = sc.next().charAt(0);
    // switch (operator) {
    //   case '+': System.out.println(a + b);
    //   break;
    //   case '-': System.out.println(a - b);
    //   break;
    //   case '*': System.out.println(a * b);
    //   break;
    //   case '/': System.out.println(a / b);
    //   break;
    //   case '%': System.out.println(a % b);
    //   break;
    //   default : System.out.println("wrong input");
    // }
    // sc.close();

    // // assign1
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Enter a number : ");
    // int a = sc.nextInt();
    // if (a < 0) {
    //   System.out.println("The number is negative");
    // } else {
    //   System.out.println("The number is positive");
    // }
    // sc.close();

    // // assign2
    // double temp = 93.5;
    // if (temp > 100) {
    //   System.out.println("You have fever!");
    // } else {
    //   System.out.println("You are good :)");
    // }

    // // assign3
    // Scanner sc = new Scanner(System.in);
    // System.out.print("Enter a number from (1-7) : ");
    // int num = sc.nextInt();
    // switch (num) {
    //   case 1: System.out.println("Monday");
    //   break;
    //   case 2: System.out.println("Tuesday");
    //   break;
    //   case 3: System.out.println("Wednesday");
    //   break;
    //   case 4: System.out.println("Thrusday");
    //   break;
    //   case 5: System.out.println("Friday");
    //   break;
    //   case 6: System.out.println("Saturday");
    //   break;
    //   case 7: System.out.println("Sunday");
    //   break;
    //   default : System.out.println("It's your day !");
    // }
    // sc.close();

    // // assign4
    Scanner sc = new Scanner(System.in);
    System.out.print("Input the year: ");
    int year = sc.nextInt();
    boolean x = (year % 4) == 0;
    boolean y = (year % 100) != 0;
    boolean z = ((year % 100 == 0) && (year % 400 == 0));
    if(x && (y || z)) {
      System.out.println(year + " is a leap year");
    } else {
      System.out.println(year + " is not a leap year");
    }
    sc.close();
  } 
}
