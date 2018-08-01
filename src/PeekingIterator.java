import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class PeekingIterator<T> implements Iterator<T> {
    Queue<T> q;

    public PeekingIterator(Iterator<T> iterator) {
        q = new LinkedList<>();
        // initialize any member here.
        while(iterator.hasNext()) q.offer(iterator.next());
    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        return q.peek();

    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        return q.poll();
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();

    }
}