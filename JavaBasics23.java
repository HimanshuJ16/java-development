import java.util.ArrayList;

public class JavaBasics23 {
  // //Brute force
  // public static boolean pairSum(ArrayList<Integer> list, int target) {
  //   for(int i=0; i<list.size(); i++) {
  //     for(int j=0; j<list.size(); j++) {
  //       if(list.get(i) + list.get(j) == target) {
  //         return true;
  //       }
  //     }
  //   }

  //   return false;
  // }

  public static boolean pairSum(ArrayList<Integer> list, int target) {
    int lp = 0;
    int rp = list.size()-1;

    while (lp != rp) {
      // case1
      if(list.get(lp)+list.get(rp) == target) {
        return true;
      }

      // case2
      if(list.get(lp)+list.get(rp) < target) {
        lp++;
      } else {
        //case3
        rp--;
      }
    }

    return false;
  }

  private static boolean pairSum2(ArrayList<Integer> list, int target) {
    int bp = -1;
    int n = list.size();
    for(int i=0; i<n; i++) {
      if(list.get(i) > list.get(i+1)) {
        bp = i;
        break;
      }
    }

    int lp = bp+1;
    int rp = bp;

    while (lp != rp) {
      // case1
      if(list.get(lp)+list.get(rp) == target) {
        return true;
      }

      // case2
      if(list.get(lp)+list.get(rp) < target) {
        lp = (lp+1) % n;
      } else {
        //case3
        rp = (rp+n-1) % n;
      }
    }

    return false;
  }
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    // 1, 2, 3, 4, 5, 6 - Sorted
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    int target = 5;
    System.out.println(pairSum(list, target));

    ArrayList<Integer> list2 = new ArrayList<>();
    // 11, 15, 6, 8, 9, 10 - Sorted & Rotated
    list2.add(11);
    list2.add(15);
    list2.add(6);
    list2.add(8);
    list2.add(9);
    list2.add(10);
    int target2 = 16;
    System.out.println(pairSum2(list2, target2));
  }
}
