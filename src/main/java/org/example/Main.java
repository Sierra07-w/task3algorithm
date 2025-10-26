package org.example;

import java.util.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);

            String inputFile = "src/main/java/org/example/input.json";
            String outputFile = "src/main/java/org/example/output.json";

            List<Graph> graphs = InputParser.readGraphs(inputFile);

            Map<Integer, MSTResult> primResults = new LinkedHashMap<>();
            Map<Integer, MSTResult> kruskalResults = new LinkedHashMap<>();

            for (Graph g : graphs) {
                MSTResult pr = PrimAlgorithm.run(g);
                MSTResult kr = KruskalAlgorithm.run(g);

                primResults.put(g.id, pr);
                kruskalResults.put(g.id, kr);

                System.out.println("Graph id=" + g.id + ": vertices=" + g.nodes.size() + " edges=" + g.edges.size());
                System.out.println("  Prim     -> cost=" + pr.total_cost + " ops=" + pr.operations_count + " time=" + pr.execution_time_ms + "ms");
                System.out.println("  Kruskal  -> cost=" + kr.total_cost + " ops=" + kr.operations_count + " time=" + kr.execution_time_ms + "ms");
            }

            OutputWriter.writeResults(outputFile, graphs, primResults, kruskalResults);
            System.out.println("Done. Results written to " + outputFile);

            try (java.io.FileWriter csvWriter = new java.io.FileWriter("src/main/java/org/example/summary.csv")) {
                csvWriter.append("Graph ID,Vertices,Edges,Prim Cost,Kruskal Cost,Δ Cost,Prim Time (ms),Kruskal Time (ms),Δ Time (ms),Prim Ops,Kruskal Ops,Δ Ops\n");

                for (Graph g : graphs) {
                    MSTResult pr = primResults.get(g.id);
                    MSTResult kr = kruskalResults.get(g.id);

                    double deltaCost = Math.abs(pr.total_cost - kr.total_cost);
                    double deltaTime = Math.abs(pr.execution_time_ms - kr.execution_time_ms);
                    long deltaOps = Math.abs(pr.operations_count - kr.operations_count);

                    csvWriter.append(String.format(
                            "%d,%d,%d,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%d,%d,%d\n",
                            g.id,
                            g.nodes.size(),
                            g.edges.size(),
                            pr.total_cost,
                            kr.total_cost,
                            deltaCost,
                            pr.execution_time_ms,
                            kr.execution_time_ms,
                            deltaTime,
                            pr.operations_count,
                            kr.operations_count,
                            deltaOps
                    ));
                }
                System.out.println("Summary saved to summary.csv");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
