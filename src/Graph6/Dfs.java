package Graph6;
import java.util.*;
class Graph {
    LinkedList<LinkedList<Edge>> adj;
    Graph(int value) {
        adj = new LinkedList<>();
        for(int i = 0; i < value;i++) {
            adj.add(new LinkedList<Edge>());
        }
    }
    static class Edge {
        int desintation;
        int cost;
        Edge(int desintation) {
            this(desintation,1);
        }
        Edge(int desintation, int cost) {
            this.desintation = desintation;
            this.cost = cost;
        }
    }
    public void addDirectedEdge(int source, int destination, int cost) {
        Edge  edge = new Edge(destination,cost);
        adj.get(source).add(edge);
    }
    public void addUndirectedEdge(int source , int destination, int cost) {
        Edge edge1  = new Edge(destination,cost);
        Edge edge2 = new Edge(source,cost);
        adj.get(source).add(edge1);
        adj.get(destination).add(edge2);
    }
    public void addDirectedEdge(int source, int destination) {
        Edge edge = new Edge(destination);
        adj.get(source).add(edge);
    }
    public void addUndirectedEdge(int source,int destination) {
        Edge edge = new Edge(destination);
        Edge edge3 = new Edge(source);
        adj.get(source).add(edge);
        adj.get(destination).add(edge3);
    }
    public void print() {
        int i = 0;
        for(LinkedList<Edge> edge: adj) {
            System.out.println(i + "is connected to : \n" );

            for(Edge ew: edge) {
                System.out.print( " (" + ew.desintation + " , " + ew.cost + " ) " + " ");
            }
            System.out.println( " " );
            i = i + 1;
        }
    }
    public void dfs(int source, Graph gph,boolean[] visited1) {
        LinkedList<Edge> sour = gph.adj.get(source);
        for(Edge edge: sour) {
            if(!visited1[edge.desintation]) {
                visited1[edge.desintation] = false;
                dfs(edge.desintation, gph,visited1);
            }
        }

        System.out.print(source);
    }

}
class Dfs1 {
    int value8 = 0;
    int cn = 0;
    int count = 0;
    boolean[] visited = new boolean[9];
    ArrayDeque<Integer> que = new ArrayDeque<>();
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
                if(!(visited[edge1.desintation])) {
                    visited[edge1.desintation] = true;
                    stack.push(edge1.desintation);
                }
            }
        }
        return visited[target];
    }

    public void dfsutil(Graph gph, int source,boolean[] visited) {
        visited[source] = true;
        LinkedList<Graph.Edge> linked =gph.adj.get(source);
        for(Graph.Edge edge: linked) {
            if(!(visited[edge.desintation])) {
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
                if(!(visited[edge1.desintation])) {
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
            if (!visited[i]) {
                dfsutil2(gph,visited,i,stack);
            }
        }System.out.println("the topological sort: ");
        while(!(stack.isEmpty())) {
            System.out.print(" " + stack.pop());
        }System.out.println("");
    }
    public void dfsutil2(Graph gph,boolean[] visited,int source,Stack<Integer> stack) {
        visited[source] = true;
        LinkedList<Graph.Edge> adj = gph.adj.get(source);
        for(Graph.Edge edge: adj) {
            if(!visited[edge.desintation]) {
                dfsutil2(gph,visited,edge.desintation,stack);
            }
        }
        stack.push(source);
    }
    public void countAlPath(Graph gph, int source ,int destination,int no)
    {
        stk.add(source);
        if(source == destination) {
            if(cn == 0) {
                cn = cn + 7;
                System.out.println("the possible paths are :");
            }
            System.out.println(stk + "\n");

            value8 = value8 + 1;
            return;
        }
        LinkedList<Graph.Edge> edge = gph.adj.get(source);
        for(Graph.Edge edge1: edge) {
            if(!visited[edge1.desintation]) {
                visited[source] = true;
                countAlPath(gph, edge1.desintation, destination,no);
                stk.pop();
            }
        }
        visited[source] = false;
    }
    public void count5(Graph gp, int source, int destination, int count) {
        countAlPath(gp,source,destination,count);
        System.out.println("possible no of path are :" + value8);
    }
    public void dfs(Graph gph, int source, boolean[] visited1) {
        visited1[source] = true;
        LinkedList<Graph.Edge> new1 = gph.adj.get(source);
        for(Graph.Edge edge1: new1) {
            if(!visited1[edge1.desintation]) {
                visited1[edge1.desintation] = false;
                dfs(gph, edge1.desintation, visited1);
            }
        }
        if(count == 0) {
            System.out.println("the path as per the dfs are");
        }
        count = 10;
        System.out.print(source + " ");
    }
    int i = 0;
    int count1 = 0;
    boolean[] new2 = new boolean[9];
    public void root2(Graph gph) {
        int reference = 0;
        System.out.println('\n');
        for(i = 0; i < 9;i++) {
            dfsutile(gph,i);
            for(int j = 0; j < 9;j++) {
                if(new2[j]) count1 = count1 + 1;
            }
            if(count1 == 9){
                if(reference == 0) {
                    System.out.println("the root vertexes are : ");
                }
                System.out.println(i);
            }
            count1 = 0;
            new2 = new boolean[9];
            reference  = 8;

        }
    }
    boolean[] new9 = new boolean[9];
    int numvwe = 0;
    int sum = 0;
    public void allpossiblePaths(Graph gph) {
        for(int i = 0; i< 9; i ++) {
           dfsutile1(gph, i);
           if(numvwe == 0) {
               System.out.print("0" +  "    " + "1" +  "     " + "2" +  "      "+  "3" +"     " +  "4" + "    " + "5" + "     " +  "6" + "    " +  "7" + "    " +  "8"  + "\n");
           }

           for(int j = 0; j < 9; j++) {
               if(sum == 0) {
                   System.out.print(i + ":");
               }
               sum = 10;
               System.out.print(new9[j] + "  ");
           }
           System.out.print("\n");
           numvwe = 9;
           sum = 0;
           new9 = new boolean[9];

        }
    }
    public void dfsutile1(Graph gp,int source) {
        new9[source] = true;
        LinkedList<Graph.Edge> edge = gp.adj.get(source);
        for(Graph.Edge ed: edge) {
            if(!new9[ed.desintation]) {
                dfsutile1(gp, ed.desintation);
            }
        }
    }

    public void dfsutile(Graph gp,int source) {
        new2[source] = true;
        LinkedList<Graph.Edge> edge = gp.adj.get(source);
        for(Graph.Edge ed: edge) {
            if(!new2[ed.desintation]) {
                dfsutile(gp, ed.desintation);
            }
        }
    }

}

public class Dfs {
    public static void main(String[] args) {
        Dfs1 dfs3 = new Dfs1();
        Graph gph = new Graph(9);
        boolean[] visited2 = new boolean[9];
        gph.addDirectedEdge(0,1,1);
        gph.addDirectedEdge(1,0,1);
        gph.addDirectedEdge(0,4,1);
        gph.addDirectedEdge(1, 2, 1);
        gph.addDirectedEdge(2, 5, 1);
        gph.addDirectedEdge(3, 5, 1);
        gph.addDirectedEdge(2, 3, 1);
        gph.addDirectedEdge(1,4,1);
        gph.addDirectedEdge(4, 3, 1);
        gph.addDirectedEdge(2,6,1);
        gph.addDirectedEdge(6,8,1);
        gph.addDirectedEdge(7,8,1);
        gph.addDirectedEdge(3,7,1);
        gph.addDirectedEdge(5,8,1);
        gph.print();
        dfs3.topological(gph, 9);
        dfs3.count5(gph, 1, 8, 9);
        dfs3.dfs(gph,1,visited2);
        dfs3.root2(gph);
        dfs3.allpossiblePaths(gph);
    }
}

