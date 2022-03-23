package revision;
import java.util.LinkedList;
class Graph {
    int count;
    private LinkedList<LinkedList<Edge>> Adj;
    class Edge {
        int destination;
        int cost;
        Edge(int dest, int cost) {
            this.destination = dest;
            this.cost = cost;
        }
    }
    public Graph(int value) {
        this.count  = value;
        Adj = new LinkedList<LinkedList<Edge>>();
        for(int i = 0 ; i< value;i++) {
            Adj.add(new LinkedList<Edge>());
        }
    }
    public void addDirectedEdge(int source, int destination,int cost) {
        Edge edge1 = new Edge(destination, cost);
        Adj.get(source).add(edge1);
    }
    public void addUndirectedEdge(int source, int destination, int cost) {
        addDirectedEdge(source,destination,cost);
        addDirectedEdge(destination,source,cost);
    }
    public void addDirectedEdge(int source, int destination) {
        this.addDirectedEdge(source,destination,1);
    }
    public void addUndirectedEdge(int source, int destination) {
        this.addDirectedEdge(source,destination);
        this.addDirectedEdge(destination,source);
    }
    public void print() {
        int count = 0;
        for(LinkedList<Edge> k : Adj) {
            System.out.print(count + ":");
            for(Edge k1: k) {
                System.out.print( "("  + k1.destination + ", " + k1.cost + ")" + " ");
            }
            count = count + 1;
            System.out.println(" ");
        }
    }
}

public class Graph_Interface {
    public static void main(String[] args) {
        Graph inner = new Graph(6);
        inner.addDirectedEdge(1,2,1);
        inner.addDirectedEdge(2,3,1);
        inner.addDirectedEdge(3,4,1);
        inner.addDirectedEdge(0,5,1);
        inner.addDirectedEdge(5,4,32);
        inner.addDirectedEdge(0, 6);
        inner.print();
    }
}
