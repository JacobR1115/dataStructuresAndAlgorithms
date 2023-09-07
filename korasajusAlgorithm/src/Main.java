import java.util.*;

public class Main {

    public static int s = -1;

    public static void main(String[] args) {
        // Create Adjacency List
        ArrayList<LinkedList<Integer>> adjList = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < 7; i++) {
            adjList.add(new LinkedList<Integer>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(1).add(3);
        adjList.get(2).add(0);
        adjList.get(3).add(4);
        adjList.get(4).add(5);
        adjList.get(5).add(6);
        adjList.get(6).add(4);


        Boolean[] visited = new Boolean[adjList.size()];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        int startNode = 0;

        // first pass will be done on the reversed graph and will return the finishing times t
        int scc = korasaju(adjList, visited);
        System.out.println(scc);
    }

    public static int korasaju(ArrayList<LinkedList<Integer>> adjList, Boolean[] visited) {
        Stack<Integer> finishingTime = new Stack<>();

        // First run through of DFS
        for (int i = 0; i < adjList.size(); i++) {
            dFS1(adjList, visited, finishingTime, 0);
        }

        // reverse the tree
        ArrayList<LinkedList<Integer>> reversedAdjList = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < adjList.size(); i++) {
            reversedAdjList.add(new LinkedList<>());
        }
        for (int i = 0; i < adjList.size(); i++) {
            visited[i] = false;
            for (int node: adjList.get(i)) {
                reversedAdjList.get(node).add(i);
            }
        }

        // Key will be the leader, values will be the node
        int scc = 0;
        while (!finishingTime.isEmpty()) {
            int currentNode = finishingTime.pop();
            if (!visited[currentNode]) {
                scc++;
                dFS2(reversedAdjList, visited, currentNode);
            }
        }
        return scc;
    }

    public static void dFS1(ArrayList<LinkedList<Integer>> adjList, Boolean[] visited, Stack<Integer> finishingTime, int s) {
        visited[s] = true;

        for (int v: adjList.get(s)) {
            if (!visited[v]) {
                dFS1(adjList, visited, finishingTime, v);
            }
        }
        finishingTime.add(s);
    }
    public static void dFS2(ArrayList<LinkedList<Integer>> reversedAdjList, Boolean[] visited, int s) {
        visited[s] = true;

        for (int v: reversedAdjList.get(s)) {
            if (!visited[v]) {
                dFS2(reversedAdjList, visited, v);
            }
        }
    }
}
