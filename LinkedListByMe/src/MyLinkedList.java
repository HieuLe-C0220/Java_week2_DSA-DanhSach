public class MyLinkedList<E> {
    private Node head;
    private Node tail;
    private int numNodes;
    public MyLinkedList(E data) {
        head = new Node(data);
        tail = head;
        numNodes=1;
    }

    private class Node {
        private Node next;
        private E data;
        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return this.data;
        }
    }
    public void addFirst(E data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    public void addLast(E data){
        tail.next = new Node(data);
        tail= tail.next;
        numNodes++;
    }

    public Node getHead() {
        return head;
    }

    public E getTail() {
        return tail.data;
    }

    public void add(int index, E data) {
        Node temp = head; //đặt biến team bằng Node head
        Node holder; //Khai báo biến Node holder

        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next; //Chạy vòng lặp duyệt qua 1 lượt Node từ đầu tới index-1
        }
        holder = temp.next; //Gán Node holder = Node tại vị trí index (.next của index -2)
        temp.next = new Node(data); //Gán data vào Node index
        temp.next.next = holder;  //Gán biến index +1 vào Node holder
        numNodes++; //số Nodes ++
    }
    public E get(int index){
        Node temp=head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }
    public E remove(int index){
        if(index<0||index>numNodes)return null;
        else if(index == 0) { //Remore first Node
            if (numNodes == 0) return null; // Nothing to delete
            else {
                Node temp = head; // Keep the first node temporarily
                head = head.next; // Move head to point to next node
                numNodes--; // Reduce size by 1
                if (head == null) tail = null; // List becomes empty
                return temp.data; // Return the deleted element
            }
        }else if(index== numNodes-1){ //Remore last Node
            if (numNodes == 0) return null; // Nothing to remove
            else if (numNodes == 1) { // Only one element in the list
                Node temp = head;
                head = tail = null; // list becomes empty
                numNodes = 0;
                return temp.data;
            } else {
                Node current = head;

                for (int i = 0; i < numNodes - 2; i++)
                    current = current.next;

                Node temp = tail;
                tail = current;
                tail.next = null;
                numNodes--;
                return temp.data;
            }
        }else {
            Node previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node current = previous.next;
            previous.next = current.next;
            numNodes--;
            return current.data;
        }
    }
    public int getSize() {
        return numNodes;
    }
    public boolean contain(E data){
        Node temp = head;
        for(int j =0;j<this.getSize();j++){
            if(temp.data == data) {
                return true;
            }else {
                temp = temp.next;
            }
        }
        return false;
    }
    public int indexOf(E data){
        Node temp = head;
        for(int j =0;j<this.getSize();j++){
            if(temp.data == data) {
                return j;
            }else {
                temp = temp.next;
            }
        }
        return -1;

    }

    @Override
    public String toString(){
        String result ="";
        Node temp = head;
        while(temp != null) {
            result+=temp.data+" ";
            temp = temp.next;
        }
        return result;
    }

}
