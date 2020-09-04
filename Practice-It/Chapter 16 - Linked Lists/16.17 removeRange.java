/**********************************************************************************************
Write a method removeRange that accepts a starting and ending index as parameters and removes
the elements at those indexes (inclusive) from the list. For example, if a variable list stores
the following values:

                    [8, 13, 17, 4, 9, 12, 98, 41, 7, 23, 0, 92]

And the following call is made:

                    listRange.removeRange(3, 8);

Then the values between index 3 and index 8 (the value 4 and the value 7) are removed, leaving
the following list:

                    [8, 13, 17, 23, 0, 92]

You should throw an IllegalArgumentException if either of the positions is negative. Otherwise
you may assume that the positions represent a legal range of the list (0 <= start index <= end
index < size of list).

Assume that you are adding this method to the LinkedIntList class as defined below:

                    public class LinkedIntList {
                        private ListNode front;   // null for an empty list
                        ...
                    }

***********************************************************************************************/

public void removeRange(int start, int end) {
    if (start < 0 || end < 0) {
        throw new IllegalArgumentException();
    }
    
    ListNode current = front;    
    int index = 0;
    
    if (start == 0) {
        
        while (index <= end) {
            front = current.next;
            current = front;
            index++;
        }
        
    } else {
        
        while (index < start - 1) {
            current = current.next;
            index++;
        }
        
        for (int i = start; i <= end; i++) {
            current.next = current.next.next;
        }
    }
}
