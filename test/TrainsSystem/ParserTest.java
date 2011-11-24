package TrainsSystem;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class ParserTest {

    private Parser parser;

    @Before
    public void setUp() throws Exception {
        parser = new Parser();
    }

    @Test
    public void test_should_parse_edge_string_to_graph_object() throws Exception {
        Graph graph = parser.parseGraph("AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7");

        assertEquals(9, graph.getEdges().size());
    }

    @Test
    public void test_should_parse_route() throws Exception {
        List<Node> nodes = parser.parseRoute("A-B-C");

        assertEquals(3,nodes.size());
    }
}
