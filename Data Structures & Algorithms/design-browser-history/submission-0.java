class BrowserHistory {

    Node homepage;
    public BrowserHistory(String homepage) {
        this.homepage = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newUrl = new Node(url);
        homepage.next = newUrl;
        newUrl.prev = homepage;
        homepage = homepage.next;
    }
    
    public String back(int steps) {
        Node temp = homepage;
        int i=0;
        while (temp.prev!=null && i < steps ) {
            i++;
            temp = temp.prev;
        }
        homepage = temp;
        return temp.page;
    }
    
    public String forward(int steps) {
        Node temp = homepage;
        int i=0;
        while (temp.next!=null && i < steps) {
            i++;
            temp = temp.next;
        }
        homepage = temp;
        return temp.page;
    }
}

class Node {
    Node prev;
    String page;
    Node next;

    public Node(String page) {
        this.prev = null;
        this.page = page;
        this.next = null;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */