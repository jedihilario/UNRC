import java.util.NoSuchElementException;

/**
 * LinkedQueue is an implementation of the Queue ADT based on linked lists.
 * 
 * Representation Invariant (RI):
 * - size >= 0
 * - If size == 0, then head == null and tail == null.
 * - If size > 0, then head != null and tail != null.
 * - `tail` is reachable from `head` by following `next` references.
 * - `tail.next == null`.
 * - The number of nodes from `head` to `tail` equals `size`.
 * - There are no cycles in the linked list.
 * 
 * Abstraction Function (AF):
 * - AF(c) = [e_1, e_2, ..., e_n] where e_1 is the front of the queue and e_n is the rear of the queue.
 *   The queue elements correspond to the node elements traversed from head to tail 
 *   (e_1 = head.elem, e_2 = head.next.elem, ..., e_n = tail.elem).
 *   If head == null, AF(c) = [].
 */
public class LinkedQueue<T> implements Queue<T> {

    // Static class that represent a linked node
    private static class Node<T> {
        T elem;
        Node<T> next;

        Node(T elem, Node<T> next) {
            this.elem = elem;
            this.next = next;
        }
    }

    // Pointers to the front and back of the queue, and size field
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Constructor
     * @post Creates an empty queue
     */
    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * @post returns the size of the queue
     */
    public int size() {
        return size;
    }

    /** 
     * @post Return true iff the queue has no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /** 
     * Public api the enqueue a new element
     * @post Adds a new element to the back of the queue
     */
    public void enqueue(T e) {
        // Creates the new node with the parameter as value
        Node<T> newNode = new Node<>(e, null);

        // If the queue is empty, set the head as the new node. Otherwise, just set tail's next pointer
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        // Set tail to the new node and increase the size
        tail = newNode;
        size++;
    }

    /**
     * Public api to get the front element and dequeue it
     * @pre the queue must not be empty
     * @post returns the front element and delete it from the queue
     */
    public T dequeue() {
        // Precondition check
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");

        // Store the front element in a variable
        T elem = head.elem;

        // Move head to the next element (the one behind the front), and decrease queue's size
        head = head.next;
        size--;

        // If the queue results empty after the deletion, set tail to null
        if (isEmpty()) {
            tail = null;
        }

        // Returns the stored element
        return elem;
    }

    /** 
     * Public api to get the front element without deleting it
     * @pre the queue must not be empty
     * @post returns the front element of the queue
     */
    public T peek() {
        if (isEmpty())
            throw new NoSuchElementException("Queue is empty");

        return head.elem;
    }

    /** 
     * Representation invariant
     * Must check if:
     * - Size is non-negative
     * - If size is 0, head and tail must be null
     * - If the size is not 0, both head and tail shouldn't be null
     * - Tail must be connected (reachable through nexts starting from head)
     * - Size stores the exact amount of nodes in the representation
     * @post returns true iff the representation is OK
     */
    public boolean repOK() {
        if (size < 0) return false;
        if (size == 0) return head == null && tail == null;
        if (head == null || tail == null) return false;

        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            if (count > size) return false; // Cycle detected
            if (current.next == null && current != tail) return false; // tail doesn't point to the last element
            current = current.next;
        }
        return count == size;
    }


    /** 
     * Abstraction method
     * @post returns the abstract representation of the queue
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.elem);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
