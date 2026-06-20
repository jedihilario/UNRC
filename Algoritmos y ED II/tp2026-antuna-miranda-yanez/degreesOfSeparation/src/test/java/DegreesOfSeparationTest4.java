import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DegreesOfSeparationTest4 {

    static AdjacencyListIntGraph G;

    static DegreesOfSeparation d;

    @BeforeAll
    public static void setup() {
        G = new AdjacencyListIntGraph(12);

        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1, 3);
        G.addEdge(2, 3);
        G.addEdge(3, 4);
        G.addEdge(4, 5);


        G.addEdge(6, 7);
        G.addEdge(7, 8);
        G.addEdge(8, 9);

        
        G.addEdge(10, 11);

        d = new DegreesOfSeparation();
        d.computeDegreesOfSeparation(G, 3);
    }

    @Test
    public void test1() {
        assertEquals(2, d.degreeOfSeparation(0));
        assertEquals(1, d.degreeOfSeparation(1));
        assertEquals(1, d.degreeOfSeparation(2));
        assertEquals(0, d.degreeOfSeparation(3));
        assertEquals(1, d.degreeOfSeparation(4));
        assertEquals(2, d.degreeOfSeparation(5));
        assertEquals(Integer.MAX_VALUE, d.degreeOfSeparation(6));
        assertEquals(Integer.MAX_VALUE, d.degreeOfSeparation(7));
        assertEquals(Integer.MAX_VALUE, d.degreeOfSeparation(8));
        assertEquals(Integer.MAX_VALUE, d.degreeOfSeparation(9));
        assertEquals(Integer.MAX_VALUE, d.degreeOfSeparation(10));
        assertEquals(Integer.MAX_VALUE, d.degreeOfSeparation(11));
    }

}
