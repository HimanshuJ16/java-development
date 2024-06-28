import java.util.ArrayList;
import java.util.Collections;

public class JavaBasics24 {
  public static boolean isMonotonic(ArrayList<Integer> A) {
    boolean inc = true;
    boolean dec = true;
    for(int i=0; i<A.size()-1; i++) {
      if(A.get(i) > A.get(i+1)) {
        inc = false;
      }
      if(A.get(i) < A.get(i+1)) {
        dec = false;
      }
    }
    return inc || dec;
  }

  public static ArrayList<Integer> findLonely(ArrayList<Integer> nums) {
    Collections.sort(nums); 
    ArrayList<Integer> list = new ArrayList<>();
    for(int i=1; i<nums.size()-1; i++) {
      if(nums.get(i-1)+1 < nums.get(i) && nums.get(i)+1 < nums.get(i+1)) {
        list.add(nums.get(i));
      }
    }
    if(nums.size() == 1) {
      list.add(nums.get(0));
    }
    if(nums.size() > 1) {
      if(nums.get(0)+1 < nums.get(1)) {
        list.add(nums.get(0));
      }
      if(nums.get(nums.size()-2)+1 < nums.get(nums.size()-1)) {
        list.add(nums.get(nums.size()-1));
      }
    }
    return list;
  }

  public static int mostFrequent(ArrayList<Integer> nums, int key) {
    int []result = new int[1000];
    for(int i=0; i<nums.size()-1; i++) {
      if(nums.get(i) == key) {
        result[nums.get(i+1)-1]++;
      }
    }
    int max = Integer.MIN_VALUE;
    int ans = 0;
    for(int i=0; i<1000; i++) { 
      if(result[i] > max) {
        max = result[i];
        ans = i+1;
      }
    }
    return ans;
  }

  //iterative approach
  public static ArrayList<Integer> beautifulArray(int n) {
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(1);
    for(int i=2; i<=n; i++) { 
      ArrayList<Integer> temp = new ArrayList<>();
      for(Integer e:ans) {
        if(2*e <= n) {
          temp.add(e*2);
        }
      }
      for(Integer e:ans) {
        if(2*e-1 <= n) {
          temp.add(e*2-1);
        }
      }
      ans = temp;
    }
    return ans;
  }

  //divide & conquer approach
  public static ArrayList<Integer> beautifulArray1(int n) {
    ArrayList<Integer> res = new ArrayList<>();
    divideConque(1, 1, res, n);
    return res;
  }

  private static void divideConque(int start, int increment, ArrayList<Integer> res, int n) {
    if(start + increment > n) {
      res.add(start);
      return;
    }
    divideConque(start, 2*increment, res, n);
    divideConque(start+increment, 2*increment, res, n);
  }
  public static void main(String[] args) {
    ArrayList<Integer> nums = new ArrayList<>();
    nums.add(2);
    nums.add(2);
    nums.add(10);
    nums.add(2);
    nums.add(3);

    System.out.println(isMonotonic(nums));

    System.out.println(findLonely(nums));

    System.out.println(mostFrequent(nums, 2));

    System.out.println(beautifulArray(4));
    System.out.println(beautifulArray1(5));
  }
}