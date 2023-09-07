import java.util.*;

public class Main {

    public static int dist[];
    public static ArrayList<Integer> settled;

    public static PriorityQueue<Node> pq;

    public static void main(String[] args) {

        ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            adjList.add(new ArrayList<Node>());
        }

        adjList.get(0).add(new Node(1, 1));
        adjList.get(0).add(new Node(7, 2));
        adjList.get(1).add(new Node(0, 1));
        adjList.get(1).add(new Node(2, 1));
        adjList.get(2).add(new Node(1, 1));
        adjList.get(2).add(new Node(3, 1));
        adjList.get(3).add(new Node(2, 1));
        adjList.get(3).add(new Node(4, 1));
        adjList.get(4).add(new Node(3, 1));
        adjList.get(4).add(new Node(5, 1));
        adjList.get(5).add(new Node(4, 1));
        adjList.get(5).add(new Node(6, 1));
        adjList.get(6).add(new Node(5, 1));
        adjList.get(6).add(new Node(7, 1));
        adjList.get(7).add(new Node(6, 1));
        adjList.get(7).add(new Node(0, 2));


        for (int i = 0; i < 8; i++) {
            System.out.println(i + " " + adjList.get(i).toString());
        }

        dijkstra(adjList, 0);

        System.out.println(Arrays.toString(dist));
    }

    public static void dijkstra(ArrayList<ArrayList<Node>> adjList, int s) {
        settled = new ArrayList<>();
        dist = new int[adjList.size()];
        pq = new PriorityQueue<Node>(adjList.size(), new Node());

        for (int i = 0; i < adjList.size(); i++)
            dist[i] = Integer.MAX_VALUE;

        pq.add(new Node(s, 0));

        dist[s] = 0;

        while (settled.size() != adjList.size()) {

            if (pq.isEmpty()) return;

            int u = pq.remove().node;

            if (settled.contains(u)) continue;

            settled.add(u);

            greedyCriterion(adjList, u);
        }

    }

    public static void greedyCriterion(ArrayList<ArrayList<Node>> adjList, int u) {

        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adjList.get(u).size(); i++) {
            Node v = adjList.get(u).get(i);

            // If current node hasn't already been processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                // Add the current node to the queue
                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }
}

class Node implements Comparator<Node> {

    // Member variables of this class
    public int node;
    public int cost;

    // Constructors of this class

    // Constructor 1
    public Node() {}

    // Constructor 2
    public Node(int node, int cost)
    {

        // This keyword refers to current instance itself
        this.node = node;
        this.cost = cost;
    }

    // Method 1
    @Override public int compare(Node node1, Node node2)
    {

        if (node1.cost < node2.cost)
            return -1;

        if (node1.cost > node2.cost)
            return 1;

        return 0;
    }
}
