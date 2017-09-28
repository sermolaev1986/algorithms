package graphs;

import java.util.Arrays;

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
