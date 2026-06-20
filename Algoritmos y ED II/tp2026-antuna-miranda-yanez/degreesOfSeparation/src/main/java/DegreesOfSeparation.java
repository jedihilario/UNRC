import java.util.List;
import java.util.LinkedList;

public class DegreesOfSeparation {

    private List<Integer> degreesOfSeparation;

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
        if (s < 0 || G.V() <= s)
            throw new IllegalArgumentException("Vertice fuera de rango");

        this.degreesOfSeparation.clear();

        boolean marked[] = new boolean[G.V()];

        for (int i = 0; i < G.V(); i++) {
            Integer v = i == s ? 0 : Integer.MAX_VALUE;
            this.degreesOfSeparation.add(v);
        }

        LinkedQueue<Integer> q = new LinkedQueue<>();
        q.enqueue(s);

        while (!q.isEmpty()) {
            int t = q.dequeue();
            int d = degreesOfSeparation.get(t);
            marked[t] = true;

            List<Integer> neighbors = G.adj(t);

            for (Integer n : neighbors) {
                if (!marked[n]) {
                    int dn = degreesOfSeparation.get(n);
                    if (1 + d < dn)
                        degreesOfSeparation.set(n, 1 + d);
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
        return degreesOfSeparation.get(v);
    }

}