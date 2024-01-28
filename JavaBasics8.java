import java.util.*;

public class JavaBasics8 {
  public static void maxSubarraySum(int numbers[]) {
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE; 
    int prefix[] = new int[numbers.length];
    prefix[0] = numbers[0];
    for(int i=1; i<prefix.length; i++) {
      prefix[i] = prefix[i-1] + numbers[i];
    }  
    for(int i=0; i<numbers.length; i++) {
      int start = i;
      for(int j=i; j<numbers.length; j++) {
        int end = j;
        currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];
        // for(int k=start; k<=end; k++) {
        //   currSum += numbers[k];
        // }
        // System.out.println(currSum);
        if(maxSum < currSum) {
          maxSum = currSum;
        }
      }
    }
    System.out.println("max sum = " + maxSum);
  }

  public static void kadanes(int numbers[]) {
    int ms = Integer.MIN_VALUE;
    int cs = 0;
    for(int i=0; i<numbers.length; i++) {
      cs = cs + numbers[i];
      if(cs < 0) {
        cs = 0;
      }
      ms = Math.max(cs, ms);
    }
    System.out.println("max subarray sum is : " + ms);
  }

  public static int trappedRainwater(int height[]) {
    int n = height.length;
    int trappedWater = 0;
    int leftMax[] = new int[n];
    leftMax[0] = height[0];
    for(int i=1; i<n; i++) {
      leftMax[i] = Math.max(height[i], leftMax[i-1]);
    }
    int rightMax[] = new int[n];
    rightMax[n-1] = height[n-1];
    for(int i=n-2; i>=0; i--) {
      rightMax[i] = Math.max(height[i], rightMax[i+1]);
    }
    for(int i=0; i<n; i++) {
      int waterLevel = Math.min(leftMax[i], rightMax[i]);
      trappedWater += waterLevel - height[i];
    }
    return trappedWater;
  }

  public static int buyAndSellStocks(int prices[]) {
    int buyPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for(int i=0; i<prices.length; i++) {
      if(buyPrice < prices[i]) {
        int profit = prices[i] - buyPrice;
        maxProfit = Math.max(maxProfit, profit);
      } else {
        buyPrice = prices[i];
      }
    }
    return maxProfit;
  }
  
  public static boolean containsDuplicate(int[] nums) {
    for(int i=0; i<nums.length; i++) {
      for(int j=i+1; j<nums.length; j++) {
        if(nums[i] == nums[j]) {
          return true;
        }
      }
    }
    return false;
  } 
  
  public int search(int[] nums, int target) {
    int min = minSearch(nums);
    if(nums[min] <= target && target <= nums[nums.length-1]) {
      return search(nums, min, nums.length, target);
    } else {
      return search(nums, 0, min, target);
    }
  }

  public int search(int[] nums, int left, int right, int target) {
    int l = left;
    int r = right;
    while (l <= r) {
      int mid = l + (r - 1)/2;
      if(nums[mid] == target) {
        return mid;
      } else if(nums[mid] > target) {
        r = mid-1;
      } else {
        l = mid+1;
      }
    }
    return -1;
  }

  public int minSearch(int[] nums) {
    int left = 0;
    int right = nums.length-1;
    while (left < right) {
      int mid = left + (right - left)/2;
      if(mid > 0 && nums[mid-1] > nums[mid]) {
        return mid;
      } else if(nums[left] <= nums[mid] && nums[mid] > nums[right]) {
        left = mid+1;
      } else {
        right = mid-1;
      }
    }
    return left;
  }

  public static int maxProfit(int[] prices) {
    int buy = prices[0]; 
    int profit = 0; 
    for (int i=1; i<prices.length; i++) { 
      if (buy < prices[i]) { 
        profit = Math.max(prices[i] - buy, profit); 
      } else { 
        buy = prices[i]; 
      } 
    } 
    return profit; 
  }

  public static int trap(int[] height) {
    int n = height.length; 
    int res = 0, 
    l = 0, 
    r = n - 1; 
    int rMax = height[r], lMax = height[l]; 
    while (l < r) { 
      if (lMax < rMax) { 
        l++; 
        lMax = Math.max(lMax, height[l]); 
        res += lMax - height[l]; 
      } else { 
        r--; 
        rMax = Math.max(rMax, height[r]); 
        res += rMax - height[r]; 
      } 
    } return res; 
  }

  public static List<List<Integer>> threeSum(int nums[]) {
    List<List<Integer>> result =  new ArrayList <List<Integer>> (); 
    for(int i=0; i<nums.length; i++) { 
      for(int j=i+1; j<nums.length; j++) { 
        for(int k=j+1; k<nums.length; k++) { 
          if(nums[i] + nums[j] + nums[k] == 0) {
            List<Integer> triplet = new ArrayList < Integer > ();
            triplet.add(nums[i]); 
            triplet.add(nums[j]); 
            triplet.add(nums[k]); 
            Collections.sort(triplet); 
            result.add(triplet);
          } 
        } 
      } 
    }
    result = new ArrayList<List<Integer>> (new LinkedHashSet<List<Integer>> (result));
    return result;
  }

  public static void main(String[] args) {
    // // code1
    // int numbers[] = {-2, -3, 4, -1, -2, 1, 5, -3};
    // kadanes(numbers);

    // // code2
    // int height[] = {4, 2, 0, 6, 3, 2, 5};
    // System.out.println(trappedRainwater(height));

    // // code3
    // int prices[] = {7, 1, 5, 3, 6, 4};
    // System.out.println(buyAndSellStocks(prices));
  
    // // assign1
    // int nums[] = {1, 2, 4, 5};
    // System.out.println(containsDuplicate(nums));

    // // assign2
    // int nums[] = {0,1,2,4,5,6,7};
    // // Some error is here while printing...
    // System.out.println(search(nums, 0));
    
    // // assign3
    // int prices[] = {7, 6, 4, 3, 1, 8};
    // System.out.println(maxProfit(prices));

    // // assign4
    // int height[] = {0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};
    // System.out.println(trap(height));

    // // assign5
    // int nums[] ={-1, 0, 1, 2, -1, -4};
    // System.out.println(threeSum(nums));
  }
}
