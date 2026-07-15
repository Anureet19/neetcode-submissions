class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        if (students.length == 0) {
            return 0;
        } 
        Node studentQueueHead = new Node(students[0]);
        Node temp = studentQueueHead;

        int x = students.length;
        int i=1;
        while (i < x) {
            Node newStudent = new Node(students[i]);
            temp.next = newStudent;
            newStudent.prev = temp;
            temp = temp.next;
            i++;
        }
        Node studentQueueEnd = temp;
        studentQueueEnd.next = null;

        i=0;
        int j=0;
        temp = studentQueueHead;
        Node tempEnd = studentQueueEnd;
        while (i < x && temp != null) {
            if (temp.data==sandwiches[j]) {
                temp = temp.next;
                if (temp != null) temp.prev = null;
                j++;
                x--;
                i=0;
            } else {
                tempEnd.next = temp;
                temp.prev = tempEnd;
                tempEnd = temp;
                temp = temp.next;
                tempEnd.next = null;
                i++;
            }
        }
        return x;
    }
}
class Node {
    Node prev;
    int data;
    Node next;
    public Node(int data) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }
}