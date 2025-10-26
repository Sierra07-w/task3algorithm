package org.example;

import java.util.*;

public class Graph {
    public int id;
    public List<String> nodes;
    public List<Edge> edges;

    public Graph(int id, List<String> nodes, List<Edge> edges) {
        this.id = id;
        this.nodes = nodes;
        this.edges = edges;
    }

    public Graph(int id) {
        this.id = id;
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addNode(String node) {
        if (!nodes.contains(node)) {
            nodes.add(node);
        }
    }

    public void addEdge(String from, String to, int weight) {
        edges.add(new Edge(from, to, weight));
    }

    public Map<String, List<Edge>> getAdjacencyList() {
        Map<String, List<Edge>> adj = new HashMap<>();
        for (String n : nodes) adj.put(n, new ArrayList<>());
        for (Edge e : edges) {
            adj.get(e.from).add(new Edge(e.from, e.to, e.weight));
            adj.get(e.to).add(new Edge(e.to, e.from, e.weight));
        }
        return adj;
    }
}
