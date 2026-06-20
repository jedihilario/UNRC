import java.util.Iterator;
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
public class LinkedQueue<T> {

    private static class Node<T> {
        T elem;
        Node<T> next;

        Node(T elem, Node<T> next) {
            this.elem = elem;
            this.next = next;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T e) {
        Node<T> newNode = new Node<>(e, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        T elem = head.elem;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return elem;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return head.elem;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T elem = current.elem;
                current = current.next;
                return elem;
            }
        };
    }

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
