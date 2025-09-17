package TADs;

public class Node <T> {
    private T value;
    private Node<T> next;

    public Node () {
        this.value = null;
        this.next = null;
    }

    public Node (T v) {
        this.value = v;
        this.next = null;
    }

    public Node (T v, Node<T> n) {
        this.value = v;
        this.next = n;
    }

    // Getters

    public T getValue () {
        return this.value;
    }

    public Node<T> getNext () {
        return this.next;
    }

    // Setters

    public void setValue (T v) {
        assert v != null;
        this.value = v;
    }

    public void setNext (Node<T> n) {
        assert n != null;
        this.next = n;
    }
}
