import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended queue that supports adding and removing items at either end.
 * @param <Item> the type of items stored in this deque
 */
public class Deque<Item> implements Iterable<Item> {

    /** A node in the doubly linked list. */
    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private Node head;
    private Node tail;
    private int size;

    /** Construct an empty deque. */
    public Deque() {
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.prev=head;
        size=0;
        // TODO: Initialize an empty linked list.
    }

    /** Return whether the deque is empty. */
    public boolean isEmpty() {
        // TODO: Report whether this linked list contains no items.
        return size==0;
    }

    /** Return the number of items in the deque. */
    public int size() {
        // TODO: Return this linked list's item count.
        return size;
    }

    /** Add an item to the front; reject null items with IllegalArgumentException. */
    public void addFirst(Item item) {
        if(item==null)
            throw new IllegalArgumentException("item can't be null");
        Node i = new Node();
        i.item=item;
        i.next=head.next;
        head.next.prev=i;
        i.prev=head;
        head.next=i;
        size++;
        // TODO: Create a node and link it at the front; update head/tail pointers.
    }

    /** Add an item to the back; reject null items with IllegalArgumentException. */
    public void addLast(Item item) {
        if(item==null)
            throw new IllegalArgumentException("item can't be null");
        Node i = new Node();
        i.item=item;
        i.next=tail;
        tail.prev.next=i;
        i.prev=tail.prev;
        tail.prev=i;
        size++;
        // TODO: Create a node and link it at the back; update head/tail pointers.
    }

    /** Remove and return the front item; throw NoSuchElementException if empty. */
    public Item removeFirst() {
        if(isEmpty())
            throw new NoSuchElementException("size is equal to 0");
        Item i = head.next.item;
        head.next=head.next.next;
        head.next.prev.next=null;
        head.next.prev.prev=null;
        head.next.prev.item=null;
        head.next.prev=head;
        size--;
        // TODO: Remove the front node and update head/tail pointers.
        return i;
    }

    /** Remove and return the back item; throw NoSuchElementException if empty. */
    public Item removeLast() {
        if(isEmpty())
            throw new NoSuchElementException("size is equal to 0");
        Item i = tail.prev.item;
        tail.prev=tail.prev.prev;
        tail.prev.next.next=null;
        tail.prev.next.prev=null;
        tail.prev.next.item=null;
        tail.prev.next=tail;
        size--;
        // TODO: Remove the back node and update head/tail pointers.
        return i;
    }

    /** Return an iterator from front to back; next() and remove() follow the specified exceptions. */
    @Override
    public Iterator<Item> iterator() {
        // TODO: Return an iterator that follows next links from head to tail.
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{
        private Node current = head.next;
        @Override
        public boolean hasNext() {
            return current!=tail;
        }

        @Override
        public Item next() {
            if(hasNext()){
                Item item = current.item;
                current=current.next;
                return item;
            }
            else
                throw new NoSuchElementException("no more items");
        }
    }

    /** Run unit tests for the deque. */
    public static void main(String[] args) {
        // TODO: Add unit tests.
    }
}
