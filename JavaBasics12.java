import java.util.*;

public class JavaBasics12 {
  public static void oddOrEven(int n) {
    int bitMask = 1;
    if((n & bitMask) == 0) {
      System.out.println("even number");
    } else {
      System.out.println("odd number");
    }
  }
  
  public static int getIthBit(int n, int i) {
    int bitMask = 1<<i;
    if((n & bitMask) == 0) {
      return 0;
    } else {
      return 1;
    }
  }

  public static int setIthBit(int n, int i) {
    int bitMask = 1<<i;
    return n | bitMask;
  }

  public static int clearIthBit(int n, int i) {
    int bitMask = ~(1<<i);
    return n & bitMask;
  }
  
  public static int updateIthBit(int n, int i, int newBit) {
    // if(newBit == 0) {
    //   return clearIthBit(n, i);
    // } else {
    //   return setIthBit(n, i);
    // }

    n = clearIthBit(n, i);
    int BitMask = newBit<<i;
    return n | BitMask;
  }
  
  public static int clearIBits(int n, int i) {
    int bitMask = (~0)<<i;
    return n & bitMask;
  }
  
  public static int clearIBitsinRange(int n, int i, int j) {
    int a = ((~0)<<(j+1));
    int b = (1<<i)-1;
    int bitMask = a | b;
    return n & bitMask;
  }
  
  public static boolean isPowerOfTwo(int n) {
    return (n&(n-1)) == 0;
  }
  
  public static int countSetbits(int n) {
    int count = 0;
    while (n > 0) {
      if ((n & 1) != 0) {
        count++;
      }
      n = n>>1;
    }
    return count;
  }

  public static int fastExpo(int a, int n) {
    int ans = 1;
    while (n > 0) {
      if((n & 1) != 0) {
        ans = ans * a;
      }
      a = a * a;
      n = n>>1;
    }
    return ans;
  }
  public static void main(String[] args) {
    // // code1
    // System.out.println((5 & 6));
    // System.out.println((5 | 6));
    // System.out.println((5 ^ 6));
    // System.out.println((~5));
    // System.out.println((5 << 2));
    // System.out.println((6 >> 1));

    // // code2
    // oddOrEven(3);

    // // code3
    // System.out.println(getIthBit(10, 2));

    // // code4
    // System.out.println(setIthBit(10, 2));

    // // code5
    // System.out.println(clearIthBit(10, 1));

    // // code6
    // System.out.println(updateIthBit(10, 2, 1));
        
    // // code7
    // System.out.println(clearIBits(15, 2));

    // // code8
    // System.out.println(clearIBitsinRange(10, 2, 4));

    // // code9
    // System.out.println(isPowerOfTwo(15));

    // // code10
    // System.out.println(countSetbits(8));

    // // code11
    // System.out.println(fastExpo(3, 5));

    // // assign2
    // int x = 3, y = 4;
    // System.out.println("Before swap: x = " + x + " and y = " + y);
    // x = x ^ y;
    // y = x ^ y;
    // x = x ^ y;
    // System.out.println("After swap: x = " + x + " and y = " + y);

    // // assign3
    // int x = 6;
    // System.out.println(x + " + " + 1 + " is " + -~x);
    // x = -4;
    // System.out.println(x + " + " + 1 + " is " + -~x);
    // x = 0;
    // System.out.println(x + " + " + 1 + " is " + -~x);
  
    // // assign4
    // for(char ch = 'A'; ch <= 'Z'; ch++) {
    //   System.out.println((char)(ch | ' '));
    // }
  }
}
