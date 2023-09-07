import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main (String[] args) {

        ArrayList<LinkedList<Integer>> adjList = new ArrayList<LinkedList<Integer>>();

        for (int i = 0; i < 35; i++) {
            adjList.add(new LinkedList<Integer>());
        }

        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(3);
        adjList.get(1).add(4);
        adjList.get(1).add(5);
        adjList.get(2).add(6);
        adjList.get(3).add(7);
        adjList.get(3).add(8);
        adjList.get(5).add(9);
        adjList.get(6).add(10);
        adjList.get(6).add(11);
        adjList.get(7).add(12);
        adjList.get(7).add(13);
        adjList.get(9).add(14);
        adjList.get(9).add(15);
        adjList.get(9).add(16);
        adjList.get(11).add(17);
        adjList.get(11).add(18);
        adjList.get(11).add(19);
        adjList.get(11).add(20);
        adjList.get(12).add(21);
        adjList.get(12).add(22);
        adjList.get(12).add(23);
        adjList.get(13).add(24);
        adjList.get(15).add(25);
        adjList.get(19).add(26);
        adjList.get(20).add(27);
        adjList.get(20).add(28);
        adjList.get(21).add(29);
        adjList.get(24).add(30);
        adjList.get(24).add(31);
        adjList.get(27).add(32);
        adjList.get(29).add(33);
        adjList.get(33).add(34);

        int numberOfClusters = undirectedConnectivity(adjList);
        System.out.println(numberOfClusters);
    }

    public static int undirectedConnectivity(ArrayList<LinkedList<Integer>> adjList) {
        int length = adjList.size();
        Boolean[] visited = new Boolean[length];
        for (int i = 0; i < length; i++) {
            visited[i] = false;
        }
        int numberOfClusters = 0;
        for (int i = 0; i < length; i++) {
            if (visited[i] == false) {
                bFS(adjList, visited, i);
                numberOfClusters++;
            }
        }
        return numberOfClusters;
    }

    public static void bFS(ArrayList<LinkedList<Integer>> adjList, Boolean[] visited, int s) {
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(s);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            visited[currentNode] = true;

            for (int i = 0; i < adjList.get(currentNode).size(); i++) {
                if (!visited[adjList.get(currentNode).get(i)]) {
                    visited[adjList.get(currentNode).get(i)] = true;
                    queue.add(adjList.get(currentNode).get(i));
                }
            }
        }
    }
}
