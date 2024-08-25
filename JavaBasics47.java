import java.util.*;

public class JavaBasics47 {
  static class HashMap<K, V> {
    private class Node {
      K key;
      V value;

      public Node(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int n;
    private int N;
    private LinkedList<Node> buckets[];

    @SuppressWarnings("unchecked")
    public HashMap() {
      this.N = 4;
      this.buckets = new LinkedList[4];
      for(int i=0; i<4; i++) {
        this.buckets[i] = new LinkedList<>();
      }
    }

    private int hashFunction(K key) {
      int hc = key.hashCode();
      return Math.abs(hc) % N;
    }

    private int SearchInLL(K key, int bi) {
      LinkedList<Node> ll = buckets[bi];
      int di = 0;

      for(int i=0; i<ll.size(); i++) {
        Node node = ll.get(i);
        if (node.key == key) {
          return di;
        }
        di++;
      }

      return -1;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
      LinkedList<Node> oldBuck[] = buckets;
      buckets = new LinkedList[N*2];
      N = 2*N;
      for(int i=0; i<buckets.length; i++) {
        buckets[i] = new LinkedList<>();
      }

      for(int i=0; i<oldBuck.length; i++) {
        LinkedList<Node> ll = oldBuck[i];
        for(int j=0; j<ll.size(); j++) {
          Node node = ll.get(j);
          put(node.key, node.value);
        }
      }
    }

    public void put(K key, V value) {
      int bi = hashFunction(key);
      int di = SearchInLL(key, bi);

      if (di != -1) {
        Node node = buckets[bi].get(di);
        node.value = value;
      } else {
        buckets[bi].add(new Node(key, value));
        n++;
      }

      double lambda = (double)n/N;
      if (lambda > 2.0) {
        rehash();
      }
    }

    public boolean containsKey(K key) {
      int bi = hashFunction(key);
      int di = SearchInLL(key, bi);

      if (di != -1) {
        return true;
      } else {
        return false;
      }
    }

    public V remove(K key) {
      int bi = hashFunction(key);
      int di = SearchInLL(key, bi);

      if (di != -1) {
        Node node = buckets[bi].remove(di);
        n--;
        return node.value;
      } else {
        return null;
      }
    }

    public V get(K key) {
      int bi = hashFunction(key);
      int di = SearchInLL(key, bi);

      if (di != -1) {
        Node node = buckets[bi].get(di);
        return node.value;
      } else {
        return null;
      }
    }

    public ArrayList<K> keySet() {
      ArrayList<K> keys = new ArrayList<>();

      for(int i=0; i<buckets.length; i++) {
        LinkedList<Node> ll = buckets[i];
        for (Node node : ll) {
          keys.add(node.key);
        }
      }

      return keys;
    }

    public boolean isEmpty() {
      return n == 0;
    }
  }
  public static void main(String[] args) {
    // // CODE1
    // //Create
    // HashMap<String, Integer> hm = new HashMap<>();

    // //Insert - O(1)
    // hm.put("India", 100);
    // hm.put("China", 150);
    // hm.put("US", 50);
    // System.out.println(hm);

    // //Get - O(1)
    // int population = hm.get("India");
    // System.out.println(population);

    // //ContainsKey - O(1)
    // System.out.println(hm.containsKey("India"));

    // //Remove - O(1)
    // System.out.println(hm.remove("China"));
    // System.out.println(hm);

    // //Size
    // System.out.println(hm.size());

    // //Is Empty
    // hm.clear();
    // System.out.println(hm.isEmpty());

    // // CODE2
    // HashMap<String, Integer> hm = new HashMap<>();
    // hm.put("India", 100);
    // hm.put("China", 150);
    // hm.put("US", 50);
    // hm.put("Indonesia", 6);
    // hm.put("Nepal", 5);

    // Set<String> keys = hm.keySet();
    // System.out.println(keys);

    // for (String k : keys) {
    //   System.out.println("key = " + k + ", " + "value = " + hm.get(k));
    // }

    // // CODE3 - implemented using HashMap<K, V>
    // HashMap<String, Integer> hm = new HashMap<>();
    // hm.put("India", 100);
    // hm.put("China", 150);
    // hm.put("US", 50);
    // hm.put("Indonesia", 6);
    // hm.put("Nepal", 5);

    // ArrayList<String> keys = hm.keySet();
    // for (String key : keys) {
    //   System.out.println(key);
    // }

    // System.out.println(hm.get("India"));

    // // CODE4
    // LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
    // lhm.put("India", 100);
    // lhm.put("China", 150);
    // lhm.put("US", 50);
    // System.out.println(lhm);

    // TreeMap<String, Integer> tm = new TreeMap<>();
    // tm.put("India", 100);
    // tm.put("China", 150);
    // tm.put("US", 50);
    // System.out.println(tm);
  }
}
