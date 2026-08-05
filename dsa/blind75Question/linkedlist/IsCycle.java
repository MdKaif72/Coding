package dsa.blind75Question.linkedlist;
/*
LC 141
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.



Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 */

public class IsCycle {
    public static boolean hasCycle(ListNode head) {

        /*

        Set<ListNode> set=new HashSet<>();
        while(head!=null){
            if(!set.add(head))
                return true;
            head=head.next;

        }
        return false;
         */

        //Hare and Turtle Approach
        ListNode fastPointer =head;
        ListNode slowPointer =head;
        while (slowPointer!=null && fastPointer!=null && fastPointer.next!=null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if(fastPointer == slowPointer)
                return true;
        }
        return false;
    }

}
