# Assignment 3 — Optimization of a City Transportation Network (Minimum Spanning Tree)

This project compares two algorithms for building a **Minimum Spanning Tree (MST)**: **Prim’s Algorithm** and **Kruskal’s Algorithm**.  
The goal is to connect all city districts with the **minimum total road cost**.

---

## 📁 Project Structure

src/
    └── main/

└── java/

└── org/example/
├── Main.java
├── Graph.java
├── Edge.java
├── MSTAlgorithms.java
├── InputParser.java
├── OutputWriter.java
├── MSTResult.java
├── MSTTests.java
├── input.json
├── output.json
└── summary.csv


---

## 🧩 File Description

- **Main.java** — runs the program and calls both algorithms.  
- **Graph.java / Edge.java** — describe the graph structure.  
- **MSTAlgorithms.java** — contains Prim’s and Kruskal’s algorithms.  
- **InputParser.java** — reads data from `input.json`.  
- **OutputWriter.java** — writes results to `output.json` and `summary.csv`.  
- **MSTResult.java** — stores algorithm results.  
- **MSTTests.java** — automated tests for correctness and performance.  
- **input.json** — input file with graph data.  
- **output.json** — output file with algorithm results.  
- **summary.csv** — comparison of algorithm performance.

---

## 📊 Example of Summary Results

| Graph ID | Vertices | Edges | Prim Cost | Kruskal Cost | Δ Cost | Prim Time (ms) | Kruskal Time (ms) | Δ Time (ms) | Prim Ops | Kruskal Ops | Δ Ops |
|-----------|-----------|--------|------------|---------------|---------|----------------|-------------------|--------------|-------------|-------------|
| 1 | 4 | 5 | 6.00 | 6.00 | 0.00 | 4.40 | 1.00 | 3.40 | 3 | 3 | 0 |
| 2 | 10 | 13 | 38.00 | 38.00 | 0.00 | 0.07 | 0.03 | 0.04 | 11 | 11 | 0 |
| 3 | 27 | 31 | 108.00 | 108.00 | 0.00 | 0.15 | 0.16 | 0.01 | 26 | 26 | 0 |

---

## 🧠 Explanation

- Both algorithms gave the **same MST cost**.  
- **Kruskal’s Algorithm** was slightly faster on small graphs.  
- **Prim’s Algorithm** performed almost the same on larger graphs.  
- The program measures both **execution time (ms)** and **operation count** for comparison.  

---

## ▶️ How to Run

1. Open the project in **IntelliJ IDEA** or **VS Code**.  
2. Make sure `input.json` is located in `src/main/java/org/example/`.  
3. Run the **Main** class.  
4. Results will be automatically saved to:
   - `output.json`
   - `summary.csv`

---

## 📈 Summary

- Both algorithms find the same **minimum total cost**.  
- **Kruskal’s Algorithm** is faster for **small and simple graphs**.  
- **Prim’s Algorithm** performs better for **large and dense graphs**.  
- Both are correct and useful for **city transportation optimization**.


