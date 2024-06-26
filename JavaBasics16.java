public class JavaBasics16 {
  public static void changeArr(int arr[], int i, int val) {
    if(i == arr.length) {
      printArr(arr);
      return;
    }
    arr[i] = val;
    changeArr(arr, i+1, val+1);
    arr[i] = arr[i] - 2;
  }

  public static void printArr(int arr[]) {
    for(int i=0; i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void findSubsets(String str, String ans, int i) {
    if(i == str.length()) {
      if(ans.length() == 0) {
        System.out.println("null");
      } else {
        System.out.println(ans);
      }
      return;
    }
    findSubsets(str, ans+str.charAt(i), i+1);
    findSubsets(str, ans, i+1);
  }

  public static void findPermutation(String str, String ans) {
    if(str.length() == 0) {
      System.out.println(ans);
      return;
    }
    for(int i=0; i<str.length(); i++) {
      char curr = str.charAt(i);
      str = str.substring(0, i) + str.substring(i+1);
      findPermutation(str, ans+curr);
    }
  }

  public static void main(String[] args) {
    // // code 1
    // int arr[] = new int[5];
    // changeArr(arr, 0, 1);
    // printArr(arr);

    // // code2
    // String str = "abc";
    // findSubsets(str, "", 0);
    
    // // code3
    // String str = "abc";
    // findPermutation(str, "");

  }
}