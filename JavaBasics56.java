import java.util.*;

public class JavaBasics56 {
  static class Edge implements Comparable<Edge> {
    int dest;
    int cost;

    public Edge(int d, int c) {
      this.dest = d;
      this.cost = c;
    }

    @Override
    public int compareTo(Edge e2) {
      return this.cost - e2.cost;
    }
  }

  public static int connectCities(int cities[][]) {
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    boolean vis[] = new boolean[cities.length];

    pq.add(new Edge(0, 0));
    int finalCost = 0;

    while (!pq.isEmpty()) {
      Edge curr = pq.remove();
      if (!vis[curr.dest]) {
        vis[curr.dest] = true;
        finalCost += curr.cost;

        for(int i=0; i<cities[curr.dest].length; i++) {
          if (cities[curr.dest][i] != 0) {
            pq.add(new Edge(i, cities[curr.dest][i]));
          }
        }
      }
    }

    return finalCost;
  }

  // static int n = 7; //for CODE2
  static int n = 4; //for CODE3
  static int par[] = new int[n];
  static int rank[] = new int[n];

  public static void init() {
    for(int i=0; i<n; i++) {
      par[i] = i;
    }
  }

  public static int find(int x) {
    if (x == par[x]) {
      return x;
    }

    return par[x] = find(par[x]);
  }

  public static void union(int a, int b) {
    int parA = find(a);
    int parB = find(b);

    if (rank[parA] == rank[parB]) {
      par[parB] = parA;
      rank[parA]++;
    } else if (rank[parA] < rank[parB]) {
      par[parA] = parB;
    } else {
      par[parB] = parA;
    }
  }

  static class Edge1 implements Comparable<Edge1> {
    int src;
    int dest;
    int wt;

    public Edge1(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.wt = w;
    }

    @Override
    public int compareTo(Edge1 e2) {
      return this.wt - e2.wt;
    }
  }

  static void createGraph(ArrayList<Edge1> edges) {
    edges.add(new Edge1(0, 1, 10));
    edges.add(new Edge1(0, 2, 15));
    edges.add(new Edge1(0, 3, 30));
    edges.add(new Edge1(1, 3, 40));
    edges.add(new Edge1(2, 3, 50));
  }

  public static void kruskalsMST(ArrayList<Edge1> edges, int V) {
    init();
    Collections.sort(edges);
    int mstCost = 0;
    int count = 0;

    for(int i=0; count<V-1; i++) {
      Edge1 e = edges.get(i);
      int parA = find(e.src);
      int parB = find(e.dest);

      if (parA != parB) {
        union(e.src, e.dest);
        mstCost += e.wt;
        count++;
      }
    }

    System.out.println(mstCost);
  }

  public void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int orgCol) {
    if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
      return;
    }

    image[sr][sc] = color;

    //left
    helper(image, sr, sc-1, color, vis, orgCol);
    //right
    helper(image, sr, sc+1, color, vis, orgCol);
    //up
    helper(image, sr-1, sc, color, vis, orgCol);
    //down
    helper(image, sr+1, sc, color, vis, orgCol);
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    boolean vis[][] = new boolean[image.length][image[0].length];
    helper(image, sr, sc, color, vis, image[sr][sc]);
    return image;
  }
  public static void main(String[] args) {
    // // CODE1
    // int cities[][] = {
    //   {0, 1, 2, 3, 4}, 
    //   {1, 0, 5, 0, 7}, 
    //   {2, 5, 0, 6, 0}, 
    //   {3, 0, 6, 0, 0}, 
    //   {4, 7, 0, 0, 0}
    // };
    // System.out.println(connectCities(cities));

    // // CODE2
    // init();
    // union(1, 3);
    // System.out.println(find(3));
    // union(2, 4);
    // union(3, 6);
    // union(1, 4);
    // System.out.println(find(3));
    // System.out.println(find(4));
    // union(1, 5);

    // // CODE3
    int V = 4;
    ArrayList<Edge1> edges = new ArrayList<>();
    createGraph(edges);
    kruskalsMST(edges, V);
  }
}
