import java.util.Arrays;
import java.util.Scanner;

public class JavaBasics11 {
  public static void printLetters(String str) {
    for(int i=0; i<str.length(); i++) {
      System.out.print(str.charAt(i) + " ");
    }
    System.out.println();
  }
  
  public static boolean isPalindrome(String str) {
    for(int i=0; i<str.length()/2; i++) {
      int n = str.length();
      if(str.charAt(i) != str.charAt(n-i-1)) {
        return false;
      }
    }
    return true;
  }
  
  public static float getShortestPath(String path) {
    int x = 0, y = 0;
    for(int i=0; i<path.length(); i++) {
      char dir = path.charAt(i);
      if(dir == 'S') {
        y--;
      } else if (dir == 'N') {
        y++;
      } else if (dir == 'W') {
        x--;
      } else {
        x++;
      }
    }
    int X2 = x*x;
    int Y2 = y*y;
    return (float)Math.sqrt(X2 + Y2); 
  }
  
  public static String subString(String str, int si, int ei) {
    String substr = "";
    for(int i=si; i<ei; i++) {
      substr += str.charAt(i);
    }
    return substr;
  }
  
  public static String toUpperCase(String str) {
    StringBuilder sb = new StringBuilder("");
    char ch = Character.toUpperCase(str.charAt(0));
    sb.append(ch);
    for(int i=1; i<str.length(); i++) {
      if(str.charAt(i) == ' ' && i<str.length()-1) {
        sb.append(str.charAt(i));
        i++;
        sb.append(Character.toUpperCase(str.charAt(i)));
      } else {
        sb.append(str.charAt(i));
      }
    }
    return sb.toString();
  }
  
  public static String compress(String str) {
    String newStr = "";
    for(int i=0; i<str.length(); i++) {
      Integer count = 1;
      while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
        count++;
        i++;
      }
      newStr += str.charAt(i);
      if(count > 1) {
        newStr += count.toString();
      }
    }
    return newStr;
  }
  
  public static int lowercaseVowels(String str) {
    int count = 0;
    for(int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
        count++;
      }
    }
    return count;
  }
  
  public static void anagrams(String str1, String str2) {
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();
    if(str1.length() == str2.length()) {
      char[] str1charArray = str1.toCharArray();
      char[] str2charArray = str2.toCharArray();
      Arrays.sort(str1charArray);
      Arrays.sort(str2charArray);
      boolean result = Arrays.equals(str1charArray, str2charArray);
      if(result) {
        System.out.println(str1 + " and " + str2 + " are anagrams of each other.");
      } else {
        System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
      }
    } else {
      System.out.println(str1 + " and " + str2 + " are not anagrams of each other.");
    }
  }
  public static void main(String[] args) {
    // // code1
    // char arr[] = {'a', 'b', 'c', 'd'};
    // String str = "abcd";
    // String str2 = new String("xyz");

    // // code2
    // Scanner sc = new Scanner(System.in);
    // String name;
    // name = sc.nextLine();
    // System.out.println(name);
    // System.out.println(name.length());

    // // code3
    // String firstName = "Himanshu";
    // String lastName = "Jangir";
    // String fullName = firstName + " " + lastName;
    // System.out.println(fullName);
    // System.out.println(fullName.charAt(0));
    // printLetters(fullName);
  
    // // code4
    // String str = "racecar";
    // System.out.println(isPalindrome(str));

    // // code5
    // String path = "WNEENESENNN";
    // System.out.println(getShortestPath(path));
  
    // // code6
    // String s1 = "Tony";
    // String s2 = "Tony";
    // String s3 = new String("Tony"); 
    // if(s1 == s2) {
    //   System.out.println("String are equal");
    // } else {
    //   System.out.println("String are not equal");
    // }
    // if(s1 == s3) {
    //   System.out.println("String are equal");
    // } else {
    //   System.out.println("String are not equal");
    // }
    // if(s1.equals(s3)) {
    //   System.out.println("String are equal");
    // } else {
    //   System.out.println("String are not equal");
    // }

    // // code7
    // String str = "HelloWorld";
    // System.out.println(str.substring(0, 5));
    // System.out.println(subString(str, 0, 5));

    // // code8
    // String fruits[] = {"apple", "mango", "banana"};
    // String largest = fruits[0];
    // for(int i=1; i<fruits.length; i++) {
    //   if(largest.compareTo(fruits[i]) < 0) {
    //     largest = fruits[i];
    //   }
    // }
    // System.out.println(largest);
    
    // // code9
    // StringBuilder sb = new StringBuilder("");
    // for(char ch='a'; ch<='z'; ch++) {
    //   sb.append(ch);
    // }
    // System.out.println(sb);
    // System.out.println(sb.length());

    // // code10
    // String str = "hi, i am himanshu";
    // System.out.println(toUpperCase(str));

    // // code11
    // String str = "aaabbcccdd";
    // System.out.println(compress(str));

    // // assign1
    // String str = new Scanner(System.in).nextLine();
    // System.out.println("count of vowels is :" + lowercaseVowels(str));

    // // assign2
    // String str = "ShradhaDidi";
    // String str1 = "ApnaCollege";
    // String str2 = "ShradhaDidi";
    // System.out.println(str.equals(str1) + " " + str.equals(str2));

    // // assign3
    // String str = "ApnaCollege".replace("l", "");
    // System.out.println(str);

    // // assign4
    String str1 = "earth";
    String str2 = "heart";
    anagrams(str1, str2);
  }
}
