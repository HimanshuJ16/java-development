import java.util.*;

public class JavaBasics48 {
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    HashMap<Character, Integer> map = new HashMap<>();

    for(int i=0; i<s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    for(int i=0; i<t.length(); i++) {
      char ch = t.charAt(i);
      if (map.get(ch) != null) {
        if (map.get(ch) == 1) {
          map.remove(ch);
        } else {
          map.put(ch, map.get(ch)-1);
        }
      } else {
        return false;
      }
    }

    return map.isEmpty();
  }
  public static void main(String[] args) {
    // // CODE1
    // int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
    // HashMap<Integer, Integer> map = new HashMap<>();

    // for(int i=0; i<arr.length; i++) {
    //   map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    // }

    // for (Integer key : map.keySet()) {
    //   if (map.get(key) > arr.length/3) {
    //     System.out.println(key);
    //   }
    // }

    // // CODE2
    // String s = "race";
    // String t = "care";
    // System.out.println(isAnagram(s, t));
  }
}    
