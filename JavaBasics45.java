import java.util.*;

public class JavaBasics45 {
  static class Student implements Comparable<Student> {
    String name;
    int rank;

    public Student(String name, int rank) {
      this.name = name;
      this.rank = rank;
    }

    @Override
    public int compareTo(Student s2) {
      return this.rank - s2.rank;
    }
  }

  static class Heap {
    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data) { // O(logn)
      arr.add(data);

      int x = arr.size()-1; // x is child index
      int par = (x-1)/2; // parent index

      while (arr.get(x) < arr.get(par)) {
        int temp = arr.get(x);
        arr.set(x, arr.get(par));
        arr.set(par, temp);

        x = par;
        par = (x-1)/2;
      }
    }

    public int peek() {
      return arr.get(0);
    }
    
    private void heapify(int i) {
      int left = 2*i+1;
      int right = 2*i+2;
      int minIdx = i;

      if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
        minIdx = left;
      }

      if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
        minIdx = right;
      }

      if (minIdx != i) {
        int temp = arr.get(i);
        arr.set(i, arr.get(minIdx));
        arr.set(minIdx, temp);

        heapify(minIdx);
      }
    }

    public int remove() {
      int data = arr.get(0);

      //step1 - swap fisrt & last
      int temp = arr.get(0);
      arr.set(0, arr.get(arr.size()-1));
      arr.set(arr.size()-1, temp);

      //step2 - delete last
      arr.remove(arr.size()-1);

      //step3 - heapify
      heapify(0);
      return data;
    }

    public boolean isEmpty() {
      return arr.size() == 0;
    }
  }

  public static void heapify(int arr[], int i, int size) {
    int left = 2*i+1;
    int right = 2*i+2;
    int maxIdx = i;

    if (left < size && arr[left] > arr[maxIdx]) {
      maxIdx = left;
    }

    if (right < size && arr[right] > arr[maxIdx]) {
      maxIdx = right;
    }

    if (maxIdx != i) {
      int temp = arr[i];
      arr[i] = arr[maxIdx];
      arr[maxIdx] = temp;

      heapify(arr, maxIdx, size);
    }
  }

  public static void heapSort(int arr[]) {
    //step1 - build maxHeap
    int n = arr.length;
    for(int i=n/2; i>=0; i--) {
      heapify(arr, i, n);
    }

    //step2 - push largest at end
    for(int i=n-1; i>0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      heapify(arr, 0, i);
    }
  }
  public static void main(String[] args) {
    // // CODE1
    // PriorityQueue<Student> pq = new PriorityQueue<>();
    
    // pq.add(new Student("A", 4));
    // pq.add(new Student("B", 5));
    // pq.add(new Student("C", 2));
    // pq.add(new Student("D", 12));
    
    // while (!pq.isEmpty()) {
    //   System.out.println(pq.peek().name + " => " + pq.peek().rank);
    //   pq.remove();
    // }

    // // CODE2
    // Heap h = new Heap();
    // h.add(3);
    // h.add(4);
    // h.add(1);
    // h.add(5);

    // while (!h.isEmpty()) {
    //   System.out.println(h.peek());
    //   h.remove();
    // }

    // // CODE3
    int arr[] = {1, 2, 4, 5, 3};
    heapSort(arr);

    for(int i=0; i<arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
