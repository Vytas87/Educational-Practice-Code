/**********************************************************************************************
Write a method split that rearranges the elements of a list so that all of the negative values
appear before all of the non-negatives. For example, suppose a variable list stores the following
sequence of values:

                    [8, 7, -4, 19, 0, 43, -8, -7, 2]

The call of list.split(); should rearrange the list to put the negatives first. One possible
arrangement would be the following:

                    [-4, -8, -7, 8, 7, 19, 0, 43, 2]

But it matters only that the negatives appear before the non-negatives. So this is only one
possible solution. Another legal solution would be to rearrange the values this way:

                    [-7, -8, -4, 2, 43, 0, 19, 7, 8]

You are not allowed to swap data fields or to create any new nodes to solve this problem; you
must rearrange the list by rearranging the links of the list. You also may not use auxiliary
structures like arrays, ArrayLists, stacks, queues, etc, to solve this problem.

Assume that you are adding this method to the LinkedIntList class as defined below:

                    public class LinkedIntList {
                        private ListNode front;   // null for an empty list
                        ...
                    }

***********************************************************************************************/

public void split() {
    
    ListNode current = front;
    
    if (current != null) {
        while (current.next != null) {
            if (current.next.data < 0) {
                ListNode temp = current.next.next;
                current.next.next = front;
                front = current.next;
                current.next = temp;
            } else {
                current = current.next;
            }
        }
    }
}
