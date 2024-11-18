import java.util.*;

public class Dijkstra {
    public void dijkstra(Map<Integer, Map<Integer, Integer>> graph, int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        // Initialize distances
        for (Integer node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

        while (!pq.isEmpty()) {
            int currentNode = pq.poll().getKey();

            for (Map.Entry<Integer, Integer> neighbor : graph.get(currentNode).entrySet()) {
                int neighborNode = neighbor.getKey();
                int edgeWeight = neighbor.getValue();
                int newDist = distances.get(currentNode) + edgeWeight;

                if (newDist < distances.get(neighborNode)) {
                    distances.put(neighborNode, newDist);
                    pq.add(new AbstractMap.SimpleEntry<>(neighborNode, newDist));
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from node " + start + ":");
        for (Map.Entry<Integer, Integer> entry : distances.entrySet()) {
            System.out.println("Node " + entry.getKey() + " - Distance: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        graph.put(1, Map.of(2, 1, 3, 4));
        graph.put(2, Map.of(1, 1, 3, 2));
        graph.put(3, Map.of(1, 4, 2, 2));

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph, 1);
    }
}
