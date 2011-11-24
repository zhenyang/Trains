package TrainsSystem;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public Graph parseGraph(String inputGraph) {
        String[] inputEdges = inputGraph.split(", ");

        return new Graph(parseEdges(inputEdges));
    }

    public List<Node> parseRoute(String route) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        String[] nodeNames = route.split("-");
        for (String nodeName : nodeNames) {
             nodes.add(new Node(nodeName.charAt(0)));
        }
        return nodes;
    }

    private List<Edge> parseEdges(String[] inputEdges) {
        List<Edge> edges = new ArrayList<Edge>();
        for (String inputEdge : inputEdges) {
            edges.add(parseEdge(inputEdge));
        }
        return edges;
    }

    private Edge parseEdge(String inputEdge) {
        Node start = new Node(inputEdge.charAt(0));
        Node end = new Node(inputEdge.charAt(1));
        int distance = Integer.parseInt(inputEdge.substring(2));

        return new Edge(start, end, distance);
    }
}
