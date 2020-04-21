public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(33);
        listInteger.add(44);
        listInteger.add(13);
        listInteger.add(24);
        listInteger.add(26);
        System.out.println("element 4: "+listInteger.get(4));
        System.out.println("element 1: "+listInteger.get(1));
        System.out.println("element 2: "+listInteger.get(2));
        listInteger.get(3);
        System.out.println(" element 3: "+listInteger.get(3));
    }
}
