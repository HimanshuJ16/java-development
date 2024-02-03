public class JavaBasics15 {
  public static void mergeSort(int arr[], int si, int ei) {
    if(si >= ei) {
      return;
    }
    int mid = si + (ei - si)/2;
    mergeSort(arr, si, mid);
    mergeSort(arr, mid+1, ei);
    merge(arr, si, mid, ei);
  }

  public static void merge(int arr[], int si, int mid, int ei) {
    int temp[] = new int[ei-si+1];
    int i = si;
    int j = mid+1;
    int k = 0;
    while(i <= mid && j <= ei) {
      if(arr[i] < arr[j]) {
        temp[k] = arr[i];
        i++;
      } else {
        temp[k] = arr[j];
        j++;
      }
      k++;
    }
    while(i <= mid) {
      temp[k++] = arr[i++];
    }
    while(j <= ei) {
      temp[k++] = arr[j++];
    }
    for(k=0, i=si; k<temp.length; k++, i++) {
      arr[i] = temp[k];
    }
  }

  public static void printArr(int arr[]) {
    for(int i=0; i<arr.length; i++) {
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }

  public static void quickSort(int arr[], int si, int ei) {
    if(si >= ei) {
      return;
    }
    int pidx = partition(arr, si, ei);
    quickSort(arr, si, pidx-1);
    quickSort(arr, pidx+1, ei);
  }

  public static int partition(int arr[], int si, int ei) {
    int pivot = arr[ei];
    int i = si-1;
    for(int j=si; j<ei; j++) {
      if(arr[j] <= pivot) {
        i++;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }
    i++;
    int temp = pivot;
    arr[ei] = arr[i];
    arr[i] = temp;
    return i;
  }

  public static int search(int arr[], int tar, int si, int ei) {
    if(si > ei) {
      return -1;
    }
    int mid = si + (ei-si)/2;
    if(arr[mid] == tar) {
      return mid;
    }
    if(arr[si] <= arr[mid]) {
      if(arr[si] <= tar && tar <= arr[mid]) {
        return search(arr, tar, si, mid-1);
      } else {
        return search(arr, tar, mid+1, ei);
      }
    } else {
      if(arr[mid] <= tar && tar <= arr[ei]) {
        return search(arr, tar, mid+1, ei);
      } else {
        return search(arr, tar, si, mid-1);
      }
    }
  }
  
  public static String[] mergeSort1(String[] arr, int lo, int hi) {
    if(lo == hi) {
      String[] A = {
        arr[lo] 
      };
      return A;
    }
    int mid = lo + (hi-lo)/2;
    String[] arr1 = mergeSort1(arr, lo, mid);
    String[] arr2 = mergeSort1(arr, mid+1, hi);
    String[] arr3 = merge1(arr1, arr2);
    return arr3;
  }

  static String[] merge1(String[] arr1, String[] arr2) {
    int m = arr1.length;
    int n = arr2.length;
    String[] arr3 = new String[m+n];
    int idx = 0;
    int i = 0;
    int j = 0;
    while(i < m && j < n) {
      if(isAlphabeticallySmaller(arr1[i], arr2[j])) { 
        arr3[idx] = arr1[i];
        i++;
        idx++;
      } else {
        arr3[idx] = arr2[j];
        j++;
        idx++;
      }
    }
    while(i < m) {
      arr3[idx] = arr1[i];
      i++;
      idx++;
    }
    while(j < n) {
      arr3[idx] = arr2[j];
      j++;
      idx++;
    }
    return arr3;
  }

  static boolean isAlphabeticallySmaller(String str1, String str2) {
    if(str1.compareTo(str2) < 0) {
      return true;
    }
    return false;
  }

  // // brute force
  // public static int majorityElement(int[] nums) {
  //   int majorityCount = nums.length/2;
  //   for(int i=0; i<nums.length; i++) {
  //     int count = 0;
  //     for(int j=0; j<nums.length; j++) {
  //       if(nums[j] == nums[i]) {
  //         count += 1;
  //       }
  //     }
  //     if(count > majorityCount) {
  //       return nums[i];
  //     }
  //   }
  //   return -1;
  // }

  private static int countInRange(int[] nums, int num, int lo, int hi) {
    int count = 0;
    for(int i=lo; i<=hi; i++) {
      if(nums[i] == num) {
        count++;
      }
    }
    return count;
  }

  private static int majorityElementRec(int[] nums, int lo, int hi) {
    if(lo == hi) {
      return nums[lo];
    }
    int mid = (hi-lo)/2 + lo;
    int left = majorityElementRec(nums, lo, mid);
    int right = majorityElementRec(nums, mid+1, hi);
    if(left == right) {
      return left;
    }
    int leftCount = countInRange(nums, left, lo, hi);
    int rightCount = countInRange(nums, right, lo, hi);
    return leftCount > rightCount ? left : right;
  }

  public static int majorityElement(int[] nums) {
    return majorityElementRec(nums, 0, nums.length-1);
  }

  // // brute force
  // public static int getInvCount(int arr[]) {
  //   int n = arr.length;
  //   int invCount = 0;
  //   for(int i=0; i<n-1; i++) {
  //     for(int j=i+1; j<n; j++) {
  //       if(arr[i] > arr[j]) {
  //         invCount++;
  //       }
  //     }
  //   }
  //   return invCount;
  // }

  public static int merge2(int arr[], int left, int mid, int right) {
    int i = left, j = mid, k = 0;
    int invCount = 0;
    int temp[] = new int[(right-left+1)];
    while((i < mid) && (j <= right)) {
      if(arr[i] <= arr[j]) {
        temp[k] = arr[i];
        k++;
        i++;
      } else {
        temp[k] = arr[j];
        invCount += (mid-i);
        k++;
        j++;
      }
    }
    while(i < mid) {
      temp[k] = arr[i];
      k++;
      i++;
    }
    while(j <= right) {
      temp[k] = arr[j];
      k++;
      j++;
    }
    for(i=left, k=0; i<=right; i++, k++) {
      arr[i] = temp[k];
    }
    return invCount;
  }

  private static int mergeSort2(int arr[], int left, int right) {
    int invCount = 0;
    if(right > left) {
      int mid = (right+left)/2;
      invCount = mergeSort2(arr, left, mid);
      invCount += mergeSort2(arr, mid+1, right);
      invCount += merge2(arr, left, mid+1, right);
    }
    return invCount;
  }

  public static int getInversions(int arr[]) {
    int n = arr.length;
    return mergeSort2(arr, 0, n-1);
  }
  public static void main(String[] args) {
    // // code1
    // int arr[] = {6, 3, 9, 5, 2, 8};
    // mergeSort(arr, 0, arr.length-1);
    // printArr(arr);

    // // code2
    // int arr[] = {6, 3, 9, 8, 2, 5};
    // quickSort(arr, 0, arr.length-1);
    // printArr(arr);

    // // code3
    // int arr[] = {4, 5, 6, 7, 0, 1, 2};
    // int target = 0;
    // int tarIdx = search(arr, target, 0, arr.length-1);
    // System.out.println(tarIdx);

    // // assign1
    // String[] arr = {"sun", "earth", "mars", "mercury"};
    // String[] a = mergeSort1(arr, 0, arr.length-1);
    // for(int i=0; i<a.length; i++) {
    //   System.out.println(a[i]);
    // }

    // // assign2
    // int nums[] = {2, 2, 1, 1, 1, 2, 2};
    // System.out.println(majorityElement(nums));

    // // assign3
    int arr[] = {1, 20, 6, 4, 5};
    System.out.println("Inversion Count = " + getInversions(arr));
  }
}