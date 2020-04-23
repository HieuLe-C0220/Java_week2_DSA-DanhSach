import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(7);
        myArrayList.add(16);
        myArrayList.add(32);
        myArrayList.add(19);
        myArrayList.add(40);
        myArrayList.add(12);
        myArrayList.add(25);
        myArrayList.add(36);
        System.out.println(myArrayList);
        System.out.println("----------------------");
        myArrayList.remove(3);
        System.out.println(myArrayList);
        System.out.println("============");
        myArrayList.add(4,20);
        System.out.println(myArrayList);
        System.out.println("============");
        System.out.println(myArrayList.clone());
        System.out.println(myArrayList.contain(18));
        myArrayList.clear();
        System.out.println(myArrayList);
    }
}
