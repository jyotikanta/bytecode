package neetcode.linkedlist;

public class MergeTwoSortedList {
    public static void main(String[] args)
    {
        ListNode node1 = new ListNode(1);
        System.out.print(1+"\t");
        ListNode head1 = node1;
        for(int i=2;i<5;i+=2) {
            ListNode temp = new ListNode(i);
            System.out.print(i+"\t");
            node1.next = temp;
            node1 = node1.next;
        }
        System.out.println();
        System.out.print(1+"\t");
        ListNode node2 = new ListNode(1);
        ListNode head2 = node2;
        for(int i=3;i<5;i++){
            ListNode temp = new ListNode(i);
            System.out.print(i+"\t");
            node2.next = temp;
            node2 = node2.next;
        }


        System.out.println("\n");
        ListNode mergeTwoLists = mergeTwoLists(head1, head2);
        while (mergeTwoLists!=null){
            System.out.println(mergeTwoLists.value);
            mergeTwoLists = mergeTwoLists.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {

        if(head1==null&&head2==null) {
            return null;
        }
        else if (head1==null) {
            return head2;
        } else if (head2 ==null) {
            return head1;
        } else {
            ListNode mergeHead = head1.value<=head2.value ? head1 : head2;
            while(head1!=null || head2!=null){

                if(head1.value <= head2.value){
                    ListNode prevHead1 = head1;
                    while (head1.value<=head2.value) {
                        prevHead1 = head1;
                        head1 = head1.next;
                        if(head1==null){
                            prevHead1.next = head2;
                            return mergeHead;
                        }
                    }
                    prevHead1.next = head2;
                    head2 = prevHead1;
                }else{
                    ListNode prevHead2 = head2;
                    while (head2.value<=head1.value) {
                        prevHead2 = head2;
                        head2 = head2.next;
                        if(head2==null){
                            prevHead2.next = head1;
                            return mergeHead;
                        }
                    }
                    prevHead2.next = head1;
                    head1 = prevHead2;
                    //-5 -3 -2 1 1 7 8
                    //                  1 5 6 7 8.
                    //    h1-> 7 8
                    //   -5 -3 -2  h2-> 1 1 5 6 7 8
                }
            }
            return mergeHead;
        }

    }
}
