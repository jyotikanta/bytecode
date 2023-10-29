package neetcode.linkedlist;

import java.util.ArrayList;

class LinkedList {
    ListNode head;
    ListNode tail;

    int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = -1;
    }

    public int get(int index) {
        if(index>this.size)
            return -1;

        ListNode node = head;
        for(int i=0;i<index;i++) {
            node = node.next;
        }
        return node.value;
    }


    public void insertHead(int val) {
        ListNode node = new ListNode(val);
        if(this.head==null) {
            this.tail = node;
        }else {
            node.next = this.head;
        }
        this.head = node;
        this.size++;
    }

    public void insertTail(int val) {
        ListNode node = new ListNode(val);
        if (this.tail != null) {
            this.tail.next = node;
        }else {
            this.head = node;
        }
        this.tail = node;
        this.size++;
    }


    public boolean remove(int index) {
        if(index>this.size)
            return false;

        if(this.size==0){
            this.head = null;
            this.tail = null;
            this.size = -1;
            return true;
        }

        if(index==0){
            this.head = this.head.next;
            this.size--;
            return true;
        }

        ListNode node = head;
        ListNode prev = head;
        for(int i=0;i<index;i++) {
            prev = node;
            node = node.next;
        }
        if(index==this.size){
            prev.next = null;
            this.tail = prev;
        }else {
            prev.next = node.next;
        }

        this.size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> elements = new ArrayList<>();
        ListNode node = head;
        while(node!=tail) {
            elements.add(node.value);
            node = node.next;
        }
        elements.add(node.value);
        return elements;
    }
}

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}