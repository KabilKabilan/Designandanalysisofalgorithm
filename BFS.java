import java.util.*;

public class BFS {
    private Map<Integer, List<Integer>> graph;

    public BFS() {
        graph = new HashMap<>();
    }

    public void addEdge(int u, int v) {
        graph.putIfAbsent(u, new ArrayList<>());
        graph.get(u).add(v);
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        bfs.addEdge(1, 2);
        bfs.addEdge(1, 3);
        bfs.addEdge(2, 4);
        bfs.addEdge(3, 4);

        System.out.print("BFS starting from node 1: ");
        bfs.bfs(1);
    }
}
