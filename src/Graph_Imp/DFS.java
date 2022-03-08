package Graph_Imp;
import java.util.*;

class DFS {
    private class Edge2 {
        int source,destination;
        public Edge2(int source,int destination) {
            this.source = source;
            this.destination = destination;
        }
    }
    public boolean Graph(Graph1 gph, int source,int target, int value) {
        boolean[] array = new boolean[value];
        array[source] = true;
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(source);
        while(!stack.isEmpty()) {
            int curr = stack.pop();
            LinkedList<Graph1.Edge> adj = gph.linkde.get(curr);
            for(Graph1.Edge edge: adj) {
                if(array[edge.destination] == false) {
                    array[edge.destination] = true;
                    stack.add(edge.destination);
                }
            }
        }
        return array[target];
    }
    public  boolean dfs(Graph1 gph,int source, int target,int value) {
        int count= value;
        boolean[] visited = new  boolean[count];
        graph5(gph, source, visited);
        return visited[target];
    }
    public static void graph5(Graph1 gph, int index, boolean[]  visited) {
        visited[index] = true;
        LinkedList<Graph1.Edge> edge = gph.linkde.get(index);
        for(Graph1.Edge ad: edge) {
            if(visited[ad.destination] == false) {
                graph5(gph,ad.destination,visited);
            }
        }
    }
    public void Node(Graph1 gph, int value, int destination, int source) {
        boolean[] visited = new boolean[value];
        Queue<Integer> que = new ArrayDeque<>();
        que.add(source);
        while (!que.isEmpty()) {
            int value1 = que.remove();
            visited[source] = true;
            LinkedList<Graph1.Edge> variable= gph.linkde.get(value1);
            for(Graph1.Edge edge1: variable ) {
                if(visited[edge1.destination] == false) {
                    visited[edge1.destination] = true;
                    que.add(edge1.destination);
                }
            }
        }
    }
}

