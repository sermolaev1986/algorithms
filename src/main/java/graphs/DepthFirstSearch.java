package graphs;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DepthFirstSearch {
    public static void main(String[] args) {
        Graph graph = new Graph(5)
                .addEdge(1, 0)
                .addEdge(0, 2)
                .addEdge(2, 1)
                .addEdge(0, 3)
                .addEdge(1, 4);

        assertThat(graph.dfsRecursive(0), is(Arrays.asList(0, 2, 1, 4, 3)));
        assertThat(graph.dfsIterative(0), is(Arrays.asList(0, 3, 2, 1, 4)));
    }
}
