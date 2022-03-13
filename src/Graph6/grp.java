package Graph6;
class Graph1 {
    int value;
    int[][] adj;
    Graph1(int count)  {
        this.value = count;
        adj = new int[count][count];
    }
    void addDirectedEdge(int source, int destination, int cost) {
        adj[source][destination] = cost;
    }
    void addUndirectedEdge(int source, int destination , int cost) {
        addDirectedEdge(source, destination,cost);
        addDirectedEdge(destination,source,cost);
    }
    void addDirectedEdge(int source, int destination) {
        addDirectedEdge(source, destination,1);
    }
    void addUndirectedEdge(int source, int destination) {
        addUndirectedEdge(source,destination, 1);
    }
    void print() {
        for(int i = 0 ; i < this.value ; i++) {
            System.out.println("the destination of the" + i + "source is ");
            for(int j = 0 ; j < this.value; j++)  {
                if(adj[i][j] != 0) {
                System.out.print( "(" + j + " ," +   adj[i][j]  + ")");
                System.out.println();
            }
            }
        }
    }
}

public class grp {
    public static void main(String[] args) {
        Graph1 graph = new Graph1(4);
        graph.addUndirectedEdge(0, 1, 5);
        graph.addUndirectedEdge(0, 2, 6);
        graph.addUndirectedEdge(1, 2, 9);
        graph.addUndirectedEdge(2, 3, 10);
        graph.print();
    }
}
