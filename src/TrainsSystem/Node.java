package TrainsSystem;

public class Node {
    private char name;

    public Node(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (name != node.name) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) name;
    }
}
