package neetcode.linkedlist;

public class DoublyLinkedList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
            list.addAtHead(1);
        //list.deleteAtIndex(1);
//        list.addAtHead(2);
//        list.addAtHead(7);
//        list.addAtHead(3);
//        list.addAtHead(2);
//        list.addAtHead(5);
        list.addAtTail(3);
        list.addAtIndex(1,2);
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        System.out.println(list.get(1));
        //2
//        while (list.head!=null){
//            System.out.print(list.head.value + "\t");
//            list.head = list.head.next;
//        }
    }
}
class MyLinkedList {
    ListNode head;
    ListNode tail;
    int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        int i = 0;
        ListNode curr = head;
        while(curr!=null){
            if(i==index){
                return curr.value;
            }
            curr = curr.next;
            i++;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if(tail == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        // 1 2 3 5
        int i = 0;
        ListNode newNode = new ListNode(val);
        ListNode curr = head;
        if(index==0){
            addAtHead(val);
        }else if(index==size){
            addAtTail(val);
        }else{
            while(curr!=null){
                if(i==index){
                    ListNode prevNode = curr.prev;
                    newNode.prev = prevNode;
                    prevNode.next = newNode;
                    curr.prev = newNode;
                    newNode.next = curr;
                    size++;
                }
                curr = curr.next;
                i++;
            }
        }

    }

    public void deleteAtIndex(int index) {
        ListNode curr = head;
        if(index<0||index>size){
            return;
        }
        if(index==0){
            removeFromHead();
        }else if(index==size-1){
            removeFromTail();
        }else{//1 2 3 4 5 6 7
            for(int i=0;i<index;i++){
                curr = curr.next;
            }
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            size--;
        }
    }

    public void removeFromHead() {
        if(size>1){
            head.next.prev=null;
            head=head.next;
            size--;
        }else if(size==1){
            head = null;
            tail = null;
            size--;
        }
    }

    public void removeFromTail() {
        if(size>1){
            tail=tail.prev;
            tail.next=null;
            size--;
        }else if(size==1){
            head = null;
            tail = null;
            size--;
        }
    }
}