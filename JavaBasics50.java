import java.util.*;

public class JavaBasics50 {
  static class Node {
    int data;
    int hd;
    Node left, right;
    
    public Node(int key) {
      this.data = key;
      this.hd = Integer.MAX_VALUE;
      this.left = this.right = null;
    }
  }
  
  public static void bottomViewHelper(Node root, int curr, int hd, TreeMap<Integer, int[]> m) {
    if (root == null) {
      return;
    }
    
    if (!m.containsKey(hd)) {
      m.put(hd, new int[]{root.data, curr });
    } else {
      int[] p = m.get(hd);
      if (p[1] <= curr) {
        p[1] = curr;
        p[0] = root.data;
      }
      m.put(hd, p);
    }
    
    bottomViewHelper(root.left, curr + 1, hd - 1, m);
    bottomViewHelper(root.right, curr + 1, hd + 1, m);
  }
  
  public static void printBottomView(Node root) {
    TreeMap<Integer, int[]> m = new TreeMap<>();
    bottomViewHelper(root, 0, 0, m);
    
    for(int val[] : m.values()) {
      System.out.print(val[0] + " ");
    }
  }

  public static int[] twoSum(int[] arr, int target) {
    Map<Integer, Integer> visited = new HashMap<>();
    for (int i=0; i<arr.length; i++) {
      int diff = target - arr[i];
      
      if (visited.containsKey(diff)) {
        return new int[] { i, visited.get(diff) };
      }
      
      visited.put(arr[i], i);
    }
    
    return new int[] {0, 0};
  }

  public static String frequencySort(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i=0; i<s.length(); ++i) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
    }
    
    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue());
    for (Map.Entry<Character, Integer> e : map.entrySet()) {
      pq.add(e);
    }

    StringBuilder res = new StringBuilder();
    while (pq.size() != 0) {
      char ch = pq.poll().getKey();
      int val = map.get(ch);
      while (val != 0) {
        res.append(ch);
        val--;
      }
    }
    
    return res.toString();
  }
  public static void main(String[] args) {
    // // CODE1
    Node root = new Node(20);
    root.left = new Node(8);
    root.right = new Node(22);
    root.left.left = new Node(5);
    root.left.right = new Node(3);
    root.right.left = new Node(4);
    root.right.right = new Node(25);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(14);
    System.out.println("Bottom view of the given binary tree:");
    printBottomView(root);
    System.out.println();

    // // CODE2
    int arr[] = {2, 7, 11, 15};
    int target = 9;
    int ans[] = twoSum(arr, target);
    for (int i : ans) {
      System.out.println(i);
    }
    
    // // CODE3
    String s = "tree";
    String ans1 = frequencySort(s);
    System.out.println(ans1);
  }
}
