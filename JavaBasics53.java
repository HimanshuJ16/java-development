import java.util.*;

public class JavaBasics53 {
  static class Edge {
    int src;
    int dest;

    public Edge(int s, int d) {
      this.src = s;
      this.dest = d;
    }
  }

  static void createGraph(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 2));
    graph[0].add(new Edge(0, 3));

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 2));

    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 1));

    graph[3].add(new Edge(3, 0));
    graph[3].add(new Edge(3, 4));
 
    graph[4].add(new Edge(4, 3));
  }

  static void createGraph1(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 1));
    graph[0].add(new Edge(0, 2));

    graph[1].add(new Edge(1, 0));
    graph[1].add(new Edge(1, 3));

    graph[2].add(new Edge(2, 0));
    graph[2].add(new Edge(2, 4));

    graph[3].add(new Edge(3, 1));
    graph[3].add(new Edge(3, 4));
 
    graph[4].add(new Edge(4, 2));
    graph[4].add(new Edge(4, 3));
  }

  static void createGraph2(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 2));

    graph[1].add(new Edge(1, 0));

    graph[2].add(new Edge(2, 3));

    graph[3].add(new Edge(3, 0));
  }

  static void createGraph3(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[2].add(new Edge(2, 3));

    graph[3].add(new Edge(3, 1));
 
    graph[4].add(new Edge(4, 0));
    graph[4].add(new Edge(4, 1));

    graph[5].add(new Edge(5, 0));
    graph[5].add(new Edge(5, 2));
  }

  static void createGraph4(ArrayList<Edge> graph[]) {
    for(int i=0; i<graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 3));

    graph[2].add(new Edge(2, 3));

    graph[3].add(new Edge(3, 1));
 
    graph[4].add(new Edge(4, 0));
    graph[4].add(new Edge(4, 1));

    graph[5].add(new Edge(5, 0));
    graph[5].add(new Edge(5, 2));
  }

  public static boolean detectCycle(ArrayList<Edge>[] graph) {
    boolean vis[] = new boolean[graph.length];
    for(int i=0; i<graph.length; i++) {
      if (!vis[i]) {
        if (detectCycleUtil(graph, vis, i, -1)) {
          return true;
        }
      }
    }

    return false;
  }

  public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
    vis[curr] = true;

    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (!vis[e.dest]) {
        if (detectCycleUtil(graph, vis, e.dest, curr)) {
          return true;
        }
      } else if (vis[e.dest] && e.dest != par) {
        return true;
      }
    }

    return false;
  }

  public static boolean isBipartite(ArrayList<Edge>[] graph) {
    int col[] = new int[graph.length];
    for(int i=0; i<col.length; i++) {
      col[i] = -1;
    }

    Queue<Integer> q = new LinkedList<>();

    for(int i=0; i<graph.length; i++) {
      if (col[i] == -1) {
        q.add(i);
        col[i] = 0;
        while (!q.isEmpty()) {
          int curr = q.remove();
          for(int j=0; j<graph[curr].size(); j++) {
            Edge e = graph[curr].get(j);
            if (col[e.dest] == -1) {
              int nextCol = col[curr] == 0 ? 1 : 0;
              col[e.dest] = nextCol;
              q.add(e.dest);
            } else if (col[e.dest] == col[curr]) {
              return false;
            }
          }
        }
      }
    }

    return true;
  }

  public static boolean isCycle(ArrayList<Edge>[] graph) {
    boolean vis[] = new boolean[graph.length];
    boolean stack[] = new boolean[graph.length];

    for(int i=0; i<graph.length; i++) {
      if (!vis[i]) {
        if (isCycleUtil(graph, i, vis, stack)) {
          return true;
        }
      }
    }

    return false;
  }

  public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
    vis[curr] = true;
    stack[curr] = true;

    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (stack[e.dest]) {
        return true;
      } 
      if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
        return true;
      }
    }

    stack[curr] = false;
    return false;
  }

  public static void topologicalSort(ArrayList<Edge>[] graph) {
    boolean vis[] = new boolean[graph.length];
    Stack<Integer> s = new Stack<>();

    for(int i=0; i<graph.length; i++) {
      if (!vis[i]) {
        topologicalSortUtil(graph, i, vis, s);        
      }
    }

    while (!s.isEmpty()) {
      System.out.print(s.pop() + " ");
    }
  }

  public static void topologicalSortUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Stack<Integer> s) {
    vis[curr] = true;

    for(int i=0; i<graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (!vis[e.dest]) {
        topologicalSortUtil(graph, e.dest, vis, s);
      }
    }

    s.push(curr);
  }

  public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]) {
    for(int i=0; i<graph.length; i++) {
      int v = i;
      for(int j=0; j<graph[v].size(); j++) {
        Edge e = graph[v].get(j);
        indeg[e.dest]++;
      }
    }
  }

  public static void topologicalSortBFS(ArrayList<Edge> graph[]) {
    int indeg[] = new int[graph.length];
    calcIndeg(graph, indeg);
    Queue<Integer> q = new LinkedList<>();

    for(int i=0; i<indeg.length; i++) {
      if (indeg[i] == 0) {
        q.add(i);
      }
    }

    while (!q.isEmpty()) {
      int curr = q.remove();
      System.out.print(curr + " ");

      for(int i=0; i<graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        indeg[e.dest]--;
        if (indeg[e.dest] == 0) {
          q.add(e.dest);
        }
      }
    }

    System.out.println();
  }

  public static void printAllPath(ArrayList<Edge> graph[], int src, int dest, String path) {
    if (src == dest) {
      System.out.println(path + dest);
      return;
    }

    for(int i=0; i<graph[src].size(); i++) {
      Edge e = graph[src].get(i);
      printAllPath(graph, e.dest, dest, path + src);
    }
  }
  public static void main(String[] args) {
    // // CODE1
    // /*       
    //         0--------3
    //        /|        |  
    //       / |        |
    //      1  |        4
    //       \ |
    //        \|
    //         2  
    // */   
    
    // int V = 5;
    // ArrayList<Edge> graph[] = new ArrayList[V];
    // createGraph(graph);
    // System.out.println(detectCycle(graph));

    // // CODE2
    // /*
    //         0------2
    //        /      /
    //       /      /
    //      1      4
    //       \    /
    //        \  /
    //          3
    // */

    // int V = 5;
    // ArrayList<Edge> graph[] = new ArrayList[V];
    // createGraph1(graph);
    // System.out.println(isBipartite(graph));

    // // CODE3
    // int V = 4;
    // ArrayList<Edge> graph[] = new ArrayList[V];
    // createGraph2(graph);
    // System.out.println(isCycle(graph));

    // CODE4
    // int V = 6;
    // ArrayList<Edge> graph[] = new ArrayList[V];
    // createGraph3(graph);
    // topologicalSort(graph);
    // System.out.println();
    // topologicalSortBFS(graph);

    // // CODE5
    // int V = 6;
    // int src = 5, dest = 1;
    // ArrayList<Edge> graph[] = new ArrayList[V];
    // createGraph4(graph);
    // printAllPath(graph, src, dest, "");
  }
}
