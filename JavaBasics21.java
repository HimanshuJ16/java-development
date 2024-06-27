import java.util.ArrayList;
import java.util.Collections;

public class JavaBasics21 {
  public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
    int temp = list.get(idx1);
    list.set(idx1, list.get(idx2));
    list.set(idx2, temp);
  }

  public static void main(String[] args) {
    // ArrayList<Integer> list = new ArrayList<>();
    // ArrayList<String> list2 = new ArrayList<>();
    // ArrayList<Boolean> list3 = new ArrayList<>();

    // //Add operation - O(1)
    // list.add(1);
    // list.add(2);
    // list.add(3);
    // list.add(4);
    // list.add(5);
    // list.add(1, 9); // O(n)
    // System.out.println(list);

    // //Get operation - O(1)
    // int element = list.get(2);
    // System.out.println(element);

    // //Delete operation - O(n)
    // list.remove(2);
    // System.out.println(list);

    // //Set operation - O(n)
    // list.set(2, 10);
    // System.out.println(list);

    // //contains
    // System.out.println(list.contains(1));
    // System.out.println(list.contains(11));

    // System.out.println(list.size());

    // for(int i=0; i<list.size(); i++) {
    //   System.out.print(list.get(i));
    // }
    // System.out.println();

    // int max = Integer.MIN_VALUE;
    // for(int i=0; i<list.size(); i++) {
    //   // if(max < list.get(i)) {
    //   //   max = list.get(i);
    //   // }
    //   max = Math.max(max, list.get(i));
    // }
    // System.out.println("max element = " + max);

    // int idx1 = 1, idx2 = 3;
    // System.out.println(list);
    // swap(list, idx1, idx2);
    // System.out.println(list);

    // Collections.sort(list);
    // System.out.println(list);

    // Collections.sort(list, Collections.reverseOrder());
    // System.out.println(list);

    // // code2
    // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
    // ArrayList<Integer> list = new ArrayList<>();
    // list.add(1); list.add(2);
    // mainList.add(list);

    // ArrayList<Integer> list2 = new ArrayList<>();
    // list2.add(3); list2.add(4);
    // mainList.add(list2);

    // for(int i=0; i<mainList.size(); i++) {
    //   ArrayList<Integer> currList = mainList.get(i);
    //   for(int j=0; j<currList.size(); j++) {
    //     System.out.print(currList.get(j) + " ");
    //   }
    //   System.out.println();
    // }
    // System.out.println(mainList);

    // // code3
    // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
    // ArrayList<Integer> list1 = new ArrayList<>();
    // ArrayList<Integer> list2 = new ArrayList<>();
    // ArrayList<Integer> list3 = new ArrayList<>();

    // for(int i=1; i<=5; i++) {
    //   list1.add(i);
    //   list2.add(i*2);
    //   list3.add(i*3);
    // }

    // mainList.add(list1);
    // mainList.add(list2);
    // mainList.add(list3);

    // System.out.println(mainList);

    // //nested loops
    // for(int i=0; i<mainList.size(); i++) {
    //   ArrayList<Integer> currList = mainList.get(i);
    //   for(int j=0; j<currList.size(); j++) {
    //     System.out.print(currList.get(j) + " ");
    //   }
    //   System.out.println();
    // }
  }
}
