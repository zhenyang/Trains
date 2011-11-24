package TrainsSystem;

import TrainsSystem.Exception.NoSuchRouteException;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Edge> edges;

    public List<Edge> getEdges() {
        return edges;
    }

    public Graph(List<Edge> edges) {
        this.edges = edges;
    }

    public int getDistanceForRoute(List<Node> nodes) throws NoSuchRouteException {
        List<Edge> edges = getEdgesFromRoute(nodes);
        int distance = 0;
        for (Edge edge : edges) {
            distance += edge.getDistance();
        }
        return distance;
    }

    private List<Edge> getEdgesFromRoute(List<Node> nodes) throws NoSuchRouteException {
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < nodes.size() - 1; i++) {
            edges.add(getEdgeFromRoute(nodes.get(i), nodes.get(i + 1)));
        }
        return edges;
    }

    private Edge getEdgeFromRoute(Node start, Node end) throws NoSuchRouteException {
        for (Edge edge : edges) {
            if (edge.getStart().equals(start) && edge.getEnd().equals(end)) {
                return edge;
            }
        }
        throw new NoSuchRouteException();
    }
}
