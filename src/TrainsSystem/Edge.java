package TrainsSystem;

public class Edge {
    private Node start;
    private Node end;
    private int distance;

    public Edge(Node start, Node end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public int getDistance() {
        return distance;
    }
}
