package TADs;

public interface List <T> {
    
    // Getters
    public T getFirst ();
    public T getLast ();
    public T get (int p);
    public int length ();
    public boolean isEmpty ();

    // Adding methods
    public void append (T x);
    public void prepend (T x);
    public void insert (T x, int p);

    // Deleting methods
    public void removeLast ();
    public void removeFirst ();
    public void delete (int p);

    // Searching
    public int search (T x);
    public T find (T x);

    // Printing
    public void printList ();
}
