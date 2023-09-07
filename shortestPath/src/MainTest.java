import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest extends Main {

    @Test
    public void node1ShouldHaveShortestPathOf1() {
        String[] args = {"0", "1"};

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

        int distance = shortestPath(adjList, 0, 1);
        assertEquals(1, distance);
    }

    @Test
    public void node2ShouldHaveShortestPathOf1() {
        String[] args = {"0", "1"};

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

        int distance = shortestPath(adjList, 0, 2);
        assertEquals(1, distance);
    }

    @Test
    public void node25ShouldHaveShortestPathOf5() {
        String[] args = {"0", "1"};

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

        int distance = shortestPath(adjList, 0, 25);
        assertEquals(5, distance);
    }

    @Test
    public void node0ShouldHaveShortestPathOf0() {
        String[] args = {"0", "1"};

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

        int distance = shortestPath(adjList, 0, 0);
        assertEquals(0, distance);
    }
}