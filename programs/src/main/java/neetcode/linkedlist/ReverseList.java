package neetcode.linkedlist;

public class ReverseList {
    public static void main(String[] args) {
        LinkedListNode node = new LinkedListNode(1);
        LinkedListNode head = node;
        for(int i=2;i<5;i++){
            LinkedListNode temp = new LinkedListNode(i);
            node.next = temp;
            node = node.next;
        }
        LinkedListNode reverse = reverseList(head);
        while (reverse!=null){
            LinkedListNode curr = reverse;
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    public static LinkedListNode reverseList(LinkedListNode head)
    {
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        while(curr!=null){
            LinkedListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

class LinkedListNode {
    int val;
    LinkedListNode next;
    LinkedListNode() {}
    LinkedListNode(int val) { this.val = val; }
    LinkedListNode(int val, LinkedListNode next) { this.val = val; this.next = next; }
}



