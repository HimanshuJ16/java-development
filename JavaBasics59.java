public class JavaBasics59 {
  static int tree[];

  public static void init(int n) {
    tree = new int[4 * n];
  }

  public static int buildST(int arr[], int i, int start, int end) {
    if (start == end) {
      tree[i] = arr[start];
      return arr[start];
    }

    int mid = (start + end) / 2;
    tree[i] = buildST(arr, 2 * i + 1, start, mid) + buildST(arr, 2 * i + 2, mid + 1, end);
    return tree[i];
  }

  public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
    if(qj <= si || qi >= sj) {
      return 0;
    } else if(si >= qi && sj <= qj) {
      return tree[i];
    } else {
      int mid = (si + sj) / 2;
      return getSumUtil(2 * i + 1, si, mid, qi, qj) + getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);
    } 
  }

  public static int getSum(int arr[], int qi, int qj) {
    int n = arr.length;
    return getSumUtil(0, 0, n - 1, qi, qj);
  }

  public static void updateUtil(int i, int si, int sj, int idx, int diff) {
    if (idx > sj || idx < si) {
      return;
    }

    tree[i] += diff;
    if (si != sj) {
      int mid = (si + sj) / 2;
      updateUtil(2 * i + 1, si, mid, idx, diff);
      updateUtil(2 * i + 2, mid + 1, sj, idx, diff);
    }
  }

  public static void update(int arr[], int idx, int newVal) {
    int n = arr.length;
    int diff = newVal - arr[idx];
    arr[idx] = newVal;
    updateUtil(0, 0, n - 1, idx, diff);
  }

  public static void buildTree(int i, int si, int sj, int arr[]) {
    if (si == sj) {
      tree[i] = arr[si];
    } else {
      int mid = (si + sj) / 2;
      buildTree(2 * i + 1, si, mid, arr);
      buildTree(2 * i + 2, mid + 1, sj, arr);
      tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }
  }

  public static void buildTree1(int i, int si, int sj, int arr[]) {
    if (si == sj) {
      tree[i] = arr[si];
      return;
    }

    int mid = (si + sj) / 2;
    buildTree1(2 * i + 1, si, mid, arr);
    buildTree1(2 * i + 2, mid + 1, sj, arr);
    tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
  }

  public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
    if(si > qj || sj < qi) {
      return Integer.MIN_VALUE;
    } else if(si >= qi && sj <= qj) {
      return tree[i];
    } else {
      int mid = (si + sj) / 2;
      return Math.max(getMaxUtil(2 * i + 1, si, mid, qi, qj), getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj));
    }
  }

  public static int getMax(int arr[], int qi, int qj) {
    int n = arr.length;
    return getMaxUtil(0, 0, n - 1, qi, qj);
  }

  public static void updateUtil1(int i, int si, int sj, int idx, int newVal) {
    if (idx < si || idx > sj) {
      return;
    }

    tree[i] = Math.max(tree[i], newVal);
    if (si != sj) {
      int mid = (si + sj) / 2;
      updateUtil1(2 * i + 1, si, mid, idx, newVal);
      updateUtil1(2 * i + 2, mid + 1, sj, idx, newVal);
    }
  }

  public static void update1(int arr[], int idx, int newVal) {
    arr[idx] = newVal;
    int n = arr.length;
    updateUtil1(0, 0, n - 1, idx, newVal);
  }

  public static void main(String[] args) {
    // // CODE1
    // int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
    // int n = arr.length;
    // init(n);
    // buildST(arr, 0, 0, n - 1);
    // for(int i=0; i<tree.length; i++) {
    //   System.out.print(tree[i] + " ");
    // }
    // System.out.println();
    // System.out.println(getSum(arr, 2, 5));
    // update(arr, 2, 2);
    // System.out.println(getSum(arr, 2, 5));

    // // CODE2
    int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};
    int n = arr.length;
    init(n);
    buildTree1(0, 0, n - 1, arr);
    for(int i=0; i<tree.length; i++) {
      System.out.print(tree[i] + " ");
    }
    System.out.println();
    System.out.println(getMax(arr, 2, 5));
    update1(arr, 2, 20);
    System.out.println(getMax(arr, 2, 5));
  }
}
