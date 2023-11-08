package neetcode.linkedlist;

class BrowserHistory {
    BrowserListNode head;
    BrowserListNode curr;
    BrowserListNode tail;
    int size = 0;
    int currPos = 0;

    public BrowserHistory(String homepage) {
        head = new BrowserListNode(homepage);
        curr = head;
        tail = head;
        size++;
        currPos++;
    }



    public void visit(String url) {
        if(size>0){
            //a b c d
            BrowserListNode newNode = new BrowserListNode(url);
            newNode.prev = curr;
            curr.next = newNode;
            tail = newNode;
            curr = newNode;
            currPos++;
            size = currPos;
        }
    }

    public String back(int steps) {
        if(curr==head){
            return head.url;
        }
        while(steps>0){
            if(curr==null){
                curr = head;
                currPos++;
                return head.url;
            }
            curr = curr.prev;
            currPos--;
            steps--;
        }
        if(curr==null){
            curr = head;
            currPos++;
            return head.url;
        }
        return curr.url;
    }

    public String forward(int steps) {
        for(int i=0;i<steps;i++){
            if(curr==null){
                currPos--;
                curr=tail;//tail
                return tail.url;
            }
            curr = curr.next;
            currPos++;
        }
        if(curr==null){
            currPos--;
            curr=tail;//tail
            return tail.url;
        }
        return curr.url;
    }
}

class BrowserListNode{
    String url;
    BrowserListNode prev;
    BrowserListNode next;

    BrowserListNode(String url){
        this.url = url;
    }
}
