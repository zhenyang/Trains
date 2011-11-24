package TrainsSystem;

import TrainsSystem.Exception.NoSuchRouteException;

import java.util.List;

public class InformationSystem {

    private Parser parser;
    private Graph graph;
    private TripSearcher tripSearcher;

    public InformationSystem(String graph) {
        parser = new Parser();
        this.graph = parser.parseGraph(graph);
        tripSearcher = new TripSearcher(this.graph);
    }

    public int getDistanceForRoute(String routeStr) throws NoSuchRouteException {
        List<Node> nodes = parser.parseRoute(routeStr);
        return graph.getDistanceForRoute(nodes);
    }

    public int getNumberOfTripsWithinMaxStops(char startName, char endName, int stops) {
        Node start = parser.pareNode(startName);
        Node end = parser.pareNode(endName);
        List<Trip> trips = tripSearcher.getTripsWithinMaxStops(start, end, stops);
        return trips.size();
    }
}
