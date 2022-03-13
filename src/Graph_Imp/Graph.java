package Graph_Imp;
class Graph2 {
    int count;
    int[][] two2d;
    public Graph2(int v) {
        this.count = v;
        two2d = new int[this.count][this.count];
    }
    public void addDirectedEdge(int source, int destination,int cost) {
        two2d[source][destination] = cost;
    }
    public void addUndirectedEdge(int source, int destination,int cost) {
        addDirectedEdge(source,destination,cost);
        addDirectedEdge(destination,source,cost);
    }
    public void print() {
        for(int i = 0; i < count;i++) {
            for(int j = 0; j <count;j++) {
                if(two2d[i][j] != 0) {
                    System.out.print(j + " ");
                }
            }
            System.out.println( " ");
        }
    }
    public void topologicalSort(Graph1 gph) {

    }
}
class Graph  {
    public static void main(String[] args) {
        Graph2 graph = new Graph2(4);
        graph.addUndirectedEdge(0, 1, 1);
        graph.addUndirectedEdge(0, 2, 1);
        graph.addUndirectedEdge(1, 2, 1);
        graph.addUndirectedEdge(2, 3, 1);
        graph.print();
    }
}

