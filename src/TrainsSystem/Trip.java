package TrainsSystem;

import java.util.ArrayList;
import java.util.List;

public class Trip {
    private Node start;
    private List<Edge> edges;

    public Trip(Node start) {
        this(start, new ArrayList<Edge>());
    }

    public Trip(Node start, List<Edge> edges) {
        this.start = start;
        this.edges = edges;
    }

    public int getStops() {
        System.out.println(edges.size());
        return edges.size();
    }

    public Node getLastNode() {
        if (edges.size() == 0) {
            return start;
        }
        return edges.get(edges.size() - 1).getEnd();
    }

    public Trip copy() {
        return new Trip(this.start, this.edges);
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public void showRoute() {
        String route = "";
        for (Edge edge : edges) {
            route += edge.getStart().getName() + "-->" + edge.getEnd().getName() + " | ";
        }
        System.out.println(route);
    }

    public Node getStartNode() {
        return this.start;
    }
}
