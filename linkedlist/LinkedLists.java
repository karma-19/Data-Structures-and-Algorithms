package linkedlist;

public class LinkedLists {
    static int carry = 0;
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void printLinkedList(ListNode head) {
        System.out.print("Printing Linked List : ");
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        int[] arr = new int[]{1, 2, 3, 4};

        for (int i = 0; i < arr.length; i++) {
            listNode.next = new ListNode(arr[i]);
            listNode = listNode.next;
        }
        printLinkedList(head);
        ListNode temp = revLinkedListRec(head);
        System.out.println("Reverse array Recursively");
        printLinkedList(temp);

        System.out.println("Reverse array Iteratively.");
        ListNode temp2 = revLinkedListItr(temp);
        printLinkedList(temp2);

        System.out.println("Reverse in groups");
        ListNode temp3 = rev(temp2, 2);
        printLinkedList(temp3);

        System.out.println("Last to first");
        ListNode temp4 = lastToFirst(temp3);
        printLinkedList(temp4);

        System.out.println("Add 1 in last node");

        add1InLast(temp4);

    }

    //add 1 in last node
    public static ListNode add1InLast(ListNode head) {
        if(head.next == null) {
            int val = head.val + 1;
            carry = val/10;
            head.val = val%10;
            return head;
        }

        ListNode temp = add1InLast(head.next);
        carry = (temp.val + carry) /10;
        temp.val = (temp.val + carry) % 10;
        return head;
    }

    //move last element to front
    public static ListNode lastToFirst(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        while(curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        curr.next = head;
        prev.next = null;
        return curr;
    }

    //reverse a linked list itr
    public  static ListNode revLinkedListItr(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    //reverse a linked list recursive
    public static ListNode revLinkedListRec(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode temp = revLinkedListRec(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    //reverse in groups
    public static ListNode rev(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;

        while(curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next != null) {
            head.next = rev(next, k);
        }

        return prev;
    }

}
