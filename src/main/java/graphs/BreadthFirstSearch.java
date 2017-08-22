package graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        Graph graph = new Graph(4)
                .addEdge(0, 1)
                .addEdge(0, 2)
                .addEdge(1, 2)
                .addEdge(2, 0)
                .addEdge(2, 3)
                .addEdge(3, 3);

        assertThat(graph.bfs(2), is(Arrays.asList(2, 0, 3, 1)));


    }
}

class Graph {
    private int verticesCount;
    private LinkedList<Integer> adjacencyLists[];

    Graph(int verticesCount) {
        this.verticesCount = verticesCount;
        adjacencyLists = new LinkedList[verticesCount];
        for (int i = 0; i < verticesCount; i++) {
            adjacencyLists[i] = new LinkedList<Integer>();
        }
    }

    public Graph addEdge(int r, int s) {
        adjacencyLists[r].add(s);
        return this;
    }

    public List<Integer> bfs(int root) {
        List<Integer> result = new LinkedList<Integer>();

        boolean[] visited = new boolean[verticesCount];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        //mark root as visited and enqueue it
        visited[root] = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            result.add(currentVertex);

            //get all adjacent vertices of current vertex
            for (Integer adjacentVertex : adjacencyLists[currentVertex]) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    queue.add(adjacentVertex);
                }
            }

        }

        return result;
    }
}
