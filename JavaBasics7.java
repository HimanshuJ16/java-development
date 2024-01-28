import java.util.*;

public class JavaBasics7 {
  public static void update(int marks[]) {
    for(int i=0; i<marks.length; i++) {
      marks[i] += 1;
    }
  }
  
  public static int linearSearch(int numbers[], int key) {
    for(int i=0; i<numbers.length; i++) {
      if(numbers[i] == key) {
        return i;
      }
    }
    return -1;
  }
  
  public static int getLargest(int numbers[]) {
    int largest = Integer.MIN_VALUE;
    int smallest = Integer.MAX_VALUE;
    for(int i=0; i<numbers.length; i++) {
      if(largest < numbers[i]) {
        largest = numbers[i];
      }
      if(smallest > numbers[i]) {
        smallest = numbers[i];
      }
    }
    System.out.println("smallest value is : " + smallest);
    return largest;
  }

  public static int binarySearch(int numbers[], int key) {
    int start = 0, end = numbers.length-1;
    while (start <= end) {
      int mid = (start + end) / 2;
      if(numbers[mid] == key) {
        return mid;
      }
      if(numbers[mid] < key) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  public static void reverse(int numbers[]) {
    int first = 0, last = numbers.length-1;
    while(first < last) {
      int temp = numbers[last];
      numbers[last] = numbers[first];
      numbers[first] = temp;
      first++;
      last--;
    }
  }

  public static void printPairs(int numbers[]) {
    int tp = 0;
    for(int i=0; i<numbers.length; i++) {
      int curr = numbers[i];
      for(int j=i+1; j<numbers.length; j++) {
        System.out.print("(" + curr + "," + numbers[j] + ") ");
        tp++;
      }
      System.out.println();
    }
    System.out.println("total pairs = " + tp);
  }

  public static void printSubarrays(int numbers[]) {
    int ts = 0;
    for(int i=0; i<numbers.length; i++) {
      int start = i;
      for(int j=i; j<numbers.length; j++) {
        int end = j;
        for(int k=start; k<=end; k++) {
          System.out.print(numbers[k] + " ");
        }
        ts++;
        System.out.println();
      }
      System.out.println();
    }
    System.out.println("total subarrays = " + ts);
  }
  public static void main(String[] args) {
    // // code1
    // int marks[] = new int[100];
    // Scanner sc = new Scanner(System.in);
    // marks[0] = sc.nextInt();
    // marks[1] = sc.nextInt();
    // marks[2] = sc.nextInt();
    // int percentage = (marks[0] + marks[1] + marks[2]) / 3;
    // System.out.println("phy : " + marks[0]);
    // System.out.println("chem : " + marks[1]);
    // System.out.println("math : " + marks[2]);
    // System.out.println("Percentage : " + percentage + "%");
    // sc.close();

    // // code2
    // int marks[] = {1, 2, 3};
    // update(marks);
    // for(int i=0; i<marks.length; i++) {
    //   System.out.print(marks[i] + " ");
    // }
    // System.out.println();

    // // code3
    // int numbers[] = {2, 4, 6, 8, 10, 12, 14, 16};
    // int key = 10;
    // int index = linearSearch(numbers, key);
    // if(index == -1) {
    //   System.out.println("NOT FOUND!");
    // } else {
    //   System.out.println("key is at index : " + index);
    // }
 
    // // code4
    // int numbers[] = {1, 2, 6, 3, 5};
    // System.out.println("largest value is : " + getLargest(numbers));  

    // // code5
    // int numbers[] = {2, 4, 6, 8, 10, 12, 14, 16};
    // int key = 4;
    // System.out.println("index for key is : " + binarySearch(numbers, key));  
  
    // // code6
    // int numbers[] = {2, 4, 6, 8, 10};  
    // reverse(numbers);
    // for(int i=0; i<numbers.length; i++) {
    //   System.out.print(numbers[i] + " ");
    // }
    // System.out.println();

    // // code7
    // int numbers[] = {2, 4, 6, 8, 10};
    // printPairs(numbers);

    // // code8
    int numbers[] = {2, 4, 6, 8, 10};
    printSubarrays(numbers);  
  }
}
