package graph;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

class Vertex {
    String label;
    Vertex(String label){
        this.label = label;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex other = (Vertex) obj;
        return label.equals(other.label);
    }

    @Override
    public  int hashCode() {
        return label.hashCode();
    }
}
public class CreateGraph {
    //adjacency list
    //https://www.baeldung.com/wp-content/uploads/2018/11/graph3.jpg
    private Map<Vertex, List<Vertex>> graph = new HashMap<Vertex, List<Vertex>>();

    public void createGraph() {
        addVertex("BoB");
        addVertex("Alice");
        addVertex("Mark");
        addVertex("Rob");
        addVertex("Maria");
        addEdge("Alice", "BoB");
        addEdge("Alice", "Mark");
        addEdge("Alice", "Maria");
        addEdge("Rob", "Maria");
        addEdge("Rob", "Mark");
        addEdge("Rob", "BoB");
        addEdge("BoB", "Alice");
        addEdge("BoB", "Rob");
        addEdge("Maria", "Alice");
        addEdge("Maria", "Rob");
        addEdge("Mark", "Alice");
        addEdge("Mark", "Rob");

//        removeVertex("Rob");
//        removeEdge("Mark", "Alice");

        printGraph();
    }

    private void addVertex(String lable) {
        Vertex vertex = new Vertex(lable);
        if(graph.containsKey(vertex)) {
            System.out.println("Vertex already exists.");
        }
        graph.put(vertex, new ArrayList<>());
    }

    private void removeVertex(String label) {
        Vertex vertex = new Vertex(label);
        ArrayList<Vertex> list = new ArrayList<>();
        list.add(vertex);
        graph.values().forEach(e -> e.removeAll(list));
        graph.remove(vertex);
    }

    private void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        graph.get(v1).add(v2);
        graph.get(v2).add(v1);
    }

    private void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        graph.get(v1).remove(v2);
        graph.get(v2).remove(v1);
    }

    private void printGraph() {
        graph.forEach((key, value) -> {
            System.out.print(key.label + ": ");
            value.forEach((val) -> {
                System.out.print(val.label + "->");
            });
            System.out.println();
        });
    }
}
