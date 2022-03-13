package Graph6;

import java.util.LinkedList;

//adjacency list of graph implementation

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
