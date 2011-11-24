package TrainsSystem;

import java.util.ArrayList;
import java.util.List;

public class TripSearcher {
    private Graph graph;
    private ArrayList<Trip> trips;

    public TripSearcher(Graph graph) {
        this.graph = graph;
    }

    public List<Trip> getTripsWithinMaxStops(Node start, Node end, int stops) {
        trips = new ArrayList<Trip>();
        Trip trip = new Trip(start);
        depthFirstSearchWithinStops(trip, start, end, stops);
        return trips;
    }

    private void depthFirstSearchWithinStops(Trip trip, Node start, Node end, int stops) {
        trip.showRoute();
        if (trip.getStops() > stops) {
            return;
        }
        if (trip.getStops() <= stops && trip.getStartNode().equals(start) && trip.getLastNode().equals(end)) {
            trip.showRoute();
            this.trips.add(trip);
            return;
        }
        List<Edge> edgesStartFrom = graph.getEdgesStartFrom(trip.getLastNode());
        for (Edge edge : edgesStartFrom) {
            Trip newTrip = trip.copy();
            newTrip.addEdge(edge);
            depthFirstSearchWithinStops(newTrip, start, end, stops);
        }
    }
}
