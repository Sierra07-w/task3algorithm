package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.util.List;

public class OutputWriter {

    @SuppressWarnings("unchecked")
    public static void writeResults(String filePath, List<Graph> graphs,
                                    java.util.Map<Integer, MSTResult> primResults,
                                    java.util.Map<Integer, MSTResult> kruskalResults) throws Exception {

        JSONObject root = new JSONObject();
        JSONArray results = new JSONArray();

        for (Graph g : graphs) {
            JSONObject gobj = new JSONObject();
            gobj.put("graph_id", g.id);

            JSONObject inputStats = new JSONObject();
            inputStats.put("vertices", g.nodes.size());
            inputStats.put("edges", g.edges.size());
            gobj.put("input_stats", inputStats);

            // Prim
            MSTResult pr = primResults.get(g.id);
            gobj.put("prim", mstResultToJson(pr));

            // Kruskal
            MSTResult kr = kruskalResults.get(g.id);
            gobj.put("kruskal", mstResultToJson(kr));

            results.add(gobj);
        }

        root.put("results", results);

        try (FileWriter fw = new FileWriter(filePath)) {
            fw.write(root.toJSONString());
        }
    }

    @SuppressWarnings("unchecked")
    private static JSONObject mstResultToJson(MSTResult r) {
        JSONObject ro = new JSONObject();
        JSONArray edges = new JSONArray();
        for (Edge e : r.mst_edges) {
            JSONObject eo = new JSONObject();
            eo.put("from", e.from);
            eo.put("to", e.to);
            eo.put("weight", e.weight);
            edges.add(eo);
        }
        ro.put("mst_edges", edges);
        ro.put("total_cost", r.total_cost);
        ro.put("operations_count", r.operations_count);
        ro.put("execution_time_ms", r.execution_time_ms);
        return ro;
    }
}
