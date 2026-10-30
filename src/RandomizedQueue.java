import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A queue that removes items uniformly at random.
 * @param <Item> the type of items stored in this randomized queue
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;

    /** Construct an empty randomized queue. */
    public RandomizedQueue() {
        items = (Item[]) new Object[1];
        size=0;
        // TODO: Initialize an empty array-backed randomized queue. Resize by doubling when full and halving when quarter full.
    }

    /** Return whether the randomized queue is empty. */
    public boolean isEmpty() {
        // TODO: Report whether this array-backed queue contains no items.
        return size==0;
    }

    /** Return the number of items in the randomized queue. */
    public int size() {
        // TODO: Return this array-backed queue's item count.
        return size;
    }

    /** Add an item; reject null with IllegalArgumentException. */
    public void enqueue(Item item) {
        if(item==null){
            throw new IllegalArgumentException("Item can't be null");
        }
        items[size]=item;
        size++;
        if(size==items.length){
            resize(items.length*2);
        }


        // TODO: Add the item to the backing array, resizing as needed.
    }
    public void resize(int n){
        Item[] newItem = (Item[]) new Object[n];
        for(int i=0;i<items.length; i++){
            newItem[i]=items[i];
        }
        items=newItem;
    }

    /** Remove and return a uniformly random item; throw NoSuchElementException if empty. */
    public Item dequeue() {
        if(isEmpty())
            throw new NoSuchElementException("blud tried to dequeue empty array");
        int index = (int)(Math.random()*(size));
        Item temp = items[index];
        items[index]=items[size-1];
        items[size-1]=null;
        size--;
        if(size<items.length/4){
            resize(items.length/2);
        }
        // TODO: Pick a random index between 0 and size-1; swap the chosen item with the last item, then remove and resize as needed.
        return temp;
    }

    /** Return a uniformly random item without removing it; throw NoSuchElementException if empty. */
    public Item sample() {
        if(isEmpty())
            throw new NoSuchElementException("blud tried to dequeue empty array");
        int index = (int)(Math.random()*(size));
        // TODO: Pick a random index between 0 and size-1 and return that array item without removing it.
        return items[index];
    }

    /** Return an independent iterator in uniformly random order; define next() and remove() exceptions. */
    @Override
    public Iterator<Item> iterator() {
        // TODO: Return an independent iterator that traverses the array items in random order.


        return new RandomizedQueueIterator();
    }
    private class RandomizedQueueIterator implements Iterator<Item>{
        private Item[] shuffledItems;
        private int current=0;

        RandomizedQueueIterator(){
            RandomizedQueue<Item> itemcopy= new RandomizedQueue<Item>();
            for(int i=0; i<items.length; i++){
                itemcopy.items[i]=items[i];
            }
            shuffledItems = (Item[]) new Object[items.length];
            for(int i=0; i<items.length; i++){
                shuffledItems[i]=itemcopy.dequeue();
            }
        }
        public boolean hasNext() {
            return !(current==size);
        }

        @Override
        public Item next() {
            if(!hasNext())
                throw  new NoSuchElementException("no more elements");
            Item i = shuffledItems[current];
            current++;
            return i;
        }
    }

    /** Run unit tests for the randomized queue. */
    public static void main(String[] args) {
        // TODO: Add unit tests.
    }
}
