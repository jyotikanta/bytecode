package neetcode.linkedlist;

public class HelloWorld {
    public static void main(String[] args) {
        //["insertHead", 1, "insertHead", 2, "insertTail", 3, "insertTail", 4, "insertHead", 5, "get", 0,
        // "get", 2, "get", 4, "remove", 2, "remove", 0, "insertHead", 6, "insertTail", 7, "getValues", "get", 5]
        System.out.println("Hello World!");
        LinkedList list = new LinkedList();
/*      list.insertHead(1);
        list.insertHead(2);
        list.insertTail(3);
        list.insertTail(4);
        list.insertHead(5);
        System.out.println(list.get(0));
        System.out.println(list.get(2));
        System.out.println(list.get(4));
        list.remove(2);
        list.remove(0);
        list.insertHead(6);
        list.insertTail(7);
        System.out.println(list.getValues());
        System.out.println(list.get(5));*/
        list.insertTail(1);
        list.insertTail(2);
        list.insertTail(3);
        list.insertTail(4);
        list.insertTail(5);
        list.insertTail(6);
        Solution s = new Solution();
        s.reorderList(list.head);
        System.out.println(list.getValues());
    }
}

class Solution {
    ListNode curr;
    ListNode tempHead;
    int count = 0;
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        if(count == 0){
            curr = head;
            tempHead = head;
            count++;
        }
        if(head.next!=null && head.next.next==null){
            head.next.next = curr.next;
            curr.next = head.next;
            head.next = null;
            if(curr.next!=null){
                curr = curr.next.next;
                reorderList(curr);
            }
        }
        else
        {
            reorderList(head.next);
        }
    }
}
