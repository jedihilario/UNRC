import java.util.LinkedList;
import java.util.List;

/**
 *  AdjacencyListGraph implements an undirected graph.
 *  Formally, a graph G=<V,E> consists of a set of vertices V,
 *  and a relation E in VxV that describes the edges of the graph.
 *
 *  This implementation uses an adjacency-lists representation, which
 *  is a vertex-indexed array of List objects.
 */
public class AdjacencyListIntGraph {
    // Number of vertices in the graph
    private final int V;
    // Number of edges in the graph
    private int E;
    // Adjacency lists
    private List<Integer>[] adj;

    /**
     * @pre V>=0
     * @post Initializes a graph with V vertices and 0 edges
     */
    @SuppressWarnings("unchecked")
    public AdjacencyListIntGraph(int V) {
        this.V = V;
        this.E = 0;

        this.adj = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            this.adj[i] = new LinkedList<Integer>();
        }
    }

    /**
     * @post Initializes a new graph that is a deep copy of G.
     */
    @SuppressWarnings("unchecked")
    public AdjacencyListIntGraph(AdjacencyListIntGraph G) {
        this.V = G.V();
        this.E = G.E();

        this.adj = new LinkedList[this.V];

        for (int i = 0; i < this.V; i++) {
            this.adj[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < this.V; i++) {
            List<Integer> copy = G.adj(i);
            this.adj[i].addAll(copy);
        }
    }

    /**
     * @post Returns the number of vertices in this graph.
     */
    public int V() {
        return V;
    }

    /**
     * @post Returns the number of edges in this graph.
     */
    public int E() {
        return E;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * @pre 0 <= v < V && 0 <= w < V
     * @post Adds the undirected edge v-w to this graph.
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);

        this.adj[v].add(w);
        this.adj[w].add(v);
        this.E++;
    }

    /**
     * @pre 0 <= v < V
     * @post Returns the list of vertices adjacent to vertex v.
     */
    public List<Integer> adj(int v) {
        validateVertex(v);

        List<Integer> copy = new LinkedList<>();
        copy.addAll(this.adj[v]);

        return copy;
    }

    /**
     * @pre 0 <= v < V && 0 <= w < V
     * @post Returns true iff there is an edge from v to w.
     */
    public boolean existsEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);

        return this.adj[v].contains(w);
    }

    /**
     * @pre 0 <= v < V
     * @post Returns the degree of vertex v.
     */
    public int degree(int v) {
        validateVertex(v);

        return this.adj[v].size();
    }

    /**
     * @post Returns a string representation of this graph.
     */
    public String toString() {
        String s = "";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : adj[v]) {
                s += w + " ";
            }
            s += '\n';
        }
        return s;
    }

}
