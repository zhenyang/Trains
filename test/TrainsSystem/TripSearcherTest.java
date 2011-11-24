package TrainsSystem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class TripSearcherTest {
    @Test
    public void test_should_return_trip_with_in_max_stops() throws Exception {
        Graph graph = new Graph(createEdges("AB3,AD3,BD3,DC3"));
        TripSearcher tripSearcher = new TripSearcher(graph);
        List<Trip> trips = tripSearcher.getTripsWithinMaxStops(new Node('A'), new Node('C'), 3);

        assertEquals(2, trips.size());

    }

    private List<Edge> createEdges(String edgesParam) {
        List<Edge> edges = new ArrayList<Edge>();
        String[] strEdges = edgesParam.split(",");
        for (String strEdge : strEdges) {
            Node start = new Node(strEdge.charAt(0));
            Node end = new Node(strEdge.charAt(1));
            int distance = Integer.parseInt(strEdge.substring(2));
            Edge edge = new Edge(start, end, distance);
            edges.add(edge);
        }
        return edges;
    }
}
