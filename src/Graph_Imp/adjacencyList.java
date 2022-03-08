package Graph_Imp;

import java.util.LinkedList;
import java.util.List;

class Graph1 {
    int v;
    LinkedList<LinkedList<Edge>> linkde;
   public class Edge {
        int destination;
        int cost;
        Edge(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }
    public Graph1(int value) {
        this.v = value;
        linkde = new LinkedList<LinkedList<Edge>>();
        for(int i = 0; i < value;i++) {
            linkde.add(new LinkedList<Edge>());
        }
    }
    public void addDirectedEdge(int source, int destination, int cost) {
        Edge edge = new Edge(destination, cost);
        linkde.get(source).add(edge);
    }
    public void addDirectedEdge(int source, int destination) {
        addDirectedEdge(source,destination,1);
    }
    public void addUndirectedEdge(int source, int destination, int cost) {
        addDirectedEdge(source,destination,cost);
        addDirectedEdge(destination,source,cost);
    }
    public void print() {
        int i = 0;
        for(LinkedList<Edge> node: linkde) {
            for(Edge x: node) {
                System.out.print( "\n " + i +  ":" + " " +  x.destination + " "  + x.cost + " ");
            }
            i++;
        }
    }
}
class adjacencyList {
    public static void main(String[] args) {
        Graph1 gph = new Graph1(5);
        gph.addDirectedEdge(0, 1, 3);
        gph.addDirectedEdge(0, 4, 2);
        gph.addDirectedEdge(1, 2, 1);
        gph.addDirectedEdge(2, 3, 1);
        gph.addDirectedEdge(4, 1, -2);
        gph.addDirectedEdge(4, 3, 1);
        gph.print();

    }

}
