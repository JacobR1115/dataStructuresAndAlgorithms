import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static int V = 5;
    static class Edge {
        int v;
        int u;
        int wt;

        Edge(int v, int u, int wt) {
            this.v = v;
            this.u = u;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int v;
        int u;
        int wt;

        Pair(int v, int u, int wt) {
            this.v = v;
            this.u = u;
            this.wt = wt;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();

        for (int i = 0; i < 4; i++) {
            graph.add(new ArrayList<Edge>());
        }

        graph.get(0).add(new Edge(0, 1, 3));
        graph.get(0).add(new Edge(0, 2, 5));
        graph.get(0).add(new Edge(0, 3, 2));
        graph.get(1).add(new Edge(1, 0, 3));
        graph.get(1).add(new Edge(1, 2, 2));
        graph.get(2).add(new Edge(2, 0, 5));
        graph.get(2).add(new Edge(2, 1, 2));
        graph.get(2).add(new Edge(2, 3, 6));
        graph.get(3).add(new Edge(3, 0, 2));
        graph.get(3).add(new Edge(3, 2, 6));


        int minCost = mst(graph);
        System.out.println(minCost);
    }

    public static int mst(ArrayList<ArrayList<Edge>> graph) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, -1, 0));
        boolean[] visited = new boolean[4];
        int sum = 0;

        while(pq.size() > 0) {
            Pair rem = pq.remove();

            if (visited[rem.v]) continue;
            visited[rem.v] = true;

            sum += rem.wt;

            for (int i = 0; i < graph.get(rem.v).size(); i++) {
                if (!visited[graph.get(rem.v).get(i).u]) {
                    pq.add(new Pair(graph.get(rem.v).get(i).u, rem.v, graph.get(rem.v).get(i).wt));
                }
            }
        }
        return sum;
    }
}
