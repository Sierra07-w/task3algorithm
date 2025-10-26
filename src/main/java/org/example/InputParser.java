package org.example;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InputParser {


    public static List<Graph> readGraphs(String filePath) throws Exception {
        List<Graph> graphs = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray garr = (JSONArray) root.get("graphs");
            for (Object go : garr) {
                JSONObject gj = (JSONObject) go;
                long idLong = (Long) gj.get("id");
                int id = (int) idLong;

      
                List<String> nodes = new ArrayList<>();
                JSONArray nodesArr = (JSONArray) gj.get("nodes");
                for (Object no : nodesArr) nodes.add((String) no);

             
                List<Edge> edges = new ArrayList<>();
                JSONArray edgesArr = (JSONArray) gj.get("edges");
                for (Object eo : edgesArr) {
                    JSONObject ej = (JSONObject) eo;
                    String from = (String) ej.get("from");
                    String to = (String) ej.get("to");
                    Number wNum = (Number) ej.get("weight");
                    double weight = wNum.doubleValue();
                    edges.add(new Edge(from, to, weight));
                }

                graphs.add(new Graph(id, nodes, edges));
            }
        }
        return graphs;
    }
}
