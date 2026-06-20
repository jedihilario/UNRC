import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DegreesOfSeparationTest1 {

    static AdjacencyListIntGraph G;

    static DegreesOfSeparation d;

    @BeforeAll
    public static void setup() {
        G = new AdjacencyListIntGraph(8);
        G.addEdge(0, 5);
        G.addEdge(4, 3);
        G.addEdge(0, 1);
        G.addEdge(6, 4);
        G.addEdge(5, 4);
        G.addEdge(0, 2);
        G.addEdge(4, 7);

        d = new DegreesOfSeparation();
        d.computeDegreesOfSeparation(G, 0);
    }

    @Test
    public void test1() {
        assertEquals(0, d.degreeOfSeparation(0));
        assertEquals(1, d.degreeOfSeparation(1));
        assertEquals(1, d.degreeOfSeparation(2));
        assertEquals(3, d.degreeOfSeparation(3));
        assertEquals(2, d.degreeOfSeparation(4));
        assertEquals(1, d.degreeOfSeparation(5));
        assertEquals(3, d.degreeOfSeparation(6));
        assertEquals(3, d.degreeOfSeparation(7));
    }

}
