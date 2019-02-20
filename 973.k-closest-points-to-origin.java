/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 *
 * https://leetcode.com/problems/k-closest-points-to-origin/description/
 *
 * algorithms
 * Easy (66.24%)
 * Total Accepted:    19.5K
 * Total Submissions: 29.3K
 * Testcase Example:  '[[1,3],[-2,2]]\n1'
 *
 * We have a list of points on the plane.  Find the K closest points to the
 * origin (0, 0).
 * 
 * (Here, the distance between two points on a plane is the Euclidean
 * distance.)
 * 
 * You may return the answer in any order.  The answer is guaranteed to be
 * unique (except for the order that it is in.)
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation: 
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just
 * [[-2,2]].
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 * 
 * 
 * 
 * 
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        List<Point> ps = new ArrayList<>();
        for(int[] p : points) {
            ps.add(new Point(p[0], p[1]));
        }
        MaxHeap<Point> heap = new MaxHeap<>(K);
        for(Point p : ps) {
            heap.add(p);
        }
        int[][] ret = new int[K][];
        for(int i=0;i<K;i++) {
            ret[i] = new int[2];
            Point v = heap.extractMax();
            ret[i][0] = v.x;
            ret[i][1] = v.y;
        }
        return ret;
    }
}
class Point implements Comparable<Point> {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point right) {
        int a = x*x + y*y;
        int b = right.x*right.x + right.y*right.y;
        return a==b?0:a<b?1:-1;
    }
}
class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        heapify(arr);
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void add(E e) {
        data.addLast(e);
//        siftUp(data.getSize() - 1);
        siftUpRecursion(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    private void siftUpRecursion(int k) {
        _siftUpRecursion(k);
    }

    private void _siftUpRecursion(int k) {
        if (k <= 0 ) {
            return;
        }
        if (data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
        }
        _siftUpRecursion(parent(k));
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }

    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
//        siftDown(0);
        siftDownRecursion(0);
        return ret;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    private void siftDownRecursion(int k) {
        _siftDownByRecursion(k);
    }

    private void _siftDownByRecursion(int k) {
        int j = leftChild(k);
        if (j >= data.getSize()) {
            return;
        }
        if (j + 1 < data.getSize() &&
                data.get(j + 1).compareTo(data.get(j)) > 0) {
            j = rightChild(k);
        }
        if (data.get(k).compareTo(data.get(j)) >= 0) {
            return;
        }
        data.swap(k, j);
        _siftDownByRecursion(j);
    }

    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    public void heapify(E[] arr) {
        for (int i = parent(arr.length - 1); i >= 0; i--) {
//            siftDown(i);
            siftDownRecursion(i);
        }
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }
}
class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, data.length);
        size = arr.length;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 添加之前数组的存储是在[0, size - 1)的区间, 在最后一个元素之后添加即在data[size]处, 之后size++.
    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add fail. Require index >= 0 and index <= size.");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        // index == size时,相当于在最后添加元素, 之前的元素都不要挪动, length参数变为0, 这里直接不用进
        // index < size时,需要将[index, size-1]位置处的元素逐个后移一位,当data满时不用担心数组越界因为之前已经resize
        // 移动的元素个数为size-1 - index + 1 = size - index
        if (size > index) System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get fail. Require index >= 0 and index < size.");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add fail. Require index >= 0 and index < size.");
        }
        data[index] = e;
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add fail. Require index >= 0 and index < size.");
        }
        E e = data[index];
        // 如果index==size-1,即删除最后一个元素,不需要挪动其余元素
        // 如果index<size-1,[index+1, size-1]的所有元素向前挪动一个位置
        if (size > index + 1) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
        }
        size--;
        data[size] = null;

//        if (size == data.length / 4 && data.length / 2 != 0) { // 其实到不了这个条件
        if (size == data.length / 4) {
            resize(data.length / 2);
        }
        return e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size=%d, capacity=%d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
