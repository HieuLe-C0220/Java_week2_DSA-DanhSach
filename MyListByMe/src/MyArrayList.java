import java.util.Arrays;

public class MyArrayList<E> {
    private static final int INTIAL_CAPACITY = 10;
    public Object[] myArray;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MyArrayList() {
        myArray = new Object[INTIAL_CAPACITY];
    }
    public MyArrayList(int capacity) {
        myArray = new Object[capacity];
    }
    public void ensureCapacity() {
        int new_size =myArray.length*2;
        myArray = Arrays.copyOf(myArray,new_size);
    }
    public void add(E element){
        if(this.size == myArray.length ) {
            ensureCapacity();
        }
        myArray[size++] = element;
    }
    public void add(int index,E e) {
        if(index >= myArray.length || this.size == myArray.length){
            ensureCapacity();
        }
        for(int j = myArray.length-1;j>index;j--){
            myArray[j]=myArray[j-1];
        }
        myArray[index]=e;
    }
    public E remove(int index) {
        if (index>=0 && index<myArray.length) {
            for (int i=index;i<myArray.length-1;i++) {
                myArray[i] = (E) myArray[i+1];
            }
            myArray[getSize()-1] = null;
            return (E) myArray;
        } else {
        throw new ArrayIndexOutOfBoundsException("Không có phần tử ở vị trí đó");
        }
    }
    public E clone() {
        MyArrayList<E> Mylist_Replica = new MyArrayList<>();
        Mylist_Replica.myArray = this.myArray;
        Mylist_Replica.size = this.size;
        return (E) Mylist_Replica;
    }
    public boolean contain(E e) {
        for (int i=0;i<size;i++) {
            if (e.equals(myArray[i])) {
                return true;
            }
        }
        return false;
    }
    public int indexOf(E e) {
        for (int i=0;i<size;i++) {
            if (e.equals(myArray[i])) {
                return i;
            }
        }
        return -1;
    }
    public E get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (E) myArray[i];
    }
    public void clear() {
        myArray = (E[]) new Object[INTIAL_CAPACITY];
        size = 0;
    }
    @Override
    public String toString(){
        String result="";
        for (int i=0;i<myArray.length;i++){
            result += myArray[i]+" ";
        }
        return result;
    }
}
