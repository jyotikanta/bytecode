package neetcode.linkedlist;

public class HelloWorld {
    public static void main(String[] args) {
        //["insertHead", 1, "insertHead", 2, "insertTail", 3, "insertTail", 4, "insertHead", 5, "get", 0,
        // "get", 2, "get", 4, "remove", 2, "remove", 0, "insertHead", 6, "insertTail", 7, "getValues", "get", 5]
        System.out.println("Hello World!");
        LinkedList list = new LinkedList();
        list.insertHead(1);
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
        System.out.println(list.get(5));


        //5 2 1 3 4

        //5 1 4

        //5 2 3 4
        //2 3 4
        //6 2 3 4
        //6 2 3 4 7
        //-1
    }
}
