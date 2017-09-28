package graphs;

import java.util.*;

public class Graph {
    private int verticesCount;
    private LinkedList<Integer> adjacencyLists[];

    Graph(int verticesCount) {
        this.verticesCount = verticesCount;
        adjacencyLists = new LinkedList[verticesCount];
        for (int i = 0; i < verticesCount; i++) {
            adjacencyLists[i] = new LinkedList<>();
        }
    }

    public Graph addEdge(int r, int s) {
        adjacencyLists[r].add(s);
        return this;
    }

    public List<Integer> bfs(int root) {
        List<Integer> result = new LinkedList<>();

        boolean[] visited = new boolean[verticesCount];
        Queue<Integer> queue = new ArrayDeque<>();

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

    public List<Integer> dfsIterative(int root) {
        List<Integer> result = new LinkedList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[verticesCount];

        stack.push(root);

        while (!stack.isEmpty()) {
            Integer currentVertex = stack.pop();
            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                result.add(currentVertex);
            }

            for (Integer adjacentVertex : adjacencyLists[currentVertex]) {
                if (!visited[adjacentVertex]) {
                    stack.push(adjacentVertex);
                }
            }

        }

        return result;
    }

    public List<Integer> dfsRecursive(int root) {
        List<Integer> result = new LinkedList<>();
        boolean[] visited = new boolean[verticesCount];

        dfsRecursiveVisit(root, visited, result);

        return result;
    }

    private void dfsRecursiveVisit(int currentVertex, boolean[] visited, List<Integer> result) {
        result.add(currentVertex);
        visited[currentVertex] = true;

        for (Integer adjacentVertex : adjacencyLists[currentVertex]) {
            if (!visited[adjacentVertex]) {
                dfsRecursiveVisit(adjacentVertex, visited, result);
            }
        }

    }

}
