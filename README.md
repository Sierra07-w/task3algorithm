# Assignment 3 — Optimization of a City Transportation Network (Minimum Spanning Tree)

## 1. Summary of Input Data and Algorithm Results

This project finds the **Minimum Spanning Tree (MST)** of a city transportation network using **Prim’s** and **Kruskal’s** algorithms.  
The graph is read from a JSON file, where:
- **Vertices** are city districts,
- **Edges** are possible roads,
- **Weights** are construction costs.

The program reads the data, runs both algorithms, and saves results in JSON and CSV files.  
Each result includes:
- Total MST cost  
- Execution time (in milliseconds)  
- Operation count (comparisons, unions, etc.)

Example results from `summary.csv`:

| Graph ID | Vertices | Edges | Prim Cost | Kruskal Cost | Prim Time (ms) | Kruskal Time (ms) | Prim Ops | Kruskal Ops |
|-----------|-----------|--------|------------|---------------|----------------|-------------------|-----------|---------------|
| 1 | 4 | 5 | 6 | 6 | 4.40 | 1.00 | 3 | 3 |
| 2 | 10 | 13 | 38 | 38 | 0.07 | 0.03 | 11 | 11 |
| 3 | 27 | 31 | 108 | 108 | 0.15 | 0.16 | 26 | 26 |

The MST total cost is the same for both algorithms, which means both are correct.

---

## 2. Comparison Between Prim’s and Kruskal’s Algorithms

### Theoretical Comparison
| Aspect | Prim’s Algorithm | Kruskal’s Algorithm |
|--------|------------------|---------------------|
| Idea | Grows one tree by adding the smallest edge that connects a new vertex | Sorts all edges and adds the smallest edge that doesn’t make a cycle |
| Data Structure | Priority Queue (Min-Heap) | Disjoint Set (Union-Find) |
| Time Complexity | O(E log V) | O(E log E) |
| Best for | Dense graphs | Sparse graphs |

### Practical Comparison
- On **small graphs**, both algorithms have almost the same execution time.  
- On **dense graphs**, **Prim’s algorithm** is a bit faster.  
- On **sparse graphs**, **Kruskal’s algorithm** performs slightly better.  
- The number of operations is very similar for both.

---

## 3. Conclusions

Both algorithms create the same MST with the same total cost.  
However:
- **Prim’s algorithm** is usually better when the graph is **dense** (many edges).  
- **Kruskal’s algorithm** is better for **sparse** graphs (fewer edges).  
- Prim’s algorithm uses a priority queue and can be a bit harder to implement.  
- Kruskal’s algorithm is easier to code and understand.

In this project, both algorithms worked correctly and efficiently for all datasets.

---

## 4. References
- GeeksforGeeks — *Minimum Spanning Tree | Prim’s and Kruskal’s Algorithms*  
- Cormen, Leiserson, Rivest, Stein — *Introduction to Algorithms (CLRS)*

