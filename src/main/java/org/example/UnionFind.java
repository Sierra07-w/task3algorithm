package org.example;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {
    private Map<String, String> parent = new HashMap<>();

    public void makeSet(String v) {
        parent.put(v, v);
    }

    public String find(String v) {
        String p = parent.get(v);
        if (p == null) return null;
        if (p.equals(v)) return v;
        String root = find(p);
        parent.put(v, root);
        return root;
    }

    public boolean union(String a, String b) {
        String ra = find(a);
        String rb = find(b);
        if (ra == null || rb == null) return false;
        if (ra.equals(rb)) return false;
        parent.put(ra, rb);
        return true;
    }
}
