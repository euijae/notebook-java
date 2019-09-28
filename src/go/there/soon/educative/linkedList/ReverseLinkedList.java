package go.there.soon.educative.linkedList;

public class ReverseLinkedList {

    public static void main(String [] args) {
        LinkedListNode1 n1 = new LinkedListNode1(7);
        LinkedListNode1 n2 = new LinkedListNode1(14);
        LinkedListNode1 n3 = new LinkedListNode1(21);
        LinkedListNode1 n4 = new LinkedListNode1(28);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        LinkedListNode1 node = reverse2(n1);
        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public static LinkedListNode1 reverse1(LinkedListNode1 head) {
        LinkedListNode1 prev = null;
        LinkedListNode1 curr = head;
        LinkedListNode1 next = head.next;

        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        curr.next = prev;

        return curr;
    }

    public static LinkedListNode1 reverse2(LinkedListNode1 head) {
        return reverse2Helper(null, head, head.next);

    }

    public static LinkedListNode1 reverse2Helper(
            LinkedListNode1 prev,
            LinkedListNode1 curr,
            LinkedListNode1 next) {
        curr.next = prev;
        return (next == null) ? curr : reverse2Helper(curr, next, next.next);
    }
}
