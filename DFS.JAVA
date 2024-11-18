import java.util.*;

public class DFS {
    private Map<Integer, List<Integer>> graph;

    public DFS() {
        graph = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(v);
    }

    public void dfs(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        dfs.addEdge(1, 2);
        dfs.addEdge(1, 3);
        dfs.addEdge(2, 4);
        dfs.addEdge(3, 4);

        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS starting from node 1: ");
        dfs.dfs(1, visited);
    }
}
