package com.company;
import java.util.*;

import static java.lang.System.out;
class Edge {
   int dest;
   int cost;
   Edge(int dest, int cost) {
       this.dest = dest;
       this.cost = cost;
   }
}
class Graph {
    int count;
    LinkedList<LinkedList<Edge>> adj;
    public Graph(int count) {
        adj = new LinkedList<>();
        for(int i =0; i < count;i++) {
            adj.add(new LinkedList<Edge>());
        }
        this.count = count;
    }
    public void addDirectedEdge(int source, int destination, int cost) {
        Edge edge =new Edge(destination,cost);
        this.adj.get(source).add(edge);
    }
    public void addDirectedEdge(int source, int destination) {
        Edge edge =new Edge(destination,1 );
        this.adj.get(source).add(edge);
    }
    public void addUndirectedEdge(int source, int destination, int cost) {
        this.addDirectedEdge(source, destination,cost);
        this.addDirectedEdge(destination,source, cost);
    }
    public void addUndirectedEdge(int source, int destination) {
       this.addDirectedEdge(source, destination);
       this.addDirectedEdge(destination, source);
    }
    public void print() {
        int count  =0;
        for(LinkedList<Edge> c:this.adj) {
            out.print(count++);
            for(Edge c1:c) {
                out.print("(" + c1.dest  + "," + c1.cost +")" + "\t");

            }
            out.println();
        }
    }
}
class solution  {
    public void sol(Graph gp){
        boolean[] visited =new boolean[gp.count];
        out.println("dfs search on the graph");
        this.dfs(gp,0,visited);
        out.println("bfs of the graph");
        visited =new boolean[gp.count];
        this.bfs(gp,0,visited);
        out.println("topological sort");
        this.dfs(gp);
        out.println("countAll paths");
        visited = new boolean[gp.count];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        this.countAllPath(gp,0,7,stack,visited);
        out.println("bfs level Node transversal");
        this.bfsLevelNode(gp,0);
        out.println("bfs level Node transversal 2");
        this.bfsLevelNode2(gp,0);
        out.println("graph isConnectedStrongly");
        this.isCyclePresent(gp);
        out.println("prims algorithms");
        this.primsAlgorithm(gp,0);
        out.println("dijkstra Algorithm");
        this.dijkstraAlgorithm(gp,0);
    }
    public void  dfs(Graph gp,int source,boolean[] visited) {
        LinkedList<Edge> list  = gp.adj.get(source);
        visited[source] = true;
        for(Edge c:list) {
            if(!visited[c.dest]) {
                dfs(gp,c.dest, visited);
            }
        }
        out.print(source + "\t");
    }
    public void bfs(Graph gp,int source,boolean[] visited) {
        Queue<Integer> que =new ArrayDeque<>();
        que.add(source);
        visited[source] = true;
        while(que.size() > 0) {
            int size = que.size();
            System.out.println(que);
            for(int i =0; i < size;i++) {
                int start = que.remove();
                LinkedList<Edge> list = gp.adj.get(start);
                for(Edge e : list) {
                    if(!visited[e.dest]) {
                        visited[e.dest] = true;
                        que.add(e.dest);
                    }
                }
            }

        }
    }
    public void dfs(Graph gp) {
        boolean[] visited = new boolean[gp.count];
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i< gp.count;i++) {
            if(!visited[i]) {
                dfs1(gp,i,visited,stack);
            }
        }
        System.out.println("topological Sort");
        while (stack.size() > 0) {
            System.out.print(stack.pop() + ",");
        }
    }
    public void dfs1(Graph gp, int source,boolean[] visited,Stack<Integer> stack) {
        LinkedList<Edge> l = gp.adj.get(source);
        visited[source] = true;
        for(Edge c:l) {
            if(!visited[c.dest]) {
                dfs1(gp,c.dest,visited,stack);
            }
        }
        stack.add(source);
    }
    public void countAllPath(Graph gp, int source, int target,Stack<Integer> stack,boolean[] visited) {
        if(source == target) {
            System.out.println("path" + "," + stack);
            return;
        }
        LinkedList<Edge> e =  gp.adj.get(source);
        visited[source] = true;
        for(Edge v:e) {
            if(!visited[v.dest]) {
                stack.push(v.dest);
                countAllPath(gp,v.dest,target,stack,visited);
                stack.pop();
            }
        }
        visited[source] = false;
    }
    public void bfsLevelNode(Graph gp,int source) {
        int[] prev =new int[gp.count];
        int[] dist = new int[gp.count];
        Arrays.fill(prev, -1 );
        Arrays.fill(dist, Integer.MAX_VALUE);
        prev[source] = -1;
        dist[source] = 0;
        boolean[] visited =new boolean[gp.count];
        Queue<Integer> que = new ArrayDeque<Integer>();
        visited[source]  = true;
        que.add(source);
        while(!que.isEmpty()) {
            int start = que.remove();
            visited[start] = true;
            LinkedList<Edge> list =  gp.adj.get(start);
            for(Edge e:list) {
                if(!visited[e.dest]) {
                    int distance = dist[start] + 1;
                    que.add(e.dest);
                    if(distance < dist[e.dest]) {
                        prev[e.dest] = start;
                        dist[e.dest] = distance;
                    }
                }
            }
        }
        for(int i=0; i< gp.count;i++) {
            System.out.println("parent of " + i + "\t" + "is" + prev[i] + "\t" + "and distance from source is " + "\t" + dist[i]);
        }
    }
    public void bfsLevelNode2(Graph gp, int source) {
        int[] previous = new int[gp.count];
        int[] dist = new int[gp.count];
        boolean[] visited =new boolean[gp.count];
        Queue<Integer> que = new ArrayDeque<>();
        Arrays.fill(previous,-1);
        Arrays.fill(dist, Integer.MAX_VALUE);
        que.add(source);
        dist[source] = 0;
        visited[source] = true;
        que.add(source);
        while(que.size() > 0) {
            int start = que.remove();
            LinkedList<Edge> list  = gp.adj.get(start);
            for(Edge d:list) {
                if(!visited[d.dest]) {
                    visited[d.dest] =true;
                    que.add(d.dest);
                    previous[d.dest] = start;
                    dist[d.dest] = dist[start] + 1;
                }
            }
        }
        for(int i=0; i< gp.count;i++) {
            System.out.println("parent of " + i + "\t" + "is" + previous[i] + "\t" + "and distance from source is " + "\t" + dist[i]);
        }

    }
    public boolean coloring(Graph gp, int index, int[] visited) {
        visited[index] = 1;
        LinkedList<Edge> list =gp.adj.get(index);
        for(Edge d:list) {
            int dest = d.dest;
            if(visited[d.dest] == 1) {
                return true;
            }
            if(visited[d.dest] == 0) {
                if(coloring(gp,dest,visited)) {
                    return true;
                }
            }
        }
        visited[index] = 2;
        return false;
    }
    public void isCyclePresent(Graph gp) {
        int count = gp.count;
        int[] visited =new int[count];
        for(int i =0; i < count;i++) {
            if(visited[i] == 0) {
                if(coloring(gp,i,visited)) {

                    System.out.println(true);
                    return;
                }
            }
        }
        out.println(false);
    }
    class comp implements Comparator<Edge> {
        @Override
        public int compare(Edge a, Edge b) {
            return a.cost - b.cost;
        }
    }
    public void primsAlgorithm(Graph gp,int source) {
        int[] previous = new int[gp.count];
        int[] distance = new int[gp.count];
        boolean[] visited = new boolean[gp.count];
        Arrays.fill(distance,(int)1e9);
        Arrays.fill(previous,-1);
        distance[source] =0;
        previous[source] = -1;
        comp c = new comp();
        PriorityQueue<Edge> que = new PriorityQueue<>(c);
        Edge edge =new Edge(source,0);
        que.add(edge);
        while(que.size() > 0) {
            int start = que.remove().dest;
            visited[start] = true;
            LinkedList<Edge> lis = gp.adj.get(start);
            for(Edge e:lis) {
                int cost = e.cost;
                if(!visited[e.dest] && cost < distance[e.dest]) {
                    distance[e.dest] = cost;
                    previous[e.dest] = start;
                    que.add(new Edge(e.dest,cost));
                }
            }
        }
        for(int i=0; i< gp.count;i++) {
            System.out.println("parent of " + i + "\t" + "is" + previous[i] + "\t" + "and distance from source is " + "\t" + distance[i]);
        }

    }
    public void dijkstraAlgorithm(Graph gp, int source) {
        int[] previous = new int[gp.count];
        int[] dist = new int[gp.count];

        boolean[] visited = new boolean[gp.count];
        PriorityQueue<Edge> que =new PriorityQueue<>(new comp());
        Arrays.fill(previous, - 1);
        Arrays.fill(dist,(int)1e9);
        Edge edge = new Edge(source, 0);
        visited[source] = true;
        que.add(edge);
        dist[0] =0;
        while(!que.isEmpty()) {
            int start = que.remove().dest;
            visited[start] = true;
            LinkedList<Edge> list = gp.adj.get(start);
            for(Edge e:list) {
                int dest = e.dest;
                int cost = e.cost + dist[start];
                if(!visited[dest] && cost < dist[dest]) {
                    dist[dest] = cost;
                    previous[dest] = start;
                    que.add(new Edge(dest, cost));

                }
            }
        }
        for(int i=0; i< gp.count;i++) {
            System.out.println("parent of " + i + "\t" + "is" + previous[i] + "\t" + "and distance from source is " + "\t" + dist[i]);
        }

    }
}
public class sol {
    public static void main(String[] args) {
        solution n =new solution();
        out.println("Hello, world");
        Graph gp =new Graph(10);
        gp.addUndirectedEdge(0,3,30);
        gp.addUndirectedEdge(0,7,10);
        gp.addUndirectedEdge(1,8,10);
        gp.addUndirectedEdge(8,4,60);
        gp.addUndirectedEdge(3,9,20);
        gp.addUndirectedEdge(9,6,100);
        gp.addUndirectedEdge(0,1,10);
        gp.addUndirectedEdge(0,2,20);
        gp.addUndirectedEdge(1,5,50);
        gp.addUndirectedEdge(3,5,70);
        gp.addUndirectedEdge(2,5,60);
        gp.addUndirectedEdge(1,4,30);
        gp.addUndirectedEdge(3,6,10);
        gp.addUndirectedEdge(4,7,70);
        gp.addUndirectedEdge(6,7,90);
        gp.addUndirectedEdge(5,7,80);
        gp.print();
        n.sol(gp);
    }
}