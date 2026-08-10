package dsa.blind75Question.linkedlist;

/*
LC 19

Given the head of a linked list, remove the nth node from the end of the list and return its head.



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 */

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next=head;

        ListNode p1 = dummy ,p2 = dummy;

        //First make the p2 and p1 diff by n
        for(int i=0;i<n;i++){
            p2=p2.next;
        }
        //move both pointer until p2.next is null
        while(p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        // we get the p1.next to be removed
        p1.next=p1.next.next;

        return dummy.next;

    }


}
