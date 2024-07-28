import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        DijkstraAlgorithm.dijkstra(graph, 0);
    }
}

class DijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE; // Велике значення, що представляє нескінченність

    public static void dijkstra(int[][] graph, int startVertex) {
        int numVertices = graph.length;
        int[] distance = new int[numVertices];
        boolean[] shortestPathTreeSet = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++) {
            distance[i] = INF;
            shortestPathTreeSet[i] = false;
        }

        distance[startVertex] = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(numVertices, new Comparator<Integer>() {
            public int compare(Integer vertex1, Integer vertex2) {
                return Integer.compare(distance[vertex1], distance[vertex2]);
            }
        });

        priorityQueue.add(startVertex);

        while (!priorityQueue.isEmpty()) {
            int u = priorityQueue.poll();
            shortestPathTreeSet[u] = true;

            for (int v = 0; v < numVertices; v++) {
                if (!shortestPathTreeSet[v] && graph[u][v] != 0 && distance[u] != INF && (distance[u] + graph[u][v] < distance[v])) {
                    distance[v] = distance[u] + graph[u][v];
                    priorityQueue.add(v);
                }
            }
        }

        System.out.println("Вершина\tВідстань від початкової вершини");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(i + "\t" + distance[i]);
        }
    }
}
