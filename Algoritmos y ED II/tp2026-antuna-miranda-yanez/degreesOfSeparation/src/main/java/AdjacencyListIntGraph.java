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
        // Check the precondition
        if (V < 0)
            throw new IllegalArgumentException("The amount of vertices must be non-negative");

        // Initialize with V vertices and no edges
        this.V = V;
        this.E = 0;

        // Initialize empty adjacency list (null lists for each vertex)
        this.adj = new LinkedList[V];

        // Create an empty list for each vertex
        for (int i = 0; i < V; i++) {
            this.adj[i] = new LinkedList<Integer>();
        }
    }

    /**
     * @post Initializes a new graph that is a deep copy of G.
     */
    @SuppressWarnings("unchecked")
    public AdjacencyListIntGraph(AdjacencyListIntGraph G) {
        // Initialize V and E with the amount of vertices and edges of the parameter
        this.V = G.V();
        this.E = G.E();

        // Initialize empty adjacency list
        this.adj = new LinkedList[this.V];

        // Create an empty list for each vertex
        for (int i = 0; i < this.V; i++) {
            this.adj[i] = new LinkedList<Integer>();
        }
        
        // For each vertex, get the corresponding adj. list in G and add all neighbours to the adjacency list
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
        // Check that both parameters are valid vertices
        validateVertex(v);
        validateVertex(w);

        // Add both edges from one parameter to another
        this.adj[v].add(w);
        this.adj[w].add(v);

        // Increment the amount of edges
        this.E++;
    }

    /**
     * @pre 0 <= v < V
     * @post Returns the list of vertices adjacent to vertex v.
     */
    public List<Integer> adj(int v) {
        // Check valid parameter
        validateVertex(v);

        // Create a new list to return
        List<Integer> copy = new LinkedList<>();
        // Get the adjecency list and add all vertices to the copy list
        copy.addAll(this.adj[v]);

        // Return the copy
        return copy;
    }

    /**
     * @pre 0 <= v < V && 0 <= w < V
     * @post Returns true iff there is an edge from v to w.
     */
    public boolean existsEdge(int v, int w) {
        // Check valid parameters
        validateVertex(v);
        validateVertex(w);

        // Verify if the adjacency list of v contains w, and return the result
        return this.adj[v].contains(w);
    }

    /**
     * @pre 0 <= v < V
     * @post Returns the degree of vertex v.
     */
    public int degree(int v) {
        // Verify valid parameter
        validateVertex(v);

        // Return the amount of elements in v's adjacency list
        return this.adj[v].size();
    }

    /**
     * @post Returns a string representation of this graph.
     */
    public String toString() {
        // Initialize a new string
        String s = "";

        // Iterate over each vertex
        for (int v = 0; v < V; v++) {
            // Add the number of vertex
            s += v + ": ";

            // Add each vertex w with and edge from v to w
            for (int w : adj[v]) {
                s += w + " ";
            }

            // Add a breakline character
            s += '\n';
        }
        return s;
    }

}
