import java.util.Arrays;
import java.util.Collections;

public class JavaBasics9 {
  public static void bubbleSort(Integer arr[]) {
    for(int turn=0; turn<arr.length-1; turn++) {
      for(int j=0; j<arr.length-1-turn; j++) {
        if(arr[j] > arr[j+1]) {
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }
  }

  public static void bubbleSortDescending(Integer arr[]) {
    for(int i=0; i<arr.length-1; i++) {
      for(int j=0; j<arr.length-1-i; j++) {
        if(arr[j] < arr[j+1]) {
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }
  }

  public static void printArr(Integer arr[]) {
    for(int i=0; i<arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }

  public static void selectionSort(Integer arr[]) {
    for(int i=0; i<arr.length-1; i++) {
      int minPos = i;
      for(int j=i+1; j<arr.length; j++) {
        if(arr[minPos] > arr[j]) {
          minPos = j;
        }
      }
      int temp = arr[minPos];
      arr[minPos] = arr[i];
      arr[i] = temp;
    } 
  }

  public static void selectionSortDescending(Integer arr[]) {
    for(int i=0; i<arr.length; i++) {
      int minPos = i;
      for(int j=i+1; j<arr.length; j++) {
        if(arr[minPos] < arr[j]) {
          minPos = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[minPos];
      arr[minPos] = temp;
    }
  }

  public static void insertionSort(Integer arr[]) {
    for(int i=1; i<arr.length; i++) {
      int curr = arr[i];
      int prev = i-1;
      while(prev >= 0 && arr[prev] > curr) {
        arr[prev+1] = arr[prev];
        prev--;
      }
      arr[prev+1] = curr;
    }
  }
  
  public static void insertionSortDescending(Integer arr[]) {
    for(int i=1; i<arr.length; i++) {
      int curr = arr[i];
      int prev = i-1;
      while(prev >= 0 && arr[prev] < curr) {
        arr[prev+1] = arr[prev];
        prev--;
      }
      arr[prev+1] = curr;
    }
  }
  
  public static void countingSort(Integer arr[]) {
    int largest = Integer.MIN_VALUE;
    for(int i=0; i<arr.length; i++) {
      largest = Math.max(largest, arr[i]);
    }
    int count[] = new int[largest+1];
    for(int i=0; i<arr.length; i++) {
      count[arr[i]]++;
    }
    int j = 0;
    for(int i=0; i<count.length; i++) {
      while(count[i] > 0) {
        arr[j] = i;
        j++;
        count[i]--;
      }
    }
  }
    
  public static void countingSortDescending(Integer arr[]) {
    int largest = Integer.MIN_VALUE;
    for(int i=0; i<arr.length; i++) {
      largest = Math.max(largest, arr[i]);
    }
    int count[] = new int[largest+1];
    for(int i=0; i<arr.length; i++) {
      count[arr[i]]++;
    }
    int j = 0;
    for(int i=count.length-1; i>=0; i--) {
      while(count[i] > 0) {
        arr[j] = i;
        j++;
        count[i]--;
      }
    }
  }
  public static void main(String[] args) {
    // // code1
    // int arr[] = {5, 4, 1, 2, 3};
    // bubbleSort(arr);
    // printArr(arr);

    // // code2
    // int arr[] = {5, 4, 1, 2, 3};
    // selectionSort(arr);
    // printArr(arr);

    // // code3
    // int arr[] = {5, 4, 1, 2, 3};
    // insertionSort(arr);
    // printArr(arr);

    // // code4
    // Integer arr[] = {5, 4, 1, 2, 3};
    // Arrays.sort(arr);
    // Arrays.sort(arr , 0, 3);
    // Arrays.sort(arr, Collections.reverseOrder());
    // printArr(arr);

    // // code5
    // Integer arr[] = {4, 1, 2, 1, 4, 5, 2, 4, 3, 7};
    // countingSort(arr);
    // printArr(arr);
  
    // // assign1
    // Integer arr[] = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
    // bubbleSortDescending(arr);
    // printArr(arr);

    // // assign2
    // Integer arr[] = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
    // selectionSortDescending(arr);    
    // printArr(arr);

    // // assign3
    // Integer arr[] = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
    // insertionSortDescending(arr);    
    // printArr(arr);

    // // assign4
    Integer arr[] = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
    countingSortDescending(arr);    
    printArr(arr);
  }
}
