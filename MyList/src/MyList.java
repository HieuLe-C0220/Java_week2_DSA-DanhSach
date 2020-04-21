import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];
    public MyList() { //Khởi tạo với capacity mặc định
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capcity) { //Khởi tạo với capacity tham số truyền vào
        elements = new Object[capcity];
    }
    private void ensureCapa() {
        int newSide = elements.length * 2;
        elements = Arrays.copyOf(elements,newSide);
    }
    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
    public E get (int i) { //trả về số phần tử vừa ở vị trí thứ i trong danh sách
        if (i>=size || i<0) {
            throw new IndexOutOfBoundsException("Index: "+i+", Size "+i);
        }
        return (E) elements[i];
    }
}
