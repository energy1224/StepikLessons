package Range;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeTest {
    public static void main(String[] args) {

        Range range = new Range(0,10);

        for (Integer i : range) {
            System.out.print(i+" ");

        }

    }
}

class Range implements Iterable<Integer>,Iterator<Integer>{
    int start;
    int end;
    int count;
    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Iterator<Integer> iterator() {
        count=start;
        return this;
    }

    @Override
    public boolean hasNext() {
        return count<=end;
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        return count++;
    }
}
