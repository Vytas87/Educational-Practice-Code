/**********************************************************************************************
Write a method equals2 that accepts a second list as a parameter and that returns true if the
two lists are equal and that returns false otherwise. Two lists are considered equal if they
store exactly the same values in exactly the same order and have exactly the same length. (Note:
On the original section handout, this method is called equals; but Practice-It already defines
an equals method for LinkedIntList for internal use, so we must call your method equals2 here
to avoid a conflict.)

Assume that you are adding this method to the LinkedIntList class as defined below:

                    public class LinkedIntList {
                        private ListNode front;   // null for an empty list
                        ...
                    }

***********************************************************************************************/

public boolean equals2(LinkedIntList other) {
    
    if (front == null && other.front == null) {
    
        return true;
    
    } else {
        
        ListNode current = front;
        ListNode currentOther = other.front;
        
        while (current != null && currentOther != null) {
            if (current.data != currentOther.data) {
                return false;
            }
            current = current.next;
            currentOther = currentOther.next;
        }
        
        return current == null && currentOther == null;
    }
}
