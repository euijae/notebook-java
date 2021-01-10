package codingproblems.ctci.ch2;

import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        MyClass mc = new MyClass();
        mc.test();
    }

    public void test() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        n2.next = null;
    }

    public boolean hasIntersect(Node n, Node m) {
        while(n != null) {
            Node temp = m;

            while(temp != null) {
                if(n == temp) {
                    return checker(n, temp);
                }

                temp = temp.next;
            }

            n = n.next;
        }

        return false;
    }

    public boolean checker(Node n1, Node n2) {
        while(n1 != null && n2 != null) {
            if(n1 != n2) {
                return false;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        return n1 == null && n2 == null;
    }

    public int getSum(Node n1, Node n2) {
        int num1 = convertToNumber(n1);
        int num2 = convertToNumber(n2);

        return num1 + num2;
    }

    public int convertToNumber(Node n) {
        int up = 0, p = 0, sum = 0;

        while(n != null) {
            int val = n.data + up;
            up = (val >= 10) ? 1 : 0;
            sum += (val *(int) Math.pow(10, p));
            p++;

            n = n.next;
        }

        return sum + (up == 1 ? (int) Math.pow(10, p) : 0);
    }

    /**
     *  @TODO in while Node next and node.next = null;
     */
    public Node partition(Node node, int x) {
        Node fs = null;
        Node fb = null;
        Node bs = null;
        Node bb = null;

        while(node != null) {
            Node next = node.next;
            node.next = null;

            if(node.data < x) {
                if(fs == null) {
                    fs = node;
                } else {
                    if(fb == null) {
                        fb = node;
                        fs.next = fb;
                    } else {
                        fb.next = node;
                        fb = node;
                    }
                }
            } else {
                if(bs == null) {
                    bs = node;
                } else {
                    if(bb == null) {
                        bb = node;
                        bs.next = bb;
                    } else {
                        bb.next = node;
                        bb = node;
                    }
                }
            }

            node = next;
        }

        if(fs == null) {
            return bs;
        } else if(fb == null) {
            fs.next = bs;
            return fs;
        } else {
            fb.next = bs;
            return fs;
        }
    }

    public Node removeMiddleNode(Node head) {
        Node m = findMiddleNode(head);

        Node n = head;

        if(n == m) return head.next;

        while(n.next != null) {
            if(n.next == m) {
                n.next = n.next.next;
                return head;
            }

            n = n.next;
        }

        return head;
    }

    public Node findMiddleNode(Node head) {
        Node p1 = head;
        Node p2 = head;

        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return p1;
    }

    public Node kthToLast(Node head, int k) {
        Node r = reverse(head);
        int runner = 1;

        while(r != null) {
            if(runner == k) {
                return r;
            }

            runner ++;
            r = r.next;
        }

        return null;
    }

    public Node reverse2(Node head) {
        return reverse2(null, head);
    }

    public Node reverse2(Node prev, Node curr) {
        if(curr == null) {
            return prev;
        }

        Node c = curr;
        Node n = curr.next;

        curr.next = prev;

        return reverse2(c, n);
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = curr.next;

        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;

            if(next == null) {
                curr.next = prev;
            }
        }

        return curr;
    }

    public Node removeDups(Node head) {
        Set<Integer> set = new HashSet<>();
        Node n = head;
        set.add(n.data);

        while(n.next != null) {
            if(!set.add(n.next.data)) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }

        System.out.println(set.toString());

        return head;
    }

    public void print(Node node) {
        while(node != null) {
            System.out.print(node.data + ", ");
            node = node.next;
        }

        System.out.println("");
    }

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
