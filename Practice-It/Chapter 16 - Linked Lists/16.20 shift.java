/**********************************************************************************************
Write a method shift that rearranges the elements of a list of integers by moving to the end of
the list all values that are in odd-numbered positions and otherwise preserving list order. For
example, suppose a variable list stores the following values:

                    [0, 1, 2, 3, 4, 5, 6, 7]

The call of list.shift(); should rearrange the list to be:

                    [0, 2, 4, 6, 1, 3, 5, 7]

In this example the values in the original list were equal to their positions and there were an
even number of elements, but that won't necessarily be the case. For example, if list had
instead stored the following:

                    [4, 17, 29, 3, 8, 2, 28, 5, 7]

Then after the call list.shift(); the list would store:

                    [4, 29, 8, 28, 7, 17, 3, 2, 5]

Notice that it doesn't matter whether the value itself is odd or even. What matters is whether
the value appears in an odd index (index 1, 3, 5, etc). Also notice that the original order of
the list is otherwise preserved. You may not construct any new nodes and you may not use any
auxiliary data structure to solve this problem (no array, ArrayList, stack, queue, String, etc).
You also may not change any data fields of the nodes; you must solve this problem by rearranging
the links of the list.

Assume that you are adding this method to the LinkedIntList class as defined below:

                    public class LinkedIntList {
                        private ListNode front;   // null for an empty list
                        ...
                    }

***********************************************************************************************/

public void shift() {
    if (front != null) {
        
        ListNode last = front;
        int size = 1;
        while (last.next != null) {
            last = last.next;
            size++;
        }
        
        ListNode currentEven = front;
        for (int i = 0; i < size / 2; i++) {
            last.next = currentEven.next;
            last = last.next;
            currentEven.next = currentEven.next.next;
            currentEven = currentEven.next;
        }
        
        last.next = null;
    }
}
