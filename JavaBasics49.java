import java.util.*;

public class JavaBasics49 {
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
    HashSet<String> cities = new HashSet<>();
    cities.add("Delhi");
    cities.add("Mumbai");
    cities.add("Noida");
    cities.add("Bangalore");
    System.out.println(cities);

    // Iterator it = cities.iterator();
    // while (it.hasNext()) {
    //   System.out.println(it.next());
    // }

    // for(String city : cities) {
    //   System.out.println(city);
    // }

    LinkedHashSet<String> lhs = new LinkedHashSet<>();
    lhs.add("Delhi");
    lhs.add("Mumbai");
    lhs.add("Noida");
    lhs.add("Bangalore");
    System.out.println(lhs);

    TreeSet<String> ts = new TreeSet<>();
    ts.add("Delhi");
    ts.add("Mumbai");
    ts.add("Noida");
    ts.add("Bangalore");
    System.out.println(ts);

    // // CODE3
    int num[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
    HashSet<Integer> set = new HashSet<>();

    for(int i=0; i<num.length; i++) {
      set.add(num[i]);
    }

    System.out.println("ans = " + set.size());
  }
}
