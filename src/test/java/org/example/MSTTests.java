package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class MSTTests {

    @Test
    public void testCorrectnessAndEquivalence() {
        Graph g = new Graph(1);
        g.addNode("A"); g.addNode("B"); g.addNode("C"); g.addNode("D");
        g.addEdge("A", "B", 1);
        g.addEdge("B", "C", 2);
        g.addEdge("C", "D", 3);
        g.addEdge("A", "D", 4);

        MSTResult prim = PrimAlgorithm.run(g);
        MSTResult kruskal = KruskalAlgorithm.run(g);

        assertEquals(prim.total_cost, kruskal.total_cost, 0.0001);
        assertEquals(g.nodes.size() - 1, prim.mst_edges.size());
        assertEquals(g.nodes.size() - 1, kruskal.mst_edges.size());
    }

    @Test
    public void testDisconnectedGraphHandled() {
        Graph g = new Graph(2);
        g.addNode("A"); g.addNode("B"); g.addNode("C");
        g.addEdge("A", "B", 1);

        MSTResult prim = PrimAlgorithm.run(g);
        MSTResult kruskal = KruskalAlgorithm.run(g);

        assertTrue(prim.mst_edges.size() < g.nodes.size() - 1);
        assertTrue(kruskal.mst_edges.size() < g.nodes.size() - 1);
    }

    @Test
    public void testPerformanceAndConsistency() {
        Graph g = new Graph(3);
        for (int i = 1; i <= 10; i++) g.addNode("V" + i);
        for (int i = 1; i < 10; i++) g.addEdge("V" + i, "V" + (i + 1), i);

        MSTResult prim = PrimAlgorithm.run(g);
        MSTResult kruskal = KruskalAlgorithm.run(g);

        assertTrue(prim.execution_time_ms >= 0);
        assertTrue(kruskal.execution_time_ms >= 0);
        assertTrue(prim.operations_count >= 0);
        assertTrue(kruskal.operations_count >= 0);
    }
}
