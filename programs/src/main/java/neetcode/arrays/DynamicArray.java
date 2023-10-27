package neetcode.arrays;
public class DynamicArray {
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(2);
        arr.pushback(0);
        arr.pushback(1);
        arr.pushback(2);
        System.out.println(arr.getSize());
        System.out.println(arr.getCapacity());
    }
    int arr[];
    int length;
    int capacity;
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        arr = new int[capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        arr[length] = n;
        length++;
    }

    public int popback() {
        if(length > 0)
        {
            length--;
        }
        return arr[length];
    }

    private void resize() {
        this.capacity*=2;
        int[] newArr = new int[this.capacity];
        for(int i=0;i<arr.length;i++)
        {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return this.capacity;
    }
}

