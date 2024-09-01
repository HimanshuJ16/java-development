import java.util.*;

public class JavaBasics55 {
  static class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int s, int d, int w) {
      this.src = s;
      this.dest = d;
      this.wt = w;
    }
  }

  static void createGraph(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1, 2));
    graph[0].add(new Edge(0, 2, 4));

    graph[1].add(new Edge(1, 3, 7));
    graph[1].add(new Edge(1, 2, 1));

    graph[2].add(new Edge(2, 4, 3));

    graph[3].add(new Edge(3, 5, 1));
 
    graph[4].add(new Edge(4, 3, 2));
    graph[4].add(new Edge(4, 5, 5));
  }

  static void createGraph1(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1, 2));
    graph[0].add(new Edge(0, 2, 4));

    graph[1].add(new Edge(1, 2, -4));

    graph[2].add(new Edge(2, 3, 2));

    graph[3].add(new Edge(3, 4, 4));
 
    graph[4].add(new Edge(4, 1, -1));
  }

  static void createGraph2(ArrayList<Edge> graph) {
    graph.add(new Edge(0, 1, 2));
    graph.add(new Edge(0, 2, 4));

    graph.add(new Edge(1, 2, -4));

    graph.add(new Edge(2, 3, 2));

    graph.add(new Edge(3, 4, 4));
 
    graph.add(new Edge(4, 1, -1));
  }

  static void createGraph3(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1, 10));
    graph[0].add(new Edge(0, 2, 15));
    graph[0].add(new Edge(0, 3, 30));

    graph[1].add(new Edge(1, 0, 10));
    graph[1].add(new Edge(1, 3, 40));

    graph[2].add(new Edge(2, 0, 15));
    graph[2].add(new Edge(2, 3, 50));

    graph[3].add(new Edge(3, 1, 40));
    graph[3].add(new Edge(3, 2, 50));
  }

  static class Pair implements Comparable<Pair> {
    int n;
    int path;

    public Pair(int n, int path) {
      this.n = n;
      this.path = path;
    }

    @Override
    public int compareTo(Pair p2) {
      return this.path - p2.path;
    }
  }

  public static void dijkstra(ArrayList<Edge> graph[], int src) {
    int dist[] = new int[graph.length];
    for(int i=0; i<graph.length; i++) {
      if (i != src) {
        dist[i] = Integer.MAX_VALUE;
      }
    }

    boolean vis[] = new boolean[graph.length];
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(src, 0));

    while (!pq.isEmpty()) {
      Pair curr = pq.remove();
      if (!vis[curr.n]) {
        vis[curr.n] = true;
        for(int i=0; i<graph[curr.n].size(); i++) {
          Edge e = graph[curr.n].get(i);
          int u = e.src;
          int v = e.dest;
          int wt = e.wt;

          if (dist[u] + wt < dist[v]) {
            dist[v] = dist[u] + wt;
            pq.add(new Pair(v, dist[v]));
          }
        }
      }
    }

    for(int i=0; i<dist.length; i++) {
      System.out.print(dist[i] + " ");
    }
    System.out.println();
  }

  public static void bellmanFord(ArrayList<Edge> graph, int src, int V) {
    int dist[] = new int[V];
    for(int i=0; i<dist.length; i++) {
      if (i != src) {
        dist[i] = Integer.MAX_VALUE;
      }
    }

    for(int i=0; i<V-1; i++) {
      for(int j=0; j<graph.size(); j++) {
        Edge e = graph.get(j);
        int u = e.src;
        int v = e.dest;
        int wt = e.wt;
        if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
          dist[v] = dist[u] + wt;
        }
      }
    }

    for(int i=0; i<dist.length; i++) {
      System.out.print(dist[i] + " ");
    }
    System.out.println();
  }
  
  static class Pair1 implements Comparable<Pair1> {
    int v;
    int cost;

    public Pair1(int v, int c) {
      this.v = v;
      this.cost = c;
    }

    @Override
    public int compareTo(Pair1 p2) {
      return this.cost - p2.cost;
    }
  }

  public static void prims(ArrayList<Edge> graph[]) { // O(ElogE)
    boolean vis[] = new boolean[graph.length];
    PriorityQueue<Pair1> pq = new PriorityQueue<>();
    pq.add(new Pair1(0, 0));
    int finalCost = 0;

    while (!pq.isEmpty()) {
      Pair1 curr = pq.remove();
      if (!vis[curr.v]) {
        vis[curr.v] = true;
        finalCost += curr.cost;

        for(int i=0; i<graph[curr.v].size(); i++) {
          Edge e = graph[curr.v].get(i);
          pq.add(new Pair1(e.dest, e.wt));
        }
      }
    }

    System.out.println("final(min) cost of MST : " + finalCost);
  }
  public static void main(String[] args) {
    // // CODE1
    // int V = 6;
    // int src = 0;
    // ArrayList<Edge> graph[] = new ArrayList[V];
    // createGraph(graph);
    // dijkstra(graph, src);

    // // CODE2
    // int V = 5;
    // // ArrayList<Edge> graph[] = new ArrayList[V];
    // ArrayList<Edge> graph = new ArrayList<>();
    // createGraph2(graph);
    // bellmanFord(graph, 0, V);

    // // CODE3
    // int V = 4;
    // ArrayList<Edge> graph[] = new ArrayList[V];
    // createGraph3(graph);
    // prims(graph);  
  }
}
