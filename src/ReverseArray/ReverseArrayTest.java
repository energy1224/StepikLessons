package ReverseArray;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReverseArrayTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = new int[scan.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        ReverseArray reverse = new ReverseArray(array);
        for (Integer item : reverse) {
            System.out.print(item + " ");
        }

    }
}

class ReverseArray implements Iterable<Integer> {
    private int[] array;

    public ReverseArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new IntegerIterator();
    }
private class IntegerIterator implements Iterator<Integer>{

    private int count = array.length - 1;


    @Override
    public boolean hasNext() {
        return count >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new NoSuchElementException();
        return array[count--];
    }
}
    }

