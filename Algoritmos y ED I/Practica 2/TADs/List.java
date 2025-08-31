package TADs;

public interface List <T> {

    // Adding methods
    void append (T x);
    void prepend (T x);
    void insert (T x, int i);

    // Deleting methods
    void removeLast ();
    void removeFirst ();
    void delete (int i);

    // Getters
    T getFirst ();
    T getLast ();
    T get (int i);
    int length ();
    boolean isEmpty ();

    // Searching
    int search (T x);
    T find (T x);

    // Printing
    void printList ();
}
