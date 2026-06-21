import java.util.List;
import java.util.LinkedList;

public class DegreesOfSeparation {

    // List field that stores the separation degree of each vertex
    private List<Integer> degreesOfSeparation;

    /**
     * @post Creates a new instance with an empty degrees' separation list
     */
    public DegreesOfSeparation() {
        this.degreesOfSeparation = new LinkedList<Integer>();
    }

    /**
     * @pre 0 <= s < V
     * @post Computa el grado de separación entre s y todos los vértices
     *   restantes del grafo. El grado de separación entre dos vértices
     *   s y v se define como el menor número de aristas que se deben
     *   atravesar para llegar a v desde s.
     */
    public void computeDegreesOfSeparation(AdjacencyListIntGraph G, int s) {
        // Checks the second parameter's validity
        if (s < 0 || G.V() <= s)
            throw new IllegalArgumentException("Vertice fuera de rango");

        // Empty the separations degrees list
        this.degreesOfSeparation.clear();

        // Initialize a boolean array with as many spaces as vertices in G to keep track of marked vertices
        boolean marked[] = new boolean[G.V()];

        // Add separation initial value for each vertex in G. If the vertex is s, init with 0 distance. Otherwise, init with the maximum integer representable
        for (int i = 0; i < G.V(); i++) {
            Integer v = i == s ? 0 : Integer.MAX_VALUE;
            this.degreesOfSeparation.add(v);
        }

        // Initialize an empty queue for a Breadth-First-Search and enqueue the initial vertex
        LinkedQueue<Integer> q = new LinkedQueue<>();
        q.enqueue(s);

        // Compute separation degrees (distance to s) until the queue is empty
        while (!q.isEmpty()) {
            // Dequeue the front element of the queue and get its degree of separation
            int t = q.dequeue();
            int d = degreesOfSeparation.get(t);

            // Mark it as seen
            marked[t] = true;

            // Get t's adjacency list
            List<Integer> neighbors = G.adj(t);

            // Iterate over each neighbour of the vertex
            for (Integer n : neighbors) {
                // If the neighbour is not marked, update its degree of separation and enqueue it
                if (!marked[n]) {
                    // Get the current degree of separation, and update it if a shorter path was finded
                    int dn = degreesOfSeparation.get(n);
                    if (1 + d < dn)
                        degreesOfSeparation.set(n, 1 + d);

                    // Enqueue the neighbour
                    q.enqueue(n);
                }
            }
        }
    }

    /**
     * @pre 0 <= v < V
     * @post Retorna el grado de separación entre el vértice origen s
     *   y el vértice v. El grado de separación entre s y v se define
     *   como el menor número de aristas que se deben atravesar para
     *   llegar a v desde s. Retorna Integer.MAX_VALUE si no hay
     *   camino de s a v.
     */
    public int degreeOfSeparation(int v) {
        // Return the degree of separation stored
        return degreesOfSeparation.get(v);
    }

}