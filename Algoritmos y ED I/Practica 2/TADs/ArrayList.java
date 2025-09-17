package TADs;

public class ArrayList<T> implements List<T> {
    private int size;
    private T[] arr;
    private int last;

    @SuppressWarnings("unchecked")
    public ArrayList (int l) {
        this.size = l;
        this.last = 0;
        this.arr = (T[]) new Object[l];
    }

    // Getters

    public T getFirst () {
        return this.arr[0];
    }

    public T getLast () {
        return this.arr[last - 1];
    }

    public T get (int i) {
        return this.arr[i];
    }

    public int length () {
        return this.last;
    }

    public boolean isEmpty () {
        return this.size == 0;
    }

    // Adding methods

    public void append (T x) {
        assert this.size - this.last > 0;

        this.arr[last] = x;
        this.last++;
    }

    public void prepend (T x) {
        assert this.size - this.last > 0;

        for (int i = last - 1; i >= 0; i++) {
            this.arr[i + 1] = this.arr[i];
        }

        this.arr[0] = x;
        this.last++;
    }

    public void insert (T x, int p) {
        assert 0 <= p && p < this.size;
        assert this.size - this.last > 0;

        for (int i = last - 1; i >= p; i++) {
            this.arr[i + 1] = this.arr[i];
        }

        this.arr[p] = x;
        this.last++;
    }

    // Deleting methods

    public void removeLast () {
        assert this.last > 0;

        this.arr[last - 1] = null;
        this.last--;
    }

    public void removeFirst () {
        assert this.last > 0;
        
        for (int i = 0; i < this.last - 1; i++) {
            this.arr[i] = this.arr[i + 1];
        }

        this.last--;
    }

    public void delete (int p) {
        assert 0 <= p && p < this.last;

        if (p == this.last - 1) {
            this.removeLast();
            return;
        }

        for (int i = p; i < this.last - 1; i++) {
            this.arr[i] = this.arr[i + 1];
        }

        this.last--;
    }

    // Searching

    public int search (T x) {
        for (int i = 0; i < this.last; i++) {
            if (this.arr[i].equals(x)) {
                return i;
            }
        }

        return -1;
    }

    public T find (T x) {
        for (int i = 0; i < this.last; i++) {
            if (this.arr[i].equals(x)) {
                return this.arr[i];
            }
        }

        return null;
    }

    // Printing

    public void printList () {
        System.out.print("The current list is: [");
        for (int i = 0; i < this.last - 1; i++) {
            System.out.print(this.arr[i].toString() + ", ");
        }
        System.out.println(this.arr[this.last - 1].toString() + ']');
    }
}
