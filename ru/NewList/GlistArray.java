package NewList;

import java.util.*;

public class GlistArray implements List {
    //new ArrayList

    private int size;
    transient Object[] elData;
    protected transient int modCount = 0;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    @Override
    public int size() {
        return this.size();
        // или можно так
        //GlistArray.this.toArray().length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elData, size);
    }

    @Override
    public boolean add(Object o) {
        int minCapacity = size + 1;
        if (elData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(10, minCapacity);
        }
        if (minCapacity - elData.length > 0) {
            int oldCapacity = elData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            if (newCapacity - MAX_ARRAY_SIZE > 0)
                newCapacity = (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
            elData = Arrays.copyOf(elData, newCapacity);
        }
        elData[size++] = o;
        return true;
    }


    @Override
    public void add(int index, Object element) {
        if (index > size || index < 0) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        System.arraycopy(elData, index, elData, index + 1,
                size - index);
        elData[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        System.arraycopy(a, 0, elData, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        Object[] a = c.toArray();//??????????
        int numNew = a.length;
        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(elData, index, elData, index + numNew,
                    numMoved);

        System.arraycopy(a, 0, elData, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elData[index] == null) {
                    int numMoved = size - index - 1;
                    if (numMoved > 0)
                        System.arraycopy(elData, index + 1, elData, index, numMoved);
                    elData[--size] = null;
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elData[index])) {
                    int numMoved = size - index - 1;
                    if (numMoved > 0)
                        System.arraycopy(elData, index + 1, elData, index, numMoved);
                    elData[--size] = null;
                    return true;
                }
        }
        return false;
    }

    @Override
    public void clear() {
        modCount++;
        for (int i = 0; i < size; i++)
            elData[i] = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return elData[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
