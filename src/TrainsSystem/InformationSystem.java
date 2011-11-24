package TrainsSystem;

import TrainsSystem.Exception.NoSuchRouteException;

import java.util.List;

public class InformationSystem {

    private Parser parser;
    private Graph graph;

    public InformationSystem(String graph) {
        parser = new Parser();
        this.graph = parser.parseGraph(graph);
    }

    public int getDistanceForRoute(String routeStr) throws NoSuchRouteException {
        List<Node> nodes = parser.parseRoute(routeStr);
        return graph.getDistanceForRoute(nodes);
    }
}
