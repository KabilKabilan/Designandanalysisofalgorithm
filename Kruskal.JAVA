import java.util.*;

public class Kruskal {
    private class Edge {
        int u, v, weight;
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }

    public void union(int[] parent, int[] rank, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);

        if (rank[xroot] < rank[yroot]) {
            parent[xroot] = yroot;
        } else if (rank[xroot] > rank[yroot]) {
            parent[yroot] = xroot;
        } else {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }

    public void kruskal(int[][] graph, int vertices) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph[i].length; j++) {
                if (graph[i][j] != 0) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        edges.sort(Comparator.comparingInt(e -> e.weight));

        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        List<Edge> result = new ArrayList<>();
        for (Edge edge : edges) {
            int x = find(parent, edge.u);
            int y = find(parent, edge.v);

            if (x != y) {
                result.add(edge);
                union(parent, rank, x, y);
            }
        }

        System.out.println("Edges in the MST:");
        for (Edge edge : result) {
            System.out.println("Edge: (" + edge.u + " - " + edge.v + "), Weight: " + edge.weight);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 4, 0, 0, 0},
            {1, 0, 4, 2, 7, 0},
            {4, 4, 0, 3, 5, 0},
            {0, 2, 3, 0, 4, 6},
            {0, 7, 5, 4, 0, 7},
            {0, 0, 0, 6, 7, 0}
        };
        Kruskal kruskal = new Kruskal();
        kruskal.kruskal(graph, 6);
    }
}
