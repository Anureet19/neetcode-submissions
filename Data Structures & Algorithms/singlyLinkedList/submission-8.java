class LinkedList {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public LinkedList() {
        head = null;
    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }
        Node tmp = head;
        int i = 0;
        while(tmp != null) {
            if (i == index) {
                return tmp.data;
            }
            i++;
            tmp = tmp.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        } 
        newNode.next = head;
        head = newNode;
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public boolean remove(int index) {
        if (head == null) {
            return false;
        }
        System.out.println(head.data);
        Node tmp = head;
        int i = 0;
        if (index == i) {
            head = head.next;
            return true;
        }
        while(tmp != null) {
            if (i + 1 == index) {
                if (tmp.next != null) {
                    tmp.next = tmp.next.next;
                    return true;
                }
            }
            i++;
            tmp = tmp.next;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> arrList = new ArrayList<>();
        Node tmp = head;
        while (tmp!=null) {
            arrList.add(tmp.data);
            tmp = tmp.next;
        }
        return arrList;
    }
}


