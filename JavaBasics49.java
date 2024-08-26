import java.util.*;

public class JavaBasics49 {
  public static String getStart(HashMap<String, String> tickets) {
    HashMap<String, String> revMap = new HashMap<>();

    for (String key : tickets.keySet()) {
      revMap.put(tickets.get(key), key);
    }

    for (String key : tickets.keySet()) {
      if (!revMap.containsKey(key)) {
        return key;
      }
    }

    return null;
  }
  public static void main(String[] args) {
    // // CODE1
    // HashSet<Integer> set = new HashSet<>();
    // set.add(1);
    // set.add(2);
    // set.add(4);
    // set.add(2);
    // set.add(1);
    // System.out.println(set);
    // set.remove(2);
    // System.out.println(set.contains(2));
    // System.out.println(set.size());
    // set.clear();
    // System.out.println(set.isEmpty());

    // // CODE2
    // HashSet<String> cities = new HashSet<>();
    // cities.add("Delhi");
    // cities.add("Mumbai");
    // cities.add("Noida");
    // cities.add("Bangalore");
    // System.out.println(cities);

    // Iterator it = cities.iterator();
    // while (it.hasNext()) {
    //   System.out.println(it.next());
    // }

    // for(String city : cities) {
    //   System.out.println(city);
    // }

    // LinkedHashSet<String> lhs = new LinkedHashSet<>();
    // lhs.add("Delhi");
    // lhs.add("Mumbai");
    // lhs.add("Noida");
    // lhs.add("Bangalore");
    // System.out.println(lhs);

    // TreeSet<String> ts = new TreeSet<>();
    // ts.add("Delhi");
    // ts.add("Mumbai");
    // ts.add("Noida");
    // ts.add("Bangalore");
    // System.out.println(ts);

    // // CODE3
    // int num[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
    // HashSet<Integer> set = new HashSet<>();

    // for(int i=0; i<num.length; i++) {
    //   set.add(num[i]);
    // }

    // System.out.println("ans = " + set.size());

    // // CODE4
    // int arr1[] = {7, 3, 9};
    // int arr2[] = {6, 3, 9, 2, 9, 4};
    // HashSet<Integer> set = new HashSet<>();

    // for(int i=0; i<arr1.length; i++) {
    //   set.add(arr1[i]);
    // }

    // for(int i=0; i<arr2.length; i++) {
    //   set.add(arr2[i]);
    // }    

    // System.out.println("union = " + set.size());

    // set.clear();
    // for(int i=0; i<arr1.length; i++) {
    //   set.add(arr1[i]);
    // }

    // int count = 0;
    // for(int i=0; i<arr2.length; i++) {
    //   if (set.contains(arr2[i])) {
    //     count++;
    //     set.remove(arr2[i]);
    //   }
    // }

    // System.out.println("intersection = " + count);

    // // CODE5
    // HashMap<String, String> tickets = new HashMap<>();
    // tickets.put("Chennai", "Bengaluru");
    // tickets.put("Mumbai", "Delhi");
    // tickets.put("Goa", "Chennai");
    // tickets.put("Delhi", "Goa");

    // String start = getStart(tickets);
    // System.out.print(start);
    // for (String key : tickets.keySet()) {
    //   System.out.print(" -> " + tickets.get(start));
    //   start = tickets.get(start);
    // }
    // System.out.println();

    // // CODE6
    // int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

    // HashMap<Integer, Integer> map = new HashMap<>();

    // int sum = 0;
    // int len = 0;

    // for(int j=0; j<arr.length; j++) {
    //   sum += arr[j];
    //   if (map.containsKey(sum)) {
    //     len = Math.max(len, j-map.get(sum));
    //   } else {
    //     map.put(sum, j);
    //   }
    // }

    // System.out.println("Largest subarray with sum as 0 => " + len);
  
    // // CODE7
    // int arr[] = {10, 2, -2, -20, 10};
    // int k = -10;

    // HashMap<Integer, Integer> map = new HashMap<>();
    
    // map.put(0, 1);

    // int sum = 0;
    // int ans = 0;

    // for(int j=0; j<arr.length; j++) {
    //   sum += arr[j];
    //   if (map.containsKey(sum-k)) {
    //     ans += map.get(sum-k);
    //   }
    //   map.put(sum, map.getOrDefault(sum, 0) + 1);
    // }

    // System.out.println(ans);
  }
}
