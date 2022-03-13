package Graph6;
import java.util.*;
class Dfs1 {
    int value8 = 0;
    int cn = 0;
    Stack<Integer> stk = new Stack<Integer>();
    Stack<Integer> stack  = new Stack<Integer>();
    public boolean stackdfs(Graph gph,int source,int target,int value1) {
        boolean[] visited = new boolean[value1];
        stack.push(source);
        visited[source] = true;
        while(!stack.isEmpty()) {
            int index = stack.pop();
            LinkedList<Graph.Edge> edge = gph.adj.get(index);
            for(Graph.Edge edge1: edge) {
                if(visited[edge1.desintation] == false) {
                    visited[edge1.desintation] = true;
                    stack.push(edge1.desintation);
                }
            }
        }
        return visited[target];
    }
    public  boolean dfs(Graph gph1, int source, int target, int value) {
        boolean[] visited = new boolean[value];
        dfsutil(gph1, source, visited);
        return visited[target];
    }
    public void dfsutil(Graph gph, int source,boolean[] visited) {
        visited[source] = true;
        LinkedList<Graph.Edge> linked =gph.adj.get(source);
        for(Graph.Edge edge: linked) {
            if(visited[edge.desintation] == false) {
                dfsutil(gph, edge.desintation,visited);
            }
        }
    }
    public boolean bfs(Graph gph1, int source, int target, int value) {
        boolean[] visited = new boolean[value];
        Queue<Integer> que  = new ArrayDeque<>();
        que.add(source);
        visited[source] = true;
        while(!que.isEmpty()) {
            int value1 = que.remove();
            LinkedList<Graph.Edge> edge = gph1.adj.get(value1);
            for(Graph.Edge edge1: edge){
                if(visited[edge1.desintation] == false) {
                    visited[edge1.desintation]  = true;
                    que.add(edge1.desintation);
                }
            }
        }
        return visited[target];
    }
    public void topological(Graph gph,int value) {
        boolean[] visited = new boolean[value];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0;i <value;i++) {
            if (visited[i] == false) {
                dfsutil2(gph,visited,i,stack);
            }
        }System.out.println("the topological sort: ");
        while(stack.isEmpty() == false) {
            System.out.print(" " + stack.pop());
        }System.out.println("");
    }
    public void dfsutil2(Graph gph,boolean[] visited,int source,Stack<Integer> stack) {
        visited[source] = true;
        LinkedList<Graph.Edge> adj = gph.adj.get(source);

        for(Graph.Edge edge: adj) {
            if(visited[edge.desintation] == false) {
                dfsutil2(gph,visited,edge.desintation,stack);
            }
        }
        stack.push(source);


    }
    public void countAlPath(Graph gph, int source ,int destination,int no) {
        stk.add(source);
        if(source == destination) {
            if(cn == 0) {
                cn = cn + 7;
                System.out.println("the possible path are :");
            }
            System.out.println(stk + "\n");
            stk.pop();
            value8 = value8 + 1;
        }
        boolean[] visited = new boolean[no];
        LinkedList<Graph.Edge> edge = gph.adj.get(source);
        for(Graph.Edge edge1: edge) {
            if(visited[edge1.desintation] == false) {
                visited[edge1.desintation] = true;
                countAlPath(gph, edge1.desintation, destination,no);

            }
        }
        if(stk.size() > 1) stk.pop();

    }
    public void count5(Graph gp, int source, int destination, int count) {
        countAlPath(gp,source,destination,count);
        System.out.println("possible no of path are :" + value8);
    }
}

public class Dfs {
    public static void main(String[] args) {
        Dfs1 dfs3 = new Dfs1();
        Graph gph = new Graph(6);
        gph.addDirectedEdge(1, 2, 1);
        gph.addDirectedEdge(2, 5, 1);
        gph.addDirectedEdge(3, 5, 1);
        gph.addDirectedEdge(2, 3, 1);
        gph.addDirectedEdge(4, 3, 1);
        gph.addDirectedEdge(1, 4, 1);
        gph.print();
        dfs3.topological(gph, 6);
        dfs3.count5(gph, 1, 5, 6);

    }
}

