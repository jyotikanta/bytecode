package neetcode.linkedlist;

public class ReverseListRecursive {

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
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }
    public static LinkedListNode reverseList(LinkedListNode head){
        LinkedListNode newHead;
        if(head.next==null) {
            return head;
        }
        else
        {
            newHead = reverseList(head.next);
            head.next.next = head;
        }
        head.next = null;
        return newHead;
    }
}
