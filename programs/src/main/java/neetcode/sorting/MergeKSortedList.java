package neetcode.sorting;

public class MergeKSortedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode l3 = new ListNode(2,new ListNode(6));
        ListNode l4 = new ListNode(2,new ListNode(6));
        ListNode l5 = new ListNode(7,new ListNode(9));
        ListNode l6 = new ListNode(-1,new ListNode(0));
        ListNode l7 = new ListNode(2,new ListNode(10));
        ListNode[] listNodes = {l1,l2,l3,l4,l5,l6,l7};
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        ListNode node = mergeKSortedList.mergeKLists(listNodes);
        while (node != null){
            System.out.print(node.val+"\t");
            node = node.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        int n = lists.length;
        for(int interval=1;interval<n;interval*=2){
            for(int i=0;i<n-interval;i+=2*interval){
                lists[i] = mergeList(lists[i],lists[i+interval]);
            }
        }
        return lists[0];
    }

    public ListNode mergeList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while(l1 != null && l2 != null){
            if(l1.val<=l2.val){
                current.next = l1;
                l1 = l1.next;
            }else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 != null ? l1 : l2;
        return dummy.next;
    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
