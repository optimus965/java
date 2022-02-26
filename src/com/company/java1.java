package com.company;
import java.util.*;
class Graph<T> {
    private Map<T,List<T>>  map = new HashMap<>();
    public void addVertex(T s) {
        map.put(s, new LinkedList<T>());
    }
    public void addEdge(T source,T destination,boolean bidirectional) {
        if(!map.containsKey(source)) addVertex(source);
        if(!map.containsKey(destination)) addVertex(destination);
        map.get(source).add(destination);
        if(bidirectional == true) {
            map.get(destination).add(source);
        }
    }
    public void getVertexCount() {
        System.out.println("The graph has " + map.keySet().size() + "vertex");
    }
    public void getEdgeCount(boolean bidirectional) {
        int count = 0;
        for(T v:map.keySet()) {
            count += map.get(v).size();
        }
        if(bidirectional == true) {
            count = count / 2;
        }
        System.out.println("the graph has" + count + "edges");
    }
    public void hasVertex(T s) {
        if(map.containsKey(s)) {
            System.out.println("the graph contains" + s + "as a vertex");
        }
        else {
            System.out.println("the graph does not contain vertex");
        }
    }
    public void hasEdge(T s, T d) {
        if(map.get(s).contains(d)) {
            System.out.println("the graph has an edge between" + s + "and" + d + "");
        }
        else{
            System.out.println("there is no edge between " + s + "and " + d + ".");
        }
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T v : map.keySet()) {
            builder.append(v.toString() + ":");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");

        }
        return (builder.toString());

    }
}
class java1 {
    public static void main(String args[]) {
        Graph<Integer> g = new Graph<>();

    }

}

