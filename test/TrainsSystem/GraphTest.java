package TrainsSystem;

import TrainsSystem.Exception.NoSuchRouteException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class GraphTest {
    @Test
    public void test_should_has_a_constructor() throws Exception {
        List<Edge> edges = createTwoEdges();

        Graph graph = new Graph(edges);

        assertEquals(2, graph.getEdges().size());
    }

    @Test
    public void test_should_return_distance_for_route() throws Exception {
        Graph graph = new Graph(createTwoEdges());
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node('A'));
        nodes.add(new Node('B'));
        nodes.add(new Node('C'));

        int distance = graph.getDistanceForRoute(nodes);

        assertEquals(9, distance);
    }

    @Test(expected = NoSuchRouteException.class)
    public void test_should_throw_exception_when_get_distance_for_none_exit_route() throws Exception {
        Graph graph = new Graph(createTwoEdges());
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node('C'));
        nodes.add(new Node('A'));

        graph.getDistanceForRoute(nodes);
    }

    private List<Edge> createTwoEdges() {
        List<Edge> edges = new ArrayList<Edge>();
        Edge edge1 = new Edge(new Node('A'), new Node('B'), 5);
        Edge edge2 = new Edge(new Node('B'), new Node('C'), 4);
        edges.add(edge1);
        edges.add(edge2);
        return edges;
    }

}
