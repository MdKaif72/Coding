package dsa.blind75Question.linkedlist;

/*
LC 143
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.


 */

public class ReOrderList {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // -------- Step 1: find the end of the first half --------
        ListNode firstHalfTail = head;        // slow pointer
        ListNode fastRunner = head.next;      // fast pointer (starts one step ahead)

        while (fastRunner != null && fastRunner.next != null) {
            firstHalfTail = firstHalfTail.next;
            fastRunner = fastRunner.next.next;
        }
        // firstHalfTail now points to the last node of the first half


        // -------- Step 2: reverse the nodes after firstHalfTail (in place) --------
        ListNode secondHalfHead = firstHalfTail.next;  // first node of the right half (will become the tail)
        while (secondHalfHead != null && secondHalfHead.next != null) {
            ListNode nodeToFront = secondHalfHead.next;   // node we want to move forward
            secondHalfHead.next = nodeToFront.next;       // detach nodeToFront
            nodeToFront.next = firstHalfTail.next;        // insert nodeToFront right after firstHalfTail
            firstHalfTail.next = nodeToFront;             // nodeToFront becomes new head of the reversed part
        }


        // -------- Step 3: merge the two halves alternately --------
        ListNode leftPointer = head;                // start from the beginning
        ListNode rightPointer = firstHalfTail.next; // head of the reversed right half

        while (leftPointer != firstHalfTail) {
            firstHalfTail.next = rightPointer.next;   // remove rightPointer from its current spot
            rightPointer.next = leftPointer.next;     // insert rightPointer after leftPointer
            leftPointer.next = rightPointer;          // link leftPointer to rightPointer

            leftPointer = rightPointer.next;          // move to next pair on the left side
            rightPointer = firstHalfTail.next;        // next node to insert from the right half
        }
    }


}
