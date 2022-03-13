package Graph6;

import java.util.LinkedList;

//adjacency list of graph implementation
class Graph {
    int count;
    LinkedList<LinkedList<Edge>> adj;
    Graph(int value) {
        adj = new LinkedList<LinkedList<Edge>>();
        for(int i = 0; i < value;i++) {
            adj.add(new LinkedList<Edge>());
        }
    }
    class Edge {
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
}
class new1 {
    public static void main(String[] args) {
        Graph gph = new Graph(5);
        gph.addDirectedEdge(0, 1, 3);
        gph.addDirectedEdge(0, 4, 2);
        gph.addDirectedEdge(1, 2, 1);
        gph.addDirectedEdge(2, 3, 1);
        gph.addDirectedEdge(4, 1, -2);
        gph.addDirectedEdge(4, 3, 1);
        gph.print();
    }
}
