package org.example;

import java.util.*;

public class KruskalAlgorithm {

    public static MSTResult run(Graph graph) {
        long start = System.nanoTime();
        int operations = 0;

        List<Edge> mstEdges = new ArrayList<>();
        if (graph.nodes.isEmpty()) {
            return new MSTResult(mstEdges, 0.0, operations, 0.0);
        }

        List<Edge> edges = new ArrayList<>(graph.edges);
        edges.sort(Comparator.comparingDouble(e -> e.weight));

        UnionFind uf = new UnionFind();
        for (String node : graph.nodes) uf.makeSet(node);

        for (Edge e : edges) {
            operations++;
            if (uf.union(e.from, e.to)) {
                mstEdges.add(e);
            }
            if (mstEdges.size() == graph.nodes.size() - 1) break;
        }

        long end = System.nanoTime();
        double totalCost = mstEdges.stream().mapToDouble(ed -> ed.weight).sum();
        double timeMs = roundTo2((end - start) / 1_000_000.0);

        return new MSTResult(mstEdges, totalCost, operations, timeMs);
    }

    private static double roundTo2(double v) {
        return Math.round(v * 100.0) / 100.0;
    }
}
